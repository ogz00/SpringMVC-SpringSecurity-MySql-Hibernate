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
	CREATE NEW OFFER
	<br />


	<fr:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		commandName="offer">

		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td><fr:input class="control" path="name" name="name"
						type="text" /><br />
				<fr:errors path="name" cssClass="error"></fr:errors></td>

			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><fr:input class="control" path="email" name="email"
						type="text" /><br />
				<fr:errors path="email" cssClass="error"></fr:errors></td>
			</tr>
			<tr>
				<td class="label">Offer:</td>
				<td><fr:textarea class="control" path="text" name="text"
						rows="10" cols="30"></fr:textarea><br />
				<fr:errors path="text" cssClass="error"></fr:errors></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Advert" type="submit" /></td>
			</tr>




		</table>

	</fr:form>

</body>
</html>