<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 02/01/2021
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>VEX Shop </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

    <!-- Fonts -->
    <!-- Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400i|Source+Sans+Pro:300,400,600,700"
          rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,400,600,700" rel="stylesheet">

    <!-- CSS -->
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="../Vex_Shop/plugins/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../Vex_Shop/plugins/themefisher-fonts/themefisher-fonts.css">
    <link rel="stylesheet" href="../Vex_Shop/plugins/owl-carousel/owl.carousel.css">
    <link rel="stylesheet" href="../Vex_Shop/plugins/magnific-popup/magnific-popup.css">
    <link rel="stylesheet" href="../Vex_Shop/css/style.css">
    <!-- Responsive Stylesheet -->
</head>

<body id="body">

<div id="preloader-wrapper">
    <div class="pre-loader"></div>
</div>

<!-- navigation -->
<header>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-white">
            <a class="navbar-brand" href="#">Hoa Hậu Việt Nam 2020</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto text-center text-lg-left">
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/registration">Registration</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div>
        <c:forEach items="${message}" var="message">
            <c:if test='${message != null}'>
                <c:choose>
                    <c:when test='${message!="Thành công"}'>
                        <div class="alert alert-danger" role="alert" style="height: 40px; margin-top: 38px">${message}</div>
                    </c:when>
                    <c:when test="${message == 'Thành công'}">
                        <div class="alert alert-success" role="alert" style="height: 40px; margin-top: 38px">Thực hiện thành công</div>
                    </c:when>
                </c:choose>
            </c:if>
        </c:forEach>
    </div>
</header>
<!-- /navigation -->

<!-- hero area -->
<section class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 text-center mb-5 mb-md-0">
                <img style="width: 30rem;height: 28rem;
    border-radius: 20px;" src="../Vex_Shop/anh/namem.jpg" alt="">
            </div>
            <div class="col-md-6 align-self-center text-center text-md-left">
                <div class="block">
                    <h1 class="font-weight-bold mb-4 font-size-60">Hoa khôi Nam Em muốn dự thi Hoa hậu Việt Nam
                        2021</h1>
                    <p class="mb-4">Người đẹp bày tỏ mong muốn tiếp tục thử sức tại cuộc thi Hoa hậu Việt Nam 2021 sau
                        khi lọt vào top 38 Hoa hậu Việt Nam 2014.
                    </p>
                    <a class="btn btn-main" href="/viewPosts?idPosts=${posts.idPosts}" role="button">Xem chi tiết</a>
                </div>
            </div>
        </div><!-- .row close -->
    </div><!-- .container close -->
</section><!-- header close -->


<!--
    Feature start
    ==================== -->
<section class="section">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="heading">
                    <h2>Trang sức đá quá IJC</h2>
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-40 text-center text-md-left">
                    <i class="d-inlin-block h2 mb-10 tf-ion-ios-alarm-outline"></i>
                    <h4 class="font-weight-bold mb-2">Smooth Touch</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, inventore?</p>
                </div>
                <div class="mb-40 text-center text-md-left">
                    <i class="d-inlin-block h2 mb-10 tf-ion-ios-bell-outline"></i>
                    <h4 class="font-weight-bold mb-2">Elegant Design</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, inventore?</p>
                </div>
                <div class="mb-40 text-center text-md-left">
                    <i class="d-inlin-block h2 mb-10 tf-ion-ios-cart-outline"></i>
                    <h4 class="font-weight-bold mb-2">Easy Pricing</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, inventore?</p>
                </div>
            </div>
            <div class="col-md-4 text-center align-self-center mb-4 mb-md-0">
                <img style="    width: 20rem;
    height: 23rem;
    border-radius: 20px;" src="../Vex_Shop/anh/a.jpg" alt="">
            </div>
            <div class="col-md-4">
                <div class="mb-40 text-center text-md-left">
                    <i class="d-inlin-block h2 mb-10 tf-ion-ios-alarm-outline"></i>
                    <h4 class="font-weight-bold mb-2">Smooth Touch</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, inventore?</p>
                </div>
                <div class="mb-40 text-center text-md-left">
                    <i class="d-inlin-block h2 mb-10 tf-ion-ios-bell-outline"></i>
                    <h4 class="font-weight-bold mb-2">Elegant Design</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, inventore?</p>
                </div>
                <div class="mb-40 text-center text-md-left">
                    <i class="d-inlin-block h2 mb-10 tf-ion-ios-cart-outline"></i>
                    <h4 class="font-weight-bold mb-2">Easy Pricing</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, inventore?</p>
                </div>
            </div>
        </div>
    </div><!-- .container close -->
