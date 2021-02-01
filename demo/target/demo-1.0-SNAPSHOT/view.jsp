<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01/02/2021
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view</title>
</head>
<body>
<table>
    <tr>
        <td>Id</td>
        <td>${requestScope.student.getId()}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${requestScope.student.getName()}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${requestScope.student.getAge()}</td>
    </tr>
    <tr>
        <td>Address</td>
        <td>${requestScope.student.getAddress()}</td>
    </tr>
</table>
<p>
    <a href="/listStudent">Back list</a>
</p>
</body>
</html>
