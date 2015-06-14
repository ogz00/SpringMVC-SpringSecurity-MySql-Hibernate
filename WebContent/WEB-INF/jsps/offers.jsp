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

	<h3>OFFERS WIA SERVICE LAYER</h3>

	<c:forEach var="row" items="${offers}">
		Id: ${row.id}<br />
    	Name: ${row.name}<br />
    	Email: ${row.email}<br />
    	Text: ${row.text}<br />
		<br />
	</c:forEach>


</body>
</html>