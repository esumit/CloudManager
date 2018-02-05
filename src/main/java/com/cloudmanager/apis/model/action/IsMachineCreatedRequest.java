package com.cloudmanager.apis.model.action;

import com.cloudmanager.apis.model.user.UserCredentials;


public class IsMachineCreatedRequest {

    UserCredentials accessDetails;

    String imageId;

    String reason;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "IsMachineCreatedRequest{" +
                "accessDetails=" + accessDetails +
                ", imageId='" + imageId + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }



}
