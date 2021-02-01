<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01/02/2021
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>

    </style>
</head>
<body>

<h1>Menu</h1>
<ul>
    <li><a href="_blank"><h3>trang chu</h3></a></li>
    <li><a href="formlogin.jsp"><h3>dang nhap</h3></a></li>

    <c:forEach items='${requestScope["listStudent"]}' var="list">
       <li>
<%--           <a href="/view?id=${student.id}">${list.getName()}</a>--%>
           <a href="${pageContext.request.contextPath}/view?id=${list.getId()-1}">${list.getName()}</a>
       </li>
    </c:forEach>
</ul>
</body>
</html>
