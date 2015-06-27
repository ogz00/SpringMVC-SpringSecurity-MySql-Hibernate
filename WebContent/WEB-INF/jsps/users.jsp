<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resource/css/main.css"
	rel="stylesheet" type="text/css">
<title>Users</title>
</head>
<body>

	<br />




	<h3>Users WIA SERVICE LAYER</h3>
	<table class="CSSTableGenerator">
		<tr>
			<td>User Name</td>
			<td>Email</td>

		</tr>
		<c:forEach var="user" items="${users}">

			<tr>
				<td><c:out value="${user.username}"></c:out></td>

				<td><c:out value="${user.email}"></c:out></td>

			</tr>

		</c:forEach>
	</table>
	<br />
	<table class="CSSTableGenerator">
		<td><a href="${pageContext.request.contextPath}/newaccount">
				Create New Account</a></td>

		<td><a href="${pageContext.request.contextPath}/">Home</a></td>
		</tr>
	</table>

</body>
</html>