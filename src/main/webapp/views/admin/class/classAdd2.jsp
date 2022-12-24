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
						Add Lớp
					</h4>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form method="post"
								action="${pageContext.request.contextPath }/admin/class/add1">
							<div class="mb-3">
								<label for="maLop">Mã Lớp</label><input type="text"
										class="form-control" id="maLop" name="maLop"
										required="required" value="${maLop }" readonly="readonly">
							</div>
							<div class="mb-3">
							<label for="loai">Loại lớp học</label>
								<input type="text"
										class="form-control" id="loai" name="loai"
										required="required" value="${loai }" readonly="readonly">
							</div>
							<div class="mb-3">
							<label for="maMH">Môn học</label>
								<input type="text"
										class="form-control" id="maMH" name="maMH"
										required="required" value="${maMH }" readonly="readonly">
							</div>
							<div class="mb-3">
							<label for="maGV"></label>
								<select class="form-select" aria-label="Default select example" id="maGV" name="maGV">
								<c:forEach items="${giangvien }" var="giangvien">
									<option value="${giangvien.maGV }">${giangvien.hoTen }</option>
								</c:forEach>
									
								</select>
							</div>
							
							
							<div class="mb-3">
								<button type="submit" class="btn btn-primary">Continue</button>
							</div>
						</form>
						<div class="col md-4 pt-2">
						<a class="btn btn-outline-dark"
									href="${pageContext.request.contextPath }/admin/class">Back</a>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</jsp:body>
</t:admin>