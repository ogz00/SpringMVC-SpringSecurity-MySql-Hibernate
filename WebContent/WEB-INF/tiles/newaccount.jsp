<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
