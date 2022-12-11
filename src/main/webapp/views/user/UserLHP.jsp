<%--
  Created by IntelliJ IDEA.
  User: tienc
  Date: 12/10/2022
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@include file="/common/taglib.jsp"%>


<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header">
                Đăng ký môn học
            </h4>
            <c:choose>
                <c:when test="${lophocphan.size() == 0}">
                    <div class="card-body">
                        <p class="card-text">Không có dữ liệu.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Mã lớp</th>
                                <th>Mã Môn học</th>
                                <th>Mã Giảng viên</th>
                                <th>Phòng</th>
                                <th>Số sinh viên</th>
                                <th>Ngày Bắt đầu</th>
                                <th>Thứ </th>
                                <th>Tiết</th>

                                <th> </th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${lophocphan}" var="c">
                                <tr>
                                    <td>${c.maLop}</td>
                                    <td>${c.maMH}</td>
                                    <td>${c.maGV}</td>
                                    <td >${c.phong}</td>
                                    <td >${c.soSV}</td>
                                    <td >${c.ngayBD}</td>
                                    <td >${c.thu}</td>
                                    <td >${c.tiet}</td>
                                    <td class="text-right">
                                            <a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/DKMH/Register?maLop=${c.id}" role="button">
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
        <div class="card">
            <h4 class="card-header">
                Môn đã đăng ký
            </h4>
            <div class="card-body">

            </div>
        </div>
    </jsp:body>
</t:main>