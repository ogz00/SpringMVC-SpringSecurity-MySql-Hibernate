<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
<!--
	function onDeleteClick(event) {

		var doDelete = confirm("Are you sure you want to delete this offer?");
		if (doDelete == false) {
			event.preventDefault();
		}
	}

	function onReady() {
		$("#delete").click(onDeleteClick);
	}

	$(document).ready(onReady);
//-->
</script>

<h2 class="form-title">CREATE NEW OFFER</h2>
<br />
<fr:form method="post"
	action="${pageContext.request.contextPath}/docreate"
	commandName="offer">
	<fr:input type="hidden" path="id" name="id" />
	<table class="CSSTableGenerator">
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>

		<tr>
			<td class="label">Offer:</td>
			<td><fr:textarea class="control" path="text" name="text"
					rows="10" cols="30"></fr:textarea><br /> <fr:errors path="text"
					cssClass="error"></fr:errors></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><c:if test="${offer.id ne 0}">
					<input id="delete" class="delete control" value="Delete Advert"
						type="submit" name="delete" />&nbsp; </c:if> <input class="control"
				value="Save Advert" type="submit" id="submit" /></td>
		</tr>


	</table>

</fr:form>

