package com.cloudmanager.apis.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    public Response toResponse(Throwable th) {

        ErrorMessage errorMessage = new ErrorMessage(th.getMessage(),500,"Please reach to Sumit@x.com");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                 .header("Content-Type", "application/json")
                .entity(errorMessage.toString())
                .build();
    }
}
