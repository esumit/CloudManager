package com.cloudmanager.apis.model.action;



import com.cloudmanager.apis.ormhelper.ormmodel.MachineDetails;

import java.util.List;


public class ListOfMachinesResponse {
    List<MachineDetails> listOfMachines;
    String countOfMachines;
    String message;

    public List<MachineDetails> getListOfMachines() {
        return listOfMachines;
    }

    public void setListOfMachines(List<MachineDetails> listOfMachines) {
        this.listOfMachines = listOfMachines;
    }

    public String getCountOfMachines() {
        return countOfMachines;
    }

    public void setCountOfMachines(String countOfMachines) {
        this.countOfMachines = countOfMachines;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ListOfMachinesResponse{" +
                "listOfMachines=" + listOfMachines +
                ", countOfMachines='" + countOfMachines + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}


