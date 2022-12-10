<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HCMUTE DKMH</title>

<!-- Google Fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="<c:url value = '/template/login/css/animate.css'/>">
<!-- Custom Stylesheet -->
<link rel="stylesheet"
	href="<c:url value ='/template/login/css/style.css'/>">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="top">
			<h1 id="title" class="hidden">
				<span id="logo">HCM <span>UTE</span></span>
			</h1>
		</div>
		<form action="${pageContext.request.contextPath }/LoginController" method="post">
			<div class="login-box animated fadeInUp">
				<div class="box-header">
					<h2>Log In</h2>
				</div>
				<c:if test="${not empty sessionScope.error }">
					<div class="alert alert-danger">${sessionScope.error }</div>
					<c:remove var="error" scope="session" />
				</c:if>
				<label for="username">Username</label> <br /> <input type="text"
					id="username" name="username"> <br /> <label
					for="password">Password</label> <br /> <input type="password"
					id="password" name="password"> <br />
				<button type="submit">Sign In</button>
				<br />
			</div>
		</form>
	</div>
</body>
<script>
	$(document).ready(function() {
		$('#logo').addClass('animated fadeInDown');
		$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>
</html>