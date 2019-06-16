# api-automation
 This project uses REST ASSURED to query api, validate ResponseCode and to validate JSON payload, TestNG as the test harness
 and gradle as the build automation tool.
 
## FRAME WORK STACK 
 ```
 1. REST ASSURED 3.3.0
 2. JSON
 3. slf4j-api 1.7.25
 4. slf4j-simple 1.7.25 
 5. TestNG 6.14.3  
 6. GRADLE
 ```
 
 ## DATA 
 ```
 1. Test environment related data is passed via command line and will be written to the environment.txt file by a gradle task.
 Then it will be set as System property so that that the environment related config file can be invoked and executed.
 
 2.Command line argument for execution- 'gradle -PenvType=env1 -PtestSuite test'
  env1 is the config file already created and testSuite refers to the execution of the xml file TestFile.xml which can be
  executed by invoking test.
  Can have different config files as well as xml files for executing with different parameters
  ```
