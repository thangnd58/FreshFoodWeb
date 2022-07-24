<%-- 
    Document   : checkout
    Created on : Mar 3, 2022, 5:31:12 PM
    Author     : thang05082001
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <!-- Basic Page Needs -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FreshMart Order</title>

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
                        <li><span>Đặt hàng</span></li>
                    </ul>
                    <h2 class="title text-center">Đặt hàng</h2>
                    <c:if test="${numberCart == 0}">
                        <h2 class="title">${mess}</h2>
                    </c:if>
                </div>
                <c:if test="${numberCart != 0}">
                    <div class="container">
                        <form action="order" method="post">
                            <div class="page-checkout">
                                <div class="row">
                                    <div class="checkout-left col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div>
                                            <div class="panel-body">
                                                <table class="cart-summary table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th class="width-80 text-center">Ảnh sản phẩm</th>
                                                            <th>Tên sản phẩm</th>
                                                            <th class="width-100 text-center">Giá</th>
                                                            <th class="width-100 text-center">Số lượng</th>
                                                            <th class="width-100 text-center">Tổng</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${cart.getItems()}" var="i">
                                                            <tr>
                                                                <td>
                                                                    <a href="detail?pid=${i.getProduct().getProductID()}">
                                                                        <img width="80" alt="Product Image" class="img-responsive" src="${i.getProduct().getImgURL1()}">
                                                                    </a>
                                                                </td>
                                                                <td>
                                                                    <a href="detail?pid=${i.getProduct().getProductID()}" class="product-name">${i.getProduct().getProductName()}</a>
                                                                </td>
                                                                <td class="text-center">
                                                                    ${i.getProduct().getOriginal()} đ
                                                                </td>
                                                                <td class="text-center">
                                                                    ${i.getQuantity()}
                                                                </td>
                                                                <td class="text-center">
                                                                    ${cart.getSubMoney(i.getProduct().getProductID())} đ
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>

                                                <h4 class="heading-primary">Cart Total</h4>
                                                <table class="table cart-total">
                                                    <tbody>
                                                        <tr>
                                                            <th>
                                                                <strong>Order Total</strong>
                                                            </th>
                                                            <td class="total">
                                                                ${cart.getTotalMoney()} đ
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="checkout-right col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="col-md-6">
                                            <label>Họ và tên</label>
                                            <input type="text" value="${user.getContact().getCustomerName()}" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Số điện thoại</label>
                                            <input type="text" value="${user.getContact().getPhone()}" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Email</label>
                                            <input type="text" value="${user.getContact().getEmail()}" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Địa chỉ</label>
                                            <input type="text" name="address" value="" class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="pull-right">
                                    <input type="submit" value="Đồng ý đặt hàng" name="proceed" class="btn btn-primary">
                                </div>
                            </div>
                        </form>
                    </div>
                </c:if>
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
