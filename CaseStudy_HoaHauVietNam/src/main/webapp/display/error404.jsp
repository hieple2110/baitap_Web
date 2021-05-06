<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 05/03/2021
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            margin: 0px;
            padding: 0px;
            font-family: "montsare", sans-serif;
            min-height: 100vh;
            /* background-image: linear-gradient(125deg, #6a89cc, #b8c994); */
            background: url('../Blog_Miss/anh/thien.gif') no-repeat 120% 20%;
        }

        .container {
            width: 100%;
            position: absolute;
            text-align: center;
            transform: translateY(-50%);
            top: 50%;
            color: #343434;
        }
        .container h1 {
            font-size: 160px;
            margin: 0;
            font-weight: 900;
            letter-spacing: 20px;
            background: url("../Blog_Miss/anh/ab.jpg");
            -webkit-text-fill-color: transparent;
            -webkit-background-clip: text;
        }

        .container a {
            text-decoration: none;
            background: #e55039aa;
            color: #fff;
            padding: 12px 24px;
            display: inline-block;
            border-radius: 25px;
            font-size: 14px;
            text-transform: uppercase;
            transition: 0.4s;
        }

        .container a:hover{
            background: #e55039;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Page not found</h2>
    <h1>404</h1>
    <p>We can't find the page you're looking for</p>
    <a href="/hoahauvietnam.com.vn">Go back home</a>
</div>

</body>
</html>
