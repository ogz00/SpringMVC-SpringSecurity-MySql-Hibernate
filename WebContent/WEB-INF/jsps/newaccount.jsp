<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/resource/css/main.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery.js"></script>

<script type="text/javascript">
	function onLoad() {
		$("#password").keyup(checkPasswordMatch);
		$("#confirmpass").keyup(checkPasswordMatch);
		$("#details").submit(canSubmit);

	}

	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password != confirmpass) {
			alert("Passwords do not match!");
			return false;
		} else {
			return true;
		}
	}

	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password.length > 3 || confirmpass.length > 3) {
			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key ='MatchedPassword.user.password'/>");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass")
						.text(
								"<fmt:message key='UnmatchedPasswords.user.password'/>");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}

	$(document).ready(onLoad);
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CREATE NEW ACCOUNT</title>
</head>
<body>

	<h2>CREATE NEW ACCOUNT</h2>
	<br />

	<fr:form id="details" method="post"
		action="${pageContext.request.contextPath}/createaccount"
		commandName="user">

		<table class="CSSTableGenerator">
		<tr></tr>
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
				<td><fr:input id="password" class="control" path="password"
						name="password" type="password" /><br />
					<div class="error">
						<fr:errors path="password"></fr:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Confirm password:</td>
				<td><input id="confirmpass" class="control" name="confirmpass"
					type="password" />
					<div id="matchpass" class="error"></div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Account" type="submit" /></td>
			</tr>

		</table>

	</fr:form>

	<br />

	<table class="CSSTableGenerator">
		<tr>
			<td><a href="${pageContext.request.contextPath}/offers">offers</a></td>

			<td><a href="${pageContext.request.contextPath}/">home</a></td>
		</tr>
	</table>

</body>
</html>