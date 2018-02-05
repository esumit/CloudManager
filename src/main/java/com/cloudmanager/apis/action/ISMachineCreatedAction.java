package com.cloudmanager.apis.action;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.action.IsMachineCreatedRequest;
import com.cloudmanager.apis.model.action.IsMachineCreatedResponse;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.ormmodel.IPV4NetworkInfo;
import com.cloudmanager.apis.utils.PropertyManager;
import com.myjeeva.digitalocean.common.DropletStatus;
import com.myjeeva.digitalocean.exception.DigitalOceanException;
import com.myjeeva.digitalocean.exception.RequestUnsuccessfulException;
import com.myjeeva.digitalocean.impl.DigitalOceanClient;
import com.myjeeva.digitalocean.pojo.Droplet;
import com.myjeeva.digitalocean.pojo.Network;
import com.myjeeva.digitalocean.pojo.Networks;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class ISMachineCreatedAction extends AbstractCloudManagerAction{

    static final Logger logger = Logger.getLogger(ISMachineCreatedAction.class);

    public String handle(String request) throws BadRequestException, InternalErrorException {

        DigitalOceanClient digitalOceanClient = new DigitalOceanClient(PropertyManager.getSetting("code3.do.accesstoken"));

        IsMachineCreatedRequest input = getGson().fromJson(request, IsMachineCreatedRequest.class);

        // - Step-1  : Validate received values from User

        // Check for empty strings and null values
        if (input == null ||
                input.getAccessDetails().getUserId() == null ||
                input.getAccessDetails().getUserId() .trim().equals("") ||
                input.getAccessDetails().getAccessToken() == null ||
                input.getAccessDetails().getAccessToken().trim().equals("") ||
                input.getImageId() == null ||
                input.getImageId().trim().equals("") ||
                input.getReason() == null ||
                input.getImageId().trim().equals("")
                ) {
            logger.info("Invalid input passed to " + this.getClass().getName());
            throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT);
        }

        IsMachineCreatedResponse isMachineCreatedResponse = new IsMachineCreatedResponse();

        // 2. Verify the Input , All Well

        // 3. Based on the ImageId retrieve the info

        Droplet dropletCreationInfo = new Droplet();


       /*
            relevant code here 
        */

        logger.info("Information retrieved successfully: {}");

        return getGson().toJson(isMachineCreatedResponse, IsMachineCreatedResponse.class);
    }

    }