</section><!-- #service close -->

<section class="bg-orange section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 text-center mb-5 mb-lg-0">
                <img style="width: 33rem;
    height: 19rem;
    border-radius: 20px;" src="../Vex_Shop/anh/bs.jpg" alt="">
            </div>
            <div class="col-md-6 align-self-center text-center text-md-left">
                <div class="content">
                    <h2 class="subheading text-white font-weight-bold mb-10">5 Hoa hậu của Thập kỷ hương sắc hội tụ
                        trong phần thi áo dài của Đêm Chung kết HHVN 2020</h2>
                    <p class="text-white">Áo dài là trang phục truyền thống của dân tộc. Việc trình diễn áo dài trong
                        đêm Chung kết toàn quốc HHVN 2020 mang ý nghĩa nhân văn lan tỏa tiếng nói trái tim và lòng nhân
                        ái đáng trân quý của người phụ nữ Việt Nam..</p>

                </div>
            </div>
        </div>
    </div>
</section>


<section class="feature-list section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading">
                    <h2>Lan tỏa cùng nhan sắc Việt</h2>
                </div>
            </div>

        </div>
        <div class="row mb-40">
            <div class="col-md-6 text-center mb-5 mb-lg-0">
                <img style="    width: 300px;
    height: 20rem;
    border-radius: 20px;" src="../Vex_Shop/anh/d.jpeg" alt="">
            </div>
            <div class="col-md-6 align-self-center text-center text-md-left">
                <div class="content">
                    <h4 class="subheading">TOP 3 HOA HẬU VIỆT NAM 2020 GIAO LƯU CÙNG CHICILON MEDIA</h4>
                    <p>Ngày 25/11 vừa qua, Tân Hoa hậu Việt Nam 2020 Đỗ Thị Hà cùng Á hậu Phương Anh và Á hậu Ngọc Thảo đã đến thăm trụ sở công ty Chicilon Media Việt Nam./p>
                    <a href="" class="btn btn-main btn-main-sm">Check Features</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 order-md-1 order-2 align-self-center text-center text-md-left">
                <div class="content">
                    <h4 class="subheading">Người đẹp nhân ái: Trao đi sự nhân ái và nhận được trái tim yêu thương</h4>
                    <p>Bảy chuyến hành trình nhân ái của Top 35 thí sinh xuất sắc nhất Hoa Hậu Việt Nam 2020 vừa kết thúc cũng là lúc những cung bậc cảm xúc dạt dào đọng lại trong lòng khán giả.</p>
                    <a href="#" class="btn btn-main btn-main-sm">Check Features</a>
                </div>
            </div>
            <div class="col-md-6 order-md-2 order-1 text-center mb-5 mb-lg-0">
                <img style="    width: 300px;
    height: 20rem;
    border-radius: 20px;" src="../Vex_Shop/anh/c.jpg" alt="">
            </div>
        </div>
    </div>
</section>


<section class="gallery">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading">
                    <h2>Checkout some amazing Image</h2>
                </div>

                <div class="gallery-slider">
                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop/anh/c.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/c.jpg" alt="">
                    </div>

                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop/anh/a.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px; height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/a.jpg" alt="">
                    </div>

                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop//anh/bs.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/bs.jpg" alt="">
                    </div>

                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop//anh/a.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/a.jpg" alt="">
                    </div>

                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop//anh/namem.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/namem.jpg" alt="">
                    </div>



                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop/anh/c.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/c.jpg" alt="">
                    </div>

                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop/anh/a.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px; height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/a.jpg" alt="">
                    </div>

                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop//anh/bs.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/bs.jpg" alt="">
                    </div>

                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop//anh/a.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/a.jpg" alt="">
                    </div>

                    <div class="block">
                        <div class="gallery-overlay">
                            <a href="../Vex_Shop//anh/namem.jpg" class="image-popup gallery-popup">
                                <i class="tf-ion-ios-search"></i>
                            </a>
                        </div>

                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/namem.jpg" alt="">
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>


