package com.cloudmanager.apis.model.action;

import com.cloudmanager.apis.model.misc.MachineFilters;

public class CreateMachinesResponse {

    String MachineName;

    String MachineDescription;

    String givenTag;

    String creationDateAndTime;

    String ipv4Address;

    String pv6Address;

    String imageId;

    MachineFilters resultStatus;

    String message;

    public String getMachineName() {
        return MachineName;
    }

    public void setMachineName(String MachineName) {
        this.MachineName = MachineName;
    }

    public String getMachineDescription() {
        return MachineDescription;
    }

    public void setMachineDescription(String MachineDescription) {
        this.MachineDescription = MachineDescription;
    }

    public String getGivenTag() {
        return givenTag;
    }

    public void setGivenTag(String givenTag) {
        this.givenTag = givenTag;
    }

    public String getCreationDateAndTime() {
        return creationDateAndTime;
    }

    public void setCreationDateAndTime(String creationDateAndTime) {
        this.creationDateAndTime = creationDateAndTime;
    }

    public String getIpv4Address() {
        return ipv4Address;
    }

    public void setIpv4Address(String ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    public String getPv6Address() {
        return pv6Address;
    }

    public void setPv6Address(String pv6Address) {
        this.pv6Address = pv6Address;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public MachineFilters getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(MachineFilters resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
