<%-- 
    Document   : cart
    Created on : Mar 3, 2022, 5:27:49 PM
    Author     : thang05082001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">


    <head>
        <!-- Basic Page Needs -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FreshMart - Organic, Fresh Food, Farm Store HTML Template</title>

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
                <!-- Breadcrumb -->
                <div class="container">
                    <ul class="breadcrumb">
                        <li><a href="home" title="Home">Trang chủ</a></li>
                        <li><span>Giỏ hàng</span></li>
                    </ul>
                </div>

                <div class="container">
                    <div class="page-cart">
                        <div class="table-responsive">
                            <h2 class="title text-center">Giỏ hàng</h2>
                            <h2 class="title">${mess}</h2>
                            <c:if test="${numberCart != 0}">
                                <table class="cart-summary table table-bordered">
                                    <thead>
                                        <tr>
                                            <th class="width-20">&nbsp;</th>
                                            <th class="width-80 text-center">Ảnh</th>
                                            <th class="width-120">Tên sản phẩm</th>
                                            <th class="width-100 text-center">Giá</th>
                                            <th class="width-100 text-center">Số lượng mua</th>
                                            <th class="width-100 text-center">Số lượng sản phẩm còn lại</th>
                                            <th class="width-100 text-center">Tổng tiền</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach items="${cart.getItems()}" var="i">
                                            <tr>
                                                <td class="product-remove">
                                                    <form action="process" method="post">
                                                        <input type="hidden" name="pid" value="${i.getProduct().getProductID()}">
                                                        <button title="Delete" class="remove" style="border: none; background-color: white" type="submit">
                                                            <i class="fa fa-times"></i>
                                                        </button>
                                                    </form>
                                                </td>
                                                <td>
                                                    <a href="detail?pid=${i.getProduct().getProductID()}">
                                                        <img width="80" alt="Product Image" class="img-responsive" src="${i.getProduct().getImgURL1()}">
                                                    </a>
                                                </td>
                                                <td>
                                                    <a href="detail?pid=${i.getProduct().getProductID()}" class="product-name">${i.getProduct().getProductName()}</a>
                                                </td>
                                                <td class="text-center">
                                                    <span>${i.getProduct().getOriginal()} đ</span>
                                                </td>
                                                <td>
                                                    <div class="product-quantity">
                                                        <div class="qty">
                                                            <div class="input-group">
                                                                <input type="text" readonly name="qty" value="${i.getQuantity()}" min="1" max="${i.getProduct().getQuantity()}">
                                                                <span class="adjust-qty">
                                                                    <span class="adjust-btn plus"><a href="process?num=1&pid=${i.getProduct().getProductID()}">+</a></span>
                                                                    <span class="adjust-btn minus"><a href="process?num=-1&pid=${i.getProduct().getProductID()}">-</a></span>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-center">
                                                    ${i.getProduct().getQuantity()}
                                                </td>
                                                <td>
                                                    <div class="product-quantity">
                                                        <div class="qty">
                                                            <div class="input-group">
                                                                ${cart.getSubMoney(i.getProduct().getProductID())} đ
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="checkout-btn">
                                    <div>
                                        <h4>Tổng tiền phải thanh toán: </h4>
                                        <h4>${cart.getTotalMoney()} đ</h4>
                                    </div>
                                    <a href="order" class="btn btn-primary pull-right">
                                        <span>Đặt hàng</span>
                                        <i class="fa fa-angle-right ml-xs"></i>
                                    </a>
                                </div>
                            </c:if>
                        </div>
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
