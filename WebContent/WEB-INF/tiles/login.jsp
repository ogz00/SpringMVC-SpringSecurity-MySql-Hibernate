<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		document.f.username.focus();

	});

	function formSubmit() {
		document.getElementById("loginForm").submit();
	}
</script>



<h2 class="form-title">Login with Username and Password</h2>

<c:if test="${param.error ne null}">
	<p class="error">Wrong username or password</p>
</c:if>

<form name='f' action='${pageContext.request.contextPath}/login'
	method='POST' id="loginForm" class="form-container">

	<div class="form-title">
		<h2>Login</h2>
	</div>
	<div class="form-title">Username</div>
	<input class="form-field" type='text' name='username'
		style="width: 200px" /><br />

	<div class="form-title">Password</div>
	<input class="form-field" type='password' name='password'
		style="width: 200px" /><br />

	<div class="form-title">
		Remember Me &nbsp; <input type='checkbox'
			name='_spring_security_remember_me' checked="checked" />
	</div>
	<br />
	<div class="submit-container">
		<input class="submit-button" type="submit" type="submit" value="Login" />
	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

</form>

