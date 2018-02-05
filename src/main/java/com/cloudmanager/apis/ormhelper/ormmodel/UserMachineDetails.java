package com.cloudmanager.apis.ormhelper.ormmodel;

public class UserMachineDetails {

    String givenName;
    String givenTag;
    String creationTime;
    String destroyTime;
    String MachineStatus;
    String masterMachineId;
    String imageId;
    String usageStatus;
    String liveTime;
    String ipv4Info;
    String ipv6Info;
    String tabledIndex;

    public String getTabledIndex() {
        return tabledIndex;
    }

    public void setTabledIndex(String tabledIndex) {
        this.tabledIndex = tabledIndex;
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

    public String getUsageStatus() {
        return usageStatus;
    }

    public void setUsageStatus(String usageStatus) {
        this.usageStatus = usageStatus;
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime;
    }

    public String getIpv4Info() {
        return ipv4Info;
    }

    public void setIpv4Info(String ipv4Info) {
        this.ipv4Info = ipv4Info;
    }

    public String getIpv6Info() {
        return ipv6Info;
    }

    public void setIpv6Info(String ipv6Info) {
        this.ipv6Info = ipv6Info;
    }

    @Override
    public String toString() {
        return "UserMachineDetails{" +
                "givenName='" + givenName + '\'' +
                ", givenTag='" + givenTag + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", destroyTime='" + destroyTime + '\'' +
                ", MachineStatus='" + MachineStatus + '\'' +
                ", masterMachineId='" + masterMachineId + '\'' +
                ", imageId='" + imageId + '\'' +
                ", usageStatus='" + usageStatus + '\'' +
                ", liveTime='" + liveTime + '\'' +
                ", ipv4Info='" + ipv4Info + '\'' +
                ", ipv6Info='" + ipv6Info + '\'' +
                '}';
    }

}
