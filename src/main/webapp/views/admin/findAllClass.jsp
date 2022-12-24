<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<t:admin>
	<jsp:body>
		<div class="container" style="padding-top: 150px; padding-bottom: 50px;">
			<div class="">
				<div class="card">
					<div class="card-header row">
						<h4 class="col-lg-9">Lớp học phần</h4>
						<a href="${pageContext.request.contextPath }/admin/class/add"
							class="btn btn-info text-decoration-none col-lg-3 text-dark fw-bold"
							style="width: 15%;">Add Khoa</a>
					</div>
					<div class = "card-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>id</th>
										<th>Mã lớp</th>
										<th>Loai</th>
										<th>Mã MH</th>
										<th>Mã GV </th>
										<th>Phòng</th>
										<th>Số SV</th>
										<th>ngày BD</th>
										<th>Năm học</th>
										<th>Thứ</th>
										<th>Tiết</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items = "${class1 }" var ="lop">
									<tr>
										<td>${lop.id }</td>
										<td>${lop.maLop }</td>
										<td>${lop.loai }</td>
										<td>${lop.maMH }</td>
										<td>${lop.maGV }</td>
										<td>${lop.phong }</td>
										<td>${lop.soSV }</td>
										<td>${lop.ngayBD }</td>
										<td>${lop.namHoc }</td>
										<td>${lop.thu }</td>
										<td>${lop.tiet }</td>
										<td><a class="btn btn-primary"
													href="">Edit
														Info</a> <a
													href=""
													class="btn btn-danger">Delete</a></td>
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