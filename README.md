# Credit Card Management System
## Overview
This system provides automated storing and processing of data as well as a tool to easily manipulate and query data. 

It utilizes the Hortonworks Platform powered by Apache Hadoop for storing, processing, and analyzing large volumes of credit card data.
A custom-built Java application is used to query the data.
## RDMBS
In order to access the pre-existing data you must load the data into a RDMS. 
This system uses MySQL to store the initial data.
This is the source in the ETL process.
Soure file is located in `mySQLDump/` folder.

Loading from Command Line:

**Note: Must be in directory with file for commands to work**

```
mysql;
create database CDW_SAPP;
use CDW_SAPP;
source cdw_sapp_db.sql;
```

## Java Business Tool Module
### Overview
This module serves as a tool to the business user e.g. banker/teller to easily query the database.

Queries that can be ran are:  
  * Get Customer Details
  * Modify Customer Details
  * Get Number and Total Transactions by Type
  * Generate Customer Bill
  * Display Transaction between Dates
  * Get Transactions by ZipCode
  * Get Number and Total Transactions by State
  
**Note: Queries are predefined**

Folders that are related to the java module are: 
* .idea 
* resources  
* src 

## Hadoop Module
### Overview
This module serves as a tool for automating backup, storing big data effectively, and querying of the Data Warehouse.

All files related to HortonWorks/Hadoop are located in the folder HadoopFiles.

Components used from the Hadoop Ecosystem are:
* HDFS
* Hive
* Sqoop
* Oozie

#### HDFS
In HDFS , we primarily use the maria_dev user to manipulate and access files therefore we put all pertinent files in this directory `/user/maria_dev/` . Because the sqoop file will take care of making the target directory Credit_Card_System we don’t need to explicitly make it.


#### Hive
The Hive files are to create the tables in the Hadoop ecosystem. These are meant to be the target tables in the ETL process.

Hive table files are located in `HadoopFiles/hiveTables/`.


#### Sqoop
Sqoop is used to migrate the data from rdms to the Hadoop system. The transformation step of the data is also done in this process according to the business requirements.
Sqoop commands are saved as jobs to be used repeatedly in the Oozie Workflow and also to saved for optimization to only grab new data from RDMBS.

**Note:** In order to use the jobs command in Oozie Workflow we need to have the sqoop metastore running. Before running any sqoop jobs or oozie workflows you must start the metastore with the command `sqoop-metastore`.

Sqoop commands/jobs are located in `HadoopFiles/sqoop_jobs/`.

#### Oozie

Oozie is used to automate and schedule the workflow to occur every 20 minutes between dates given in business requirements. 

Oozie files are found in `HadoopFiles/oozie_jobs/`.

`workflow.xml` and `coordinator.xml` should be put into HDFS where it can be found.
On the system, it is located at `/user/maria_dev/oozie_jobs/`.

`job.properties` should be put on the local system where it can be found.
On the system, `job.properties` is located in `Documents/`.


Command to kick off automated workflow 

`oozie job -oozie https://localhost:11000/sqoop -config <location-of-jobs.properties file> -run`

Command to stop/suspend automated workflow 

`oozie job -oozie https://localhost:11000/sqoop -suspend job-id`

`oozie job -oozie https://localhost:11000/sqoop -kill job-id`

**NOTE:** Must be ran from local system not Hadoop
