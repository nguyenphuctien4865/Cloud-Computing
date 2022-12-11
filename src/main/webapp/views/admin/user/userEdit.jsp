<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:admin>
	<jsp:body>
	<div class="container mt-2">
		<div class="col-md-12 col-12 col-sm-12">
			<c:if test="${not empty sessionScope.categoryNameAdd }">
			<div class="alert alert-success">Add category name: ${sessionScope.categoryNameAdd } successful</div>
			<c:remove var="categoryNameAdd" scope="session" />
		</c:if>
		<c:if test="${not empty sessionScope.categoryNameEdit }">
			<div class="alert alert-success">Edit category name: ${sessionScope.categoryNameEdit } successful</div>
			<c:remove var="categoryNameEdit" scope="session" />
		</c:if>
			<div class="card">
				<div class="card-header " style="padding-top: 130px;">
					<h4>
						Edit Sinh Viên
					</h4>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form method="post" action="${pageContext.request.contextPath }/admin/user/edit">
							<input type="text" name="maSV" value="${id }" hidden="true">
							<div class="mb-3">
								<label for="hoTen">Mã SV</label><input type="text" class="form-control" id="maSV" name="maSV"
										required="required" value="${user.maSV }" disabled>
							</div>
							<div class="mb-3">
								<label for="hoTen">Họ Tên SV</label><input type="text" class="form-control" id="hoTen" name="hoTen"
										required="required" value="${user.hoTen }">
							</div>
			
							<div class="mb-3">
								<label for="hoTen">Ngày Sinh</label><input type="date"
										class="form-control" id="ngaySinh" name="ngaySInh"
										required="required" value="${user.ngaySinh }">
							</div>
							<div class="mb-3">
								<label for="hoTen">Mã Khoa</label><input type="text" class="form-control" id="maKhoa" name="maKhoa"
										required="required" value="${user.maKhoa }" disabled>
							</div>
							<div class="mb-3">
								<label for="hoTen">Account ID</label><input type="text" class="form-control" id="accountID" name="accountID"
										required="required" value="${user.accountID }" disabled>
							</div>
							<div class="mb-3">
								<button type="submit" class="btn btn-primary">Edit</button>
							</div>
						</form>
						<div class="col md-4 pt-2">
						<a class="btn btn-outline-dark" href="${pageContext.request.contextPath }/admin/user">Back</a>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</jsp:body>
</t:admin>