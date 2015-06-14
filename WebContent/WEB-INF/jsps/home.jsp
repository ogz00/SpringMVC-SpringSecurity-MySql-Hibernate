<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<h3>Home Page</h3>

	<br>
<a href="/SpringMVC//offers">offers</a>
<br/>
	<!-- Usage og JSTL tags and jsp scripts with el expressions -->
	<c:choose>
		<c:when test="${name eq 'OguzHan'}">

			<p>Session is:
			<h3><%=session.getAttribute("name")%></h3>
			</p>

		</c:when>

		<c:otherwise>

			<h3>Wrong session is: ${name}</h3>
		</c:otherwise>
	</c:choose>



	<!-- DB TEST for this part you should setting your JNDI datasource according to 
	
		https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html#MySQL_DBCP_Example
	
		It is quite simple for start to configure connection pool with JNDI
	-->
	<sql:query var="rs" dataSource="jdbc/SpringDB">
		select id, name, email, text from offers
	</sql:query>
	<h2>DB Test Results --OFFERS WITH JNDI QUERY</h2>

	<c:forEach var="row" items="${rs.rows}">
		Id: ${row.id}<br />
    	Name: ${row.name}<br />
		<br />
	</c:forEach>

</body>
</html>