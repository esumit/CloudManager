package com.cloudmanager.apis.configuration;

/**
 * Static list of error messages when exceptions are thrown
 */
public class ExceptionMessages {

    public static final String EX_INVALID_TOKEN_ACCESS = "Error to check existing Token parmaters for the logged user";
    public static final String EX_INVALID_VALIDATION_CODE = "MFA Code Length should be 6";
    public static final String EX_INVALID_INPUT = "Invalid input parameters";
    public static final String EX_PWD_SALT = "Cannot generate password salt";
    public static final String EX_PWD_ENCRYPT = "Failed to encrypt password";
    public static final String EX_PWD_SAVE = "Failed to save password";
    public static final String EX_NO_COGNITO_IDENTITY = "Cannot retrieve Cognito identity";
    public static final String EX_DAO_ERROR = "Error loading user";
    public static final String EX_INVALID_MFA = " Invalid Validaiton Code";

    public static final String EX_INVALID_FIRSTNAME_INPUT = "It should be a single word, only letters and with at\n" +
                                                            " * least 3 characters and at top 30 characers";
    public static final String EX_INVALID_LASTNAME_INPUT =  "It should be a single word, only letters and with at\n" +
                                                            " * least 3 characters and at top 30 characers";
    public static final String EX_INVALID_EMAIL_INPUT = "Valid email with only domain name x.com";
    public static final String EX_INVALID_PASSWORD_INPUT = "8 to 20 characters string with\n" +
                              " * at least one digit, one upper case letter, one lower case letter\n" +
                              " * and one special symbol (“@#$%”)";
    public static final String EX_INVALID_LOGOUT = "Invalid accesstoken value or username";
    public static final String EX_INVALID_MOBILENO = "Invalid mobileno value";
    public static final String EX_INVALID_TOKEN = "Non Exist token";

    public static final String EX_USER_ALREADY_EXIST = "This User Already Exist";
    public static final String EX_USER_NOT_FOUND = "This User Already Exist";

    public static final String EX_DB_CNFE = "ClassNotFoundException : Exception while accessing Database";
    public static final String EX_DB_SQLE = "SQLException : Exception while accessing Database";
    public static final String EX_DB_DAOE = "DAOException : Exception while accessing Database";

    public static final String EX_TnC = "Terms and Conditions are not accepted";

    public static final String EX_TOKEN_NOT_FOUND    = "Invalid Token or Incorrect Input";
    public static final String TOKEN_INVALID_OR_EXPIRED = "Token Invalid or Expired";

    public static final String INVALID_TOKEN_OR_USERID = "Invalid Token  or User-Id Or Both";

    public static final String EX_OTP_NOT_FOUND    = "EX_OTP_NOT_FOUND";
    public static final String INVALID_USER_OR_OTP_STATE    = "INVALID_USER_OR_OTP_STATE";


    public static final String DIFFERENT_PASSWORD    = "DIFFERENT_PASSWORD";

    public static final String EX_REQUESTUNSUCCESSFULEX = "RequestUnsuccessfulException";

    public static final String EX_INVALID_Machine_INPUT = "It should be a single word, only letters and with at\n" +
            " * least 3 characters and at top 30 characers";

    public static final String EXISTING_Machine_NAME    = "Machine_NAME should be unique for this user";

    public static final String EX_NO_Machine_WITH_GIVEN_NAME_OR_ID_OR_BOTH    = "No Machine exist with given name or id or both";

    public static final String EX_ON_UPDATING_SESSION_DETAILS    = "EX_ON_UPDATING_SESSION_DETAILS";

    public static final String INTERNAL_ERROR_EXCEPTION    = "INTERNAL_ERROR_EXCEPTION";

}
