<%-- 
    Document   : header.jsp
    Created on : Mar 3, 2022, 5:09:50 PM
    Author     : thang05082001
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <a href="products" title="Product">Sản Phẩm</a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <c:forEach items="${listCategory}" var="cats">
                                            <li>
                                                <a href="products?cid=${cats.getCategoryID()}">${cats.getCategoryName()}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </li>
                            <li>
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
                            <input oninput="searchByName(this)" type="text" class="form-input" name="txt" value="${txt}" placeholder="Search">
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
                                        <a href="changeinfo" title="User info"><i class="fa fa-user"></i>${sessionScope.user.getContact().getCustomerName()}</a>
                                    </div>
                                </c:if>
                                <c:if test="${sessionScope.user.isRole() == false}">
                                    <div class="item">
                                        <a href="changeinfo" title="User info"><i class="fa fa-user"></i>${sessionScope.user.getContact().getCustomerName()}</a>
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
                                    <a href="login" title="Login"><i class="fa fa-sign-in"></i>Đăng nhập</a>
                                </div>
                                <div class="item">
                                    <a href="register" title="Register"><i class="fa fa-user"></i>Đăng ký</a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
</header>
