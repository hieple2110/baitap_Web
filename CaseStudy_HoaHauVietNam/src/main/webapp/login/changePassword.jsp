<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Change Password | </title>

    <!-- Bootstrap -->
    <link href="../gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../gentelella/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="../gentelella/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../gentelella/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">

        <div class="animate form login_form">
            <section class="login_content">
                <form action="/changPassword" method="post">
                    <h1>Change Password</h1>

                    <div>
                        <td><input type="text"  value="${account.userName}" name="user" class="form-control" required=""/></td>
                    </div>
                    <div>

                        <td><input type="text" class="form-control" name="oldPassword" placeholder="Enter Old Password " required=""/></td>
                    </div>

                    <div>

                        <input type="text" class="form-control" name="newPassword" placeholder="Enter New Password " required=""/>
                    </div>

                    <div>
                        <a class="btn btn-default submit"><input type="submit" value="Change Password"></a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Already a member ?
                            <a href="/login" class="to_register"> Log in </a>
                        </p>

                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                            <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and
                                Terms</p>
                        </div>

                        <div>
                            <c:if test="${message !=null}">
                                <span class="alert-warning">${message}</span>
                            </c:if>
                        </div>
                    </div>
                </form>
            </section>
        </div>


    </div>
</div>

</body>
</html>
