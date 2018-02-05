package com.cloudmanager.apis;

import com.cloudmanager.apis.action.*;
import com.cloudmanager.apis.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("cloudmanagerservice")
public class CloudManagerServiceEndPointsImpl implements ICloudManagerServiceEndPoints {


    // Initialize the Log4j logger.
    static final Logger logger = Logger.getLogger(CloudManagerServiceEndPointsImpl.class);

    @Autowired
    DestroyMachinesAction destroyMachinesAction;

    @Autowired
    InfoMachinesAction infoMachinesAction;


    @Autowired
    CreateMachinesAction createMachinesAction;

    @Autowired
    ListOfMachinesAction listOfMachinesAction;

    @Autowired
    ISMachineCreatedAction isMachineCreatedAction;

    @Autowired
    StartMachineAction startMachineAction;

    @Autowired
    StopMachineAction stopMachineAction;


   /*
     URL : http://localhost:8080/cloudmanager-service/cloudmanager/listMachines

     Request :

         {
        "accessDetails":
        {
            "userId":"sumit@x.com",
            "accessToken":"ADSADDSDSFSFSFSDF"
        },
        "MachineType":"Machine_LIVE"
      }

    Response :

     {
    "listOfMachines": [
        {
            "masterId": "1",
            "givenName": "Machine-2GB",
            "imageId": "XXXXXX",
            "creationTime": "2017-09-04T06:52:19Z",
            "hwSwConfig": "Ubuntu1604-2gb-nyc3&sfo1-vcpu2-disk40gb",
            "desc": "Machine deployed in Ubuntu1604-2gb-nyc3&sfo1-vcpu2-disk40gb VM. ",
            "mode": "MACHINE_LIVE",
            "whoAdmin": "sumit@x.com",
            "comments": "Machine added by sumit@x.com for test purpose."
        },
        {
            "masterId": "2",
            "givenName": "Machine-4GB",
            "imageId": "XXXXX",
            "creationTime": "2017-09-04T07:20:38Z",
            "hwSwConfig": "Ubuntu1604-4gb-nyc3&sfo1-vcpu2-disk60gb",
            "desc": "Machine deployed in Ubuntu1604-4gb-nyc3&sfo1-vcpu2-disk60gb VM.",
            "mode": "MACHINE_LIVE",
            "whoAdmin": "sumit@x.com",
            "comments": "Machine added by sumit@x.com for test purpose."
        }
            ],
            "countOfMachines": "2",
            "message": "Success"
        }

    */


    public String listOfMachines(String request) {

        return listOfMachinesAction.handle(request);
    }


    /*
      http://localhost:8080/cloudmanager-service/cloudmanager/createMachines

     Request Response :

      {
        "accessDetails":
        {
            "userId":"sumit@x.com",
            "accessToken":"ADSADDSDSFSFSFSDF"
        },
        "givenName":"Sumit_2GB_Instance",
        "sizeSlug":"TWOGB",
        "regionSlug":"NEWYORK1",
        "imageId":"27563444",
        "tag":"Default"
     }

    If Error

     {
      "ErrorMessage": "BAD_REQ: Invalid input parameters--The image you specified is not
       available in the selected region, you can transfer it to this region from the images pages.",
      "ErrorCode": "400",
      "documentation": "Please reach to Sumit@x.com"
    }

    Droplet Response :

            {
            "id": 6XXXXXXX,
            "name": "SumitGBInstance--sumitxcom",
            "memory": 2048,
            "vcpus": 2,
            "disk": 40,
            "region": {
                "slug": "nyc3",
                "name": "New York 3",
                "sizes": [
                    "512mb",
                    "1gb",
                    "2gb",
                    "c-2",
                    "4gb",
                    "c-4",
                    "8gb",
                    "c-8",
                    "16gb",
                    "m-16gb",
                    "c-16",
                    "32gb",
                    "m-32gb",
                    "48gb",
                    "c-32",
                    "m-64gb",
                    "64gb",
                    "m-128gb",
                    "m-224gb"
                ],
                "available": true,
                "features": [
                    "private_networking",
                    "backups",
                    "ipv6",
                    "metadata",
                    "install_agent"
                ]
            },
            "image": {
                "id": 2XXXXXXX,
                "name": "Machine-Ubuntu1604-2gb-nyc3&sfo1-vcpu2-disk40gb-4Sep2017",
                "distribution": "Ubuntu",
                "public": false,
                "regions": [
                    "sfo1",
                    "nyc3",
                    "blr1"
                ],
                "created_at": "Sep 4, 2017 12:22:19 PM",
                "min_disk_size": 40,
                "size_gigabytes": 8.55,
                "type": "snapshot"
            },
            "size_slug": "2gb",
            "locked": true,
            "status": "new",
            "networks": {
                "v4": [],
                "v6": []
            },
            "created_at": "Sep 6, 2017 1:46:17 PM",
            "features": [],
            "backup_ids": [],
            "snapshot_ids": [],
            "volume_ids": [],
            "tags": [],
            "rate_limit": {
                "limit": 5000,
                "remaining": 4997,
                "reset": "Sep 6, 2017 2:07:55 PM"
            }
        }

       http://localhost:8080/cloudmanager-service/cloudmanager/createMachines

        Request :

        {
            "accessDetails":
            {
                "userId":"sumit@x.com",
                "accessToken":"ADSADDSDSFSFSFSDF"
            },
            "givenName":"Sumit4GBAnotherInstance",
            "sizeSlug":"TWOGB",
            "regionSlug":"SANFRANCISCO1",
            "imageId":"27563444",
            "tag":"DefaultTEST",
            "masterId":"1"
        }

        Response :

        {
            "MachineName": "Sumit4GBAnotherInstance",
            "givenTag": "DefaultTEST",
            "creationDateAndTime": "Fri Sep 08 16:13:16 IST 2017",
            "ipv4Address": "UNKNOWN",
            "pv6Address": "UNKNOWN",
            "imageId": "61486962",
            "resultStatus": "MACHINE_UCREATED",
            "message": "Machine is on creation Status, get more information e.g. by calling : isMachineCreated API with
            path likecloudmanager-service/cloudmanager/isMachineCreated"
        }


     */
    public String createMachines(String request) throws ServiceException{

        return createMachinesAction.handle(request);
    }

