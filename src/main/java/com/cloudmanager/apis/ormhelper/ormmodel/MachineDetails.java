package com.cloudmanager.apis.ormhelper.ormmodel;

public class MachineDetails {

    String imageId;
    String hwSwConfig;
    String masterId;

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getHwSwConfig() {
        return hwSwConfig;
    }

    public void setHwSwConfig(String hwSwConfig) {
        this.hwSwConfig = hwSwConfig;
    }

}
