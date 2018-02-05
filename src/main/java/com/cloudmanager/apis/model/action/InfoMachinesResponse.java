package com.cloudmanager.apis.model.action;

import com.cloudmanager.apis.ormhelper.ormmodel.UserMachineDetails;

import java.util.List;


public class InfoMachinesResponse {
    List<UserMachineDetails> userMachineDetailsList;
    String count;
    String message;

    public List<UserMachineDetails> getUserMachineDetailsList() {
        return userMachineDetailsList;
    }

    public void setUserMachineDetailsList(List<UserMachineDetails> userMachineDetailsList) {
        this.userMachineDetailsList = userMachineDetailsList;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "InfoMachinesResponse{" +
                "userMachineDetailsList=" + userMachineDetailsList +
                ", count='" + count + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}
