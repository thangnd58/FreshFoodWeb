<%-- 
    Document   : product-detail
    Created on : Mar 2, 2022, 10:33:10 PM
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
        <title>FreshMart Product Detail</title>

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
                        <li><a href="home">Trang chủ</a></li>
                        <li><a href="products">Sản phẩm</a></li>
                        <li><a href="products?cid=${pdetail.getCategory().getCategoryID()}">${pdetail.getCategory().getCategoryName()}</a></li>
                        <li><span>${pdetail.getProductName()}</span></li>
                    </ul>
                </div>


                <div class="container">
                    <div class="row">
                        <!-- Sidebar -->
                        <div id="left-column" class="sidebar col-lg-3 col-md-3 col-sm-3 col-xs-12">
                            <!-- Block - Product Categories -->
                            <div class="block product-categories">
                                <h3 class="block-title">Danh mục sản phẩm</h3>
                                <div class="block-content">
                                    <c:forEach items="${listCategory}" var="c">
                                        <div class="item">
                                            <a class="category-title" href="products?cid=${c.getCategoryID()}">${c.getCategoryName()}</a>
                                        </div>
                                    </c:forEach>   
                                </div>
                            </div>
                        </div>

                        <!-- Page Content -->
                        <div id="center-column" class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
                            <div class="product-detail">
                                <div class="products-block layout-5">
                                    <div class="product-item">
                                        <div class="product-title">
                                            ${pdetail.getProductName()}
                                        </div>

                                        <div class="row">
                                            <div class="product-left col-md-5 col-sm-5 col-xs-12">
                                                <div class="product-image horizontal">
                                                    <div class="main-image">
                                                        <img class="img-responsive" src="${pdetail.getImgURL1()}" alt="Product Image">
                                                    </div>
                                                    <div class="thumb-images owl-theme owl-carousel">
                                                        <img class="img-responsive" src="${pdetail.getImgURL1()}" alt="Product Image">
                                                        <img class="img-responsive" src="${pdetail.getImgURL2()}" alt="Product Image">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="product-right col-md-7 col-sm-7 col-xs-12">
                                                <div class="product-info">
                                                    <div class="product-price">
                                                        <span class="sale-price">${pdetail.getOriginal()} đ</span>
                                                    </div>

                                                    <div class="product-stock">
                                                        <span class="availability">Số lượng còn lại trong kho: ${pdetail.getQuantity()}</span>
                                                    </div>

                                                    <div class="product-short-description">
                                                        ${pdetail.getDescription()}
                                                    </div>

                                                    <div class="product-add-to-cart border-bottom">
                                                        <div class="product-buttons">
                                                            <button data-toggle="modal" data-target="#exampleModalCenter" class="addToCart" style="border: none; background-color: white" type="button" title="Add to cart" data-id="${pdetail.getProductID()}" class="add-to-cart"><i class="fa fa-shopping-basket" aria-hidden="true"></i></button>
                                                            <button data-toggle="modal" data-target="#exampleModalLong" class="addToWishList" style="border: none; background-color: white" type="button" title="Add to wishlist" data-id="${pdetail.getProductID()}" class="add-to-cart"><i class="fa fa-heart" aria-hidden="true"></i></button>

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Related Products -->
                            <div class="products-block related-products">
                                <div class="block-title">
                                    <h4 class="title">Liên quan</h4>
                                </div>
                                <div class="block-content">
                                    <div class="products owl-theme owl-carousel">
                                        <c:forEach items="${relatedList}" var="r">
                                            <div class="product-item" style="height: 400px">
                                                <div class="product-image">
                                                    <a href="detail?pid=${r.getProductID()}">
                                                        <img src="${r.getImgURL1()}" alt="Product Image">
                                                    </a>
                                                </div>

                                                <div class="product-title">
                                                    <a href="detail?pid=${r.getProductID()}">
                                                        ${r.getProductName()}
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
                                                    <span class="sale-price">${r.getOriginal()} đ</span>
                                                </div>

                                                <div class="product-buttons">
                                                    <button data-toggle="modal" data-target="#exampleModalCenter" class="addToCart" style="border: none; background-color: white" type="button" title="Add to cart" data-id="${r.getProductID()}" class="add-to-cart"><i class="fa fa-shopping-basket" aria-hidden="true"></i></button>
                                                    <button data-toggle="modal" data-target="#exampleModalLong" class="addToWishList" style="border: none; background-color: white" type="button" title="Add to wishlist" data-id="${r.getProductID()}" class="add-to-cart"><i class="fa fa-heart" aria-hidden="true"></i></button>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
                <jsp:include page="footer.jsp"/>
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
        <script>
            $('.addToCart').click(function () {
                var id = $(this).attr('data-id');
                $('#addcart').on('click', function () {
                    window.location.href = 'addcart?pid='+id+'&local=detail';
                });
            });

            $('.addToWishList').click(function () {
                var id = $(this).attr('data-id');
                $('#addwishlist').on('click', function () {
                    window.location.href = 'addwishlist?pid='+id+'&local=detail';
                });
            });
        </script>
    </body>

</html>
