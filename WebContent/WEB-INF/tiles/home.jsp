<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<h2 class="form-title">Welcome to the Home Page</h2>

<sec:authorize access="isRememberMe()">
	<h2 ># This user is login by "Remember Me Cookies".</h2>
</sec:authorize>

<br>
<table class="CSSTableGenerator">
	<tr>
		<td><c:choose>
				<c:when test="${hasOffer}">

					<a href="${pageContext.request.contextPath}/createoffer">Edit/Delete
						Your Current Offer </a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/createoffer">Create
						Offer </a>
				</c:otherwise>
			</c:choose></td>
	</tr>
</table>
<br>
<br>
<br>
<table class="CSSTableGenerator">

	<tr>
		<c:if test="${!hasOffer}">
			<td><a href="${pageContext.request.contextPath}/createoffer">Create
					Offer </a></td>
		</c:if>
		
		<td><a href="${pageContext.request.contextPath}/offers">Show
				Offers</a></td>
		<td><a href="${pageContext.request.contextPath}/users">Users</a>
		</td>
		<td><a href="<c:url value="/newaccount"/>">Create New Account</a></td>
	</tr>
</table>


<br />


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
