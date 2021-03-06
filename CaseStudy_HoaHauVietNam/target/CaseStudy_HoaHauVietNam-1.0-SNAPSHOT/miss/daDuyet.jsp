<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 24/12/2020
  Time: 14:00
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
    <link rel="icon" href="../gentelella/production/images/favicon.ico" type="image/ico"/>

    <title>List Duyet | </title>

    <!-- Bootstrap -->
    <link href="../gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../gentelella/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../gentelella/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- bootstrap-progressbar -->
    <link href="../gentelella/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../gentelella/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="../gentelella/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../gentelella/build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="index.html" class="site_title"><i class="fa fa-paw"></i>
                        <span>Management Customer</span></a>
                </div>

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
                                    <img src="<c:url value="${sessionScope.account.image}"/>"
                                         alt=" ">${sessionScope.account.userName}
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
                <div class="page-title">
                    <div>
                        <c:if test="${message !=null}">
                            <span class="alert-success">${message}</span>
                        </c:if>
                    </div>
                    <div class="title_left">
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
                            Create Miss
                        </button>

                    </div>
                    <div class="title_right">
                        <form action="/listSearchMiss" method="post">
                            <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" name="search" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="submit">Go!</button>
                                    </span>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="clearfix"></div>
                <div class="row" style="display: block;">
                    <div class="col-md-12 col-sm-12  ">
                        <div class="x_panel">
                            <div class="x_content">
                                <div class="table-responsive">
                                    <table class="table table-striped jambo_table bulk_action">
                                        <thead>
                                        <tr class="headings">
                                            <th class="column-title">Image</th>
                                            <th class="column-title">Name</th>
                                            <th class="column-title">Province</th>
                                            <th class="column-title">Nation</th>
                                            <th class="column-title">Education</th>
                                            <th class="column-title">Status</th>
                                            <th class="column-title no-link last"><span class="nobr">Action</span>
                                            </th>
                                            <th class="bulk-actions" colspan="7">
                                                <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions (
                                                    <span
                                                            class="action-cnt"> </span> ) <i
                                                            class="fa fa-chevron-down"></i></a>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%--                                        <c:forEach var="user" items="${sessionScope.user}">--%>
                                        <c:forEach var="miss" items="${listMiss}">
                                            <tr class="even pointer">
                                                <td><img src="<c:out value="${miss.image}" />" height="100px"
                                                         width="120px"></td>
                                                <td><c:out value="${miss.nameMiss}"/></td>
                                                <td><c:out value="${miss.province.nameProvince}"/></td>
                                                <td><c:out value="${miss.nation.nameNation}"/></td>
                                                <td><c:out value="${miss.education.nameEducational}"/></td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${miss.status=='Đã duyệt'}">
                                                            <span class="status text-success ">&bull;</span>
                                                            Đã duyệt</a>
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <a href="/viewMiss?idMiss=${miss.idMiss}"><i
                                                            style="color: #6ce26c" class="fa fa-eye"></i> || </a>
                                                    <a href="/updateMiss?idMiss=${miss.idMiss}"><i
                                                            style="color: #007bff"
                                                            class="fa fa-cogs"></i> || </a>
                                                    <a href="#" onclick="deleteMiss(${miss.idMiss})"
                                                       class="delete" title="Delete" data-toggle="tooltip"><i
                                                            style="color: crimson"
                                                            class="fa fa-trash"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--add account--%>
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Create Miss</h4>
                        </div>
                        <div class="modal-body">
                            <form action="/addMiss" method="post">
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Name<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" type="text" name="name"
                                               required="required"/>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Date<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" type="date" name="date"
                                               required="required"/>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">PassPort<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" data-validate-length-range="6" name="pass"
                                               type="text" required="required"/>
                                    </div>
                                </div>

                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Address<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" data-validate-length-range="6" name="address"
                                               type="text" required="required"/>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Job<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" data-validate-length-range="6" name="job"
                                               type="text" required="required"/>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Email<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" data-validate-length-range="6" name="email"
                                               type="text" required="required"/>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">NumberPhone<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" data-validate-length-range="6" name="phone"
                                               type="text" required="required"/>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Province<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <select class="form-control" name="province">
                                            <option>Select Province</option>
                                            <c:forEach items="${listProvince}" var="province">
                                                <option value="${province.idProvince}">${province.nameProvince}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Nation<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <select class="form-control" name="nation">
                                            <option>Select Nation</option>
                                            <c:forEach items="${listNation}" var="nation">
                                                <option value="${nation.idNation}">${nation.nameNation}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Educational<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <select class="form-control" name="education">
                                            <option>Select Education</option>
                                            <c:forEach items="${listEducation}" var="education">
                                                <option value="${education.idEducational}">${education.nameEducational}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="field item form-group">
                                    <label class="col-form-label col-md-3 col-sm-3  label-align">Image<span
                                            class="required"></span></label>
                                    <div class="col-md-6 col-sm-6">
                                        <input class="form-control" data-validate-length-range="6" name="image"
                                               type="text" required="required"/>
                                    </div>
                                </div>
                                <div class="ln_solid">
                                    <div class="form-group">
                                        <div class="col-md-6 offset-md-3">
                                            <button type='submit' class="btn btn-primary">Create</button>
                                            <button type='reset' class="btn btn-success">Reset</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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

<script>
    function deleteMiss(id) {
        let showMessage = confirm("Do you want to delete this Miss ?");
        if (showMessage) {
            alert("Delete Miss successfully!")
            window.location = "/deleteMiss?id=" + id;
        } else {
        }
    }
</script>


<!-- jQuery -->
<script src="../gentelella/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../gentelella/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../gentelella/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../gentelella/vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="../gentelella/vendors/Chart.js/dist/Chart.min.js"></script>
<!-- gauge.js -->
<script src="../gentelella/vendors/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="../gentelella/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="../gentelella/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="../gentelella/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="../gentelella/vendors/Flot/jquery.flot.js"></script>
<script src="../gentelella/vendors/Flot/jquery.flot.pie.js"></script>
<script src="../gentelella/vendors/Flot/jquery.flot.time.js"></script>
<script src="../gentelella/vendors/Flot/jquery.flot.stack.js"></script>
<script src="../gentelella/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="../gentelella/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="../gentelella/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="../gentelella/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="../gentelella/vendors/DateJS/build/date.js"></script>
<!-- JQVMap -->
<script src="../gentelella/vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="../gentelella/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="../gentelella/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="../gentelella/vendors/moment/min/moment.min.js"></script>
<script src="../gentelella/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- Custom Theme Scripts -->
<script src="../gentelella/build/js/custom.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script>
    $(document).ready(function () {
        $('#content').summernote();
    });
</script>
</body>
</html>