    /*
            {
            "accessDetails":
            {
                "userId":"sumit@x.com",
                "accessToken":"ADSADDSDSFSFSFSDF"
            },
            "givenName":"Sumit4GBAnotherInstanc",
            "imageId":"61513693"
        }

        Response :

         {
            "ErrorMessage": "BAD_REQ: No Machine exist with given name or id or both-- Invalid:Machine_DESTROYED",
            "ErrorCode": "400",
            "documentation": "Please reach to Sumit@x.com"
        }
     */



    public String destroyMachines(String request) throws ServiceException{

        return destroyMachinesAction.handle(request);

    }


    /*
       Request :

         {
            "accessDetails":
            {
                "userId":"sumit@x.com",
                "accessToken":"ADSADDSDSFSFSFSDF"
            },
            "MachineName":"Sumit4GBAnotherInstanc",
            "infoRequestType":"MACHINE_BY_NAME"
        }

        or

        {
            "accessDetails":
            {
                "userId":"sumit@x.com",
                "accessToken":"ADSADDSDSFSFSFSDF"
            },
            "MachineName":"Sumit2GSeattleBombay",
            "infoRequestType":"MACHINE_ALL"
        }

        Response :
            {
            "ErrorMessage": "BAD_REQ: DAOException : Exception while accessing Database---No Machine found in Machine Database",
            "ErrorCode": "400",
            "documentation": "Please reach to Sumit@x.com"
        }

        or

        {
    "userMachineDetailsList": [
        {
            "givenName": "Sumit2GSeattleBombay",
            "givenTag": "DefaultTEST",
            "creationTime": "Fri Sep 08 20:33:40 IST 2017",
            "destroyTime": "2017-09-08T20:38:31.464",
            "Machinestatus": "MACHINE_DESTROYED",
            "masterMachineId": "1",
            "imageId": "61513693",
            "usageStatus": "sumit@x.com",
            "liveTime": "Fri Sep 08 20:33:40 IST 2017",
            "ipv4Info": "[  {    \"ip_address\": \"104.131.129.186\",    \"netmask\": \"255.255.240.0\",    \"gateway\": \"104.131.128.1\",    \"type\": \"public\"  }]",
            "ipv6Info": "[  {    \"ip_address\": \"2604:A880:0001:0020:0000:0000:435B:B001\",    \"netmask\": \"64\",    \"gateway\": \"2604:A880:0001:0020:0000:0000:0000:0001\",    \"type\": \"public\"  }]",
            "tabledIndex": "12"
        }
            ],
            "count": "1",
            "message": "Success"
        }

        or

        {
    "userMachineDetailsList": [
        {
            "givenName": "Sumit4GBAnotherInstance",
            "givenTag": "DefaultTEST",
            "creationTime": "Fri Sep 08 17:06:49 IST 2017",
            "destroyTime": "2017-09-08T19:29:46.955",
            "Machinestatus": "MACHINE_DESTROYED",
            "masterMachineId": "1",
            "imageId": "61492871",
            "usageStatus": "sumit@x.com",
            "liveTime": "Fri Sep 08 17:06:49 IST 2017",
            "ipv4Info": "[\n  {\n    \"ip_address\": \"104.236.150.37\",\n    \"netmask\": \"255.255.192.0\",\n    \"gateway\": \"104.236.128.1\",\n    \"type\": \"public\"\n  }\n]",
            "ipv6Info": "[\n  {\n    \"ip_address\": \"2604:A880:0001:0020:0000:0000:434E:8001\",\n    \"netmask\": \"64\",\n    \"gateway\": \"2604:A880:0001:0020:0000:0000:0000:0001\",\n    \"type\": \"public\"\n  }\n]",
            "tabledIndex": "8"
        },
        {
            "givenName": "Sumit2GBLondon",
            "givenTag": "DefaultTEST",
            "creationTime": "Fri Sep 08 20:01:51 IST 2017",
            "destroyTime": "2017-09-08T20:09:58.114",
            "Machinestatus": "MACHINE_CREATED",
            "masterMachineId": "1",
            "imageId": "61510463",
            "usageStatus": "sumit@x.com",
            "liveTime": "UNKNOWN",
            "ipv4Info": "UNKNOWN",
            "ipv6Info": "UNKNOWN",
            "tabledIndex": "9"
        },
        {
            "givenName": "Sumit2GBLondonSeattle",
            "givenTag": "DefaultTEST",
            "creationTime": "Fri Sep 08 20:13:28 IST 2017",
            "destroyTime": "UNKNOWN",
            "Machinestatus": "MACHINE_DESTROYED",
            "masterMachineId": "1",
            "imageId": "61511672",
            "usageStatus": "sumit@x.com",
            "liveTime": "UNKNOWN",
            "ipv4Info": "UNKNOWN",
            "ipv6Info": "UNKNOWN",
            "tabledIndex": "10"
        },
        {
            "givenName": "Sumit2GSeattle",
            "givenTag": "DefaultTEST",
            "creationTime": "Fri Sep 08 20:16:21 IST 2017",
            "destroyTime": "UNKNOWN",
            "Machinestatus": "MACHINE_DESTROYED",
            "masterMachineId": "1",
            "imageId": "61511966",
            "usageStatus": "sumit@x.com",
            "liveTime": "UNKNOWN",
            "ipv4Info": "UNKNOWN",
            "ipv6Info": "UNKNOWN",
            "tabledIndex": "11"
        },
        {
            "givenName": "Sumit2GSeattleBombay",
                    "givenTag": "DefaultTEST",
                    "creationTime": "Fri Sep 08 20:33:40 IST 2017",
                    "destroyTime": "2017-09-08T20:38:31.464",
                    "Machinestatus": "MACHINE_DESTROYED",
                    "masterMachineId": "1",
                    "imageId": "61513693",
                    "usageStatus": "sumit@x.com",
                    "liveTime": "Fri Sep 08 20:33:40 IST 2017",
                    "ipv4Info": "[  {    \"ip_address\": \"104.131.129.186\",    \"netmask\": \"255.255.240.0\",    \"gateway\": \"104.131.128.1\",    \"type\": \"public\"  }]",
                    "ipv6Info": "[  {    \"ip_address\": \"2604:A880:0001:0020:0000:0000:435B:B001\",    \"netmask\": \"64\",    \"gateway\": \"2604:A880:0001:0020:0000:0000:0000:0001\",    \"type\": \"public\"  }]",
                    "tabledIndex": "12"
                }
            ],
            "count": "5",
            "message": "Success"
        }

     */
    public String inforOfMachines(String request) throws ServiceException{

        return infoMachinesAction.handle(request);

    }

