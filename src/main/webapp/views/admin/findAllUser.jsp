<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:admin>
	<jsp:body>
		<div class="container"
			style="padding-top: 150px; padding-bottom: 50px">
			<div class="">
				<div class="card ">
					<div class="card-header row">
						<h4 class="col-lg-9">Sinh Viên</h4>
						<a href="${pageContext.request.contextPath }/admin/user/add"
							class="btn btn-info text-decoration-none col-lg-3 text-dark fw-bold"
							style="width: 15%;">Add Sinh Viên</a>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã số SV</th>
										<th>Họ Tên</th>
										<th>Ngày Sinh</th>
										<th>Mã Khoa</th>
										<th>AccountID </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${user}" var="sinhvien">
									<tr>
										<td>${sinhvien.maSV }</td>
										<td>${sinhvien.hoTen }</td>
										<td>${sinhvien.ngaySinh }</td>
										<td>${sinhvien.maKhoa }</td>
										<td>${sinhvien.accountID }</td>
										<td><a class="btn btn-primary"
												href="${pageContext.request.contextPath }/admin/user/edit?maSV=${sinhvien.maSV }&svKhoa=${sinhvien.maKhoa }">Edit
														Info</a>
											<a href="" class="btn btn-danger">Delete</a></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:admin>