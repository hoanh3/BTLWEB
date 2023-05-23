<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

            <div class="slider">
                <i id="prev-btn" class="fa-solid fa-angle-left"></i>
                <div class="slider-wrapper">
                    <picture>
                        <source media="(max-width: 739px)" srcset="${url}/images/Slider/slide_index_1_mb.png" />
                        <img
                            src="${url}/images/Slider/slide_index_1.png"
                            alt="slider"
                            class="slider__img"
                            draggable="false"
                        />
                    </picture>
                    <picture>
                        <source media="(max-width: 739px)" srcset="${url}/images/Slider/slide_index_2_mb.png" />
                        <img
                            src="${url}/images/Slider/slide_index_2.png"
                            alt="slider"
                            class="slider__img"
                            draggable="false"
                        />
                    </picture>
                    <picture>
                        <source media="(max-width: 739px)" srcset="${url}/images/Slider/slide_index_1_mb.png" />
                        <img
                            src="${url}/images/Slider/slide_index_1.png"
                            alt="slider"
                            class="slider__img"
                            draggable="false"
                        />
                    </picture>
                    <picture>
                        <source media="(max-width: 739px)" srcset="${url}/images/Slider/slide_index_2_mb.png" />
                        <img
                            src="${url}/images/Slider/slide_index_2.png"
                            alt="slider"
                            class="slider__img"
                            draggable="false"
                        />
                    </picture>
                    <picture>
                        <source media="(max-width: 739px)" srcset="${url}/images/Slider/slide_index_1_mb.png" />
                        <img
                            src="${url}/images/Slider/slide_index_1.png"
                            alt="slider"
                            class="slider__img"
                            draggable="false"
                        />
                    </picture>
                    <picture>
                        <source media="(max-width: 739px)" srcset="${url}/images/Slider/slide_index_2_mb.png" />
                        <img
                            src="${url}/images/Slider/slide_index_2.png"
                            alt="slider"
                            class="slider__img"
                            draggable="false"
                        />
                    </picture>
                </div>
                <i id="next-btn" class="fa-solid fa-angle-right"></i>
            </div>

            <div class="container">
                <div class="app-content">
                    <!-- Service content -->
                    <div class="service">
                        <div class="grid wide">
                            <div class="row">
                                <div class="col l-3 m-3 c-12">
                                    <i class="service-icon fa-solid fa-truck-fast"></i>
                                    <h2 class="service-title">Giao hàng toàn quốc</h2>
                                    <p class="service-description">
                                        Thời gian giao hàng linh động từ 3 - 4 - 5 ngày tùy khu vực, đôi khi sẽ nhanh
                                        hơn hoặc chậm hơn. Mong Quý Khách hàng thông cảm và cố gắng đợi hàng giúp shop.
                                    </p>
                                </div>
                                <div class="col l-3 m-3 c-12">
                                    <i class="service-icon fa-solid fa-rotate"></i>
                                    <h2 class="service-title">Chính sách đổi trả hàng</h2>
                                    <p class="service-description">
                                        Sản phẩm được phép đổi hàng trong vòng 36h nếu phát sinh lỗi từ nhà sản xuất
                                        (Yêu cầu: hình ảnh phần bị lỗi rõ nét, chi tiết và đầy đủ).
                                    </p>
                                </div>
                                <div class="col l-3 m-3 c-12">
                                    <i class="service-icon fa-solid fa-hand-holding-dollar"></i>
                                    <h2 class="service-title">Giao hàng nhận tiền và kiểm kê đơn hàng</h2>
                                    <p class="service-description">
                                        Được phép kiểm hàng trước khi thanh toán. Lưu ý: Trường hợp Quý Khách hàng đã
                                        nhận hàng về nhà, vui lòng quay video unbox đơn hàng trong tình trạng nguyên vẹn
                                        để có căn cứ xác thực đơn hàng gặp phải vấn đề, trường hợp không có video shop
                                        không thể hỗ trợ.
                                    </p>
                                </div>
                                <div class="col l-3 m-3 c-12">
                                    <i class="service-icon fa-solid fa-phone-volume"></i>
                                    <h2 class="service-title">Đặt hàng online và kiểm tra đơn hàng vui lòng liên hệ</h2>
                                    <p class="service-description">
                                        <span>Hotline: 037 335 7405.</span>
                                        <span>Facebook: Vargancy</span>
                                        <span>Instagram: vergency.vn</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Product -->
                    <div class="product">
                        <div class="grid wide">
                            <div class="row">
                                <div class="col l-12 m-12 c-12">
                                    <div class="title-box">
                                        <div class="wrap-content">
                                            <h3 class="title-group">VERGENCY</h3>
                                            <div class="title-group-desc">Satisfy You - Happy Us.</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col l-12 m-12 c-12">
                                    <div class="box-count">
                                        <div class="box-time">
                                            <span class="date">11</span>
                                            <p class="times-dots">Ngày</p>
                                        </div>
                                        <div class="box-time">
                                            <span class="hours">00</span>
                                            <p class="times-dots">Giờ</p>
                                        </div>
                                        <div class="box-time">
                                            <span class="minutes">00</span>
                                            <p class="times-dots">Phút</p>
                                        </div>
                                        <div class="box-time">
                                            <span class="seconds">00</span>
                                            <p class="times-dots">Giây</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- List product -->
                            <div class="row product-list">
                                <!-- <div class="col l-3 m-4 c-6">
                                    <div class="product-information">
                                        <a href="#" class="product-item">
                                            <div class="product-item__img" style="background-image: url(${url}/images/Products/product1.png);"></div>
                                            <h4 class="product-item__name">DISSOLVE 3D T-SHIRT/RED</h4>
                                            <p class="product-item__vendor">VERGENCY</p>
                                            <div class="product-item__review">
                                                <span class="rating">
                                                    <i class="star-yellow fa-solid fa-star"></i>
                                                    <i class="star-yellow fa-solid fa-star"></i>
                                                    <i class="star-yellow fa-solid fa-star"></i>
                                                    <i class="star-yellow fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                </span>
                                            </div>
                                            <div class="product-item__price">
                                                <span class="price-old">420.000đ</span>
                                                <span class="price-new">59.000đ</span>
                                            </div>
                                            <div class="product-item__sale-off">-86%</div>
                                        </a>
                                        <div class="product-item__quick-view">
                                            <a class="quick-view--btn">Xem nhanh</a>
                                        </div>
                                    </div>
                                </div> -->
                            </div>

                            <!-- view more -->
                            <div class="row">
                                <div class="col l-12 m-12 c-12">
                                    <div class="view-more">
                                        <button class="btn custom-btn">Xem tất cả</button>
                                        <!-- <button class="btn">Xem tất cả</button> -->
                                    </div>
                                </div>
                            </div>

                            <!-- Favorite list: start -->
                            <div class="row">
                                <div class="col l-12 m-12 c-12">
                                    <div class="title-box">
                                        <div class="wrap-content">
                                            <h3 class="title-group">DANH MỤC ƯA THÍCH</h3>
                                            <div class="title-group-desc">Danh sách được nhiều khách hàng ưa thích</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col l-4 m-4 c-6">
                                    <div class="box-favorite">
                                        <a href="#" class="favorite-link">
                                            <img
                                                src="${url}/images/Favorites/banner_index_1.png"
                                                alt=""
                                                class="favorite-img"
                                            />
                                        </a>
                                    </div>
                                </div>
                                <div class="col l-4 m-4 c-6">
                                    <div class="box-favorite">
                                        <a href="#" class="favorite-link">
                                            <img
                                                src="${url}/images/Favorites/banner_index_2.png"
                                                alt=""
                                                class="favorite-img"
                                            />
                                        </a>
                                    </div>
                                </div>
                                <div class="col l-4 m-4 c-6">
                                    <div class="box-favorite">
                                        <a href="#" class="favorite-link">
                                            <img
                                                src="${url}/images/Favorites/banner_index_3.png"
                                                alt=""
                                                class="favorite-img"
                                            />
                                        </a>
                                    </div>
                                </div>
                                <div class="col l-4 m-4 c-6">
                                    <div class="box-favorite">
                                        <a href="#" class="favorite-link">
                                            <img
                                                src="${url}/images/Favorites/banner_index_4.png"
                                                alt=""
                                                class="favorite-img"
                                            />
                                        </a>
                                    </div>
                                </div>
                                <div class="col l-4 m-4 c-6">
                                    <div class="box-favorite">
                                        <a href="#" class="favorite-link">
                                            <img
                                                src="${url}/images/Favorites/banner_index_5.png"
                                                alt=""
                                                class="favorite-img"
                                            />
                                        </a>
                                    </div>
                                </div>
                                <div class="col l-4 m-4 c-6">
                                    <div class="box-favorite">
                                        <a href="#" class="favorite-link">
                                            <img
                                                src="${url}/images/Favorites/banner_index_6.png"
                                                alt=""
                                                class="favorite-img"
                                            />
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <!-- Favorite list: end -->

                            <!-- Best saller: start -->
                            <div class="row">
                                <div class="col l-12 m-12 c-12">
                                    <div class="title-box">
                                        <div class="wrap-content">
                                            <h3 class="title-group">BEST SALLER</h3>
                                            <div class="title-group-desc">Products are sold out very quickly.</div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row best-saller"></div>

                            <!-- view more -->
                            <div class="row">
                                <div class="col l-12 m-12 c-12">
                                    <div class="view-more">
                                        <button class="btn custom-btn">Xem tất cả</button>
                                        <!-- <button class="btn">Xem tất cả</button> -->
                                    </div>
                                </div>
                            </div>
                            <!-- Best saller: end -->

                            <!-- Brand -->
                            <div class="row">
                                <div class="col l-12 m-12 c-12">
                                    <div class="title-box">
                                        <div class="wrap-content">
                                            <h3 class="title-group">THƯƠNG HIỆU</h3>
                                            <div class="title-group-desc">Thương hiệu nổi bật của chúng tôi</div>
                                        </div>
                                    </div>
                                </div>
                                <!-- slide brand: start -->
                                <div class="col l-12 m-12 c-12">
                                    <div class="brand-carousel">
                                        <div class="brand-wrapper">
                                            <div class="brand-item">
                                                <img src="${url}/images/Brand/partner_1.png" alt="" class="brand-img" />
                                            </div>
                                            <div class="brand-item">
                                                <img src="${url}/images/Brand/partner_2.png" alt="" class="brand-img" />
                                            </div>
                                            <div class="brand-item">
                                                <img src="${url}/images/Brand/partner_3.png" alt="" class="brand-img" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- slide brand: end -->
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
                                    <img src="${url}/images/SliderQuickView/image1.png" alt="" />
                                </div>
                                <div class="quick-view__slider">
                                    <i class="quick-view-prev fa-solid fa-chevron-left"></i>
                                    <div class="slider-product">
                                        <div class="slider-product__item active">
                                            <img
                                                src="${url}/images/SliderQuickView/image1.png"
                                                alt=""
                                                class="item-img"
                                            />
                                        </div>
                                        <div class="slider-product__item">
                                            <img
                                                src="${url}/images/SliderQuickView/image2.png"
                                                alt=""
                                                class="item-img"
                                            />
                                        </div>
                                        <div class="slider-product__item">
                                            <img
                                                src="${url}/images/SliderQuickView/image3.png"
                                                alt=""
                                                class="item-img"
                                            />
                                        </div>
                                        <div class="slider-product__item">
                                            <img
                                                src="${url}/images/SliderQuickView/image4.png"
                                                alt=""
                                                class="item-img"
                                            />
                                        </div>
                                        <div class="slider-product__item">
                                            <img
                                                src="${url}/images/SliderQuickView/image5.png"
                                                alt=""
                                                class="item-img"
                                            />
                                        </div>
                                        <!-- <div class="slider-product__item">
                                            <img
                                                src="${url}/images/SliderQuickView/image6.png"
                                                alt=""
                                                class="item-img"
                                            />
                                        </div>
                                        <div class="slider-product__item">
                                            <img
                                                src="${url}/images/SliderQuickView/image7.png"
                                                alt=""
                                                class="item-img"
                                            />
                                        </div> -->
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
                                        <i class="star-yellow fa-solid fa-star"></i>
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
                                            <input type="radio" name="size" value="1" id="small" />
                                            <span>S</span>
                                        </label>
                                        <label for="medium" class="size-option">
                                            <input type="radio" name="size" value="2" id="medium" />
                                            <span>M</span>
                                        </label>
                                        <label for="large" class="size-option">
                                            <input type="radio" name="size" value="3" id="large" />
                                            <span>L</span>
                                        </label>
                                        <label for="x-large" class="size-option sold-out">
                                            <input type="radio" name="size" value="4" id="x-large" />
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
                                        <p class="amount" data-max="1">0</p>
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
                                        Sản phẩm áo thun nam nữ local brand unisex form rộng tay lỡ Vergency Rapper/RAP
                                        hàng chính hãng.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- message login begin-->
        <jsp:include page="./menu/message.jsp" flush="true" />
        <!-- message login end -->

        <!-- menu begin -->
        <jsp:include page="./menu/menu.jsp" flush="true" />
        <!-- menu end -->

        <div class="back-to-top">
            <button><i class="fa-solid fa-chevron-up"></i></button>
        </div>

        <div class="hotline">
            <a href="#"><i class="fa-sharp fa-solid fa-phone"></i></a>
        </div>
        <!-- script begin -->
        <script src="${url}/js/app.js"></script>
        <script src="${url}/js/slider.js"></script>
        <!-- <script src="${url}/js/main.js"></script> -->
        <script src="${url}/js/quickViewSlide.js"></script>
        <script src="${url}/js/renderProduct.js"></script>
        <script src="${url}/js/addToCart.js"></script>
        <!-- script end -->
    </body>
</html>
