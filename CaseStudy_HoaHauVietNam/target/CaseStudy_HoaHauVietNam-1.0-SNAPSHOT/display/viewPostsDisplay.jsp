<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="en">
<head>
    <title>Hoa Hậu Việt Nam 2020</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300, 400,700" rel="stylesheet">

    <link rel="stylesheet" href="../Blog_Miss/css/bootstrap.css">
    <link rel="stylesheet" href="../Blog_Miss/css/animate.css">
    <link rel="stylesheet" href="../Blog_Miss/css/owl.carousel.min.css">

    <link rel="stylesheet" href="../Blog_Miss/fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../Blog_Miss/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../Blog_Miss/fonts/flaticon/font/flaticon.css">

    <!-- Theme Style -->
    <link rel="stylesheet" href="../Blog_Miss/css/style.css">
</head>
<body>


<header role="banner">
    <div class="top-bar">
        <div class="container">
            <div class="row">
                <div class="col-9 social">
                    <a href="#"><span class="fa fa-twitter"></span></a>
                    <a href="#"><span class="fa fa-facebook"></span></a>
                    <a href="#"><span class="fa fa-instagram"></span></a>
                    <a href="#"><span class="fa fa-youtube-play"></span></a>
                    <a href="#"><span class="fa fa-vimeo"></span></a>
                    <a href="#"><span class="fa fa-snapchat"></span></a>
                </div>
                <div class="col-3 search-top">
                    <!-- <a href="#"><span class="fa fa-search"></span></a> -->
                    <form action="#" class="search-top-form">
                        <span class="icon fa fa-search"></span>
                        <input type="text" placeholder="Type keyword to search...">
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container logo-wrap">
        <div class="row pt-5">
            <div class="col-12 text-center">
                <a class="absolute-toggle d-block d-md-none" data-toggle="collapse" href="#navbarMenu" role="button"
                   aria-expanded="false" aria-controls="navbarMenu"><span class="burger-lines"></span></a>
                <h1 class="site-logo"><a href="/hoahauvietnam.com.vn">Miss Việt Nam 2021</a></h1>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-expand-md  navbar-light bg-light">
        <div class="container">
            <div class="collapse navbar-collapse" id="navbarMenu">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="/pageUser">Trang chủ</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Tin Tức</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown05">
                            <a class="dropdown-item" href="/newPosts">Tin Tức Mới</a>
                            <a class="dropdown-item" href="/postsDonors">Nhà Đồng Hành</a>
                            <a class="dropdown-item" href="/postsMiss">Thí Sinh</a>
                            <a class="dropdown-item" href="/activities">Hoạt Động</a>
                            <a class="dropdown-item" href="/postsRound">Vòng thi</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Hồ sơ Thí sinh</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown05">
                            <a class="dropdown-item" href="/listMissDisplay">Danh sách Đăng Ký</a>
                            <a class="dropdown-item" href="/listMissWait">Danh sách Chờ Duyệt</a>
                            <a class="dropdown-item" href="/listMissApprove">Danh sách Đã Duyệt</a>
                            <a class="dropdown-item" href="/listMissOut">Danh sách Đã Loại</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown06" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Khác</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown06">
                            <a class="dropdown-item" href="/registerProfile">Đăng ký Dự thi</a>
                            <a class="dropdown-item" href="/login">Đăng Nhập</a>
                            <a class="dropdown-item" href="/logout">Đăng Xuất</a>
                            <a class="dropdown-item" href="/changPassword">Đổi Mật Khẩu</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="document.getElementById('id01').style.display='block'"
                           style="width:auto;">Đăng Ký Dự Thi</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <h6 style="color: deepskyblue">${sessionScope.account.userName}</h6>
                        </a>
                    </li>
                </ul>
                <div id="id01" class="modal">
                    <div class="modal-dialog modal-lg">
                        <span onclick="document.getElementById('id01').style.display='none'" class="close"
                              title="Close Modal">&times;</span>

                        <form class="modal-content" action="/registerProfile" method="post">
                            <div class="container">
                                <h1>Thông tin đăng ký</h1>
                                <p>Vui lòng nhập đúng thông tin </p>
                                <hr>
                                <label><b>Họ và Tên</b></label>
                                <input type="text" placeholder="Nhập Họ và tên" name="name" required>

                                <label><b>Ngày Sinh</b></label>
                                <input type="date" placeholder="Nhập Ngày Sinh" name="date" required>

                                <label><b>Chứng minh Nhân dân</b></label>
                                <input type="text" placeholder="Nhập Số Chứng minh nhân dân" name="pass" required>


                                <label><b>Địa chỉ</b></label>
                                <input type="text" placeholder="Nhập Địa chỉ" name="address" required>

                                <label><b>Nghề nghiệp</b></label>
                                <input type="text" placeholder="Nhập Nghề nghiệp" name="job" required>

                                <label><b>Email</b></label>
                                <input type="text" placeholder="Nhập Họ và tên" name="email" required>

                                <label><b>Số điện thoại</b></label>
                                <input type="text" placeholder="Nhập Số điẹn thoại" name="phone" required>


                                <label><b>Tỉnh Thành</b></label>
                                <select class="form-control" name="province">
                                    <option>Chọn Tỉnh thành</option>
                                    <c:forEach items="${listProvince}" var="province">
                                        <option value="${province.idProvince}">${province.nameProvince}</option>
                                    </c:forEach>
                                </select>

                                <label><b>Dân Tộc</b></label>
                                <select class="form-control" name="nation">
                                    <option>Chọn Dân Tộc</option>
                                    <c:forEach items="${listNation}" var="nation">
                                        <option value="${nation.idNation}">${nation.nameNation}</option>
                                    </c:forEach>
                                </select>

                                <label><b>Học Vấn</b></label>
                                <select class="form-control" name="education">
                                    <option>Chọn Học vấn</option>
                                    <c:forEach items="${listEducation}" var="education">
                                        <option value="${education.idEducational}">${education.nameEducational}</option>
                                    </c:forEach>
                                </select>

                                <label><b>Ảnh Đại diện</b></label>
                                <input type="text" placeholder="Repeat Password" name="image" required>
                                <div class="clearfix">
                                    <button type="button" onclick="document.getElementById('id01').style.display='none'"
                                            class="cancelbtn">Cancel
                                    </button>
                                    <button type="submit" class="signupbtn">Sign Up</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <c:forEach items="${message}" var="message">
                    <c:if test='${message != null}'>
                        <c:choose>
                            <c:when test='${message!="Thành công"}'>
                                <script>alert(${message})</script>
                            </c:when>
                            <c:when test="${message == 'Thành công'}">
                                <script>alert("Bạn đã đăng ký hồ sơ thành công.")</script>
                            </c:when>
                        </c:choose>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </nav>
