# Spring Tutorial - 2

Some of the best bractices *[SpringMVC](http://projects.spring.io/spring-framework/)* and *[Spring Security](http://projects.spring.io/spring-security/)* with *MySql Database*. Used *[Apache Tiles](https://tiles.apache.org/)* for templates and *Junit* for test cases. Furthermore I added *[SpringWebFlow](http://projects.spring.io/spring-webflow/)* usage examples to this project.

Best practices of the using *Spring Form Elements* with *JSP* pages and MVC concepts.

Spring MVC pattern with service layer and controllers objects. 

CRUD operation on the MySql with *Hibernate* and commented examples of *jdbc queries*

Best Practices of setting the **Dispatcher Servlet** together with **web.xml**. 

Configuration of the *Spring Security* and Create authenticated pages like **Login** and **Admin Pages**.

*Security-Context* Integration for Create Secure Users at the Database with Authority Roles.

-------------------------------------------------------------------------------------------------------------
(this tutorial is using JNDI data source; 
	
	<jee:jndi-lookup id="dataSource" jndi-name="jdbc/SpringDB"
		expected-type="javax.sql.DataSource">
	</jee:jndi-lookup> 


Next, modify $CATALINA_BASE/conf/server.xml to create the UserDatabase resource based on your XMl file. It should look something like this:

  
	<Resource name="jdbc/SpringDB" auth="Container" type="javax.sql.DataSource"
	maxActive="100" maxIdle="30" maxWait="10000" username="root"
	password="admin" driverClassName="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/springtutorial" />


example usage: add this codes to context.xml for 
*[Apache Tomcat](https://tomcat.apache.org/tomcat-5.5-doc/jndi-resources-howto.html#UserDatabase_Resources)*

-------------------------------------------------------------------------------------------------------------
	
Provided *[Apache Tiles](https://tiles.apache.org/)* 2.2.2 Integration. So that application has better gui with header-body-footer parts, anymore.

*JUnit Test Cases* and *[Log4j](http://logging.apache.org/log4j/2.x/) Properties* were integrated. For testing case created 2 seperate datasource like dev and production. Attached SQL files for to be able to automatically generate production and test databases.

*[Hibernate](http://hibernate.org/orm/)* integration is over.
All of the DAO's are working with Hibernate and *[JPA](https://en.wikipedia.org/wiki/Java_Persistence_API)*.
Also Dao Classes contains jdbc queries as a block comment as well, because of showing the differences between **SQL** and **HQL**.


**Ajax/JSON** requests and **jquery** integration for effective pages.


