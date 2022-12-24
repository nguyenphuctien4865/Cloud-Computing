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
						Edit Môn học
					</h4>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form method="post"
								action="${pageContext.request.contextPath }/admin/subject/edit">
							<div class="mb-3">
								<label for="maMH">Mã MH</label><input type="text"
										class="form-control" id="maMH" name="maMH" required="required"
										value="${monEdit.maMH }">
							</div>
							<div class="mb-3">
								<label for="tenMH">Tên MH</label><input type="text"
										class="form-control" id="tenMH" name="tenMH"
										required="required" value="${monEdit.tenMH }">
							</div>
							<div class="mb-3">
								<label for="loai">Loại</label>
								<select class="form-select" aria-label="Default select example" id="loai" name="loai">
									<option selected value="${monEdit.loai }">
										<c:choose>
											<c:when test="${monEdit.loai== 'BB'}">
												Bắt buộc
											</c:when>
											<c:otherwise>
												Tự chọn
											</c:otherwise>
										</c:choose>
									</option>
									<option value="BB">Bắt buộc</option>
									<option value="TC">Tùy chọn</option>
								</select>
							</div>
							<div class="mb-3">
								<label for="soTC">Số tín chỉ</label>
								<select class="form-select" aria-label="Default select example" id="soTC" name="soTC">
									<option selected value = "${monEdit.soTC }">${monEdit.soTC }</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>
							</div>
							<div class="mb-3">
							<label for="khoaID">Mã Khoa</label>
								<select class="form-select" aria-label="Default select example"
										id="khoaID" name="khoaID">
  									<option selected value="${monKhoa.khoaID }">${monKhoa.tenKhoa }</option>
  									<c:forEach items="${Khoa }" var="Khoa">
  										<option value="${Khoa.khoaID }">${Khoa.tenKhoa }</option>
  									</c:forEach>
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