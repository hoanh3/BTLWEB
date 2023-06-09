<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/admin/assets" var="url" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <title>Admin</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="${url}/css/style.css">
    <link rel="stylesheet" href="${url}/css/table.css">
    <link rel="stylesheet" href="${url}/css/modal.css">
    <link rel="stylesheet" href="${url}/css/feedback.css">
</head>
<body>
    <%
        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma" , "no-cache");
        response.setHeader("Expires" , "0");
        
        
        if (session.getAttribute("admin") == null){
            response.sendRedirect(request.getContextPath() + "/admin/login"); 
        }
    %>
    <div class="all">
        <div class="header">
            <div class="logo">
                <a href="${pageContext.request.contextPath}/admin/home">
                    <img src="${url}/images/bg-shop.jpg" alt="">
                </a>
            </div>
            <div class="navbar">
                <div class="icon">
                    <i class="fa-solid fa-bell"></i>
                </div>
                <div class="login">
                    <c:choose>
                        <c:when test="${sessionScope.admin == null}">
                            <a href="${pageContext.request.contextPath}/admin/login">Đăng nhập</a>
                        </c:when>
                        <c:otherwise>
                            <p>${sessionScope.admin.lastName} ${sessionScope.admin.firstName}</p>
                            <a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <div class="slidebar">
            <div class="nav">
                <ul id="items">
                    <li id ="admin"><a href="${pageContext.request.contextPath}/admin/admin">Quản lý admin</a></li>
                    <li id ="user"><a href="${pageContext.request.contextPath}/admin/user">Quản lý người dùng</a></li>
                    <li id ="product"><a href="${pageContext.request.contextPath}/admin/product">Quản lý sản phẩm</a></li>
                    <li id ="category"><a href="${pageContext.request.contextPath}/admin/category">Quản lý danh mục</a></li>
                    <li id ="order"><a href="${pageContext.request.contextPath}/admin/order">Đơn hàng</a></li>
                    <li id ="feedback"><a href="${pageContext.request.contextPath}/admin/feedback">Phản hồi khách hàng</a></li>
                </ul>
            </div> 