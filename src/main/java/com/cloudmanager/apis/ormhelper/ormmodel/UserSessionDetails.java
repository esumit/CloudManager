package com.cloudmanager.apis.ormhelper.ormmodel;

public class UserSessionDetails {

    String userId;
    String sessionToken;
    String creationTime;
    String validUpTo;
    String MachineIPV4;
    String MachineIPV6;
    String tokenStatus;
    String MachineStatus;
    String deviceId;
    String imageId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getValidUpTo() {
        return validUpTo;
    }

    public void setValidUpTo(String validUpTo) {
        this.validUpTo = validUpTo;
    }

    public String getMachineIPV4() {
        return MachineIPV4;
    }

    public void setMachineIPV4(String MachineIPV4) {
        this.MachineIPV4 = MachineIPV4;
    }

    public String getMachineIPV6() {
        return MachineIPV6;
    }

    public void setMachineIPV6(String MachineIPV6) {
        this.MachineIPV6 = MachineIPV6;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getMachineStatus() {
        return MachineStatus;
    }

    public void setMachineStatus(String MachineStatus) {
        this.MachineStatus = MachineStatus;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }


}
