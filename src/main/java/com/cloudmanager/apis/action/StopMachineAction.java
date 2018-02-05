package com.cloudmanager.apis.action;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.configuration.SetStrings;
import com.cloudmanager.apis.exception.AuthorizationException;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.action.*;
import com.cloudmanager.apis.model.user.AuthUidAndSessionToken;
import com.cloudmanager.apis.model.user.UserCredentials;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.dbaccess.UserSessionsDBAccess;
import com.cloudmanager.apis.ormhelper.ormmodel.MachineDetails;
import com.cloudmanager.apis.ormhelper.ormmodel.UserSessionDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Tunnel would be stopped from Local Client and then
 * this function would be called.
 *
 * 1. Step-1 Stop the Tunnel Server
 *
 * 2. DestroyMachine
 *
 *
 */
@Service
public class StopMachineAction extends AbstractCloudManagerAction {

    static final Logger logger = Logger.getLogger(StopMachineAction.class);
    static final int CONNECTION_TIMEOUT = 60000;

    @Autowired
    AllowAccessAction allowAccessAction;

    @Autowired
    DestroyMachinesAction destroyMachinesAction;

    public String handle(String request) throws BadRequestException, InternalErrorException {
        AuthUidAndSessionToken input = getGson().fromJson(request, AuthUidAndSessionToken.class);

        // - Step-1  : Validate received values from User

        // Check for empty strings and null values
        if (input == null ||
                input.getUserId() == null ||
                input.getUserId().trim().equals("") ||
                input.getSessionToken() == null ||
                input.getSessionToken().trim().equals("")
                ) {
            logger.info("Invalid input passed to " + this.getClass().getName());
            throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT);
        }

        StopMachineResponse stopMachineResponse = new StopMachineResponse();

        AuthUidAndSessionToken authUidAndSessionToken  = new AuthUidAndSessionToken();

        /*
            relevant code here 
        */
        return getGson().toJson(stopMachineResponse, StopMachineResponse.class);
    }
 }
