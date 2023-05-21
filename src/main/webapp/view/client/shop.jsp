<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

        <div class="thumbnail-shop">
            <img src="${url}/images/bg-shop.jpg" alt="" class="bg-shop-img">
        </div>

        <div class="container">
            <div class="product">
                <div class="grid wide">
                    <div class="row">
                        <div class="col l-12 m-12 c-12">
                            <ul class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                                <li><i class="fa-solid fa-angle-right"></i></li>
                                <li><a href="${pageContext.request.contextPath}/shop">Shop</a></li>
                                <li><i class="fa-solid fa-angle-right"></i></li>
                                <li><a href="${pageContext.request.contextPath}/shop">Tất cả sản phẩm</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <!-- Category -->
                        <div class="col l-3 m-4 c-12">
                            <section class="category">
                                <div class="category__heading">Danh mục</div>
                                <div class="category__box">
                                    <ul class="collection">
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
                                </div>
                            </section>
                            <section class="mobile-category">
                                <ul class="mobile-category__list">
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=1" class="mobile-category__link">T-SHIRTS</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=2" class="mobile-category__link">SHIRTS</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=3" class="mobile-category__link">SWEATERS</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=4" class="mobile-category__link">HOODIES</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=5" class="mobile-category__link">SHORTS</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=6" class="mobile-category__link">BAGS</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=7" class="mobile-category__link">PERFUME</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=8" class="mobile-category__link">JACKET</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=9" class="mobile-category__link">ACCESSORIES</a>
                                    </li>
                                    <li class="mobile-category__item">
                                        <a href="${pageContext.request.contextPath}/shop?cate-id=10" class="mobile-category__link">POLO</a>
                                    </li>
                                </ul>
                            </section>
                        </div>
    
                        <!-- List Product -->
                        <div class="col l-9 m-8 c-12">
                            <div class="row">
                                <div class="col l-12 m-12 c-12">
                                    <div class="filter">
                                        <h1 class="filter__heading">Tất cả sản phẩm</h1>
                                        <div class="select-input">
                                            <span>Sắp xếp theo:</span>
                                            <select name="" id="" class="sort-by">
                                                <option value="">Bán chạy nhất</option>
                                                <option value="">Sản phẩm nổi bật</option>
                                                <option value="">Giá: Tăng dần</option>
                                                <option value="">Giá: Giảm dần</option>
                                                <option value="">Tên: A-Z</option>
                                                <option value="">Tên: Z-A</option>
                                                <option value="">Mới nhất</option>
                                                <option value="">Cũ nhất</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
    
                            <div class="row shop-product">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- footer begin -->
        <jsp:include page="./footer/mainFooter.jsp" flush="true" />
        <!-- footer end -->
    </div>

    <div class="modal">
        <div class="modal__overlay"></div>
        <div class="modal__content">
            <div class="quick-view">
                <div class="grid wide">
                    <div class="row">
                        <div class="col l-5">
                            <div class="quick-view__img">
                                <img src="${url}/images/SliderQuickView/image1.png" alt="">
                            </div>
                            <div class="quick-view__slider">
                                <i class="quick-view-prev fa-solid fa-chevron-left"></i>
                                <div class="slider-product">
                                    <div class="slider-product__item active">
                                        <img src="${url}/images/SliderQuickView/image1.png" alt="" class="item-img">
                                    </div>
                                    <div class="slider-product__item">
                                        <img src="${url}/images/SliderQuickView/image2.png" alt="" class="item-img">
                                    </div>
                                    <div class="slider-product__item">
                                        <img src="${url}/images/SliderQuickView/image3.png" alt="" class="item-img">
                                    </div>
                                    <div class="slider-product__item">
                                        <img src="${url}/images/SliderQuickView/image4.png" alt="" class="item-img">
                                    </div>
                                    <div class="slider-product__item">
                                        <img src="${url}/images/SliderQuickView/image5.png" alt="" class="item-img">
                                    </div>
                                    <div class="slider-product__item">
                                        <img src="${url}/images/SliderQuickView/image6.png" alt="" class="item-img">
                                    </div>
                                    <div class="slider-product__item">
                                        <img src="${url}/images/SliderQuickView/image7.png" alt="" class="item-img">
                                    </div>
                                </div>
                                <i class="quick-view-next fa-solid fa-chevron-right"></i>
                            </div>
                        </div>
                        <div class="col l-7">
                            <div class="quick-view__close-btn">
                                <i class="fa-solid fa-xmark"></i>
                            </div>
                            <a href="#" class="quick-view__title">
                                <h2>ACTION T-SHIRT/GREY</h2>
                            </a>
                            <div class="quick-view__rating">
                                <span class="rating">
                                    <i class="star-yellow fa-solid fa-star"></i>
                                    <i class="star-yellow fa-solid fa-star"></i>
                                    <i class="star-yellow fa-solid fa-star"></i>
                                    <i class="star-yellow fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                </span>
                            </div>
                            <div class="quick-view__price">
                                <span class="price-new">59.000đ</span>
                                <span class="price-old">420.000đ</span>
                            </div>
                            <div class="quick-view__size">
                                <p>Kích Thước:</p>
                                <form class="size-select">
                                    <label for="small" class="size-option">
                                        <input type="radio" name="size" value="s" id="small">
                                        <span>S</span>
                                    </label>
                                    <label for="medium" class="size-option">
                                        <input type="radio" name="size" value="s" id="medium">
                                        <span>M</span>
                                    </label>
                                    <label for="large" class="size-option">
                                        <input type="radio" name="size" value="L" id="large">
                                        <span>L</span>
                                    </label>
                                    <label for="x-large" class="size-option sold-out">
                                        <input type="radio" name="size" value="XL" id="x-large">
                                        <span>XL</span>
                                    </label>
                                </form>
                            </div>
                            <div class="quick-view__quantity">
                                <p>Số Lượng:</p>
                                <div class="quantity-select">
                                    <button class="minus-btn">
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                    <p class="amount">0</p>
                                    <button class="plus-btn">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="quick-view__add-cart btn">
                                <i class="fa-solid fa-cart-plus"></i>
                                <span>Thêm vào giỏ hàng</span>
                            </div>
                            <div class="quick-view__desc">
                                <p>
                                    Sản phẩm áo thun nam nữ local brand unisex form rộng tay lỡ Vergency Rapper/RAP hàng chính hãng.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- menu begin -->
    <jsp:include page="./mobile/menu.jsp" flush="true" />
    <!-- menu end -->

    <div class="back-to-top">
        <button><i class="fa-solid fa-chevron-up"></i></button>
    </div>

    <div class="hotline">
        <a href="#"><i class="fa-sharp fa-solid fa-phone"></i></a>
    </div>

    <script src="${url}/js/app.js"></script>
    <script src="${url}/js/main.js"></script>
    <script src="${url}/js/shop.js"></script>
</body>
</html>