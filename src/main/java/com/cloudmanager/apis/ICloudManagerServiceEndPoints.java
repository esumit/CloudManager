package com.cloudmanager.apis;

import com.cloudmanager.apis.exception.ServiceException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/cloudmanager")
public interface ICloudManagerServiceEndPoints {

    @POST
    @Path("/listMachines")
    @Produces(MediaType.APPLICATION_JSON)
    public String listOfMachines(String request)throws ServiceException;

    @POST
    @Path("/createMachines")
    @Produces(MediaType.APPLICATION_JSON)

    public String createMachines(String request) throws ServiceException;

    @POST
    @Path("/destroyMachines")
    @Produces(MediaType.APPLICATION_JSON)
    public String destroyMachines(String request) throws ServiceException;

    @POST
    @Path("/infoMachines")
    @Produces(MediaType.APPLICATION_JSON)
    public String inforOfMachines(String request) throws ServiceException;

    @POST
    @Path("/isMachineCreated")
    @Produces(MediaType.APPLICATION_JSON)
    public String isMachineCreated(String request) throws ServiceException;

}
