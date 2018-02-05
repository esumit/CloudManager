package com.cloudmanager.apis.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {


    public Response toResponse(BadRequestException ex) {

        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),400,"Please reach to Sumit@x.com");
        return Response.status(Response.Status.BAD_REQUEST)
                .header("Content-Type", "application/json")
                .entity(errorMessage.toString())
                .build();
    }
}
