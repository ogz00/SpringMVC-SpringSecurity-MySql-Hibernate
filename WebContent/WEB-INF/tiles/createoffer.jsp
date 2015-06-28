<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>

<h2>CREATE NEW OFFER</h2>
<br />


<fr:form method="post"
	action="${pageContext.request.contextPath}/docreate"
	commandName="offer">

	<table class="CSSTableGenerator">
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td class="label">Name:</td>
			<td><fr:input class="control" path="name" name="name"
					type="text" /><br /> <fr:errors path="name" cssClass="error"></fr:errors></td>

		</tr>
		<tr>
			<td class="label">Email:</td>
			<td><fr:input class="control" path="email" name="email"
					type="text" /><br /> <fr:errors path="email" cssClass="error"></fr:errors></td>
		</tr>
		<tr>
			<td class="label">Offer:</td>
			<td><fr:textarea class="control" path="text" name="text"
					rows="10" cols="30"></fr:textarea><br /> <fr:errors path="text"
					cssClass="error"></fr:errors></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><input class="control" value="Create Advert" type="submit" /></td>
		</tr>

	</table>

</fr:form>

