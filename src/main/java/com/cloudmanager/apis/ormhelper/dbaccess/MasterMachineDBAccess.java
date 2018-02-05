package com.cloudmanager.apis.ormhelper.dbaccess;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.action.ListOfMachinesResponse;
import com.cloudmanager.apis.model.misc.MachineFilters;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.interfaces.IMasterMachineDBAccess;
import com.cloudmanager.apis.ormhelper.ormmodel.MachineDetails;
import org.apache.commons.lang3.EnumUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MasterMachineDBAccess implements IMasterMachineDBAccess {

    // Initialize the Log4j logger.
    static final Logger logger = Logger.getLogger(MasterMachineDBAccess.class);

    public ListOfMachinesResponse getListOfMachines(MachineFilters machineFilters) throws DAOException,InternalErrorException
    {

        if(!EnumUtils.isValidEnum(MachineFilters.class, machineFilters.toString()))
        {
            throw new DAOException("Invalid Machine Type Value : " + machineFilters.toString());
        }

        Connection connection = MySqlConnect.getDatabaseConnection().getConnection();
        PreparedStatement preparedStatement = null;

        List<MachineDetails> masterMachinesDetailsList = new ArrayList<MachineDetails>();

        /*

           Code here to access the database

        */
        ListOfMachinesResponse listOfMachinesResponse = new ListOfMachinesResponse();

        listOfMachinesResponse.setCountOfMachines(Integer.toString(masterMachinesDetailsList.size()));
        listOfMachinesResponse.setListOfMachines(masterMachinesDetailsList);
        listOfMachinesResponse.setMessage("Success");

        // Close the connection !
        //MySqlConnect.getDatabaseConnection().getConnection();.getDatabaseConnection().close();

        return listOfMachinesResponse;
    }

    public MachineDetails getMachineInfoByName(String machineName) throws DAOException,InternalErrorException
    {

        if (machineName == null || machineName.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty userId");
        }

        Connection connection = MySqlConnect.getDatabaseConnection().getConnection() ;
        PreparedStatement preparedStatement = null;

        MachineDetails machineDetails = new MachineDetails();

        /*

           Code here to access the database

        */

        return machineDetails;
    }

}
