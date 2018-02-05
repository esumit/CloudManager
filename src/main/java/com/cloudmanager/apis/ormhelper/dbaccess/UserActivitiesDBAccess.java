package com.cloudmanager.apis.ormhelper.dbaccess;

import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.interfaces.IUsersActivitiesDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserActivitiesDBAccess implements IUsersActivitiesDao {

    // Initialize the Log4j logger.
    static final Logger logger = Logger.getLogger(UserActivitiesDBAccess.class);


    public String logThisUserActivity(String userEmailIdAndUniquePrefix,String activityCode,
                               String activityTime,String userEmailId , String adminComments) throws DAOException,InternalErrorException
    {


        if (userEmailIdAndUniquePrefix == null || userEmailIdAndUniquePrefix.trim().equals("")
            || activityCode == null   || activityCode.trim().equals("")
            || activityTime == null   || activityTime.trim().equals("")
            || userEmailId  == null   || userEmailId.trim().equals("")
            || adminComments == null  || adminComments.trim().equals("")
            ) {
            throw new DAOException("Cannot create user with empty username");
        }
       
        /*

           Code here to access the database

        */

        return "success";
    }


}
