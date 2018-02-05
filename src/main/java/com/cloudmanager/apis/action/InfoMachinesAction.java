package com.cloudmanager.apis.action;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.SetStrings;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.model.action.InfoMachineRequest;
import com.cloudmanager.apis.model.action.InfoMachinesResponse;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.dbaccess.UserMachinesDBAccess;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class InfoMachinesAction  extends AbstractCloudManagerAction {

    static final Logger logger = Logger.getLogger(InfoMachinesAction.class);

    public String handle(String request) {
        InfoMachineRequest input = getGson().fromJson(request, InfoMachineRequest.class);

        // - Step-1  : Validate received values from User

        // Check the request Type

         // MACHINE_ALL  -- All Machines from this user
         // MACHCINE_BY_NAME - Machine by Name
         // MACHINE_DATE_RANGE - Machine as given start date and end date
         // MACHINE_BY_FILTER - Machine as defined by the filter e.g. Machine_Destroyed, Machine_Created etc

        // Check for empty strings and null values
        if (input == null ||
                input.getAccessDetails().getUserId() == null ||
                input.getAccessDetails().getUserId() .trim().equals("") ||
                input.getAccessDetails().getAccessToken() == null ||
                input.getAccessDetails().getAccessToken().trim().equals("") ||
                input.getInfoRequestType() == null ||
                input.getInfoRequestType().trim().equals("")
              ) {
            logger.info("Invalid input passed to " + this.getClass().getName());
            throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT);
        }

        UserMachinesDBAccess userMachinesDBAccess = new UserMachinesDBAccess();
        InfoMachinesResponse infoMachinesResponse = new InfoMachinesResponse();

        try {

            switch (input.getInfoRequestType()) {
                case SetStrings.MACHINE_ALL:

                    // do query to UsersMachine Database and Retreive list of All Machines created by this user;
                    try {
                        infoMachinesResponse = userMachinesDBAccess.getMachinesByUserId(input.getAccessDetails().getUserId());
                    } catch (DAOException e) {
                        throw new BadRequestException(ExceptionMessages.EX_DB_DAOE + "---" + "getMachinesByUserId");
                    }

                    break;

                case SetStrings.MACHINE_BY_NAME:

                    // do query to UsersMachine Database and Retreive Machine with the given name

                    // do check MachineName value in input

                    try {
                        infoMachinesResponse = userMachinesDBAccess.getMachinesByUserIdAndMachinesName(input.getAccessDetails().getUserId()
                                , input.getMachineName());
                    } catch (DAOException e) {
                        throw new BadRequestException(ExceptionMessages.EX_DB_DAOE + "---" + e.getMessage());
                    }

                    break;

                case SetStrings.MACHINE_BY_FILTER:

                    // do query to UsersMachine Database and Retreive Machine with the given name

                    // do check value of Machine_BY_FILTER in input;


                    break;

                case SetStrings.MACHINE_DATE_RANGE:

                    //Machine date range

                    // do check
                    break;

                default:
                    throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT + "--" + "Invalid Request Type");
            }
        }
        finally
        {
            MySqlConnect.getDatabaseConnection().close();
        }



        // select records from the database based on the request


        // return the response.

        return getGson().toJson(infoMachinesResponse, InfoMachinesResponse.class);
    }




}
