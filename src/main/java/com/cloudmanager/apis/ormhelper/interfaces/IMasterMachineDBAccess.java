package com.cloudmanager.apis.ormhelper.interfaces;

import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.action.ListOfMachinesResponse;
import com.cloudmanager.apis.model.misc.MachineFilters;
import com.cloudmanager.apis.ormhelper.ormmodel.MachineDetails;

public interface IMasterMachineDBAccess {

    ListOfMachinesResponse getListOfMachines(MachineFilters machineFilters) throws DAOException,InternalErrorException;
    public MachineDetails getMachineInfoByName(String machineName) throws DAOException,InternalErrorException;
}
