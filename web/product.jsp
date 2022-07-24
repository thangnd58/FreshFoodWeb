<%-- 
    Document   : product.jsp
    Created on : Mar 17, 2022, 10:21:13 PM
    Author     : thang05082001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">


    <head>
        <!-- Basic Page Needs -->
        <meta charset="UTF-8">
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
            <jsp:include page="header.jsp"/>
            <!-- Main Content -->
            <div id="content" class="site-content">
                <!-- Breadcrumb -->
                <div id="breadcrumb">
                    <div class="container">
                    </div>
                </div>

                <div class="container">
                    <div class="">
                        <h4 class="title ">Lọc sản phẩm</h4>
                    </div>
                    <div class="row">
                        <form action="products" method="get">

                            <div class="col-md-3">
                                <h5>Danh mục</h5>
                                <div class="select">
                                    <select class="form-control" name="cid" onchange="this.form.submit()">
                                        <option value="0">Tất cả (${totalProduct})</option>
                                        <c:forEach items="${listCNum}" var="c">
                                            <option value="${c.key.getCategoryID()}" ${cid==c.key.getCategoryID()?"selected":""}>${c.key.getCategoryName()} (${c.value})</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <h5>Sắp xếp</h5>
                                <div class="select">
                                    <select class="form-control" name="filter" onchange="this.form.submit()">
                                        <option value="default" ${filter eq 'default'?"selected":""}>Mới nhất</option>
                                        <option value="priceincrease" ${filter eq 'priceincrease'?"selected":""}>Theo giá: Tăng dần</option>
                                        <option value="pricedecrease" ${filter eq 'pricedecrease'?"selected":""}>Theo giá: Giảm dần</option>
                                        <option value="nameincrease" ${filter eq 'nameincrease'?"selected":""}>Theo tên: Bảng chữ cái A - Z</option>
                                        <option value="namedecrease" ${filter eq 'namedecrease'?"selected":""}>Theo tên: Bảng chữ cái Z - A</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <h5>Giá (VNĐ)</h5>
                                <div class="row">
                                    <div class="col-md-5">
                                        <input class="form-control" placeholder="Từ" type="number" min="0" value="${pricefrom}" name="pricefrom">
                                    </div>
                                    <div class="col-md-5">
                                        <input class="form-control" placeholder="Đến" type="number" min="0" value="${priceto}" value="" name="priceto">
                                    </div>
                                    <div class="col-md-2">
                                        <input class="btn btn-default" type="submit" value="Tìm">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <hr>
                    <div class="row">
                        <!-- Page Content -->
                        <div id="center-column" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="product-category-page">
                                <!-- Nav Bar -->
                                <div class="">
                                    <div class="row">
                                        <div class="col-md-4 col-xs-4">
                                            <div class="total-products"><h4>${mess}</h4></div>
                                        </div>

                                    </div>
                                </div>
                                <div class="tab-content">
                                    <!-- Products Grid -->
                                    <div class="tab-pane active" id="products-grid">
                                        <div class="products-block">
                                            <div class="row" id="product">
                                                <c:forEach items="${listProduct}" var="p">
                                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                                        <div class="product-item" style="height: 380px">
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

                                        <!-- Pagination Bar -->
                                        <div class="pagination-bar">
                                            <div class="pagination">
                                                <c:if test="${txt != null}">
                                                    <ul class="page-list">
                                                        <li><a href="search?txt=${txt}&page=${page-1}" class="prev">Trước</a></li>
                                                            <c:forEach begin="1" end="${num}" var="i">
                                                            <li><a href="search?txt=${txt}&page=${i}" ${page==i?"class=\"current\"":""}>${i}</a></li>
                                                            </c:forEach>
                                                        <li><a href="search?txt=${txt}&page=${page+1}" class="next">Sau</a></li>
                                                    </ul>
                                                </c:if>
                                                <c:if test="${filter != null}">
                                                    <ul class="page-list">
                                                        <li><a href="${link}page=${page-1}" class="prev">Trước</a></li>
                                                            <c:forEach begin="1" end="${num}" var="i">
                                                            <li><a href="${link}page=${i}" ${page==i?"class=\"current\"":""}>${i}</a></li>
                                                            </c:forEach>
                                                        <li><a href="${link}page=${page+1}" class="next">Sau</a></li>
                                                    </ul>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
<script type="text/javascript" charset="UTF-8">
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

                                        var local = "products";
                                        if (${txt!=null}) {
                                            local = "search&txt=${txt}";
                                        }
                                        $('.addToCart').click(function () {
                                            var id = $(this).attr('data-id');
                                            $('#addcart').on('click', function () {
                                                if (${cid==0}) {
                                                    window.location.href = 'addcart?pid=' + id + '&page=${page}&filter=${filter}&pricefrom=${pricefrom}&priceto=${priceto}&local=' + local;
                                                } else {
                                                    window.location.href = 'addcart?cid=${cid}&pid=' + id + '&page=${page}&filter=${filter}&pricefrom=${pricefrom}&priceto=${priceto}&local=' + local;
                                                }
                                            });
                                        });

                                        $('.addToWishList').click(function () {
                                            var id = $(this).attr('data-id');
                                            $('#addwishlist').on('click', function () {
                                                if (${cid==0}) {
                                                    window.location.href = 'addwishlist?pid=' + id + '&page=${page}&filter=${filter}&pricefrom=${pricefrom}&priceto=${priceto}&local=' + local;
                                                } else {
                                                    window.location.href = 'addwishlist?cid=${cid}&pid=' + id + '&page=${page}&filter=${filter}&pricefrom=${pricefrom}&priceto=${priceto}&local=' + local;
                                                }
                                            });
                                        });

</script>

</html>
