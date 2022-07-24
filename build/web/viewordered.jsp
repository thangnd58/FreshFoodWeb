<%-- 
    Document   : viewordered
    Created on : Mar 21, 2022, 12:53:40 AM
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
        <title>FreshMart View Ordered</title>

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
                        <li><span>Lịch sử mua hàng</span></li>
                    </ul>
                </div>

                <div class="container">
                    <div class="page">
                        <div class="">
                            <h2 class="title text-center">Lịch sử mua hàng</h2>
                            <form>
                                <div class="row">
                                    <div class="select col-md-2">
                                        <select class="form-control" name="filter" onchange="this.form.submit()">
                                            <option value="dateincrease" ${filter=='dateincrease'?"selected":""}>Gần đây nhất</option>
                                            <option value="datedecrease" ${filter=='datedecrease'?"selected":""}>Cũ nhất</option>
                                        </select>
                                    </div> 
                                </div>
                            </form>
                            <table class="cart-summary table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th>Ngày đặt hàng</th>
                                        <th>Địa chỉ</th>
                                        <th>Tổng</th>
                                        <th>Chi tiết</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${listOrder}" var="o">
                                        <tr>
                                            <th scope="row"> 
                                                ${o.getOrderID()}
                                            </th>
                                            <td>
                                                ${o.getOrderDate()}
                                            </td>
                                            <td>
                                                ${o.getAddress()}
                                            </td>
                                            <td>
                                                ${o.getTotal()} đ
                                            </td>
                                            <td>
                                                <c:if test="${o.getOrderdetail().size() != 0}">
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th scope="col">ID</th>
                                                                <th scope="col">Tên sản phẩm</th>
                                                                <th scope="col">Số lượng đã mua</th>
                                                                <th scope="col">Giá 1 sản phẩm</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${o.getOrderdetail()}" var="od">

                                                                <tr>
                                                                    <th scope="row">${od.getOrderDetailID()}</th>
                                                                    <td>${od.getProduct().getProductName()}</td>
                                                                    <td>${od.getQuantity()}</td>
                                                                    <td>${od.getPrice()} đ</td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <c:if test="${filter != null}">
                                <div class="clearfix">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="prev" href="${link}page=${page-1}">Sau</a></li>
                                            <c:forEach begin="1" end="${num}" var="i">
                                            <li class="page-item ${page==i?"active":""}"><a href="${link}page=${i}" class="page-link">${i}</a></li>
                                            </c:forEach>
                                        <li class="page-item"><a class="next" href="${link}page=${page+1}" class="page-link">Trước</a></li>
                                    </ul>
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
        <script>
                                            const currentPage = ${page};
                                            const maxPage = ${num};
                                            const prevBtn = document.getElementsByClassName("prev");
                                            const nextBtn = document.getElementsByClassName("next");
                                            if (currentPage === maxPage) {
                                                nextBtn[0].href = "#";
                                            }
                                            if (currentPage === 1) {
                                                prevBtn[0].href = "#";
                                            }
        </script>
    </body>
</html>