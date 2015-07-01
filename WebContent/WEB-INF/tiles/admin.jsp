<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Admin</title>
</head>
<body>
	<h2 class="form-title">Authorized Users Only</h2>

	<table class="CSSTableGenerator">
		<tr>
			<td>User Name</td>
			<td>Name</td>
			<td>Email</td>
			<td>Role</td>
			<td>Enabled</td>

		</tr>
		<c:forEach var="user" items="${users}">

			<tr>
				<td><c:out value="${user.username}"></c:out></td>

				<td><c:out value="${user.name}"></c:out></td>

				<td><c:out value="${user.email}"></c:out></td>

				<td><c:out value="${user.authority}"></c:out></td>

				<td><c:out value="${user.enabled}"></c:out></td>

			</tr>

		</c:forEach>
	</table>