package com.cloudmanager.apis.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthorizationExceptionMapper extends RuntimeException{

    public Response toResponse(AuthorizationException ex) {

        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),401,"Please reach to Sumit@x.com");
        return Response.status(Response.Status.UNAUTHORIZED)
                .header("Content-Type", "application/json")
                .entity(errorMessage.toString())
                .build();
    }
}
