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
										required="required" value="">
							</div>
							<div class="mb-3">
							<label for="loai">Loại lớp học</label>
								<select class="form-select" aria-label="Default select example" id="loai" name="loai">
									<option selected="selected">Chọn loại lớp học</option>
									<option Value="Extra">Extra</option>
									<option Value="Original">Original</option> 
								</select>
							</div>
							<div class="mb-3">
							<label for="maMH">Môn học</label>
								<select class="form-select" aria-label="Default select example" id="maMH	" name="maMH">
									<option selected="selected">Chọn môn học</option>
									<c:forEach items="${monhoc }" var="monhoc">
										<option Value="${monhoc.maMH }">${monhoc.tenMH }</option> 
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