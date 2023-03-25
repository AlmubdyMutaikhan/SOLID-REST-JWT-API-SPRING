# Project description
```
Implementation of bank app enabled with JDBC usage, REST API handling and CLI program powered by SOLID principles.
```

# Project requirements
1. IDE: IntelijIdea IDE.
2. Framework: Spring Framework and Spring Boot
3. Declaration of Beans: via @Annotations

# Run
Before you even create a build.gradle file for the project, you can ask it what tasks are available:
```
gradle tasks
```
Ensure you have build.gradle file, then build the project type the command below on terminal
```
gradle build
```
## Build the project with gradle-wrapper
The Gradle Wrapper is the preferred way of starting a Gradle build. It consists of a batch script for Windows and a shell script for OS X and Linux.
These scripts allow you to run a Gradle build without requiring that Gradle be installed on your system. 
This used to be something added to your build file, 
but it’s been folded into Gradle, so there is no longer any need. Instead, you simply use the following command.
```
gradle wrapper --gradle-version 6.0.1
```
## After building
Run the DemoApplication.java class as it contains main() method.
Spring boot application should start with some output logs.
Go to http://localhost:8080/swagger-ui/index.html# to learn the REST API.

## Remarks
1. Added new classes(TransactionBasicCLI, TransactionListingServiceImpl) and an interface(TransactionListingService) that shows Transaction log list on command - 5.
2. Logging is followed after each operation.
3. Lombok persists.
4. Dependencies are set via @Autowired.
5. SOLID principles are enabled.
6. Server is running on port 3000.
7. Go to swagger via http://localhost:8080/swagger-ui/index.html#
8. REST API
![SolidBankApp](https://github.com/singularity-camp/backend-2-solid-bank-app-AlmubdyMutaikhan/blob/main/solidbankapp2.PNG?raw=true)
## Enjoy your SolidBankApp2
