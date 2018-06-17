## Keep in mind the following while running ##
  * Tomcat v7 is the recommended version to be used while running the code. The installation for it can be found at the following link (mekala please add the link)

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