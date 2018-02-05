package com.cloudmanager.apis.ormhelper.dbaccess;


import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.exception.DAOException;

import com.cloudmanager.apis.ormhelper.ormmodel.UserSessionDetails;
import org.apache.log4j.Logger;


public class UserSessionsDBAccess {

    // Initialize the Log4j logger.
    static final Logger logger = Logger.getLogger(UserSessionsDBAccess.class);

    public UserSessionDetails getUserSessionDetailsByUserIdAndSessionToken(String userId, String sessionToken)
            throws DAOException
    {
        if (userId == null || userId.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty userId");
        }


        if (sessionToken == null || sessionToken.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty sessionToken");
        }

        String MachineStatus  = null;
        String TokenStatus    = null;
        String MachineIPV4    = null;
        String MachineIPV6    = null;
        String DeviceId       = null;
        String MachineImageId = null;

        UserSessionDetails userSessionDetails = new UserSessionDetails();

        /*

           Code here to access the database

        */


        return userSessionDetails;
    }


    public String updateUserSessionDetailOnCreation(UserSessionDetails userSessionDetails)
            throws DAOException
    {
        if (userSessionDetails.getMachineStatus() == null || userSessionDetails.getMachineStatus().trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty userId");
        }
        if (userSessionDetails.getSessionToken() == null || userSessionDetails.getSessionToken().trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty sessionToken");
        }

        /*

           Code here to access the database

        */

        return InfoStrings.success;
    }


    public String updateUserSessionDetailOnMachineCreated(UserSessionDetails userSessionDetails)
            throws DAOException
    {
        if (userSessionDetails.getMachineStatus() == null || userSessionDetails.getMachineStatus().trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty userId");
        }
        if (userSessionDetails.getSessionToken() == null || userSessionDetails.getSessionToken().trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty sessionToken");
        }

        /*

           Code here to access the database

        */
           
        return InfoStrings.success;
    }

    public String updateUserSessionDetailOnMachineDestroyed(UserSessionDetails userSessionDetails)
            throws DAOException
    {
        if (userSessionDetails.getMachineStatus() == null || userSessionDetails.getMachineStatus().trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty userId");
        }
        if (userSessionDetails.getSessionToken() == null || userSessionDetails.getSessionToken().trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty sessionToken");
        }

       /*

           Code here to access the database

        */

        return InfoStrings.success;
    }


}
