<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Lütfen Bağlanın</title>
<style type="text/css">
.note {
	text-align: center;
	height: 80px;
	background: -webkit-linear-gradient(left, #0072ff, #8811c5);
	color: #fff;
	font-weight: bold;
	line-height: 80px;
}

.form-content {
	padding: 5%;
	border: 1px solid #ced4da;
	margin-bottom: 2%;
}

.form-control {
	border-radius: 1.5rem;
}

.btnSubmit {
	border: none;
	border-radius: 1.5rem;
	padding: 1%;
	width: 20%;
	cursor: pointer;
	background: #0062cc;
	color: #fff;
}
</style>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

</head>
<body>
	<f:form modelAttribute="user" method="POST" action="new-user/singup">
		<div class="container register-form">
			<div class="form">
				<div class="note">
					<p>Sing up</p>
				</div>

				<div class="form-content">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<f:input type="text" class="form-control" placeholder="Username"
									path="username" required="true" />
									
							</div>
							<div class="form-group">
								<f:input type="text" class="form-control" placeholder="Nickname"
									path="nickname" required="true" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<f:input type="password" class="form-control"
									placeholder="Your Password *" path="password" required="true" />
							</div>
<!-- 							<div class="form-group"> -->
<%-- 								<f:input type="password" class="form-control" --%>
<%-- 									placeholder="Confirm Password *" path="" /> --%>
<!-- 							</div> -->
						</div>
						<f:errors path="username" cssStyle="color:red; margin-left:20px;"></f:errors>
					</div>
					<button type="submit" class="btnSubmit">Submit</button>
				</div>
			</div>
		</div>

	</f:form>
</body>
</html>