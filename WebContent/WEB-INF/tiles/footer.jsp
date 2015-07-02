<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<table cellspacing="10">

	<tr>
		<td><a href="${pageContext.request.contextPath}/createoffer">Create
				Offer</a></td>

		<td><a href="${pageContext.request.contextPath}/offers">Offers</a>
		</td>
		<td><a href="${pageContext.request.contextPath}/users">Users</a>
		</td>
		<td><a href="<c:url value="/newaccount"/>">Create New Account</a></td>
		<td><sec:authorize access="hasRole('ROLE_ADMIN')">
				<a class=admin href="<c:url value="/admin"/>">Admin</a>
			</sec:authorize></td>

	</tr>
</table>
<br>
<p>Created by Oguzhan Karacullu https://github.com/ogz00</p>
