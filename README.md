# Spring Tutorial - 2

SpringMVC and Spring Security with MySql Database

Created a simple form application on the JSP pages whiches integrated with validation annotations and spring form elements.

Usage of the service layer and controllers objects.

Usage of the CRUD operation with SpringMVC pattern at the jsp pages, its also depends on the MySql database.

Easy integration of the resource files at the SpringMVC.

Introduction to Spring Security, Login and Admin Pages

Usages of the Security-Context for Create Secure Users at the Database with Authority Roles.

(this tutorial is using JNDI data source, for use that add something like following configuration to your Server Directory:

  
	<Resource name="jdbc/SpringDB" auth="Container" type="javax.sql.DataSource"
	maxActive="100" maxIdle="30" maxWait="10000" username="root"
	password="admin" driverClassName="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/springtutorial" />

	example usage: add this codes inside of the context.xml for Tomcat.
	
-------------------------------------------------------------------------------------------------------------
<a target="_blank" href="https://tomcat.apache.org/tomcat-5.5-doc/jndi-resources-howto.html#UserDatabase_Resources"> Apache Tomcat</a>

-------------------------------------------------------------------------------------------------------------
	
Provided Apache Tiles 2.2.2 Integration. So that application has better gui with header-body-footer parts, anymore.

"JUnit Test Cases" and "Log4j Properties" were integrated. For testing case created 2 seperate datasource like dev and production. Attached SQL files for to be able to automatically generate production and test databases.


