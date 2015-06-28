<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<h3>Welcome to the Home Page</h3>

<sec:authorize access="isRememberMe()">
	<h2># This user is login by "Remember Me Cookies".</h2>
</sec:authorize>


<table class="CSSTableGenerator">

	<tr>
		<td><a href="${pageContext.request.contextPath}/createoffer">Create
				Offer </a></td>

		<td><a href="${pageContext.request.contextPath}/offers">Offers</a>
		</td>
		<td><a href="${pageContext.request.contextPath}/users">Users</a>
		</td>
		<td><a href="<c:url value="/newaccount"/>">Create New Account</a></td>



	</tr>
</table>




<br />
<!-- Usage og JSTL tags and jsp scripts with el expressions -->
<c:choose>
	<c:when test="${name eq 'OguzHan'}">

		<p>Session is:
		<h3><%=session.getAttribute("name")%></h3>


	</c:when>

	<c:otherwise>

		<h3></h3>
	</c:otherwise>
</c:choose>



<!-- DB TEST for this part you should setting your JNDI datasource according to 
	
		https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html#MySQL_DBCP_Example
	
		It is quite simple for start to configure connection pool with JNDI
	-->
<sql:query var="rs" dataSource="jdbc/SpringDB">
		select id, name, email, text from offers
	</sql:query>
<h2></h2>

<!-- 	<c:forEach var="row" items="${rs.rows}">
		Id: ${row.id}<br />
    	Name: ${row.name}<br />
		<br />
	</c:forEach> -->
