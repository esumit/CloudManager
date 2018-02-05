package com.cloudmanager.apis.ormhelper.interfaces;

import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.ormhelper.ormmodel.UsersToken;


public interface IUsersToken {

    /**
     * Create Token for this User, This token would be created based on the duration and type of User,
     *
     * @param  authorizeTokenUser , Authorized Token User
     * @return success return value, null otherwise
     * @throws DAOException
     */
    UsersToken createTokenForThisUser(String authorizeTokenUser, int durationInMinutes, String tokenType) throws DAOException,InternalErrorException;

    UsersToken getExistingTokenDetailsByUsername(String username, String tokenValue) throws DAOException,InternalErrorException;

    String updateExistingTokenDetailsByUsername(String username , String tokenValue, String tokenStatus) throws DAOException,InternalErrorException;

}
