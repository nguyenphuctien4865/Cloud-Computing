<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:admin>
	<jsp:body>
	<div class="container mt-2">
		<div class="col-md-12 col-12 col-sm-12">
			<div class="card">
				<div class="card-header " style="padding-top: 130px;">
					<h4>
						Add Giảng Viên
					</h4>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form method="post"
								action="${pageContext.request.contextPath }/admin/teacher/add">
							<div class="mb-3">
								<label for="maGV">Mã GV</label><input type="text"
										class="form-control" id="maGV" name="maGV" required="required"
										value="">
							</div>
							<div class="mb-3">
								<label for="hoTen">Họ Tên GV</label><input type="text"
										class="form-control" id="hoTen" name="hoTen"
										required="required" value="">
							</div>
							<div class="mb-3">
								<label for="ngaySinh">Ngày Sinh</label><input type="date"
										class="form-control" id="ngaySinh" name="ngaySinh"
										required="required" value="">
							</div>
							<div class="mb-3">
							<label for="maKhoa">Mã Khoa</label>
								<select class="form-select" aria-label="Default select example"
										id="maKhoa" name="maKhoa">
  									<option selected>Chọn mã khoa</option>
  									<c:forEach items="${Khoa }" var="Khoa">
  										<option value="${Khoa.khoaID }">${Khoa.tenKhoa }</option>
  									</c:forEach>
								</select>
							</div>
							<div class="mb-3">
								<label for="loaiGV">Loại Giảng Viên</label>
								<select class="form-select" id="loaiGV" name="loaiGV"
										aria-label="Default select example"> 
										<option selected>Chọn loại giảng viên</option>
										<option value="CH">CH</option>
										<option value="TG">TG</option>
								</select>
							</div>
							<div class="mb-3">
								<label for="maMH">Môn Giảng dạy</label>
								<select class="form-select" aria-label="Default select example" name="maMH">
									<option selected>Chọn môn học</option>
									<c:forEach items = "${Monhoc }" var="Monhoc">
										<option value = "${Monhoc.maMH }">${Monhoc.tenMH }</option>
									</c:forEach>
								</select>
							</div>
							
			
							
							
							<div class="mb-3">
								<button type="submit" class="btn btn-primary">Add</button>
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