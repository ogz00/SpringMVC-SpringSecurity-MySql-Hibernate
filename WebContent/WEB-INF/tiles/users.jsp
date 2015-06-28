<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<br />

	<h3>Users VIA SERVICE LAYER</h3>
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

