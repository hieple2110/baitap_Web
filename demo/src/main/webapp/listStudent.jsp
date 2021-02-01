<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01/02/2021
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<p>
    <a href="demo.jsp">home</a>
</p>
<p>
    <c:if test="${requestScope.message ==null}">
        ${requestScope.message}
    </c:if>
</p>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${requestScope.listStudent}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.age}</td>
            <td>${list.address}</td>
            <td><a href="/view?id=${list.getId()}">view</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
