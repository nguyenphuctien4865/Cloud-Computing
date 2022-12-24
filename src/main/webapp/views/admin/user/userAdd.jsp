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
						Add Sinh Viên
					</h4>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form method="post"
								action="${pageContext.request.contextPath }/admin/user/add">
							<div class="mb-3">
								<label for="hoTen">Mã SV</label><input type="text"
										class="form-control" id="maSV" name="maSV" required="required"
										value="">
							</div>
							<div class="mb-3">
								<label for="password">Password</label><input type="password"
										class="form-control" id="password" name="password"
										required="required">
							</div>
							<div class="mb-3">
								<label for="type">Type</label><input type="text"
										class="form-control" id="type" name="type" required="required"
										readonly="readonly" value="student"> 
							</div>
							<div class="mb-3">
								<label for="hoTen">Họ Tên SV</label><input type="text"
										class="form-control" id="hoTen" name="hoTen"
										required="required" value="">
							</div>
			
							<div class="mb-3">
								<label for="hoTen">Ngày Sinh</label><input type="date"
										class="form-control" id="ngaySinh" name="ngaySinh"
										required="required" value="">
							</div>
							<div class="mb-3">
							<label for="maKhoa">Mã Khoa</label>
								<select class="form-select" aria-label="Default select example" id="maKhoa" name="maKhoa">
  									<option selected>Chọn mã khoa</option>
  									<c:forEach items="${Khoa }" var="Khoa">
  										<option value="${Khoa.khoaID }">${Khoa.tenKhoa }</option>
  									</c:forEach>
								</select>
							</div>
							<div class="mb-3">
								<button type="submit" class="btn btn-primary">Add</button>
							</div>
						</form>
						<div class="col md-4 pt-2">
						<a class="btn btn-outline-dark"
									href="${pageContext.request.contextPath }/admin/user">Back</a>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</jsp:body>
</t:admin>