<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/createoffer">create
			offer</a>
	</p>
	<br />

	<h3>OFFERS WIA SERVICE LAYER</h3>

	<c:forEach var="offer" items="${offers}">
		<p>
			<c:out value="${offer}"></c:out>
		</p>
		<br />
	</c:forEach>

	<p>
		<a href="${pageContext.request.contextPath}/createoffer">create
			offer</a>
	</p>
	<br />

</body>
</html>