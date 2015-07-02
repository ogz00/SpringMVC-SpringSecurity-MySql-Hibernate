<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<a class="mymessages" href="<c:url value="/messages"/>">My
		Messages(<span id="numberMessages">0</span>)
	</a>
</sec:authorize>

<div class="toolbar">
	<br>
	<table class="CSSTableGenerator">
		<tr>
			<td style="width: 20%;"><c:choose>
					<c:when test="${hasOffer}">

						<a href="${pageContext.request.contextPath}/createoffer">Edit/Delete
							Your Current Offer </a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/createoffer">Create
							Offer </a>
					</c:otherwise>
				</c:choose></td>

			<td style="width: 20%;"><a
				href="${pageContext.request.contextPath}/offers">Show Offers</a></td>
			<td style="width: 20%;"><a
				href="${pageContext.request.contextPath}/users">Users</a></td>
			<td style="width: 20%;"><a href="<c:url value="/newaccount"/>">Create
					New Account</a></td>
		</tr>

	</table>
</div>



<script type="text/javascript">
	var timer2;
	function updateMessageLink(data) {

		$("#numberMessages").text(data.number);
	}

	function onLoad() {
		updateMessageCount();
		startTimer();
	}

	function startTimer() {
		timer2 = window.setInterval(updateMessageLink, 5000);
	}

	function stopTimer2() {

		window.clearInterval(timer2);
	}

	function updateMessageCount() {
		$.ajax({
			url : "<c:url value="getmessages"/>",
			dataType : 'json',
			asnyc : false,
			success : updateMessageLink
		});
	}
	$(document).ready(onLoad);
</script>