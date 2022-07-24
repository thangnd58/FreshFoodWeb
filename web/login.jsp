<%-- 
    Document   : register
    Created on : Mar 3, 2022, 5:17:03 PM
    Author     : thang05082001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">


    <head>
        <!-- Basic Page Needs -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FreshMart Login</title>

        <meta name="keywords" content="Organic, Fresh Food, Farm Store">
        <meta name="description" content="FreshMart - Organic, Fresh Food, Farm Store HTML Template">
        <meta name="author" content="tivatheme">

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.png" type="image/png">

        <!-- Mobile Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:300,400,700" rel="stylesheet">

        <!-- Vendor CSS -->
        <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="libs/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="libs/font-material/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="libs/nivo-slider/css/nivo-slider.css">
        <link rel="stylesheet" href="libs/nivo-slider/css/animate.css">
        <link rel="stylesheet" href="libs/nivo-slider/css/style.css">
        <link rel="stylesheet" href="libs/owl.carousel/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="libs/slider-range/css/jslider.css">

        <!-- Template CSS -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/reponsive.css">
    </head>

    <header id="header">
        <div class="container">
            <div class="header-top">
                <div class="row align-items-center">
                    <!-- Header Center -->
                    <div class="col-lg-12 col-md-12 col-sm-12 header-center justify-content-center">
                        <!-- Logo -->		
                        <div class="logo">
                            <a href="home">
                                <img class="img-responsive" src="img/logo.png" alt="Logo">
                            </a>
                        </div>

                        <span id="toggle-mobile-menu"><i class="zmdi zmdi-menu"></i></span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <body class="home home-1">
        <div id="all">
            <!-- Main Content -->
            <div id="content" class="site-content">
                <!-- Breadcrumb -->
                <div class="container" style="padding-top: 50px">
                    <ul class="breadcrumb">
                        <li><a href="home" title="Home">Trang chủ</a></li>
                        <li><span>Đăng nhập</span></li>
                    </ul>
                </div>

                <div class="container">
                    <div class="login-page">
                        <div class="login-form form">
                            <div class="block-title">
                                <h2 class="title"><span>Đăng nhập</span></h2>
                                <h2 class="text-danger"><span>${mess}</span>
                            </div>

                            <form action="login" method="post">
                                <div class="form-group">
                                    <label>Tên tài khoản</label>
                                    <input type="text" value="" name="userName">
                                </div>

                                <div class="form-group">
                                    <label>Mật khẩu</label>
                                    <input type="password" value="" name="password">
                                </div>

                                <div class="form-group text-center">
                                    <div class="link">
                                        <a href="register">Bạn chưa có tài khoản? Đăng ký ngay!</a>
                                    </div>
                                </div>

                                <div class="form-group text-center">
                                    <input type="submit" class="btn btn-primary" value="Đăng nhập">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Go Up button -->
            <div class="go-up">
                <a href="#">
                    <i class="fa fa-long-arrow-up"></i>
                </a>
            </div>
        </div>

        <!-- Vendor JS -->
        <script src="libs/jquery/jquery.js"></script>
        <script src="libs/bootstrap/js/bootstrap.js"></script>
        <script src="libs/jquery.countdown/jquery.countdown.js"></script>
        <script src="libs/nivo-slider/js/jquery.nivo.slider.js"></script>
        <script src="libs/owl.carousel/owl.carousel.min.js"></script>
        <script src="libs/slider-range/js/tmpl.js"></script>
        <script src="libs/slider-range/js/jquery.dependClass-0.1.js"></script>
        <script src="libs/slider-range/js/draggable-0.1.js"></script>
        <script src="libs/slider-range/js/jquery.slider.js"></script>
        <script src="libs/elevatezoom/jquery.elevatezoom.js"></script>

        <!-- Template CSS -->
        <script src="js/main.js"></script>
    </body>


</html>
