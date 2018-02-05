package com.cloudmanager.apis.ormhelper.interfaces;

import com.cloudmanager.apis.exception.DAOException;
import com.cloudmanager.apis.exception.InternalErrorException;
import com.cloudmanager.apis.model.action.CreateMachinesResponse;
import com.cloudmanager.apis.model.action.ExistingMachineResponse;
import com.cloudmanager.apis.model.action.InfoMachinesResponse;
import com.cloudmanager.apis.ormhelper.ormmodel.MachineUsageDetails;
import com.myjeeva.digitalocean.pojo.Networks;


public interface IMachineUsageDBAccess {

    CreateMachinesResponse insertMachineActivityInDB(MachineUsageDetails MachineUsageDetails) throws DAOException;

    String updateMachineLiveTimeAndNetworkInfo(String imageId, String liveTime, String networkInfo, String ipv4Info,
                                               String ipv6Info, String status, String userId) throws DAOException;

    String  checkExistingMachineName(String MachineName, String userId) throws DAOException,InternalErrorException;

    String updateMachineDestroyStatus(String imageId, String userId , String destroyStatus) throws DAOException;

    InfoMachinesResponse getMachinesByUserId(String userId)throws DAOException;

    InfoMachinesResponse getMachinesByUserIdAndMachinesName(String userId, String givenName)throws DAOException;

}
