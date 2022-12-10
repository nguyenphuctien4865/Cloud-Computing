<%--
  Created by IntelliJ IDEA.
  User: tienc
  Date: 12/10/2022
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header">
                Profile
            </h4>
            <div class="card-body">
                Thông tin cá nhân người dùng đang đăng nhập, lấy từ session.getAttibute("authUser").
            </div>
        </div>
    </jsp:body>
</t:main>