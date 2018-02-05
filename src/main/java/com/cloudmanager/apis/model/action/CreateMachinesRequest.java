package com.cloudmanager.apis.model.action;

import com.cloudmanager.apis.model.user.UserCredentials;


public class CreateMachinesRequest {

    UserCredentials accessDetails;
    String tag;

    String givenName;

    String sizeSlug;

    String regionSlug;

    String imageId;

    String masterId;


    public UserCredentials getAccessDetails() {
        return accessDetails;
    }

    public void setAccessDetails(UserCredentials accessDetails) {
        this.accessDetails = accessDetails;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSizeSlug() {
        return sizeSlug;
    }

    public void setSizeSlug(String sizeSlug) {
        this.sizeSlug = sizeSlug;
    }

    public String getRegionSlug() {
        return regionSlug;
    }

    public void setRegionSlug(String regionSlug) {
        this.regionSlug = regionSlug;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }



    @Override
    public String toString() {
        return "CreateMachinesRequest{" +
                "accessDetails=" + accessDetails +
                ", tag='" + tag + '\'' +
                ", givenName='" + givenName + '\'' +
                ", sizeSlug='" + sizeSlug + '\'' +
                ", regionSlug='" + regionSlug + '\'' +
                ", imageId='" + imageId + '\'' +
                ", masterId='" + masterId + '\'' +
                '}';
    }


}
