package com.cloudmanager.apis.action;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.configuration.SetStrings;
import com.cloudmanager.apis.exception.AuthorizationException;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.helper.CommonFunctions;
import com.cloudmanager.apis.model.action.*;
import com.cloudmanager.apis.model.user.AuthUidAndSessionToken;
import com.cloudmanager.apis.model.user.UserCredentials;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.dbaccess.UserSessionsDBAccess;
import com.cloudmanager.apis.ormhelper.ormmodel.UserSessionDetails;
import com.cloudmanager.apis.utils.PropertyManager;
import com.myjeeva.digitalocean.common.DropletStatus;
import com.myjeeva.digitalocean.pojo.Networks;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Step-1 : Receive user-Id and Session Token, Verify it , All Well then
 *
 * Step-2 : If MachineStatus = UNKNOWN from UserSessions Table If its Unknown
 * and TokenStatus (Created), that means User did just login to System, so go
 * for ListMachines,CreateMachines, IsMachineCreated returns new
 * then Set status | Machine_CREATION_IN_PROCESS
 *
 * Step-3: If MachineStatus = Machine_CREATION_IN_PROCESS , Only call
 * IsMachineCreated returns active then Set MachineStatus=Machine_LIVE,
 *
 */

@Service
public class StartMachineAction extends AbstractCloudManagerAction {

    static final Logger logger = Logger.getLogger(StartMachineAction.class);

    static final int CONNECTION_TIMEOUT = 60000;

    @Autowired
    AllowAccessAction allowAccessAction;

    @Autowired
    CreateMachinesAction createMachinesAction;

    @Autowired
    ISMachineCreatedAction isMachineCreatedAction;

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


        StartMachineResponse startMachineResponse = new StartMachineResponse();
        UserSessionDetails updateUserSessionDetails = new UserSessionDetails();
        UserSessionDetails userSessionDetails = new UserSessionDetails();

        AuthUidAndSessionToken authUidAndSessionToken  = new AuthUidAndSessionToken();

        /*
            relevant code here 
        */

        // if Machine perfectly created then return : MACHINE_CREATION_IN_PROCESS
        return getGson().toJson(startMachineResponse, StartMachineResponse.class);

    }
}
