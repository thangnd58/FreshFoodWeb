<%-- 
    Document   : editproduct
    Created on : Mar 14, 2022, 11:45:24 PM
    Author     : thang05082001
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Product manager</title>
        <!-- Favicon -->
        <!-- Mobile Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:300,400,700" rel="stylesheet">
        <link rel="shortcut icon" href="../img/favicon.png" type="../image/png">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            input{
                border: none;
            }
            textarea{
                border: none;
            }
        </style>
    <header id="header">
        <div class="container">
            <div class="header-top">
                <div class="row align-items-center">
                    <!-- Header Center -->
                    <div class="col-lg-12 col-md-12 col-sm-12 header-center justify-content-center">
                        <!-- Logo -->		
                        <div class="logo">
                            <a href="../home">
                                <img class="img-responsive" src="../img/logo.png" alt="Logo">
                            </a>
                        </div>

                        <span id="toggle-mobile-menu"><i class="zmdi zmdi-menu"></i></span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <body>
        <div class="container">
            <div class="container" style="padding-top: 50px">
                <ul class="breadcrumb">
                    <li><a href="../home" title="Home">Trang chủ</a></li>
                    <li><a href="./productmanegement">Quản lý sản phẩm</a></li>
                </ul>
            </div>
            <div class="table-wrapper" style="margin-left: 14px">
                <div class="table-title">
                    <div class="row">
                        <div class="col-md-2">
                            <a href="#addProductModal"  class="btn btn-success" data-toggle="modal">Thêm</span></a>
                        </div>
                        <form action="productmanegement" method="get">
                            <div class="col-md-2">
                                <select class="form-control" name="cid" onchange="this.form.submit()">
                                    <option value="0">Tất cả sản phẩm</option>
                                    <c:forEach items="${listCategory}" var="c">
                                        <option value="${c.getCategoryID()}" ${cid==c.getCategoryID()?"selected":""}>${c.getCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2 select">
                                <select class="form-control" name="filter" onchange="this.form.submit()">
                                    <option value="default" ${filter=='default'?"selected":""}>Mới nhất</option>
                                    <option value="priceincrease" ${filter=='priceincrease'?"selected":""}>Giá: Tăng</option>
                                    <option value="pricedecrease" ${filter=='pricedecrease'?"selected":""}>Giá: Giảm</option>
                                    <option value="nameincrease" ${filter=='nameincrease'?"selected":""}>Tên: A - Z</option>
                                    <option value="namedecrease" ${filter=='namedecrease'?"selected":""}>Tên: Z - A</option>
                                </select>
                            </div>
                                <div class="col-md-2 select">
                                ${mess}
                            </div>
                        </form>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Danh mục</th>
                            <th>Tên</th>
                            <th>Ảnh 1</th>
                            <th>Ảnh 2</th>
                            <th>Giá</th>
                            <th>Mô tả</th>
                            <th>Số lượng</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listProduct}" var="p">
                        <form action="editproduct" method="post">
                            <input type="hidden" name="filter" value="${filter}">
                            <input type="hidden" name="cid" value="${cid}">
                            <input name="page" value="${page}" type="hidden">
                            <tr style="background-color: white">
                                <td><input  class="form-control" type="text" name="pid" style="width: 50px" value="${p.getProductID()}" readonly></td>
                                <td><input  class="form-control" type="text" name="cid" style="width: 130px" value="${p.getCategory().getCategoryName()}" readonly></td>
                                <td><textarea class="form-control" style="height: 100px; width: 150px" name="name">${p.getProductName()}</textarea></td>
                                <td>
                                    <img width="100px" height="100px" id="img1"  src="${p.getImgURL1()}">
                                    <input type="text" id="i1" onchange="changeImage(this)" class="form-control"  name="image1" style="width: 100px" value="${p.getImgURL1()}">
                                </td>
                                <td>
                                    <img width="100px" height="100px" id="img2" onchange="changeImage()" src="${p.getImgURL2()}">
                                    <input class="form-control" id="i1" type="text" name="image2" style="width: 100px" value="${p.getImgURL2()}">
                                </td>
                                <td>
                                    <span>${p.getOriginal()} đ</span>
                                    <input  class="form-control" type="text" name="price" style="width: 100px" value="${p.getOriginalD()}">
                                </td>
                                <td><textarea class="form-control" name="description" style="height: 150px; width: 320px">${p.getDescription()}</textarea></td>
                                <td><input class="form-control" name="quantity" style="width: 60px" type="number" min="0" value="${p.getQuantity()}"></td>
                                <td>
                                    <button class="btn btn-default" id="toggle" style="border: none; background-color: white" type="submit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></button>
                                    <a style="padding-left: 12px" id="toggle" href="editproduct?pid=${p.getProductID()}&page=${page}&cid=${cid}&filter=${filter}" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
                <c:if test="${filter != null}">
                    <div class="clearfix">
                        <ul class="pagination">
                            <li class="page-item"><a class="prev" href="${link}page=${page-1}">Trước</a></li>
                                <c:forEach begin="1" end="${num}" var="i">
                                <li class="page-item ${page==i?"active":""}"><a href="${link}page=${i}" class="page-link">${i}</a></li>
                                </c:forEach>
                            <li class="page-item"><a class="next" href="${link}page=${page+1}" class="page-link">Sau</a></li>
                        </ul>
                    </div>
                </c:if>
            </div>

        </div>
        <!-- Edit Modal HTML -->
        <div id="addProductModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="productmanegement" method="post">
                        <input type="hidden" name="filter" value="${filter}">
                            <input type="hidden" name="cid" value="${cid}">
                            <input type="hidden" name="page" value="${page}">
                        <div class="modal-header">						
                            <h4 class="modal-title">Thêm sản phẩm</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Danh mục sản phẩm</label>
                                <select name="category" class="form-select">
                                    <c:forEach items="${listCategory}" var="c">
                                        <option value="${c.getCategoryID()}">${c.getCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Tên</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Giá</label>
                                <input name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Số lượng</label>
                                <input name="quantity" type="number" min="1" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Ảnh 1</label>
                                <input name="image1" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Ảnh 2</label>
                                <input name="image2" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Mô tả</label>
                                <textarea name="description" class="form-control" required></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-danger" data-dismiss="modal" value="Hủy">
                            <input type="submit" class="btn btn-success" value="Thêm">
                        </div>
                    </form>
                </div>
            </div>
        </div>
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

            function changeImage() {
                var i1 = document.getElementById('i1').value;
                document.getElementById('img1').src = i1;
            }
        </script>
    </body>
</html>
