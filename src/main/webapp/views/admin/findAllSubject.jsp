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
						<h4 class="col-lg-9">Môn học</h4>
						<a href="${pageContext.request.contextPath }/admin/subject/add"
							class="btn btn-info text-decoration-none col-lg-3 text-dark fw-bold"
							style="width: 15%;">Add Môn học</a>
					</div>
					<div class = "card-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã MH</th>
										<th>Tên MH</th>
										<th>Loai</th>
										<th>Số TC</th>
										<th>Id Khoa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items = "${subject }" var ="monhoc">
									<tr>
										<td>${monhoc.maMH }</td>
										<td>${monhoc.tenMH }</td>
										<td>${monhoc.loai }</td>
										<td>${monhoc.soTC }</td>
										<td>${monhoc.khoaID }</td>
										<td><a class="btn btn-primary"
													href="${pageContext.request.contextPath }/admin/subject/edit?id=${monhoc.maMH }&khoa=${monhoc.khoaID }">Edit
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