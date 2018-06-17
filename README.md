## Keep in mind the following while running ##
  * Tomcat v7 is the recommended version to be used while running the code. The installation for it can be found at the following link (mekala please add the link)

## How to run the code ##
  * Method 1
    * Use Eclipse IDE

  * Method 2 :bowtie:
    * Run the maven command 
      ```mvn tomcat7:run```

  * Method 3
    * Run the mvn command
      ```mvn package```
    * Then run the command
      ```java -jar target/dependency/webapp-runner.jar target/*.war```