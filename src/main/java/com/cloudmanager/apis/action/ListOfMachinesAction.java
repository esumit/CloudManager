package com.cloudmanager.apis.action;

import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.configuration.InfoStrings;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.action.ListOfMachineRequest;
import com.cloudmanager.apis.model.action.ListOfMachinesResponse;
import com.cloudmanager.apis.model.user.UserCredentials;
import com.cloudmanager.apis.ormhelper.db.MySqlConnect;
import com.cloudmanager.apis.ormhelper.dbaccess.MasterMachineDBAccess;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class ListOfMachinesAction extends AbstractCloudManagerAction  {

    static final Logger logger = Logger.getLogger(ListOfMachinesAction.class);

    /*

     - Receive the following input :
      accessDetails - UserId and Token
      MachineType - MACHINE_LIVE - scannres which are LIVe in Master Table

      Step-1 : Check User-Id Situation and Valid Token Value

      On Success

      Step-2 : Access to database and get all Machines Values and return the List
     */

public String handle(String request)  {
        ListOfMachineRequest input = getGson().fromJson(request, ListOfMachineRequest.class);

        // - Step-1  : Validate received values from User

        // Check for empty strings and null values
        if (input == null ||
                input.getAccessDetails().getUserId() == null ||
                input.getAccessDetails().getUserId() .trim().equals("") ||
                input.getAccessDetails().getAccessToken() == null ||
                input.getAccessDetails().getAccessToken().trim().equals("") ||
                input.getMachineType() == null
                ) {
            logger.info("Invalid input passed to " + this.getClass().getName());
            throw new BadRequestException(ExceptionMessages.EX_INVALID_INPUT);
        }

        // Step-2 : Access to database and get all Machines Values and return the List

        MasterMachineDBAccess masterMachineDBAccess = new MasterMachineDBAccess();

        ListOfMachinesResponse listOfMachinesResponse = new ListOfMachinesResponse();
    try {
        listOfMachinesResponse = masterMachineDBAccess.getListOfMachines(input.getMachineType());
    } catch (DAOException e) {
       // throw new DAOException("No Machine found in Machine Database");
    }finally
    {
        MySqlConnect.getDatabaseConnection().close();
    }

    // return list of Machines

        return getGson().toJson(listOfMachinesResponse, ListOfMachinesResponse.class);
      }

    }
