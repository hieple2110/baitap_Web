<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01/02/2021
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login form</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <tr>
        <td>user:</td>
        <input type="text" name="user" placeholder="enter username">
    </tr>
    <tr>
        <td>pass:</td>
        <input type="text" name="pass" placeholder="enter pass">
    </tr>
    <tr>
        <input type="submit"  value="login">
    </tr>

</form>
</body>
</html>
