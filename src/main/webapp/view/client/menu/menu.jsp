<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />

<div id="menu-mobile">
    <div class="account-mobile">
        <div class="avatar-mobile">
            <i class="fa-regular fa-circle-user"></i>
        </div>
        <div class="account-text">
            <div class="account-login">
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </div>
            <div class="account-register">
                <a href="${pageContext.request.contextPath}/login">Register</a>
            </div>
        </div>
    </div>
    <ul class="menu-mobile">
        <li class="menu-mobile__item">
            <a href="${pageContext.request.contextPath}/" class="menu-mobile__link">Home</a>
        </li>
        <li class="menu-mobile__item">
            <a href="${pageContext.request.contextPath}/shop" class="menu-mobile__link">
                Shop
                <i class="fa-solid fa-chevron-down"></i>
            </a>
            <ul class="list-product">
                
            </ul>
        </li>
        <li class="menu-mobile__item">
            <a href="${pageContext.request.contextPath}/blog" class="menu-mobile__link">Blog</a>
        </li>
        <li class="menu-mobile__item">
            <a href="${pageContext.request.contextPath}/contact" class="menu-mobile__link">Contact</a>
        </li>
        <li class="menu-mobile__item">
            <a href="${pageContext.request.contextPath}/about" class="menu-mobile__link">About</a>
        </li>
        <li class="menu-mobile__item">
            <a href="#" class="menu-mobile__link">Group</a>
        </li>
        <li class="menu-mobile__item">
            <a href="#" class="menu-mobile__link">Instagram</a>
        </li>
    </ul>
</div>