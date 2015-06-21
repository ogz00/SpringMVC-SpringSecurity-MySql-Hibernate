# Spring Tutorial - 2

SpringMVC and Spring Security with MySql Database

Created a simple form application on the JSP pages whiches integrated with validation annotations and spring form elements.

Usage of the service layer and controllers objects.

Usage of the CRUD operation with SpringMVC pattern at the jsp pages, its also depends on the MySql database.

Easy integration of the resource files at the SpringMVC.

Introduction to Spring Security and Login Page

Usages of the Security-Context for Create Secure Users at the Database with Authority Roles.

(this tutorial is using JNDI data source, for use that add something like that:

    
    <Resource name="jdbc/SpringDB" auth="Container" type="javax.sql.DataSource"
		maxActive="100" maxIdle="30" maxWait="10000" username="root"
		password="admin" driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/springtutorial" />
		
		to your Server Directory's context.xm for Tomcat.
