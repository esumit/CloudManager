package com.cloudmanager.apis.ormhelper.interfaces;

import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;


public interface IUsersActivitiesDao {

    /**
     * Find a user by its unique username, here unique username is his email id
     *
     * @param  userEmailIdAndUniquePrefix unique useremail-prefix
     * @param  activityCode activity code
     * @param  activityTime activity time
     * @param  userEmailId  user email id
     * @return success as a return if all goes well, else throw exception
     * @throws DAOException
     */
    String logThisUserActivity(String userEmailIdAndUniquePrefix,String activityCode,String activityTime,
                               String userEmailId,String adminComments) throws DAOException,InternalErrorException;

}
