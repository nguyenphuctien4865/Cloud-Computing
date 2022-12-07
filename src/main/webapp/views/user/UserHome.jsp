<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@include file="/common/taglib.jsp"%>

<jsp:useBean id="monhoc" scope="request" class="java.util.ArrayList"/>

<t:main>
	<jsp:body>
		<div class="card">
			<h4 class="card-header">
				Index
			</h4>
			<c:choose>
				<c:when test="${monhoc.size() == 0}">
					<div class="card-body">
						<p class="card-text">Không có dữ liệu.</p>
					</div>
				</c:when>
				<c:otherwise>
					<div class="card-body">
						<table class="table table-hover">
							<thead>
							<tr>
								<th>Mã môn học</th>
								<th>Tên môn học</th>
								<th >Loại MH</th>
								<th >Số tín chỉ</th>
								<th>&nbsp;</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${monhoc}" var="c">
								<tr>
									<td>${c.maMH}</td>
									<td>${c.tenMH}</td>
									<td>${c.loai}</td>
									<td >${c.soTC}</td>
									<td class="text-right">
										<a class="btn btn-sm btn-outline-primary" href="#" role="button">
											<i class="fa fa-pencil" aria-hidden="true"></i>
										</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</jsp:body>
</t:main>