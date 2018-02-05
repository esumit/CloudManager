package com.cloudmanager.apis.action;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.configuration.SetStrings;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.user.AuthUidAndSessionToken;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.dbaccess.UserActivitiesDBAccess;
import com.cloudmanager.apis.ormhelper.dbaccess.UsersTokenDBAccess;
import com.cloudmanager.apis.ormhelper.ormmodel.UsersToken;
import org.apache.log4j.Logger;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AllowAccessAction extends AbstractCloudManagerAction {

    static final Logger logger = Logger.getLogger(AllowAccessAction.class);

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

        DateTime localDateTime = new DateTime(DateTimeZone.UTC);
        UserActivitiesDBAccess userActivitiesDBAccess = new UserActivitiesDBAccess();

        // - Step-2  : Validate if this user exists in database( e.g. if exist then check the status, even if pending)

        // Validate Token

        UsersTokenDBAccess usersTokenDBAccess = new UsersTokenDBAccess();
        UsersToken usersToken = new UsersToken();

        try {
            usersToken = usersTokenDBAccess.getExistingTokenDetailsByUsername(input.getUserId(), input.getSessionToken());

            // Add the Logs that Existing user was checked for auth reasons
            userActivitiesDBAccess.logThisUserActivity(input.getUserId(),
                    input.getActivityCode(), localDateTime.toString(), input.getUserId(), input.getReason());

            if (usersToken != null) {
                if (usersToken.getTokenStatus().equalsIgnoreCase(SetStrings.REGULAR_TIME_TOKEN)) {
                    // We have received the right token, now compare its timings, it shouldn't be expired.
                    // Verify Token Value and validity within given time frame
                    if (!((localDateTime.now().getMillis() >= localDateTime.parse(usersToken.getTokenValidFrom()).getMillis()) &&
                            (localDateTime.now().getMillis() <= localDateTime.parse(usersToken.getTokenValidTo()).getMillis()))) {
                        // UI will automatically check the status and based on that it will respond to the user
                        throw new BadRequestException(ExceptionMessages.TOKEN_INVALID_OR_EXPIRED);
                    }


                } else {
                    // Add the Logs that Existing user was checked for for auth reasons
                    userActivitiesDBAccess.logThisUserActivity(input.getUserId() + "-" + UUID.randomUUID().toString().replaceAll("-", ""),
                            input.getActivityCode(), localDateTime.toString(), input.getUserId(), "Reason : Invalid Token Status:" + input.getReason());

                    // UI will automatically check the status and based on that it will respond to the user
                    throw new BadRequestException(ExceptionMessages.EX_TOKEN_NOT_FOUND + "User/Token Value :" + input.getUserId() + "/" + input.getSessionToken());
                }
            } else {

                // Add the Logs that Existing user was checked for for auth reasons
                userActivitiesDBAccess.logThisUserActivity(input.getUserId() + "-" + UUID.randomUUID().toString().replaceAll("-", ""),
                        input.getActivityCode(), localDateTime.toString(), input.getUserId(), "Reason : Invalid Token - No Token Found:" + input.getReason());

                // UI will automatically check the status and based on that it will respond to the user
                throw new BadRequestException(ExceptionMessages.EX_TOKEN_NOT_FOUND + "User/Token Value :" + input.getUserId() + "/" + input.getSessionToken());

            }
        } catch (DAOException e) {
            logger.info("DAOException while doing usersTokenDBAccess.getExistingTokenDetailsByUsername for Access to Core APIs");
            throw new InternalErrorException(ExceptionMessages.EX_DB_DAOE);
        }finally
        {
            MySqlConnect.getDatabaseConnection().close();
        }

        // Step-3 Token value passed the check - so return success

        return InfoStrings.success;
    }
}