</header>
<!-- END header -->

<section class="site-section py-lg">
    <div class="container">

        <div class="row blog-entries">
            <div class="col-md-12 col-lg-8 main-content">
                <h1 class="mb-4">${posts.title}</h1>
                <div class="post-meta">
                    <span class="category">Food</span>
                    <span class="mr-2">${posts.date}</span> &bullet;
                    <span class="ml-2"><span class="fa fa-eye"></span>${posts.view}</span>
                    <span class="ml-2"><a href="/likePosts?idPosts=${posts.idPosts}"><span class="fa fa-thumbs-up"></span></a>${posts.like}</span>
                </div>
                <div class="post-content-body">
                    <div>${posts.fullContent}</div>
                </div>

                <%--tag--%>
                <div class="pt-5">
                    <p>Categories: <a href="#">Food</a>, <a href="#">Travel</a> Tags: <a href="#">#manila</a>, <a
                            href="#">#asia</a></p>
                </div>


                <div class="pt-5">
                    <ul class="comment-list">
                        <c:forEach items="${listComment}" var="comment">
                            <li class="comment">
                                <div class="vcard">
                                    <img src="${comment.account.image}">
                                </div>
                                <div class="comment-body">
                                    <h3>${comment.account.userName}</h3>
                                    <div class="meta">${comment.dateComment}</div>
                                    <p>${comment.content}</p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>

                    <%--add comment--%>
                    <div class="comment-form-wrap pt-5">
                        <h3 class="mb-5">Bình luận</h3>
                        <form action="/addComment" method="post" class="p-5 bg-light">
                            <div class="form-group">
                                <label >Content</label>
                                <input type="text" class="form-control"  name="content">
                            </div>
                            <input type="hidden" class="form-control"  name="posts" value="${posts.idPosts}">
                            <input type="hidden" class="form-control"  name="account" value="${sessionScope.account.idAccount}">
                            <input type="hidden" class="form-control"  name="image" value="${sessionScope.account.image}">
                            <input type="hidden" class="form-control"  name="name" value="${sessionScope.account.userName}">
                            <div class="form-group">
                                <input type="submit" value="Post Comment" class="btn btn-primary">
                            </div>

                        </form>
                    </div>
                </div>
            </div>

            <!-- END main-content -->

            <div class="col-md-12 col-lg-4 sidebar">
                <div class="sidebar-box search-form-wrap">
                    <form action="#" class="search-form">
                        <div class="form-group">
                            <span class="icon fa fa-search"></span>
                            <input type="text" class="form-control" id="s" placeholder="Type a keyword and hit enter">
                        </div>
                    </form>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <div class="bio text-center">
                        <img src="../Blog_Miss/images/person_1.jpg" alt="Image Placeholder" class="img-fluid">
                        <div class="bio-body">
                            <h2>Meagan Smith</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Exercitationem facilis sunt
                                repellendus excepturi beatae porro debitis voluptate nulla quo veniam fuga sit molestias
                                minus.</p>
                            <p><a href="#" class="btn btn-primary btn-sm">Read my bio</a></p>
                            <p class="social">
                                <a href="#" class="p-2"><span class="fa fa-facebook"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-twitter"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-instagram"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-youtube-play"></span></a>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <h3 class="heading">Hoạt động Thiện nguyện</h3>
                    <div class="post-entry-sidebar">
                        <ul>
                            <c:forEach items="${listActivities}" var="action">
                                <li>
                                    <a href="/viewPostsDisplay?idPosts=${posts.idPosts}">
                                        <img style="width: 90%;height: 11rem;object-fit: cover;" src="${action.image}"
                                             alt="Image placeholder" class="mr-4">
                                        <div class="text">
                                            <c:set var="String1" value="${action.title}"/>
                                            <c:set var="String2" value="${fn:substring(String1, 0, 30)}"/>
                                            <h4>${String2}</h4>
                                            <div class="post-meta">
                                                <span class="mr-2">${action.date}</span> &bullet;
                                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Categories</h3>
                    <ul class="categories">
                        <li><a href="#">Courses <span>(12)</span></a></li>
                        <li><a href="#">News <span>(22)</span></a></li>
                        <li><a href="#">Design <span>(37)</span></a></li>
                        <li><a href="#">HTML <span>(42)</span></a></li>
                        <li><a href="#">Web Development <span>(14)</span></a></li>
                    </ul>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Tags</h3>
                    <ul class="tags">
                        <li><a href="#">Travel</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Lifestyle</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">Freelancing</a></li>
                        <li><a href="#">Travel</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Lifestyle</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">Freelancing</a></li>
                    </ul>
                </div>
            </div>
            <!-- END sidebar -->

        </div>
    </div>
