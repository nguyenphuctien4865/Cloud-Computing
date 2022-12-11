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

<jsp:useBean id="listmonhoc" scope="request" type="java.util.List<com.cloudcomputing.models.MonhocModel>" />

<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header">
                Đăng ký môn học
            </h4>
            <c:choose>
                <c:when test="${listmonhoc.size() == 0}">
                    <div class="card-body">
                        <p class="card-text">Không có dữ liệu.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Mã Môn học</th>
                                <th>Tên môn học</th>
                                <th>Loại môn học </th>
                                <th>Số tín chỉ</th>

                                <th> </th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${listmonhoc}" var="c">
                                <tr>
                                    <td>${c.maMH}</td>
                                    <td>${c.tenMH}</td>
                                    <td>${c.loai}</td>
                                    <td >${c.soTC}</td>

                                    <td class="text-right">
                                        <a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/DKMH/Detail?maMH=${c.maMH}" role="button">
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
                <c:choose>
                    <c:when test="${listthamgia.size() == 0}">
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
                                <c:forEach items="${listthamgia}" var="tg">
                                    <tr>
                                        <td>${tg.maLop}</td>
                                        <td>${tg.maMH}</td>
                                        <td>${tg.maGV}</td>
                                        <td >${tg.phong}</td>
                                        <td >${tg.soSV}</td>
                                        <td >${tg.ngayBD}</td>
                                        <td >${tg.thu}</td>
                                        <td >${tg.tiet}</td>
                                        <td class="text-right">
                                            <%--<a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/DKMH/Register?maLop=${c.id}" role="button">
                                                <i class="fa fa-pencil" aria-hidden="true"></i>
                                            </a>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </jsp:body>
</t:main>