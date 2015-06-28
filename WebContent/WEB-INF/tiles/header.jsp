<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
	function formSubmit() {

		document.getElementById("logoutForm").submit();

	}
</script>

<a class="title" href="<c:url value='/'/>">Offers</a>

<sec:authorize access="isAuthenticated()">
	<form action="${pageContext.request.contextPath}/logout" method="post"
		id="logoutForm">

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <a class="login" href="javascript:formSubmit()"
			style="text-decoration: none"> Logout</a>



	</form>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a class="admin" href="<c:url value="/admin"/>">Admin</a>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<a class="login" href="<c:url value="/login"/>">Login</a>
</sec:authorize>
