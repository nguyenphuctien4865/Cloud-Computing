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
						<form method="post"
								action="${pageContext.request.contextPath }/admin/user/edit?maSV=${user.maSV}">
							<div class="mb-3">
								<label for="hoTen">user</label><input type="text"
										class="form-control" id="maSV" name="maSV" required="required"
										value="${user.maSV }" readonly="readonly">
							</div>
							<div class="mb-3">
								<label for="hoTen">Họ Tên SV</label><input type="text"
										class="form-control" id="hoTen" name="hoTen"
										required="required" value="${user.hoTen }">
							</div>
			
							<div class="mb-3">
								<label for="hoTen">Ngày Sinh</label><input type="date"
										class="form-control" id="ngaySinh" name="ngaySinh"
										required="required" value="${user.ngaySinh }">
							</div>
							<div class="mb-3">
								<div class="mb-3">
							<label for="maKhoa">Mã Khoa</label>
								<select class="form-select" aria-label="Default select example"
											id="maKhoa" name="maKhoa">
  									<option selected value="${userKhoa.khoaID }"
												class="form-control" id="maKhoa" name="maKhoa">${userKhoa.tenKhoa }</option>
  									<c:forEach items="${Khoa }" var="Khoa">
  										<option value="${Khoa.khoaID }" class="form-control"
													id="maKhoa" name="maKhoa">${Khoa.tenKhoa }</option>
  									</c:forEach>
								</select>
							</div>
								
							</div>
							<div class="mb-3">
								<label for="hoTen">Account ID</label><input type="text"
										class="form-control" id="accountID" name="accountID"
										required="required" value="${user.accountID }" readonly="readonly">
							</div>
							<div class="mb-3">
								<button type="submit" class="btn btn-primary">Edit</button>
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