<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
//<jsp:useBean id="categoriesWithDetails" scope="request" type="java.util.List<com.ute.ecwebapp.beans.Category>"/>
--%>

<%--<div class="card">
  <h4 class="card-header">
    Categories
  </h4>
  <div class="list-group list-group-flush">
    <c:forEach items="${categoriesWithDetails}" var="c">
      <a href="${pageContext.request.contextPath}/Product/ByCat?id=${c.catID}" class="list-group-item list-group-item-action">
        <i class="fa fa-caret-right" aria-hidden="true"></i>
        ${c.catName}
      </a>
    </c:forEach>
    &lt;%&ndash;<a href="#" class="list-group-item list-group-item-action active" aria-current="true">&ndash;%&gt;
    &lt;%&ndash;  The current link item&ndash;%&gt;
    &lt;%&ndash;</a>&ndash;%&gt;
  </div>
</div>--%>

<div class="card mt-3">
  <%--h4 class="card-header">
    Thông tin
  </h4>
  <div class="fa-picture-o">
    <div class="card" style="width: 18rem;">
      <img class="card-img-top" src="..." alt="Card image cap">
      <div class="card-body">
        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      </div>
    </div>--%>
    <%--<a href="#" class="list-group-item list-group-item-action active" aria-current="true">
      The current link item (edited)
    </a>
    <a href="#" class="list-group-item list-group-item-action">A second link item</a>
    <a href="#" class="list-group-item list-group-item-action">A third link item</a>
    <a href="#" class="list-group-item list-group-item-action">A fourth link item</a>
    <a href="#" class="list-group-item list-group-item-action disabled" tabindex="-1" aria-disabled="true">A disabled link item</a>--%>
<%--  </div>--%>
    <div class="card" style="width: 18rem;">
        <c:url value="/template/image/logo-cntt2021.png"
               var="logoSPKT"/>
      <img class="card-img-top" src="${logoSPKT}" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">Trang chủ</h5>
        <p class="card-text">Trang chủ trường đại học Sư phạm kĩ thuật TP.HCM</p>

        <a href="https://hcmute.edu.vn/" class="btn btn-primary">Website</a>
      </div>
    </div>
</div>