<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23/12/2020
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Update Education | </title>

    <!-- Bootstrap -->
    <link href="../gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../gentelella/vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../gentelella/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Management
                                Customer</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="<c:url value="${sessionScope.account.image}"/>" alt=" "
                             class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome</span>
                        <h2>${sessionScope.account.fullName}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <ul class="nav side-menu">
                            <li><a href="/listAccount"><i class="fa fa-desktop"></i>Quản lý Tài khoản</a>
                            </li>

                            <li><a href="/listPosts"><i class="fa fa-desktop"></i>Quản lý Bài viết</a>
                            </li>

                            <li><a href="#"><i class="fa fa-desktop"></i>Quản lý Thí Sinh</a>
                                <ul class="nav child_menu">
                                    <li><a href="/listMiss">Hồ Sơ Đăng Ký</a></li>
                                    <li><a href="/listPage">Hồ Sơ Đăng Ký(Page)</a></li>
                                    <li><a href="/xetduyet">Danh sách Xét duyệt</a></li>
                                    <li><a href="/choDuyet">Danh sách Chờ duyệt</a></li>
                                    <li><a href="/daDuyet">Danh sách Đã duyệt</a></li>
                                    <li><a href="/biLoai">Danh sách Bị loại</a></li>
                                </ul>
                            </li>
                            <li><a href="#"><i class="fa fa-desktop"></i>Quản lý Tỉnh thành</a>
                                <ul class="nav child_menu">
                                    <li><a href="/pageProvince">Danh sách Tỉnh thành(Page)</a></li>
                                    <li><a href="/listProvince">Danh sách Tỉnh thành</a></li>
                                </ul>
                            </li>

                            <li><a href="/listNation"><i class="fa fa-desktop"></i>Quản lý Dân Tộc</a>
                            </li>
                            <li><a href="/listEducation"><i class="fa fa-desktop"></i>Quản lý Học Vấn</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open" style="padding-left: 15px;">
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true"
                               id="navbarDropdown"
                               data-toggle="dropdown" aria-expanded="false">
                                <span>
                                    <img src="<c:url value="${sessionScope.account.image}"/>" alt=" ">
                                    ${sessionScope.account.userName}
                                </span>
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <div class="profile_info">
                                    <a>
                                        <h2>${sessionScope.account.fullName}</h2>
                                        <h2>${sessionScope.account.email}</h2>
                                    </a>
                                </div>
                                <div>
                                    <a class="dropdown-item" href="/changePassword"><span>Change Password</span></a>
                                </div>
                                <div>
                                    <a class="dropdown-item" href="/logout"><i class="fa fa-sign-out pull-right"></i>
                                        Log Out</a>
                                </div>

                            </div>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="x_content">
                            <a href="/listEducation"><span class="section"><small>Back List Education</small></span></a>
                            <form action="/updateEducation" method="post">
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align"><span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" name="id"
                                               value="${education.idEducational}" type="hidden" required="required"/>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Name Education<span
                                            class="required">*</span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" data-validate-length-range="3" name="name"
                                               value="${education.nameEducational}" type="text" required="required"/>
                                    </div>
                                </div>
                                <div class="ln_solid">
                                    <div class="form-group">
                                        <div class="col-md-6 offset-md-3">
                                            <button type='submit' class="btn btn-primary">Edit</button>
                                            <button type='reset' class="btn btn-success">Reset</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /page content -->

    <!-- footer content -->
    <footer>
        <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
        </div>
        <div class="clearfix"></div>
    </footer>
    <!-- /footer content -->
</div>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="../gentelella/vendors/validator/multifield.js"></script>
<script src="../gentelella/vendors/validator/validator.js"></script>

<!-- Javascript functions	-->
<script>
    function hideshow() {
        var password = document.getElementById("password1");
        var slash = document.getElementById("slash");
        var eye = document.getElementById("eye");

        if (password.type === 'password') {
            password.type = "text";
            slash.style.display = "block";
            eye.style.display = "none";
        } else {
            password.type = "password";
            slash.style.display = "none";
            eye.style.display = "block";
        }

    }
</script>

<script>
    // initialize a validator instance from the "FormValidator" constructor.
    // A "<form>" element is optionally passed as an argument, but is not a must
    var validator = new FormValidator({
        "events": ['blur', 'input', 'change']
    }, document.forms[0]);
    // on form "submit" event
    document.forms[0].onsubmit = function (e) {
        var submit = true,
            validatorResult = validator.checkAll(this);
        console.log(validatorResult);
        return !!validatorResult.valid;
    };
    // on form "reset" event
    document.forms[0].onreset = function (e) {
        validator.reset();
    };
    // stuff related ONLY for this demo page:
    $('.toggleValidationTooltips').change(function () {
        validator.settings.alerts = !this.checked;
        if (this.checked)
            $('form .alert').remove();
    }).prop('checked', false);

</script>

<!-- jQuery -->
<script src="../gentelella/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../gentelella/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../gentelella/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../gentelella/vendors/nprogress/nprogress.js"></script>
<!-- validator -->
<!-- <script src="../vendors/validator/validator.js"></script> -->

<!-- Custom Theme Scripts -->
<script src="../gentelella/build/js/custom.min.js"></script>

</body>
</html>
