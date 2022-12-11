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

<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header">
                Profile
            </h4>
            <div class="card-body">
                <c:if test="${auth}">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Mã số sinh viên</th>
                            <th>${sv.maSV}</th>
                        </tr>
                        <tr>
                            <th>Họ tên</th>
                            <th>${sv.hoTen}</th>
                        </tr>
                        <tr>
                            <th>Ngày sinhh</th>
                            <th><fmt:formatDate value="${sv.ngaySinh}" pattern="yyyy-MM-dd" /></th>
                        </tr>
                        <tr>
                            <th>Khoa</th>
                            <th>${kh.tenKhoa}</th>
                        </tr>

                    </table>
                </c:if>
            </div>
        </div>
    </jsp:body>
</t:main>