package com.cloudmanager.apis.model.action;

import com.myjeeva.digitalocean.pojo.Network;


public class ExistingMachineResponse {
    String MachineStatus;
    String networkInfo;

    public String getMachineStatus() {
        return MachineStatus;
    }

    public void setMachineStatus(String MachineStatus) {
        this.MachineStatus = MachineStatus;
    }

    public String getNetworkInfo() {
        return networkInfo;
    }

    public void setNetworkInfo(String networkInfo) {
        this.networkInfo = networkInfo;
    }

    @Override
    public String toString() {
        return "ExistingMachineResponse{" +
                "MachineStatus='" + MachineStatus + '\'' +
                ", networkInfo='" + networkInfo + '\'' +
                '}';
    }
}
