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
						<h4>Lớp học phần</h4>
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