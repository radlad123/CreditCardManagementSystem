# Credit Card Management System
## Overview
This system provides automated storing and processing of data as well as a tool to easily manipulate and query data. 

It utilizes the Hortonworks Platform powered by Apache Hadoop for storing, processing, and analyzing large volumes of credit card data.
A custom-built Java application is used to query the data.
## RDMBS
In order to access the pre-existing data you must load the data into a RDMS. 
We used MySQL to store the initial data.
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

- [ ] Architecture/FileStructure
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
The Hive files are to create the tables in the Hadoop ecosystem. These are meant to be the target tables in the ETL process
Hive table files are located in `HadoopFiles/hiveTables/`.


#### Sqoop
Sqoop is used to migrate the data from rdms to the Hadoop system. The transformation step of the data is also done in this process according to the business requirements.
Sqoop commands are saved as jobs to be used repeatedly in the Oozie Workflow and also to saved for optimization to only grab new data from RDMBS.
**Note:** In order to use the jobs command in Oozie Workflow we need to have the sqoop metastore running. Before running any sqoop jobs or oozie workflows you must start the metastore with the command `sqoop-metastore`.

Sqoop commands/jobs are located in `HadoopFiles/sqoop_jobs/`.

#### Oozie




- [ ] HDFS
- [ ] Hive
- [ ] Sqoop
- [ ] Oozie



