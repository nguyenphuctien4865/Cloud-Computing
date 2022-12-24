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
						Edit Khoa
					</h4>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<form method="post"
								action="${pageContext.request.contextPath }/admin/major/edit">
							<div class="mb-3">
								<label for="khoaID">ID Khoa</label><input type="text"
										class="form-control" id="khoaID" name="khoaID"
										required="required" value="${khoaEdit.khoaID }" readonly="readonly">
							</div>
							<div class="mb-3">
								<label for="tenKhoa">Tên Khoa</label><input type="text"
										class="form-control" id="tenKhoa" name="tenKhoa"
										required="required" value="${khoaEdit.tenKhoa }">
							</div>
							<div class="mb-3">
								<button type="submit" class="btn btn-primary">Edit</button>
							</div>
						</form>
						<div class="col md-4 pt-2">
						<a class="btn btn-outline-dark"
									href="${pageContext.request.contextPath }/admin/major">Back</a>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</jsp:body>
</t:admin>