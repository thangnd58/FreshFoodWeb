<%-- 
    Document   : checkout
    Created on : Mar 3, 2022, 5:31:12 PM
    Author     : thang05082001
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <!-- Basic Page Needs -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FreshMart User</title>

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

    <jsp:include page="header.jsp"/>

    <body class="home home-3" style="margin-top: 220px">
        <div id="all">
            <!-- Main Content -->
            <div id="content" class="site-content">
                <div class="container"> 
                    <ul class="breadcrumb">
                        <li><a href="home" title="Home">Trang chủ</a></li>
                        <li><span>Thông tin người dùng</span></li>
                    </ul>
                    <h2 class="title text-center">Thông tin và chỉnh sửa thông tin người dùng</h2>
                </div>
                <div class="container">
                    <div class="page-checkout">
                        <div class="row">
                            <form action="changeinfo" method="post">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div>
                                        <h2 class="title" style="margin-left: 13px">${mess}</h2>
                                    </div>
                                    <div class="col-md-4">
                                        <label>Họ và tên</label>
                                        <input type="text" name="fullname" value="${user.getContact().getCustomerName()}" class="form-control">
                                    </div>
                                    <div class="col-md-4">
                                        <label>Số điện thoại</label>
                                        <input type="text" name="phone" pattern="[0-9]{10}" value="${user.getContact().getPhone()}" class="form-control">
                                    </div>
                                    <div class="col-md-4">
                                        <label>Email</label>
                                        <input type="text"  name="email" value="${user.getContact().getEmail()}" class="form-control">
                                    </div>
                                    <div style="margin-top: 130px; margin-left: 13px">
                                        <input type="submit" value="Lưu thay đổi" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                            <form action="changepassword" method="post">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div>
                                        <h2 class="title" style="margin-left: 13px">${mess1}</h2>
                                    </div>
                                    <div class="col-md-4">
                                        <label>Mật khẩu cũ</label>
                                        <input type="password" name="oldpassword" value="" class="form-control" required>
                                    </div>
                                    <div class="col-md-4">
                                        <label>Mật khẩu mới</label>
                                        <input type="password" name="newpassword" value="" class="form-control" required>
                                    </div>
                                    <div class="col-md-4">
                                        <label>Nhập lại mật khẩu mới</label>
                                        <input type="password" name="newrepassword" value="" class="form-control" required>
                                    </div>
                                    <div style="margin-top: 130px; margin-left: 13px">
                                        <input type="submit" value="Lưu thay đổi" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
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

