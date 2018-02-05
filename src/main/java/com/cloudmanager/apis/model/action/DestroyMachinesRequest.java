package com.cloudmanager.apis.model.action;

import com.cloudmanager.apis.model.user.UserCredentials;


public class DestroyMachinesRequest {

    UserCredentials accessDetails;
    String givenName;
    String imageId;


    public UserCredentials getAccessDetails() {
        return accessDetails;
    }

    public void setAccessDetails(UserCredentials accessDetails) {
        this.accessDetails = accessDetails;
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


    @Override
    public String toString() {
        return "DestroyMachinesRequest{" +
                "accessDetails=" + accessDetails +
                ", givenName='" + givenName + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }




}
