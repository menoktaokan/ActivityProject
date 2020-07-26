<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activity Planner</title>

<style type="text/css">
body {
	background-color: #ffe6e6;
}

#header {
	height: 100px;
}

#activity-list {
	margin: 20px;
	background-color: white;
	float: left;
}

#activity-details {
	background-color: #F2F3F4;
	margin: 20px;
	float: left;
}

#table-activity-details {
	
}
</style>
</head>
<body>

	<div id="header">
		<h1 align="center" style="margin-right: 10px;">Activity Planner</h1>
		<!-- Giriş yapılmamışsa Login butonunu gösteriyor -->
		<sec:authorize access="!isAuthenticated()">
			<button onclick="window.location.href='loginForm'"
				style="float: left; margin-right: 10px;">Login</button>
			<button onclick="window.location.href='new-user'"
				style="float: left; margin-right: 10px;">Singup</button>
			<c:if test="${param.logout != null}">
				<b class="logout">Logged Out</b>
			</c:if>
		</sec:authorize>
		<!-- Giriş yapılmışsa Logout butonunu gösteriyor -->
		<sec:authorize access="isAuthenticated()">
			<f:form action="${pageContext.request.contextPath}/logout"
				method="POST" cssStyle="">
				<input type="submit" value="Logout" />
			</f:form>
		</sec:authorize>
		<c:if test="${param.username != null}">
			<b class="logout">Successfully checked!<br>
			</b>
		</c:if>


		<!-- Verilan bir linke erişim varsa o linki açıyor, yoksa gizliyor
		<sec:authorize url="/user">
			<a href="/user">User</a>
		</sec:authorize>

		<sec:authorize url="/admin">
			<a href="/admin">Admin</a>
		</sec:authorize>
		 -->

		<!-- Eğer giriş yapılmışsa kullanıcı adıyla hoş geldin diyor
		<sec:authorize access="isAuthenticated()">
    Welcome Back, <sec:authentication property="name" />
		</sec:authorize>
		 -->
	</div>
	<hr>
	<div id="activity-list">
		<table border="1px">
			<thead>
				<tr>
					<th>Recently Activities</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${activities}" var="act">
					<c:url var="choose" value="act-choose">
						<c:param name="actId" value="${act.id}" />
					</c:url>
					<tr>
						<td><a href="${choose}">${act.name}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="activity-details">
		<table id="table-activity-details" border="1px">

			<tbody>
				<tr>
					<td style="color: blue;">Details:</td>

				</tr>
				<tr>
					<td style="width: 600px">${theAct.details}</td>

				</tr>
				<c:if test="${param.actId != null}">
					<!-- Aktivite seçim durumunu kontrol eder -->
					<!-- Üye girişi yapmamış kullanıcı için -->
					<sec:authorize access="!isAuthenticated()">
						<c:if test="${param.actId != null}">
							<b><c:url var="activity" value="activity">
									<c:param name="actId" value="${param.actId}" />
								</c:url>
								<tr>
									<td><a href="${activity}">Login for check-in</a></td>
								</tr></b>
						</c:if>
					</sec:authorize>
					<!-- Üye girişi yapmış kullanıcı için -->
					<sec:authorize access="isAuthenticated()">
						<sec:authentication property="principal.username" var="username" />

						<c:if test="${param.actId != null}">
							<b class=""><tr>
									<td><c:url var="checkin" value="check-in">
											<c:param name="username" value="${username}" />
											<c:param name="actId" value="${param.actId}" />
										</c:url> <a href="${checkin}">Check-in for this activity</a></td>
								</tr></b>
						</c:if>
						<!-- Kayıt yaptırmış bir kullanıcı için kayıt ol butonunu kapatmaya çalışıyorum -->
						<c:if test="${1 == 2}">
							<b class=""><tr>
									<td><a accesskey="isChecked(5)">aaaaaaaaaaaaa</a></td>
								</tr></b>
						</c:if>
					</sec:authorize>
					<tr>
						<td style="color: blue;">Comments:</td>
					</tr>
					<c:forEach items="${comments}" var="comment">
						<tr>

							<td>${comment.commentDetails}<br> by
								${comment.nickname}, on ${comment.commentDate}<br> <c:if
									test="${nickname == comment.nickname}">
									<b class=""> <c:url var="delete" value="delete-comment">
											<c:param name="commentId" value="${comment.id}" />
										</c:url> <a href="${delete}">delete </a>
									</b>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					<sec:authorize access="isAuthenticated()">
					</sec:authorize>
					<f:form modelAttribute="comment" method="POST" action="new-comment">
						<f:hidden path="nickname" />
						<tr>
							<td>Leave a comment <br>
							<f:textarea path="commentDetails"
									cssStyle="width:595px;" /></td>
						</tr>

						<tr>
							<td>
							
							<f:button>Send comment</f:button></td>
						</tr>
					</f:form>
				</c:if>

			</tbody>
		</table>
	</div>


</body>
</html>