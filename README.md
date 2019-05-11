# travedia
A demo social media application with spring

##### Build Dependencies
    1. Maven
    2. Java 8
    3. Tomcat 8.5.40
    
##### Database setup

MySql Database has been used in this project. You can find the sql file in the resource
directory of the project. You should set the database name as travedia, import the sql file and
change necessary database host and port number as per your environment.

##### Property File
You need to modify the db config on the applicaiton.properties file as per
your database set up.


##### Build Project

Clone the project and on the root directory open any terminal.
Run the following command to build the project. Before runnning the 
command make sure M2_HOME, JAVA_HOME environment variable are set.

     mvn clean
     mvn install
     mvn package

A war file will be generated in target directory inside the root directory.
Copy the war to Tomcat webapps. The application should run perfetcly.

##### Demo 

username: testuser
password: 123456
