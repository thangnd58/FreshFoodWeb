<%-- 
    Document   : home
    Created on : Mar 4, 2022, 8:25:55 PM
    Author     : thang05082001
--%>

<%@page import="models.Products"%>
<%@page import="models.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <!-- Basic Page Needs -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FreshMart Home</title>

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
    <body class="home home-3">
        <div id="all">
            <!-- Header -->
            <header id="header">
                <div class="container">
                    <div class="header-top">
                        <div class="row align-items-center">
                            <!-- Header Left -->
                            <div class="col-lg-5 col-md-5 col-sm-12">
                                <!-- Main Menu -->
                                <div id="main-menu">
                                    <ul class="menu">
                                        <li class="dropdown">
                                            <a href="home" title="Homepage">Trang chủ</a>
                                        </li>

                                        <li class="dropdown">
                                            <a href="products" title="Product">Sản phẩm</a>
                                            <div class="dropdown-menu">
                                                <ul>
                                                    <c:forEach items="${listCategory}" var="c">
                                                        <li>
                                                            <a href="products?cid=${c.getCategoryID()}" >${c.getCategoryName()}</a>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="dropdown">
                                            <c:if test="${sessionScope.user == null}">
                                                <a href="login">Đăng nhập ngay</a>
                                            </c:if>
                                            <c:if test="${sessionScope.user != null}">
                                                <a style="color: green" href="changeinfo">Xin chào ${user.getContact().getCustomerName()}</a>
                                            </c:if>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <!-- Header Center -->
                            <div class="col-lg-2 col-md-2 col-sm-12 header-center justify-content-center">
                                <!-- Logo -->
                                <div class="logo">
                                    <a href="home">
                                        <img class="img-responsive" src="img/logo.png" alt="Logo">
                                    </a>
                                </div>

                                <span id="toggle-mobile-menu"><i class="zmdi zmdi-menu"></i></span>
                            </div>


                            <!-- Header Right -->
                            <div class="col-lg-5 col-md-5 col-sm-12 header-right d-flex justify-content-end align-items-center">

                                <!-- Search -->							
                                <div class="form-search">
                                    <form action="search" method="get">
                                        <input oninput="searchByName(this)" type="text" class="form-input" name="txt" placeholder="Search">
                                        <button type="submit" class="fa fa-search"></button>
                                    </form>
                                </div>

                                <!-- Cart -->
                                <div class="block-cart dropdown">
                                    <a href="viewcart">
                                        <div class="cart-title">
                                            <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                                            <span class="cart-count">${numberCart}</span>
                                        </div>
                                    </a>   
                                </div>


                                <!-- My Account -->
                                <div class="my-account dropdown toggle-icon">
                                    <div class="dropdown-toggle" data-toggle="dropdown">
                                        <i class="zmdi zmdi-menu"></i>
                                    </div>
                                    <div class="dropdown-menu">										
                                        <c:if test="${sessionScope.user != null}">
                                            <c:if test="${sessionScope.user.isRole() == true}">
                                                <div class="item">
                                                    <a href="./admin/productmanegement" title="Product manager menu"><i class="fa fa-cog"></i>(Admin) Quản lý sản phẩm</a>
                                                </div>
                                                <div class="item">
                                                    <a href="./admin/usermanagement" title="User manager menu"><i class="fa fa-cog"></i>(Admin) Quản lý người dùng</a>
                                                </div>
                                                <div class="item">
                                                    <a href="changeinfo" title="Log in to your customer account"><i class="fa fa-user"></i>${sessionScope.user.getContact().getCustomerName()}</a>
                                                </div>
                                            </c:if>
                                            <c:if test="${sessionScope.user.isRole() == false}">
                                                <div class="item">
                                                    <a href="changeinfo" title="Log in to your customer account"><i class="fa fa-user"></i>${sessionScope.user.getContact().getCustomerName()}</a>
                                                </div>
                                            </c:if>
                                            <div class="item">
                                                <a href="viewwishlist" title="My Wishlists"><i class="fa fa-heart"></i>Danh sách yêu thích</a>
                                            </div>
                                            <div class="item">
                                                <a href="viewordered" title="My Ordered"><i class="fa fa-calendar"></i>Đơn hàng đã đặt</a>
                                            </div>
                                            <div class="item">
                                                <a href="viewcart" title="My Cart"><i class="fa fa-shopping-basket"></i>Giỏ hàng</a>
                                            </div>
                                            <div class="item">
                                                <a href="order"title="Order"><i class="fa fa-opencart"></i>Đặt hàng</a>
                                            </div>

                                            <div class="item">
                                                <a href="logout" title="Logout"><i class="fa fa-sign-in"></i>Đăng xuất</a>
                                            </div>
                                        </c:if>
                                        <c:if test="${sessionScope.user == null}">
                                            <div class="item">
                                                <a href="login" title="Log in to your customer account"><i class="fa fa-sign-in"></i>Đăng nhập</a>
                                            </div>
                                            <div class="item">
                                                <a href="register" title="Register Account"><i class="fa fa-user"></i>Đăng ký</a>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>	
            </header>


            <!-- Main Content -->
            <div id="content" class="site-content">				
                <!-- Slideshow -->		
                <div class="section slideshow">
                    <div class="tiva-slideshow-wrapper">
                        <div id="tiva-slideshow" class="nivoSlider">
                            <a href="#">
                                <img class="img-responsive" src="img/slideshow/home3-slideshow-1.jpg" alt="Slideshow Image">
                            </a>
                        </div>
                    </div>
                </div>


                <!-- Product - New Arrivals -->
                <div class="section products-block product-tab tab-2">
                    <div class="block-title">
                        <div class="sub-title">Thực Phẩm Sạch An Toàn Với Mọi Người</div>
                        <h2 class="title">Sản phẩm mới nhất</h2>
                    </div>
                    <!-- All Products -->
                    <!-- Product - New Arrivals -->
                    <div class="section products-block new-arrivals layout-3">
                        <div class="block-content">
                            <div class="row" id="product">
                                <c:forEach items="${listProduct}" var="p">
                                    <div  class="numberproduct col-md-3 col-sm-3 col-xs-12">
                                        <div class="product-item" style="height: 140px">
                                            <div class="product-image">
                                                <a href="detail?pid=${p.getProductID()}">
                                                    <img class="img-responsive" src="${p.getImgURL1()}" alt="Product Image">
                                                </a>
                                            </div>

                                            <div class="product-title">
                                                <a href="detail?pid=${p.getProductID()}">
                                                    ${p.getProductName()}
                                                </a>
                                            </div>

                                            <div class="product-rating">
                                                <div class="star on"></div>
                                                <div class="star on"></div>
                                                <div class="star on "></div>
                                                <div class="star on"></div>
                                                <div class="star on"></div>
                                            </div>

                                            <div class="product-price">
                                                <span class="sale-price">${p.getOriginal()} đ</span>
                                            </div>

                                            <div class="product-buttons">
                                                <button data-toggle="modal" data-target="#exampleModalCenter" class="addToCart" style="border: none; background-color: white" type="button" title="Add to cart" data-id="${p.getProductID()}" class="add-to-cart"><i class="fa fa-shopping-basket" aria-hidden="true"></i></button>
                                                <br>
                                                <button data-toggle="modal" data-target="#exampleModalLong" class="addToWishList" style="border: none; background-color: white" type="button" title="Add to wishlist" data-id="${p.getProductID()}" class="add-to-cart"><i class="fa fa-heart" aria-hidden="true"></i></button>

                                                <a class="quickview" href="detail?pid=${p.getProductID()}">
                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <button onclick="loadMore()" class="btn btn-primary">Xem thêm</button>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Bạn có muốn thêm vào giỏ hàng không?</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body text-center">
                            Xác nhận?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                            <button type="button" id="addcart" class="btn btn-primary">Đồng ý</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Bạn có muốn thêm vào danh sách yêu thích không?</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body text-center">
                            Xác nhận?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                            <button type="button" id="addwishlist" class="btn btn-primary">Đồng ý</button>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="footer.jsp"/>

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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Template CSS -->
        <script src="js/main.js"></script>

        <script>
                        function loadMore() {
                            var amount = document.getElementsByClassName('numberproduct').length;
                            $.ajax({
                                url: "/FreshFoodWeb/loadmore",
                                type: "get",
                                data: {
                                    exits: amount
                                },
                                success: function (response) {
                                    var row = document.getElementById("product");
                                    row.innerHTML += response;
                                }
                            }
                            );
                        }

                        function searchByName(param) {
                            var txtSearch = param.value;
                            var local = "home";
                            $.ajax({
                                url: "/FreshFoodWeb/searchByAjax",
                                type: "get",
                                data: {
                                    txt: txtSearch,
                                    local: local
                                },
                                success: function (response) {
                                    var row = document.getElementById("product");
                                    row.innerHTML = response;
                                }
                            }
                            );
                        }
                        $('.addToCart').click(function () {
                            var id = $(this).attr('data-id');
                            $('#addcart').on('click', function () {
                                window.location.href = 'addcart?pid=' + id + '&local=home';
                            });
                        });

                        $('.addToWishList').click(function () {
                            var id = $(this).attr('data-id');
                            $('#addwishlist').on('click', function () {
                                window.location.href = 'addwishlist?pid=' + id + '&local=home';
                            });
                        });
        </script>
    </body>


</html>
