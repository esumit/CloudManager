package com.cloudmanager.apis.ormhelper.interfaces;

import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.ormhelper.ormmodel.UserSessionDetails;


public interface IUserSessionsDBAccess {

    UserSessionDetails getUserSessionDetailsByUserIdAndSessionToken(String userId, String sessionToken)
            throws DAOException;

    String updateUserSessionDetailOnCreation(UserSessionDetails userSessionDetails)
            throws DAOException;

    String updateUserSessionDetailOnMachineCreated(UserSessionDetails userSessionDetails)
            throws DAOException;

    public String updateUserSessionDetailOnMachineDestroyed(UserSessionDetails userSessionDetails)
            throws DAOException;
}
