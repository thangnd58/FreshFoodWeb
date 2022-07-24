<%-- 
    Document   : home
    Created on : Mar 1, 2022, 10:39:50 AM
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
        <title>FreshMart Products</title>

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
            <jsp:include page="header.jsp"/>
            <!-- Main Content -->
            <div id="content" class="site-content">
                <div id="breadcrumb">
                    <div class="container">
                    </div>
                </div>
                <!-- Product - Our Products -->
                <div class="section products-block product-tab tab-2">
                    <div class="block-title">
                        <div class="sub-title">Thực Phẩm Sạch An Toàn Với Mọi Người</div>
                        <h2 class="title">Sản phẩm của cửa hàng</h2>
                    </div>
                    <div class="block-content">
                        <div class="container">
                            <h2>${mess}</h2>
                            <div class="tab-content">
                                <div class="row" id="product">
                                    <c:forEach items="${listProduct}" var="p">
                                        <div class="col-md-3 col-sm-3 col-xs-12">
                                            <div class="product-item" style="height: 400px">
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
                                                    <c:if test="${cid!=''}">
                                                        <button data-toggle="modal" data-target="#exampleModalCenter" class="addToCart" style="border: none; background-color: white" type="button" title="Add to cart" data-id="${p.getProductID()}" class="add-to-cart"><i class="fa fa-shopping-basket" aria-hidden="true"></i></button>
                                                        <button data-toggle="modal" data-target="#exampleModalLong" class="addToWishList" style="border: none; background-color: white" type="button" title="Add to wishlist" data-id="${p.getProductID()}" class="add-to-cart"><i class="fa fa-heart" aria-hidden="true"></i></button>
                                                        </c:if>
                                                        <c:if test="${cid==''}">
                                                        <button data-toggle="modal" data-target="#exampleModalCenter" class="addToCart" style="border: none; background-color: white" type="button" title="Add to cart" data-id="${p.getProductID()}" class="add-to-cart"><i class="fa fa-shopping-basket" aria-hidden="true"></i></button>
                                                        <button data-toggle="modal" data-target="#exampleModalLong" class="addToWishList" style="border: none; background-color: white" type="button" title="Add to wishlist" data-id="${p.getProductID()}" class="add-to-cart"><i class="fa fa-heart" aria-hidden="true"></i></button>
                                                        </c:if>
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
                    </div>
                </div>
                <c:if test="${page != null}">
                    <!-- Pagination Bar -->
                    <div class="pagination-bar">
                        <div class="pagination">
                            <c:choose>
                                <c:when test="${cid!=''}">
                                    <ul class="page-list">
                                        <li><a href="products?page=${page-1}&cid=${cid}" class="prev">Previous</a></li>
                                            <c:forEach begin="1" end="${num}" var="i">
                                            <li><a href="products?cid=${cid}&page=${i}" ${page==i?"class=\"current\"":""}>${i}</a></li>
                                            </c:forEach>
                                        <li><a href="products?page=${page+1}&cid=${cid}" class="next">Next</a></li>
                                    </ul>
                                </c:when>
                                <c:otherwise>
                                    <ul class="page-list">
                                        <li><a href="products?page=${page-1}" class="prev">Previous</a></li>
                                            <c:forEach begin="1" end="${num}" var="i">
                                            <li><a href="products?page=${i}" ${page==i?"class=\"current\"":""}>${i}</a></li>
                                            </c:forEach>
                                        <li><a href="products?page=${page+1}" class="next">Next</a></li>
                                    </ul>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:if>
                <!-- Go Up button -->
                <div class="go-up">
                    <a href="#">
                        <i class="fa fa-long-arrow-up"></i>
                    </a>
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
            <div class="modal-dialog modal-dialog-centered" role="document">
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

                function searchByName(param) {
                    var txtSearch = param.value;
                    var local = "product";
                    $.ajax({
                        url: "/FreshFoodWeb/searchByAjaxProduct",
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
                        if (${cid==''}) {
                            window.location.href = 'addcart?pid=' + id +'&page=${page}&local=products';
                        } else {
                            window.location.href = 'addcart?cid=${cid}&pid=' + id + '&page=${page}&local=products';
                        }
                    });
                });

                $('.addToWishList').click(function () {
                    var id = $(this).attr('data-id');
                    $('#addwishlist').on('click', function () {
                        if (${cid==''}) {
                            window.location.href = 'addwishlist?pid=' + id + '&page=${page}&local=products';
                        } else {
                            window.location.href = 'addwishlist?cid=${cid}&pid=' + id + '&page=${page}&local=products';
                        }
                    });
                });
        </script>
    </body>
</html>					