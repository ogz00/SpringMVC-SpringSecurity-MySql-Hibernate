<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2 class="form-title">Offerrs VIA SERVICE LAYER</h2>
<table class="CSSTableGenerator">
	<tr>
		<td>Name</td>
		<td>Email</td>
		<td>Offer</td>
	</tr>
	<c:forEach var="offer" items="${offers}">

		<tr>
			<td><c:out value="${offer.user.name}"></c:out></td>

			<td><a href="<c:url value='/message?uid=${offer.username}'></c:url>">Contact</a></td>

			<td><c:out value="${offer.text}"></c:out></td>
		</tr>

	</c:forEach>
</table>