<section class="call-to-action section bg-opacity bg-1">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-8 text-center mx-auto">
                <h2 class="subheading text-white">Get Product Updates</h2>
                <p class="text-white">Lorem ipsum dolor amet, consectetur adipisicing elit, sed do eiusmod</p>
                <div class="input-group">
                    <form action="#" class="w-100">
                        <input type="email" id="email" class="form-control" name="email"
                               placeholder="Your Email Address Here" required>
                        <button class="btn btn-main btn-submit" type="submit">Subscribe</button>
                    </form>
                </div><!-- /input-group -->
            </div>
        </div>
    </div>
</section><!-- #call-to-action close -->


<section class="testimonials section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12">
                <div class="heading">
                    <h2>Watch Review</h2>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-5 mb-lg-0 text-center">
                <div class="testimonial-block">
                    <i class="tf-ion-quote"></i>
                    <p>
                        A wonderful serenity has taken possession of my entire soul, like these sweet mornings of
                        spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in
                        this spot, which was created for the bliss of souls like mine. I am so happy, my dear
                        friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my
                        talents.
                    </p>
                    <div class="author-details">
                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/a.jpg" alt="">
                        <h4>Jonathon Andrew</h4>
                        <span>CEO, Themefisher</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-5 mb-lg-0 text-center">
                <div class="testimonial-block">
                    <i class="tf-ion-quote"></i>
                    <p>
                        A wonderful serenity has taken possession of my entire soul, like these sweet mornings of
                        spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in
                        this spot, which was created for the bliss of souls like mine. I am so happy, my dear
                        friend. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, perferendis.
                    </p>
                    <div class="author-details">
                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/bs.jpg" alt="">
                        <h4>Jonathon Andrew</h4>
                        <span>CEO, Themefisher</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-5 mb-lg-0 text-center">
                <div class="testimonial-block">
                    <i class="tf-ion-quote"></i>
                    <p>
                        A wonderful serenity has taken possession of my entire soul, like these sweet mornings of
                        spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in
                        this spot, which was created for the bliss of souls like mine. I am so happy, my dear
                        friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my
                        talents.
                    </p>
                    <div class="author-details">
                        <img style="width: 300px;height: 150px;
    border-radius: 20px;" src="../Vex_Shop/anh/c.jpg" alt="">
                        <h4>Jonathon Andrew</h4>
                        <span>CEO, Themefisher</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-100">
            <div class="col-md-12 text-center">
                <a href="" class="btn btn-main">Grab You Product Now</a>
            </div>
        </div>
    </div>
</section>


<footer>
    <div class="container text-center">
        <div class="row">
            <div class="col-md-12">
                <div class="block">
                    <a href="#" class="footer-logo mb-4">Vex</a>
                    <ul class="list-inline footer-menu">
                        <li class="list-inline-item">
                            <a href="#">HOME</a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#about">ABOUT</a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#service">SERVICES</a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#contact">CONTACT</a>
                        </li>
                    </ul>
                    <p class="copyright-text">Copyright &copy; <a href="http://www.Themefisher.com">Themefisher</a>|
                        All right reserved.</p>
                </div>
            </div>
        </div>
    </div>
</footer>


<!-- Js -->
<script src="../Vex_Shop/plugins/jquery-2.1.1.min.js"></script>
<script src="../Vex_Shop/plugins/bootstrap/bootstrap.min.js"></script>
<script src="../Vex_Shop/plugins/owl-carousel/owl.carousel.min.js"></script>
<script src="../Vex_Shop/plugins/magnific-popup/jquery.magnific.popup.min.js"></script>
<script src="../Vex_Shop/js/main.js"></script>

</body>

</html>
