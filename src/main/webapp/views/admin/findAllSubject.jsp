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
						<h4>Môn học</h4>
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