    /*
      http://localhost:8080/cloudmanager-service/cloudmanager/isMachineCreated

      Request :

      {
            "accessDetails":
            {
                "userId":"sumit@x.com",
                "accessToken":"ADSADDSDSFSFSFSDF"
            },
            "imageId":"61332125",
            "reason":"CreationStatus"
        }

        Response : (NEW or ACTIVE)

        {
            "imageId": "61332125",
            "status": "new",
            "message": "Machine not Active yet",
            "networkInfo": {
                "v4": [
                    {
                        "ip_address": "107.170.214.83",
                        "netmask": "255.255.240.0",
                        "gateway": "107.170.208.1",
                        "type": "public"
                    }
                ],
                "v6": [
                    {
                        "ip_address": "2604:A880:0001:0020:0000:0000:4306:8001",
                        "netmask": "64",
                        "gateway": "2604:A880:0001:0020:0000:0000:0000:0001",
                        "type": "public"
                    }
                ]
            }
        }

        OR

        {
            "imageId": "61332125",
            "status": "active",
            "message": "Machine Active Now",
            "networkInfo": {
                "v4": [
                    {
                        "ip_address": "107.170.214.83",
                        "netmask": "255.255.240.0",
                        "gateway": "107.170.208.1",
                        "type": "public"
                    }
                ],
                "v6": [
                    {
                        "ip_address": "2604:A880:0001:0020:0000:0000:4306:8001",
                        "netmask": "64",
                        "gateway": "2604:A880:0001:0020:0000:0000:0000:0001",
                        "type": "public"
                    }
                ]
            }
        }
     */

    public String isMachineCreated(String request) {

       return isMachineCreatedAction.handle(request);

    }

}
