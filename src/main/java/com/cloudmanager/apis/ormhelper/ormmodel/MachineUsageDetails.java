package com.cloudmanager.apis.ormhelper.ormmodel;

public class MachineUsageDetails {

    String userId;
    String givenName;
    String givenTag;
    String creationTime;
    String destroyTime;
    String MachineStatus;
    String masterMachineId;
    String imageId;
    String isBackup;
    String isSnapshot;
    String usgaeStatus;
    String actionPerformedBy;
    String userType;
    String ipV4Address;
    String ipV6Address;
    String region;
    String networkInfo;
    String comments;
    String liveTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getGivenTag() {
        return givenTag;
    }

    public void setGivenTag(String givenTag) {
        this.givenTag = givenTag;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(String destroyTime) {
        this.destroyTime = destroyTime;
    }

    public String getMachineStatus() {
        return MachineStatus;
    }

    public void setMachineStatus(String MachineStatus) {
        this.MachineStatus = MachineStatus;
    }

    public String getMasterMachineId() {
        return masterMachineId;
    }

    public void setMasterMachineId(String masterMachineId) {
        this.masterMachineId = masterMachineId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getIsBackup() {
        return isBackup;
    }

    public void setIsBackup(String isBackup) {
        this.isBackup = isBackup;
    }

    public String getIsSnapshot() {
        return isSnapshot;
    }

    public void setIsSnapshot(String isSnapshot) {
        this.isSnapshot = isSnapshot;
    }

    public String getUsgaeStatus() {
        return usgaeStatus;
    }

    public void setUsgaeStatus(String usgaeStatus) {
        this.usgaeStatus = usgaeStatus;
    }

    public String getActionPerformedBy() {
        return actionPerformedBy;
    }

    public void setActionPerformedBy(String actionPerformedBy) {
        this.actionPerformedBy = actionPerformedBy;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIpV4Address() {
        return ipV4Address;
    }

    public void setIpV4Address(String ipV4Address) {
        this.ipV4Address = ipV4Address;
    }

    public String getIpV6Address() {
        return ipV6Address;
    }

    public void setIpV6Address(String ipV6Address) {
        this.ipV6Address = ipV6Address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNetworkInfo() {
        return networkInfo;
    }

    public void setNetworkInfo(String networkInfo) {
        this.networkInfo = networkInfo;
    }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime;
    }


    @Override
    public String toString() {
        return "MachineUsageDetails{" +
                "userId='" + userId + '\'' +
                ", givenName='" + givenName + '\'' +
                ", givenTag='" + givenTag + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", destroyTime='" + destroyTime + '\'' +
                ", MachineStatus='" + MachineStatus + '\'' +
                ", masterMachineId='" + masterMachineId + '\'' +
                ", imageId='" + imageId + '\'' +
                ", isBackup='" + isBackup + '\'' +
                ", isSnapshot='" + isSnapshot + '\'' +
                ", usgaeStatus='" + usgaeStatus + '\'' +
                ", actionPerformedBy='" + actionPerformedBy + '\'' +
                ", userType='" + userType + '\'' +
                ", ipV4Address='" + ipV4Address + '\'' +
                ", ipV6Address='" + ipV6Address + '\'' +
                ", region='" + region + '\'' +
                ", networkInfo='" + networkInfo + '\'' +
                ", comments='" + comments + '\'' +
                ", liveTime='" + liveTime + '\'' +
                '}';
    }

}
