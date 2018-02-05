package com.cloudmanager.apis.model.action;



public class DestroyMachinesResponse {

    String machineName;
    String imageId;
    String message;

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getImageId() {
        return imageId;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "DestroyMachinesResponse{" +
                "machineName='" + machineName + '\'' +
                ", imageId='" + imageId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
