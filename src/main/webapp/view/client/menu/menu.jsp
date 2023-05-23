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
                <a href="./login.html">Login</a>
            </div>
            <div class="account-register">
                <a href="./login.html">Register</a>
            </div>
        </div>
    </div>
    <ul class="menu-mobile">
        <li class="menu-mobile__item">
            <a href="./index.html" class="menu-mobile__link">Home</a>
        </li>
        <li class="menu-mobile__item">
            <a href="./shop.html" class="menu-mobile__link">
                Shop
                <i class="fa-solid fa-chevron-down"></i>
            </a>
            <ul class="list-product">
                <li class="menu__product">
                    <a href="#" class="menu__product-link">T-SHIRTS</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">SHIRTS</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">SWEATERS</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">HOODIES</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">SHORTS</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">BAGS</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">PERFUME</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">JACKET</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">ACCESSORIES</a>
                </li>
                <li class="menu__product">
                    <a href="#" class="menu__product-link">POLO</a>
                </li>
            </ul>
        </li>
        <li class="menu-mobile__item">
            <a href="./blog.html" class="menu-mobile__link">Blog</a>
        </li>
        <li class="menu-mobile__item">
            <a href="./contact.html" class="menu-mobile__link">Contact</a>
        </li>
        <li class="menu-mobile__item">
            <a href="./about.html" class="menu-mobile__link">About</a>
        </li>
        <li class="menu-mobile__item">
            <a href="#" class="menu-mobile__link">Group</a>
        </li>
        <li class="menu-mobile__item">
            <a href="#" class="menu-mobile__link">Instagram</a>
        </li>
    </ul>
</div>