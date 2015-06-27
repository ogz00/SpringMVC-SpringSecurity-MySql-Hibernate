<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="${pageContext.request.contextPath}/resource/css/main.css"
	rel="stylesheet" type="text/css">
<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>

	<c:if test="${param.error ne null}">
		<p class="error">Wrong username or password</p>
	</c:if>

	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>

		<table class="formtable">
			<tr>
				<td>Username:</td>
				<td><input type='text' name='username' style="width:200px"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' style="width:200px"/></td>
			</tr>

			<tr>
				<td>Remember Me:</td>
				<td><input type='checkbox' name='_spring_security_remember_me'
					checked="checked" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</table>
	</form>
	<br />
	<a href="<c:url value="/newaccount"/>">Create New Account</a>
	<a href="<c:url value="/"/>">Home</a>
</body>
</html>