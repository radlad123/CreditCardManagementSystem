# Credit Card Management System
## Overview
This system provides automated storing and processing of data as well as a tool to easily change/query data. 

It uses the Hortonworks Platform powered by Apache Hadoop for storing, processing, and analyzing large volumes of credit card data.
A custom-built Java application is used to query the data.
## RDMBS
In order to access the pre-existing data you must load the data into a RDMS. 
We used MySQL to store the initial data.
Soure file is located in mySQLDump folder.

Loading from Command Line:

**Note: Must be in directory with file for commands to work**

``` 
mysql;
create database CDW_SAPP;
use CDW_SAPP;
source cdw_sapp_db.sql;
````

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
This module serves as a tool for automated backup, storing big data effectively, and querying of the Data Warehouse.

All files related to HortonWorks/Hadoop are located in the folder HadoopFiles.

- [ ] HDFS
- [ ] Hive
- [ ] Sqoop
- [ ] Oozie




