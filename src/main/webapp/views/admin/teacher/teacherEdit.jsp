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
						Edit Giảng Viên
					</h4>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form method="post"
								action="${pageContext.request.contextPath }/admin/teacher/edit">
							<div class="mb-3">
								<label for="maGV">Mã Giảng Viên</label><input type="text"
										class="form-control" id="maGV" name="maGV" required="required"
										value="${gvEdit.maGV }" readonly="readonly">
							</div>
							<div class="mb-3">
								<label for="hoTen">Họ Tên GV</label><input type="text"
										class="form-control" id="hoTen" name="hoTen"
										required="required" value="${gvEdit.hoTen }">
							</div>
			
							<div class="mb-3">
								<label for="ngaySinh">Ngày Sinh</label><input type="date"
										class="form-control" id="ngaySinh" name="ngaySinh"
										required="required" value="${gvEdit.ngaySinh }">
							</div>
							<div class="mb-3">
								<div class="mb-3">
							<label for="maKhoa">Mã Khoa</label>
								<select class="form-select" aria-label="Default select example"
											id="maKhoa" name="maKhoa">
  									<option selected value="${teacherKhoa.khoaID }"
												class="form-control" id="maKhoa" name="maKhoa">${teacherKhoa.tenKhoa }</option>
  									<c:forEach items="${Khoa }" var="Khoa">
  										<option value="${Khoa.khoaID }" class="form-control"
													id="maKhoa" name="maKhoa">${Khoa.tenKhoa }</option>
  									</c:forEach>
								</select>
							</div>
								
							</div>
							<div class="mb-3">
								<label for="hoTen">Loại Giảng Viên</label>
								<select class="form-select" aria-label="Default select example"
										id="loaiGV" name="loaiGV">
										<option selected value="${gvEdit.loaiGV }">${gvEdit.loaiGV }</option>
										<option value="CH">CH</option>
										<option value="TG">TG</option>
								</select>
							</div>
							<div class="mb-3">
								<button type="submit" class="btn btn-primary">Edit</button>
							</div>
						</form>
						<div class="col md-4 pt-2">
						<a class="btn btn-outline-dark"
									href="${pageContext.request.contextPath }/admin/teacher">Back</a>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</jsp:body>
</t:admin>