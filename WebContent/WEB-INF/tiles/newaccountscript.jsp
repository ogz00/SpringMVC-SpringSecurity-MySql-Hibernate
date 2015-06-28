<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
				$("#matchpass").text(
						"<fmt:message key ='MatchedPassword.user.password'/>");
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