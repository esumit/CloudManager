package com.cloudmanager.apis.model.action;

import com.cloudmanager.apis.model.misc.MachineFilters;
import com.cloudmanager.apis.model.user.UserCredentials;


public class InfoMachineRequest {
    private UserCredentials accessDetails;
    private MachineFilters MachineType;
    private String startDate;
    private String endDate;
    private String MachineName;
    private String infoRequestType;

    public String getInfoRequestType() {
        return infoRequestType;
    }

    public void setInfoRequestType(String infoRequestType) {
        this.infoRequestType = infoRequestType;
    }


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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMachineName() {
        return MachineName;
    }

    public void setMachineName(String MachineName) {
        this.MachineName = MachineName;
    }

    @Override
    public String toString() {
        return "InfoMachinesRequest{" +
                "accessDetails=" + accessDetails +
                ", MachineType=" + MachineType +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", MachineName='" + MachineName + '\'' +
                ", infoRequestType='" + infoRequestType + '\'' +
                '}';
    }

}
