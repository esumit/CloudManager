package com.cloudmanager.apis.model.misc;

/**
 * .
 */
public class MasterMachinesDetails {

    String masterId;
    String givenName;
    String imageId;
    String creationTime;
    String destroyTime;
    String hwSwConfig;
    String desc;
    String mode;
    String whoAdmin;
    String actionPerformedby;
    String comments;

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
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

    public String getHwSwConfig() {
        return hwSwConfig;
    }

    public void setHwSwConfig(String hwSwConfig) {
        this.hwSwConfig = hwSwConfig;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getWhoAdmin() {
        return whoAdmin;
    }

    public void setWhoAdmin(String whoAdmin) {
        this.whoAdmin = whoAdmin;
    }

    public String getActionPerformedby() {
        return actionPerformedby;
    }

    public void setActionPerformedby(String actionPerformedby) {
        this.actionPerformedby = actionPerformedby;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "MasterMachinesDetails{" +
                "masterId='" + masterId + '\'' +
                ", givenName='" + givenName + '\'' +
                ", imageId='" + imageId + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", destroyTime='" + destroyTime + '\'' +
                ", hwSwConfig='" + hwSwConfig + '\'' +
                ", desc='" + desc + '\'' +
                ", mode='" + mode + '\'' +
                ", whoAdmin='" + whoAdmin + '\'' +
                ", actionPerformedby='" + actionPerformedby + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

}
