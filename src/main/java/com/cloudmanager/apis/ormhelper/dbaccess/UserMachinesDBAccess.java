package com.cloudmanager.apis.ormhelper.dbaccess;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.action.CreateMachinesResponse;
import com.cloudmanager.apis.model.action.ExistingMachineResponse;
import com.cloudmanager.apis.model.action.InfoMachinesResponse;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.interfaces.IMachineUsageDBAccess;
import com.cloudmanager.apis.ormhelper.ormmodel.MachineDetails;
import com.cloudmanager.apis.ormhelper.ormmodel.MachineUsageDetails;
import com.cloudmanager.apis.ormhelper.ormmodel.UserMachineDetails;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class UserMachinesDBAccess implements IMachineUsageDBAccess {

    // Initialize the Log4j logger.
    static final Logger logger = Logger.getLogger(UserMachinesDBAccess.class);

    public String updateMachineLiveTimeAndNetworkInfo(String imageId, String liveTime, String networkInfo, String ipv4Info, String ipv6Info, String status, String userId) throws DAOException
    {
        if (liveTime == null || liveTime.trim().equals("")
                || networkInfo == null   || networkInfo.toString().trim().equals("")
                || imageId == null   || imageId.trim().equals("")
                || status == null   || status.trim().equals("")
                || userId == null   || userId.trim().equals(""))
        {
            throw new DAOException("Cannot update Machine details with one or more empty params");
        }

        Connection connection = MySqlConnect.getDatabaseConnection().getConnection() ;

        PreparedStatement preparedStatement = null;

        /*

           Code here to access the database

        */

        return "success";

    }

    public String updateMachineDestroyTime(String imageId, String destroyTime) throws DAOException
    {
        if (destroyTime == null || destroyTime.trim().equals("")
                || imageId == null   || imageId.trim().equals(""))
        {
            throw new DAOException("Cannot create user with empty username");
        }

        /*

           Code here to access the database

        */

        return "success";

    }

    public CreateMachinesResponse insertMachineActivityInDB(MachineUsageDetails MachineUsageDetails) throws DAOException, InternalErrorException
    {
         /*

           Code here to access the database

        */

        return null;
    }


    /**
     * Queries DB to find a user by its Username if its exist
     *
     * @param MachineName The username to search for
     * @return A populated User object, null if the user was not found
     * @throws DAOException
     */
    @Override
    public String  checkExistingMachineName(String MachineName, String userId) throws DAOException,InternalErrorException {

        if (MachineName == null || MachineName.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty MachineName");
        }


        if (userId == null || userId.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty userName");
        }

        String existingMachineName = new String();

         /*

           Code here to access the database

        */

        if(existingMachineName.equalsIgnoreCase(MachineName)) {

            return existingMachineName;

        } else
        {
            return InfoStrings.False;
        }


    }


    public ExistingMachineResponse getExistingMachineStatus(String imageId, String userId) throws DAOException,InternalErrorException
    {

        if (imageId == null || imageId.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty MachineName");
        }


        if (userId == null || userId.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty userName");
        }
        String existingMachineStatus = new String(InfoStrings.UNKNOWN);

        String networkInfo =new String(InfoStrings.UNKNOWN);

        /*

           Code here to access the database

        */

        ExistingMachineResponse existingMachineResponse = new ExistingMachineResponse();

        existingMachineResponse.setNetworkInfo(networkInfo);
        existingMachineResponse.setMachineStatus(existingMachineStatus);
        return existingMachineResponse;

    }


    public String updateMachineDestroyStatus(String imageId, String userId , String destroyStatus) throws DAOException
    {
        if (imageId == null   || imageId.trim().equals("")
                || destroyStatus == null   || destroyStatus.trim().equals("")
                || userId == null   || userId.trim().equals(""))
        {
            throw new DAOException("Cannot update Machine details with one or more empty params");
        }

         /*

           Code here to access the database

        */

        return "success";

    }


   public InfoMachinesResponse getMachinesByUserId(String userId)throws DAOException
    {

        if (userId == null   || userId.trim().equals(""))
        {
            throw new DAOException("Cannot update Machine details with one or more empty params");
        }


        Connection connection = MySqlConnect.getDatabaseConnection().getConnection() ;
        PreparedStatement preparedStatement = null;

        List<UserMachineDetails> userMachineDetailsList = new ArrayList<UserMachineDetails>();

         /*

           Code here to access the database

        */

        InfoMachinesResponse infoMachineResponse = new InfoMachinesResponse();
        infoMachineResponse.setUserMachineDetailsList(userMachineDetailsList);
        infoMachineResponse.setCount(Integer.toString(userMachineDetailsList.size()));
        infoMachineResponse.setMessage("Success");

        return infoMachineResponse;

    }

    public InfoMachinesResponse getMachinesByUserIdAndMachinesName(String userId, String givenName)throws DAOException
    {
        if (userId == null   || userId.trim().equals("") || givenName == null   || givenName.trim().equals(""))
        {
            throw new DAOException("Cannot retrieve Machine details with one or more empty params");
        }


        Connection connection = MySqlConnect.getDatabaseConnection().getConnection() ;
        PreparedStatement preparedStatement = null;

        List<UserMachineDetails> userMachineDetailsList = new ArrayList<UserMachineDetails>();

         /*

           Code here to access the database

        */

        InfoMachinesResponse infoMachineResponse = new InfoMachinesResponse();
        infoMachineResponse.setUserMachineDetailsList(userMachineDetailsList);
        infoMachineResponse.setCount(Integer.toString(userMachineDetailsList.size()));
        infoMachineResponse.setMessage("Success");

        return infoMachineResponse;
    }

    ExistingMachineResponse getExistingMachinestatus(String imageId , String userId)
            throws DAOException,InternalErrorException
    {
        /*

           Code here to access the database

        */
        return null;
    }

}
