<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:admin>
	<jsp:body>
		<div class="container"
			style="padding-top: 150px; padding-bottom: 50px;">
			<div class="">
				<div class="card">
					<div class="card-header row">
						<h4 class="col-lg-9">Khoa</h4>
						<a href="${pageContext.request.contextPath }/admin/major/add"
							class="btn btn-info text-decoration-none col-lg-3 text-dark fw-bold"
							style="width: 15%;">Add Khoa</a>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã Khoa</th>
										<th>Tên Khoa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${major }" var="khoa">
									<tr>
										<td>${khoa.khoaID }</td>
										<td>${khoa.tenKhoa }</td>
										<td><a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/major/edit?id=${khoa.khoaID }">Edit
														Info</a> <a href="" class="btn btn-danger">Delete</a></td>
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