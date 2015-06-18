<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/resource/css/main.css"
	rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>CREATE NEW ACCOUNT</h2>
	<br />

	<fr:form method="post"
		action="${pageContext.request.contextPath}/createaccount"
		commandName="user">

		<table class="formtable">
			<tr>
				<td class="label">Username:</td>
				<td><fr:input class="control" path="username" name="username"
						type="text" /><br />
					<div class="error">
						<fr:errors path="username"></fr:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><fr:input class="control" path="email" name="email"
						type="text" /><br />
					<div class="error">
						<fr:errors path="email"></fr:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><fr:input class="control" path="password" name="password"
						type="password" /><br />
					<div class="error">
						<fr:errors path="password"></fr:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Confirm password:</td>
				<td><input class="control" name="confirmpass" type="password" /><br />
				</td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Account" type="submit" /></td>
			</tr>

		</table>

	</fr:form>

	<br />

	<table class="offers">
		<tr>
			<td><a href="${pageContext.request.contextPath}/offers">offers</a></td>

			<td><a href="${pageContext.request.contextPath}/">home</a></td>
		</tr>
	</table>

</body>
</html>