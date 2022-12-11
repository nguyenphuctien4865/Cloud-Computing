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
						<h4>Sinh Viên</h4>
					</div>
					<div class = "card-body">
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
									<c:forEach items="${user}"  var ="sinhvien">
									<tr>
										<td>${sinhvien.maSV }</td>
										<td>${sinhvien.hoTen }</td>
										<td>${sinhvien.ngaySinh }</td>
										<td>${sinhvien.maKhoa }</td>
										<td>${sinhvien.accountID }</td>
										<td><a class="btn btn-primary"
													href="">Edit
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