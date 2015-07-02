<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<h2 class="form-title">Send Message</h2>
<br />

${fromUser}
<fr:form id="messages" method="post" commandName="message">

	<input name="_flowExecutionKey" value="${flowExecutionKey }"
		type="hidden" />
	<input name="_eventId" value="send" type="hidden" />


	<table class="CSSTableGenerator" style="width: 50% !important">
		<tr></tr>
		<tr>

			<td class="label">Your Name:</td>
			<td><fr:input class="control" path="name" name="name"
					type="text" value="${fromName}" /><br />
				<div class="error">
					<fr:errors path="name"></fr:errors>
				</div></td>
		</tr>

		<tr>

			<td class="label">Your Email:</td>
			<td><fr:input class="control" path="email" name="email"
					type="text" value="${fromEmail}" /><br />
				<div class="error">
					<fr:errors path="email"></fr:errors>
				</div></td>
		</tr>

		<tr>

			<td class="label">Subject:</td>
			<td><fr:input class="control" path="subject" name="subject"
					type="text" /><br />
				<div class="error">
					<fr:errors path="subject"></fr:errors>
				</div></td>
		</tr>
		<tr>

			<td class="label">Your Message:</td>
			<td><fr:textarea class="control" path="content" name="content"
					type="text" /><br />
				<div class="error">
					<fr:errors path="content"></fr:errors>
				</div></td>
		</tr>

		<tr>
			<td class="label"></td>
			<td><input class="control" value="Send Message" type="submit" /></td>
		</tr>

	</table>

</fr:form>
