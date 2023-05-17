<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Vergancy</title>
        <!-- <link rel="stylesheet" href="${url}/font/fontawesome-free-6.3.0/css/all.min.css"> -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
        <link rel="icon" href="${url}/images/icons8-v-16.png" type="image/x-icon" />
        <link rel="stylesheet" href="${url}/css/main.css" />
        <link rel="stylesheet" href="${url}/css/login.css" />
        <link rel="stylesheet" href="${url}/css/base.css" />
        <link rel="stylesheet" href="${url}/css/responsive.css" />
        <link rel="stylesheet" href="${url}/css/grid.css" />
        <link rel="stylesheet" href="${url}/css/shop.css" />
        <link rel="stylesheet" href="${url}/css/contact.css" />
        <link rel="stylesheet" href="${url}/css/blog.css" />
        <link rel="stylesheet" href="${url}/css/about.css" />
        <link rel="stylesheet" href="${url}/css/cart.css" />
        <link rel="stylesheet" href="${url}/css/account.css" />
        <link rel="stylesheet" href="${url}/css/address.css" />
    </head>
    <body>
        <input type="hidden" id="user-id" value="${sessionScope.user != null ? sessionScope.user.id : 0}" />
        <div class="app">
            <div class="header">
                <div class="header-wrapper">
                    <div class="toggle-box">
                        <a href="#" class="header__toggle">
                            <i class="fa-solid fa-bars"></i>
                        </a>
                    </div>
                    <div class="header__tel">
                        <i class="phone-icon fa-solid fa-phone"></i>
                        <span>0373357405.</span>
                    </div>
                    <div class="header__logo">
                        <a href="${pageContext.request.contextPath}/home" class="logo__link">
                            <img src="${url}/images/logo.jpg" alt="logo" class="logo__img" />
                        </a>
                    </div>
                    <div class="header__control">
                        <div class="header__search">
                            <div class="form-search">
                                <i class="control-icon fa-solid fa-magnifying-glass"></i>
                            </div>
                            <div class="form-input">
                                <input type="text" class="search-input" required placeholder="Search ..." />
                                <i class="close-icon fa-solid fa-xmark"></i>
                            </div>
                        </div>
                        <div class="header__user">
                            <a href="${pageContext.request.contextPath}/${sessionScope.user != null ? 'account' : 'login'}" class="header__user-link">
                                <i class="control-icon fa-solid fa-user"></i>
                            </a>
                        </div>
                        <div class="header__cart">
                            <a href="${pageContext.request.contextPath}/cart-view" class="header__cart-link">
                                <i class="control-icon fa-solid fa-cart-shopping"></i>
                                <span class="header__cart--notify">0</span>
                            </a>
                        </div>
                        <div class="mobile-header__search">
                            <span class="mobile__search-icon">
                                <i class="control-icon fa-solid fa-magnifying-glass"></i>
                                <!-- <i class="close-icon fa-solid fa-xmark"></i> -->
                            </span>
                        </div>
                    </div>
                </div>
                <div class="mobile__search-box">
                    <input type="text" placeholder="Search ..." />
                </div>
            </div>

            <nav class="navbar">
                <div class="navbar__wrapper">
                    <ul class="navbar-list">
                        <li class="navbar-item navbar-item--current">
                            <a href="${pageContext.request.contextPath}/home" class="navbar-item__link">Home</a>
                        </li>
                        <li class="navbar-item">
                            <a href="${pageContext.request.contextPath}/shop" class="navbar-item__link">
                                Shop
                                <i class="fa-solid fa-chevron-down"></i>
                                <ul class="navbar__list-product">
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=1" class="navbar__product-link">T-SHIRTS</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=2" class="navbar__product-link">SHIRTS</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=3" class="navbar__product-link">SWEATERS</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=4" class="navbar__product-link">HOODIES</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=5" class="navbar__product-link">SHORTS</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=6" class="navbar__product-link">BAGS</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=7" class="navbar__product-link">PERFUME</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=8" class="navbar__product-link">JACKET</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=9" class="navbar__product-link">ACCESSORIES</a>
                                    </li>
                                    <li class="navbar__item-product">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=10" class="navbar__product-link">POLO</a>
                                    </li>
                                </ul>
                            </a>
                        </li>
                        <li class="navbar-item">
                            <a href="${pageContext.request.contextPath}/blog" class="navbar-item__link">Blog</a>
                        </li>
                        <li class="navbar-item">
                            <a href="${pageContext.request.contextPath}/contact" class="navbar-item__link">Contact</a>
                        </li>
                        <li class="navbar-item">
                            <a href="${pageContext.request.contextPath}/about" class="navbar-item__link">About</a>
                        </li>
                        <li class="navbar-item">
                            <a href="#" class="navbar-item__link">Group</a>
                        </li>
                        <li class="navbar-item">
                            <a href="#" class="navbar-item__link">Instagram</a>
                        </li>
                    </ul>
                </div>
            </nav>