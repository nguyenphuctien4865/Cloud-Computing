<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<t:admin>
	<jsp:body>
		<div class="container" style="padding-top: 150px; padding-bottom : 50px;">
			<div class="">
				<div class="card">
					<div class="card-header row">
						<h4 class = "col-lg-9">Giảng Viên</h4>
						<a href="${pageContext.request.contextPath }/admin/teacher/add"
							class="btn btn-info text-decoration-none col-lg-3 text-dark fw-bold"
							style="width: 15%;">Add Giảng Viên</a>
					</div>
					<div class = "card-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã GV</th>
										<th>Họ Tên</th>
										<th>Ngày Sinh</th>
										<th>Mã Khoa</th>
										<th>LoaiGV</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items = "${teacher }" var ="giangvien">
									<tr>
										<td>${giangvien.maGV }</td>
										<td>${giangvien.hoTen }</td>
										<td>${giangvien.ngaySinh }</td>
										<td>${giangvien.maKhoa }</td>
										<td>${giangvien.loaiGV }</td>
										<td><a class="btn btn-primary"
													href="${pageContext.request.contextPath }/admin/teacher/edit?maGV=${giangvien.maGV }">Edit
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