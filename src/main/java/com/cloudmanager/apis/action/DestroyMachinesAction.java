package com.cloudmanager.apis.action;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.RevokeSecurityGroupIngressRequest;
import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.configuration.SetStrings;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.action.*;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.utils.PropertyManager;
import com.myjeeva.digitalocean.exception.DigitalOceanException;
import com.myjeeva.digitalocean.exception.RequestUnsuccessfulException;
import com.myjeeva.digitalocean.impl.DigitalOceanClient;
import com.myjeeva.digitalocean.pojo.Delete;
import com.myjeeva.digitalocean.pojo.Droplet;
import com.myjeeva.digitalocean.pojo.Network;
import com.myjeeva.digitalocean.pojo.Networks;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class DestroyMachinesAction extends AbstractCloudManagerAction {

    static final Logger logger = Logger.getLogger(DestroyMachinesAction.class);



    public String handle(String request) throws BadRequestException, InternalErrorException {

        DestroyMachinesRequest input = getGson().fromJson(request, DestroyMachinesRequest.class);

        DigitalOceanClient digitalOceanClient = new DigitalOceanClient(PropertyManager.getSetting("code3.do.accesstoken"));

        /*
            relevant code here 
        */

        DestroyMachinesResponse destroyMachinesResponse = new DestroyMachinesResponse();

        destroyMachinesResponse.setMachineName(input.getGivenName());
        destroyMachinesResponse.setImageId(input.getImageId());

        // Also add next link to see the Status information until it would be live

        return getGson().toJson(destroyMachinesResponse, DestroyMachinesResponse.class);
    }
}
