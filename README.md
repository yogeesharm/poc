# REST Services POC

Very basic example for REST web application with Jersey, Maven, Spring and Hibernate.

With this example you could check how to develop REST web services in a web application. Different methods in your application will be called depending on the HTTP methods: GET, POST, PUT or DELETE.

Database script is also present at scripts/script.sql

To build the application please run the below command
>mvn clean install

Copy the war file generated by running the above command in target folder of the project into webapps directory of apache tomcat server.

Start the tomcat server to run the application.

Open the users.html file in the browser to check the services deployed in the server.
When the page loads, it displays the list of all the users.
There is a form to add new user.
To update the user, click on the edit link provided in the user details table. User details will be populated in the form, edit the details and click on Update button.
To delete the User, click on the delete link provided in the user details table. This will delete the user details.

The war file is also attached for easy deployment of the application.

Junit test.
The test cases for testing the REST services are written inside the RestControlerTest class.
Please update the ID value before running the test.

 

