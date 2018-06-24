[ ![Codeship Status for murtazasmart/stock-market-analyst-service](https://app.codeship.com/projects/7830ce90-56c9-0136-0a1a-5ae1f167f9dd/status?branch=master)](https://app.codeship.com/projects/294831)

# Analyst Service
This is the component which implements the Analyst an an API REST service using Java and Maven.

# Project details
### Team name: EXIT
### API doc link - https://docs.google.com/spreadsheets/d/1tFuveKrxBRxqtGC7-UDONrHTRYYbcqwofPyL0zMwmcE/edit#gid=0
### Members:
 - Murtaza Anverali Esufali 16211211
 - Maheshi K.H.Gunaratne    16211197
 - Rathnayake Bhagya P M    16211279
 - Mekala Rashmika K B      16211194
 - M.Kasun lalendra Silva   16211181

| Repository Name        | Github Link           | Live URL  |
| ------------- |-------------| -----|
| Stock market simulator | https://github.com/murtazasmart/stock-market-sim | http://stock-market-simulator.herokuapp.com/ |
| Stock market broker | https://github.com/murtazasmart/stock-market-broker | https://eager-babbage-836674.netlify.com |
| Stock market broker backend | https://github.com/murtazasmart/stock-market-broker-backend | https://hidden-badlands-21838.herokuapp.com/ |
| Stock market analyst service | https://github.com/murtazasmart/stock-market-analyst-service/ | https://stock-market-analyst.herokuapp.com |
| Stock market bank service | https://github.com/murtazasmart/stock-market-bank-service/ | https://stock-market-bank-service.herokuapp.com/ |

## How to run the code ##
  * Method 1 - using Eclipse IDE
    * Go to File -> Import
    * Select Maven -> Existing Maven Projects
    * Provide root directory
    * Finish

Note: for next 2 methods Maven needs to be installed on your system and should be set in the env variables(should be added to the path). Run ```mvn --version``` to check if you have Maven present in the environment.

  * Method 2 :bowtie - using command line + Maven
    * Run the maven command 
      ```mvn tomcat7:run```

  * Method 3 - using command line + Maven
    * Run the mvn command
      ```mvn package```
    * Then run the command
      ```java -jar target/dependency/webapp-runner.jar target/*.war```
