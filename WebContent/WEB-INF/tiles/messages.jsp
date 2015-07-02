<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="messages"></div>



<script type="text/javascript">
	var timer;
	function showReply(i) {
		stopTimer();
		$("#form" + i).toggle();
	}

	function sendMessage(i) {

		alert($("#textbox"+i).val());
	}
	
	function showMessages(data) {
		$("div#messages").html("");

		for (var i = 0; i < data.messages.length; i++) {
			var message = data.messages[i];

			var messageDiv = document.createElement("div");
			messageDiv.setAttribute("class", "message");

			var subjectSpan = document.createElement("span");
			subjectSpan.setAttribute("class", "subject");
			subjectSpan.appendChild(document.createTextNode(message.subject));

			var contentSpan = document.createElement("span");
			contentSpan.setAttribute("class", "messagebody");
			contentSpan.appendChild(document.createTextNode(message.content));

			var nameSpan = document.createElement("span");
			nameSpan.setAttribute("class", "name");
			nameSpan.appendChild(document.createTextNode(message.name + "("));

			var link = document.createElement("a");
			link.setAttribute("class", "replylink");
			link.setAttribute("href", "#");
			link.setAttribute("onclick", "showReply(" + i + ")");
			link.appendChild(document.createTextNode(message.email));
			nameSpan.appendChild(link);
			nameSpan.appendChild(document.createTextNode(")"));

			var replyForm = document.createElement("form");
			replyForm.setAttribute("id", "form" + i);
			replyForm.setAttribute("class", "replyform");

			var textarea = document.createElement("textarea");
			textarea.setAttribute("class", "replyarea");
			textarea.setAttribute("id", "textbox"+i);

			var replyButton = document.createElement("input");
			replyButton.setAttribute("class", "replybutton");
			replyButton.setAttribute("type", "button");
			replyButton.setAttribute("value", "Reply");
			replyButton.onclick = function(j) {
				return function() {
					sendMessage(j);
				};
			}(i);

			replyForm.appendChild(textarea);
			replyForm.appendChild(replyButton);

			messageDiv.appendChild(subjectSpan);
			messageDiv.appendChild(contentSpan);
			messageDiv.appendChild(nameSpan);
			messageDiv.appendChild(replyForm);

			$("div#messages").append(messageDiv);

		}
	}

	function startTimer() {
		timer = window.setInterval(updatePage, 5000);

	}

	function stopTimer() {
		window.clearInterval(timer);
	}

	function updatePage() {
		$.ajax({
			url : "<c:url value="getmessages"/>",
			dataType : 'json',
			asnyc : false,
			success : showMessages
		});
	}

	function onLoad() {
		updatePage();
		startTimer();
	}

	$(document).ready(onLoad);
</script>