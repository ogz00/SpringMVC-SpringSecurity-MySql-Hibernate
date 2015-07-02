<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<h2 class="form-title">Welcome to the Home Page</h2>




<!-- DB TEST for this part you should setting your JNDI datasource according to 
	
		https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html#MySQL_DBCP_Example
	
		It is quite simple for start to configure connection pool with JNDI
	-->
<!--<sql:query var="rs" dataSource="jdbc/SpringDB">
		select id, username, text from offers
	</sql:query> -->

<!-- 	<c:forEach var="row" items="${rs.rows}">
		Id: ${row.id}<br />
    	Username: ${row.username}<br />
		<br />
	</c:forEach> -->
