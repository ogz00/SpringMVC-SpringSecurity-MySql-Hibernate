# Spring Tutorial - 2

SpringMVC and Spring Security with MySql Database. Used Apache tiles for templates and Junit for test cases.

Created a simple form applications on the JSP pages whiches integrated with validation annotations and spring form elements.

Spring MVC pattern with service layer and controllers objects. 

CRUD operation from both of jsp pages and spring core
its also depends on the MySql database.

Showed Integration of the spring config files with the web.xml. 

Configuration of the "Spring Security" and Create authenticated pages like Login and Admin Pages.

Security-Context Integration for Create Secure Users at the Database with Authority Roles.

-------------------------------------------------------------------------------------------------------------
(this tutorial is using JNDI data source; 
	<!--
	<jee:jndi-lookup id="dataSource" jndi-name="jdbc/SpringDB"
		expected-type="javax.sql.DataSource">
	</jee:jndi-lookup> -->


for use that add something like following configuration to your Server Directory:

  
	<Resource name="jdbc/SpringDB" auth="Container" type="javax.sql.DataSource"
	maxActive="100" maxIdle="30" maxWait="10000" username="root"
	password="admin" driverClassName="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/springtutorial" />


example usage: add this codes to context.xml for <a target="_blank" href="https://tomcat.apache.org/tomcat-5.5-doc/jndi-resources-howto.html#UserDatabase_Resources"> Apache Tomcat</a>

-------------------------------------------------------------------------------------------------------------
	
Provided Apache Tiles 2.2.2 Integration. So that application has better gui with header-body-footer parts, anymore.

"JUnit Test Cases" and "Log4j Properties" were integrated. For testing case created 2 seperate datasource like dev and production. Attached SQL files for to be able to automatically generate production and test databases.

--Optional form buttons and jquery integration.