</section>

<section class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2 class="mb-3 ">Tin Tức Mới</h2>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${listPostsTop3}" var="top3">
                <div class="col-md-6 col-lg-4">
                    <a href="/viewPostsDisplay?idPosts=${posts.idPosts}" class="a-block d-flex align-items-center height-md"
                       style="background-image: url('${top3.image}'); ">
                        <div class="text">
                            <div class="post-meta">
                                <span class="category">Lifestyle</span>
                                <span class="mr-2">${top3.date}</span> &bullet;
                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                            </div>
                            <c:set var="String1" value="${action.title}"/>
                            <c:set var="String2" value="${fn:substring(String1, 0, 30)}"/>
                            <h4>${String2}</h4>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>


</section>
<!-- END section -->

<footer class="site-footer">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-4">
                <h3>Paragraph</h3>
                <img src="../Blog_Miss/images/img_1.jpg" alt="Image placeholder" class="img-fluid">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi, accusantium optio unde perferendis
                    eum illum voluptatibus dolore tempora, consequatur minus asperiores temporibus reprehenderit.</p>
            </div>
            <div class="col-md-6 ml-auto">
                <div class="row">
                    <div class="col-md-7">
                        <h3>Tin Tức Mới</h3>
                        <div class="post-entry-sidebar">
                            <ul>
                                <c:forEach items="${listPostsTop3}" var="top3">
                                    <a href="/viewPostsDisplay?idPosts=${posts.idPosts}">
                                        <img style=" width: 15rem; height: 5rem; object-fit: cover;" src="${top3.image}"
                                             alt="Image placeholder" class="mr-4">
                                        <div class="text">
                                            <c:set var="String1" value="${action.title}"/>
                                            <c:set var="String2" value="${fn:substring(String1, 0, 30)}"/>
                                            <h4>${String2}</h4>
                                            <div class="post-meta">
                                                <span class="mr-2">${action.date}</span> &bullet;
                                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-1"></div>

                    <div class="col-md-4">

                        <div class="mb-5">
                            <h3>Quick Links</h3>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Travel</a></li>
                                <li><a href="#">Adventure</a></li>
                                <li><a href="#">Courses</a></li>
                                <li><a href="#">Categories</a></li>
                            </ul>
                        </div>

                        <div class="mb-5">
                            <h3>Social</h3>
                            <ul class="list-unstyled footer-social">
                                <li><a href="#"><span class="fa fa-twitter"></span> Twitter</a></li>
                                <li><a href="#"><span class="fa fa-facebook"></span> Facebook</a></li>
                                <li><a href="#"><span class="fa fa-instagram"></span> Instagram</a></li>
                                <li><a href="#"><span class="fa fa-vimeo"></span> Vimeo</a></li>
                                <li><a href="#"><span class="fa fa-youtube-play"></span> Youtube</a></li>
                                <li><a href="#"><span class="fa fa-snapchat"></span> Snapshot</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a
                    href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </div>
        </div>
    </div>
</footer>
<!-- END footer -->

<!-- loader -->
<div id="loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#f4b214"/>
    </svg>
</div>

<script src="../Blog_Miss/js/jquery-3.2.1.min.js"></script>
<script src="../Blog_Miss/js/jquery-migrate-3.0.0.js"></script>
<script src="../Blog_Miss/js/popper.min.js"></script>
<script src="../Blog_Miss/js/bootstrap.min.js"></script>
<script src="../Blog_Miss/js/owl.carousel.min.js"></script>
<script src="../Blog_Miss/js/jquery.waypoints.min.js"></script>
<script src="../Blog_Miss/js/jquery.stellar.min.js"></script>


<script src="../Blog_Miss/js/main.js"></script>
</body>
</html>