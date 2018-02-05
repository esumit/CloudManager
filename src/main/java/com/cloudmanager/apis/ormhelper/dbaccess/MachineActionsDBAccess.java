package com.cloudmanager.apis.ormhelper.dbaccess;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;

import com.cloudmanager.apis.ormhelper.ormmodel.MachineActionDetails;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MachineActionsDBAccess {
    // Initialize the Log4j logger.
    static final Logger logger = Logger.getLogger(MachineActionsDBAccess.class);

    public String updateMachineActionsDetails(MachineActionDetails MachineActionDetails)
            throws DAOException
    {
        if (MachineActionDetails.getUserId() == null || MachineActionDetails.getUserId().trim().equals("") ||
                MachineActionDetails.getSessionToken() == null || MachineActionDetails.getSessionToken().trim().equals("") ||
                MachineActionDetails.getDateAndTime() == null || MachineActionDetails.getDateAndTime().trim().equals("") ||
                MachineActionDetails.getAction() == null || MachineActionDetails.getAction().trim().equals("") ||
                MachineActionDetails.getIpv4() == null || MachineActionDetails.getIpv4().trim().equals("") ||
                MachineActionDetails.getIpv6() == null || MachineActionDetails.getIpv6().trim().equals("")
                ) {
            throw new DAOException("Invalid Machine Details");
        }

        /*

           Code here to access the database

        */

        return InfoStrings.success;
    }


}
