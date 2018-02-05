package com.cloudmanager.apis.model.action;

import com.myjeeva.digitalocean.pojo.Network;
import com.myjeeva.digitalocean.pojo.Networks;


public class IsMachineCreatedResponse {

    String imageId;
    String status;
    String message;
    String networkInfo;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNetworkInfo() {
        return networkInfo;
    }

    public void setNetworkInfo(String networkInfo) {
        this.networkInfo = networkInfo;
    }


    @Override
    public String toString() {
        return "IsMachineCreatedResponse{" +
                "imageId='" + imageId + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", networkInfo='" + networkInfo + '\'' +
                '}';
    }

}
