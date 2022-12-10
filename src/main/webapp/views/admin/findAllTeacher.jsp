<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<t:admin>
	<jsp:body>
		<div class="row" style="padding-top: 104px;">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<h4>Giảng Viên</h4>
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