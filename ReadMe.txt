What is CloudManager
---------------------------
CloudManager manages preDefined Images for a specific account 
in DigitalOcean Cloud.  
It have list of REST APIs to automate and manage 
the DigitalOCean's preDefined Droplets(Cloud Machines) for
project work related specific needs on a specific account,
e.g. preInstalled Images (it contains various predefined
settings, processes and softwares).


![alt tag](https://github.com/esumit/CloudManager/blob/master/images/CloudManager%20and%20DigitalOcean.png)

One of the major use case where it was written to use, its like
a project work require to create a virtual machine by multiple applications
on runtime(with preInstalled stuff) for specific use, and that applications
uses the created machine for a specific period and once the need is
over, it destroy the machine.

Example : A preDefinedVirtual Machine have preInstalled tomcat server, 
and preDefine deployed webapps which are connected with a centralised database. 
This machine have all specific ssl certificates, ip rules, security groups and 
other relevant configurations.

An application on runtime createMachine with the help of this cloudmanager,
Once the machine up then relevant web application is also up. 
That webapplication used by that app to collect set of data and store 
that data into database, once the work is over then it Destroy the machine.

All acivities logged into the database for further analysis.

List of Interfaces :
https://github.com/esumit/CloudManager/blob/master/src/main/java/com/cloudmanager/apis/ICloudManagerServiceEndPoints.java

Its implementation from :
https://github.com/esumit/CloudManager/blob/master/src/main/java/com/cloudmanager/apis/CloudManagerServiceEndPointsImpl.java


List of CloudManager APIs
----------------------------

+++++
listMachines : It list the existing machines which are available to create replica of it.


URL : https://CloudManagerAPIs.com/cloudmanager-service/cloudmanager/listMachines

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

+++++
CreateMachines : It used to create a cloud machine which is replica of any one of
available existing machine. (ImageID refers to the specific machine)

URL :https://CloudManagerAPIs.com/cloudmanager-service/cloudmanager/createMachines

Request Input :

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

+++++
destroyMachines : It destroy the machine once the work would over.

URL : https://CloudManagerAPIs.com/cloudmanager-service/cloudmanager/destroyMachines

Request

     {
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

    Or

   {
    "result": "successfully destroyed",
    "data": "UNKNOWN"
   }

+++++
infoMachines : It provides the list of Machines by Nane, Active Machines

URL : https://CloudManagerAPIs.com/cloudmanager-service/cloudmanager/InfoOfMachines

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

+++++
isMachineCreated : A machines takes like 30 to 50 seconds to get created, this method
checks the staus of machine creation.

URL : https://CloudManagerAPIs.com/cloudmanager-service/cloudmanager/InfoOfMachines

https://CloudManagerAPIs.com/cloudmanager-service/cloudmanager/isMachineCreated

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


 How to build it ?
 ------------------

 Install maven and type command : mvn clean install  (see below logs)

 It will produce : CloudManagerAPIs-1.0-SNAPSHOT.war

 Deploy to TomcatServer

Logs Of mvn clean install
-------------------------
 [INFO]
 [INFO] --- maven-install-plugin:2.4:install (default-install) @ CloudManagerAPIs ---
 [INFO] Installing /Users/eSumit/Documents/Public Github/GitPush/CloudManagerAPIs/target/Code3Manager.war to /Users/eSumit/.m2/repository/com/code3manager/CloudManagerAPIs/1.0-SNAPSHOT/CloudManagerAPIs-1.0-SNAPSHOT.war
 [INFO] Installing /Users/eSumit/Documents/Public Github/GitPush/CloudManagerAPIs/pom.xml to /Users/eSumit/.m2/repository/com/code3manager/CloudManagerAPIs/1.0-SNAPSHOT/CloudManagerAPIs-1.0-SNAPSHOT.pom
 [INFO] ------------------------------------------------------------------------
 [INFO] BUILD SUCCESS
 [INFO] ------------------------------------------------------------------------
 [INFO] Total time: 19.105 s
 [INFO] Finished at: 2018-02-05T14:53:17+10:00
 [INFO] Final Memory: 29M/261M
 [INFO] ------------------------------------------------------------------------

 *Note : DB Part not added to this code, You may add DB part based on your convenience or continue to watch here I will add that part later.
