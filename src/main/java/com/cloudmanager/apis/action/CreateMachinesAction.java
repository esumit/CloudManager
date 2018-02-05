package com.cloudmanager.apis.action;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.helper.NameValidator;
import com.cloudmanager.apis.model.action.CreateMachinesRequest;
import com.cloudmanager.apis.model.action.CreateMachinesResponse;
import com.cloudmanager.apis.model.misc.DORegionSlugs;
import com.cloudmanager.apis.model.misc.DOSizeSlugs;
import com.cloudmanager.apis.model.misc.MachineFilters;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.dbaccess.UserMachinesDBAccess;
import com.cloudmanager.apis.ormhelper.ormmodel.MachineUsageDetails;
import com.cloudmanager.apis.utils.PropertyManager;
import com.myjeeva.digitalocean.exception.DigitalOceanException;
import com.myjeeva.digitalocean.exception.RequestUnsuccessfulException;
import com.myjeeva.digitalocean.impl.DigitalOceanClient;
import com.myjeeva.digitalocean.pojo.Droplet;
import com.myjeeva.digitalocean.pojo.Image;
import com.myjeeva.digitalocean.pojo.Region;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CreateMachinesAction extends AbstractCloudManagerAction {

    static final Logger logger = Logger.getLogger(CreateMachinesAction.class);

    /*
       1. Get the Input - ImageId , Tag, GivenName , SizeSlug, RegionSlug

       2. Verify the Input , All Well

       3. Based on the ImageId and Given Description, do a Create VM

       4. All goes well, receive the details and insert into the database

       5. Insert goes well, return the details to the caller also email the details to user.

       Tag is not mandatory , if not provided by the user , then it should be with DEFAULT String
     */

    public String handle(String request)  {

        DigitalOceanClient digitalOceanClient = new DigitalOceanClient(PropertyManager.getSetting("code3.do.accesstoken"));
        Droplet dropletCreated = new Droplet();

        CreateMachinesRequest input = getGson().fromJson(request, CreateMachinesRequest.class);

        UserMachinesDBAccess MachineUsageDBAccess = new UserMachinesDBAccess();

        // - Step-1  : Validate received values from User
        // SizeSlug, ImageID,RegionSlug,TAG (String DEfault),GivenName,SigeSlug is important

        // Check for empty strings and null values
        if (input == null ||
                input.getAccessDetails().getUserId() == null ||
                input.getAccessDetails().getUserId() .trim().equals("") ||
                input.getAccessDetails().getAccessToken() == null ||
                input.getAccessDetails().getAccessToken().trim().equals("") ||
                input.getGivenName() == null ||
                input.getGivenName().trim().equals("") ||
                input.getSizeSlug() == null ||
                input.getSizeSlug().trim().equals("") ||
                input.getTag() == null ||
                input.getTag().trim().equals("") ||
                input.getRegionSlug() == null ||
                input.getRegionSlug().trim().equals("") ||
                input.getMasterId() == null ||
                input.getMasterId().trim().equals("")
                ) {
            logger.info("Invalid input passed to " + this.getClass().getName());
            throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT);
        }

        boolean isValidInput;

        NameValidator nameValidator = new NameValidator();
        // Validate FirstName
        String givenNametoMachine = input.getGivenName();
        isValidInput = nameValidator.validate(givenNametoMachine);

        if(!isValidInput)
        {
            logger.info(ExceptionMessages.EX_INVALID_Machine_INPUT);
            throw new BadRequestException(ExceptionMessages.EX_INVALID_Machine_INPUT);
        }

        // check for unique name into the database

        try {

            String existingMachineName = new String();

            try {
                existingMachineName = MachineUsageDBAccess.checkExistingMachineName(givenNametoMachine, input.getAccessDetails().getUserId());
            } catch (DAOException e) {
                throw new BadRequestException(ExceptionMessages.EXISTING_Machine_NAME + "--" + "existingMachineName check error");
            }

            if (existingMachineName.equalsIgnoreCase(givenNametoMachine)) {

                throw new BadRequestException(ExceptionMessages.EXISTING_Machine_NAME);

            }

            // 2. Verify the Input , All Well

            // 3. Based on the ImageId and Given Description, do a Create VM

            final Droplet droplet = new Droplet();
            final Region region = new Region();

            droplet.setStatus(com.myjeeva.digitalocean.common.DropletStatus.ACTIVE);
            droplet.setName(input.getGivenName() + "--" + input.getAccessDetails().getUserId().replaceAll("[^\\p{Alpha}]+", ""));
            droplet.setSize(DOSizeSlugs.valueOf(input.getSizeSlug()).toString());
            droplet.setImage(new Image(Integer.parseInt(input.getImageId())));
            region.setSlug(DORegionSlugs.valueOf(input.getRegionSlug()).toString());
            droplet.setRegion(region);

            // if no tags defined by the user, then take it as default tags
            List<String> userDefinedTags = new ArrayList<>();
            userDefinedTags.add(input.getTag());
            droplet.setTags(userDefinedTags);

            //Enable IPv6
            droplet.setEnableIpv6(true);


            try {
                dropletCreated = digitalOceanClient.createDroplet(droplet);
            } catch (DigitalOceanException e) {
                throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT + "--" + e.getMessage());
            } catch (RequestUnsuccessfulException e) {
                throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT + "--" + e.getMessage());
            }
            logger.info("Code3 Machine created successfully : {}");

            // Insert the details into the database

            MachineUsageDetails MachineUsageDetails = new MachineUsageDetails();

            MachineUsageDetails.setUserId(input.getAccessDetails().getUserId());
            MachineUsageDetails.setGivenName(input.getGivenName());
            MachineUsageDetails.setGivenTag(input.getTag());
            MachineUsageDetails.setCreationTime(dropletCreated.getCreatedDate().toString());
            MachineUsageDetails.setDestroyTime(InfoStrings.UNKNOWN);
            MachineUsageDetails.setMachineStatus(InfoStrings.Machine_CREATED);
            MachineUsageDetails.setMasterMachineId(input.getMasterId());
            MachineUsageDetails.setImageId(Integer.toString(dropletCreated.getId()));
            MachineUsageDetails.setIsBackup(InfoStrings.UNKNOWN);
            MachineUsageDetails.setIsSnapshot(InfoStrings.UNKNOWN);
            MachineUsageDetails.setUsgaeStatus(InfoStrings.USAGE_STATUS_ON_CREATED);
            MachineUsageDetails.setUsgaeStatus(input.getAccessDetails().getUserId());
            MachineUsageDetails.setUserType(InfoStrings.AUTHORIZED_USER_NORMAL);
            MachineUsageDetails.setIpV4Address(InfoStrings.UNKNOWN);
            MachineUsageDetails.setIpV6Address(InfoStrings.UNKNOWN);
            MachineUsageDetails.setRegion(input.getRegionSlug().toString());
            MachineUsageDetails.setNetworkInfo(InfoStrings.UNKNOWN);
            MachineUsageDetails.setLiveTime(InfoStrings.UNKNOWN);
            MachineUsageDetails.setActionPerformedBy(input.getAccessDetails().getUserId());


            try {
                MachineUsageDBAccess.insertMachineActivityInDB(MachineUsageDetails);
            } catch (DAOException e) {
                throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT + "--" + e.getMessage());
            }
        }finally
        {
            MySqlConnect.getDatabaseConnection().close();
        }

        // ID, UserID, GivenName, GivenTag,CreationTime,MasterMachineID,ImageID,IsBackup,UsgaeStatus,ActionPerformedBy
        // UserType,Comments
        // Return relevant information

        CreateMachinesResponse createMachinesResponse = new CreateMachinesResponse();

        createMachinesResponse.setCreationDateAndTime(dropletCreated.getCreatedDate().toString());
        createMachinesResponse.setGivenTag(input.getTag());
        createMachinesResponse.setImageId(dropletCreated.getId().toString());
        createMachinesResponse.setIpv4Address(InfoStrings.UNKNOWN);
        createMachinesResponse.setPv6Address(InfoStrings.UNKNOWN);
        createMachinesResponse.setMachineName(input.getGivenName());
        createMachinesResponse.setResultStatus(MachineFilters.MACHINE_UCREATED);
        createMachinesResponse.setMessage("Machine is on creation Status, " +
                "get more information e.g. by calling : isMachineCreated API with path like" +
                 "cloudmanager-service/cloudmanager/isMachineCreated");

        // Also add next link to see the Status information until it would be live

        return getGson().toJson(createMachinesResponse, CreateMachinesResponse.class);

    }
}
