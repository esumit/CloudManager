package com.cloudmanager.apis.model.action;


import com.cloudmanager.apis.model.misc.MachineFilters;
import com.cloudmanager.apis.model.user.UserCredentials;


public class ListOfMachineRequest {
    private UserCredentials accessDetails;
    private MachineFilters MachineType;


    public UserCredentials getAccessDetails() {
        return accessDetails;
    }

    public void setAccessDetails(UserCredentials accessDetails) {
        this.accessDetails = accessDetails;
    }

    public MachineFilters getMachineType() {
        return MachineType;
    }

    public void setMachineType(MachineFilters MachineType) {
        this.MachineType = MachineType;
    }
}
