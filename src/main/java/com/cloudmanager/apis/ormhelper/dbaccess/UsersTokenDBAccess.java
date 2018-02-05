package com.cloudmanager.apis.ormhelper.dbaccess;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.ormhelper.interfaces.IUsersToken;
import com.cloudmanager.apis.ormhelper.ormmodel.UsersToken;
import com.cloudmanager.apis.exception.InternalErrorException;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Random;
import java.util.UUID;


public class UsersTokenDBAccess implements IUsersToken {

    // Initialize the Log4j logger.
    static final Logger logger = Logger.getLogger(UsersTokenDBAccess.class);

    public UsersToken createTokenForThisUser(String authorizeTokenUser, int durationInMinutes, String tokenType) throws DAOException,InternalErrorException
    {
        if (authorizeTokenUser == null || authorizeTokenUser.trim().equals("")
                || tokenType == null   || tokenType.trim().equals("")
                || durationInMinutes <= InfoStrings.ZERO   || durationInMinutes >= InfoStrings.ONE_DAY_MINUTES
                ) {
            throw new DAOException("Cannot generate token with invalid input value"
                    + "authorizeTokenUser :" + authorizeTokenUser
                    + "tokenType :" + tokenType
                    + "durationInMinutes :" + durationInMinutes );
        }
       // INSERT INTO ZA3.UsersToken (AuthorizeTokenUser, TokenCreatedAt, TokenStatus,TokenValidFrom, TokenValidTo, TokenValue,DateAndTime)
       // VALUES (?,? ,? ,? ,? ,?,?);

        DateTime localDateTime = new DateTime(DateTimeZone.UTC);
        Random ran = new Random();

        UsersToken usersToken = new UsersToken();
        usersToken.setAuthorizeTokenUser(authorizeTokenUser);
        usersToken.setTokenStatus(tokenType);
        usersToken.setDateAndTime(localDateTime.plusMillis(1000 + ran.nextInt(9000)).toString());
        usersToken.setTokenCreatedAt(localDateTime.now().toString());
        usersToken.setTokenValidFrom(localDateTime.now().toString());
        usersToken.setTokenValue(UUID.randomUUID().toString().replaceAll("-", ""));
        usersToken.setTokenValidTo(localDateTime.now().plusMinutes(durationInMinutes).toString());

        /*

           Code here to access the database

        */
        UserActivitiesDBAccess userActivitiesDBAccess = new UserActivitiesDBAccess();

        // User successfully created, Log it
        try {

            userActivitiesDBAccess.logThisUserActivity(authorizeTokenUser + "-" + UUID.randomUUID().toString().replaceAll("-", ""),
                    tokenType, localDateTime.toString(), authorizeTokenUser, InfoStrings.Activity);
        } catch (DAOException e) {
            logger.info("DAOException while doing userActivitiesDBAccess");
            throw new InternalErrorException(ExceptionMessages.EX_DB_DAOE);
        }
        return usersToken;
    }


    public UsersToken getExistingTokenDetailsByUsername(String username , String tokenValue) throws DAOException,InternalErrorException
    {
        if (username == null || username.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty user");
        }

        if (tokenValue == null || tokenValue.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty tokenValue");
        }
    
        UsersToken usersToken = new UsersToken();

        String AuthorizeTokenUser = null;
        String TokenType = null;
        String TokenDateAndTime = null;
        String TokenCreatedAt = null;
        String TokenValidFrom = null;
        String TokenValidTo = null;
        String TokenValue = null;

        /*

           Code here to access the database

        */

        return usersToken;
    }

    @Override
    public String updateExistingTokenDetailsByUsername(String username , String tokenValue, String tokenStatus) throws DAOException,InternalErrorException
    {
        if (username == null || username.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty user");
        }

        if (tokenValue == null || tokenValue.trim().equals("")) {
            throw new DAOException("Cannot lookup null or empty tokenValue");
        }


        /*

           Code here to access the database

        */

        return "success";
    }
}
