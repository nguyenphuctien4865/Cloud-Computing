<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,  initial-scale = 1.0">

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/template/css/AdminHome.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<!-- navbar -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-white py-4 fixed-top">
		<div class="container order-lg-0">
			<a
				class="navbar-brand d-flex justify-content-between align-items-center"
				href=""> <c:url value="/template/image/logo-spk.png"
					var="logoSPKT" /> <img src="${logoSPKT }" alt="site logo"
				class="site_logo"> <span class="text-uppercase fw-bold ms-2">HCMUTE</span>
			</a>

			<div class="order-lg-2">
				<button type="button" class="btn position-relative">
					<i class="fa fa-user"></i>
				</button>
			</div>

			<button class="navbar-toggler border-0" type="button"
				data-bs-toggle="collapse" data-bs-target="#navMenu">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse order-lg-1" id="navMenu">
				<ul class="navbar-nav mx-auto text-center">
					<li class="nav-item px-2 py-2"><a
						class="nav-link text-uppercase text-dark"
						href="${pageContext.request.contextPath }/admin/user">User">Sinh
							Viên</a></li>
					<li class="nav-item px-2 py-2"><a
						class="nav-link text-uppercase text-dark" href="#brand">Giảng
							Viên</a></li>
					<li class="nav-item px-2 py-2"><a
						class="nav-link text-uppercase text-dark" href="#category">Môn
							học</a></li>
					<li class="nav-item px-2 py-2"><a
						class="nav-link text-uppercase text-dark border-0" href="#header">Lớp</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar end -->
	<div class="container"></div>



	<!-- footer -->
	<footer class="bg-dark py-5 fixed-bottom">
		<div class="container">
			<div class="row text-white g-4">
				<div class="">
					<a class="text-uppercase text-decoration-none brand text-white"
						href="">HCMUTE</a>
				</div>
			</div>
		</div>
	</footer>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</html>