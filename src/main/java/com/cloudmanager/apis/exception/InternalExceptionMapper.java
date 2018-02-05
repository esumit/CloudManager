package com.cloudmanager.apis.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InternalExceptionMapper implements ExceptionMapper<InternalErrorException> {

    public Response toResponse(InternalErrorException ex) {

        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),500,"Please reach to Sumit@x.com");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "application/json")
                .entity(errorMessage.toString())
                .build();
    }

}
