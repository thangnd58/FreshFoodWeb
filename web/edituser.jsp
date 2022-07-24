<%-- 
    Document   : user
    Created on : Mar 9, 2022, 4:23:17 PM
    Author     : thang05082001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>User manager</title>
        <!-- Favicon -->
        <link rel="shortcut icon" href="../img/favicon.png" type="../image/png">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #404E67;
                background: #F5F7FA;
                font-family: 'Open Sans', sans-serif;
            }
            .table-wrapper {
                width: 1250px;
                margin: 30px auto;
                background: #fff;
                padding: 20px;	
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 10px;
                margin: 0 0 10px;
            }
            .table-title h2 {
                margin: 6px 0 0;
                font-size: 22px;
            }
            .table-title .add-new {
                float: right;
                height: 30px;
                font-weight: bold;
                font-size: 12px;
                text-shadow: none;
                min-width: 100px;
                border-radius: 50px;
                line-height: 13px;
            }
            .table-title .add-new i {
                margin-right: 4px;
            }
            table.table {
                table-layout: fixed;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table th:last-child {
                width: 100px;
            }
            table.table td a {
                cursor: pointer;
                display: inline-block;
                margin: 0 5px;
                min-width: 24px;
            }    
            table.table td a.add {
                color: #27C46B;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #E34724;
            }
            table.table td i {
                font-size: 19px;
            }
            table.table td a.add i {
                font-size: 24px;
                margin-right: -1px;
                position: relative;
                top: 3px;
            }    
            table.table .form-control {
                height: 32px;
                line-height: 32px;
                box-shadow: none;
                border-radius: 2px;
            }
            table.table .form-control.error {
                border-color: #f50000;
            }
            table.table td .add {
                display: none;
            }
            body{
                background-color: white;
            }
        </style>
    </head>
    <header id="header">
        <div class="container">
            <div class="header-top">
                <div class="row align-items-center">
                    <!-- Header Center -->
                    <div class="col-lg-12 col-md-12 col-sm-12 header-center justify-content-center">
                        <!-- Logo -->		
                        <div class="logo">
                            <a href="home">
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
                    <li><a href="./usermanagement" title="Admin">Quản lý người dùng</a></li>
                </ul>
            </div>
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-md-2">
                            <a href="#addUserModal"  class="btn btn-success" data-toggle="modal">Thêm</span></a>
                        </div>
                        <div class="col-md-10">
                            <div class="input-group">
                                <form action="searchuser" method="post">
                                    <input type="searchuser" name="txt" placeholder="Search"/>
                                    <button style="border: none" type="submit" class="btn btn-default">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Tên đăng nhập</th>
                            <th>Họ và tên</th>
                            <th>Vai trò</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listUsers}" var="u">
                        <form action="edituser" method="post">
                            <tr>
                                <td><input type="text" value="${u.getUserName()}" class="form-control" name="username" id="username" readonly></td>
                                <td><input type="text" value="${u.getContact().getCustomerName()}" class="form-control" name="fullname" id="fullname"></td>
                                    <c:if test="${u.isRole() == true}">
                                    <td>Admin</td>
                                </c:if>
                                <c:if test="${u.isRole() == false}">
                                    <td>User</td>
                                </c:if>
                                <td><input type="text" value="${u.getContact().getPhone()}" class="form-control" name="phone" id="phone"></td>
                                <td><input type="text" value="${u.getEmail()}" class="form-control" name="email" id="email"></td>
                                <td>
                                    <button style="border: none; background-color: white" class="btn" title="Save edit"><i class="material-icons">&#xE254;</i></button>
                                    <a href="edituser?uname=${u.getUserName()}" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="addUserModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="usermanagement" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Thêm người dùng</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Họ và tên</label>
                                <input name="fullname" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Tên đăng nhập</label>
                                <input name="username" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu</label>
                                <input name="password" type="password" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input name="email" type="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input name="phone" type="text" pattern="[0-9]{10}" class="form-control" required>
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
    </body>
</html>