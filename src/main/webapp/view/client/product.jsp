<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

            <main class="container">
                <input type="hidden" name="cate-id" id="cate-id" value="${product.category.id}">
                <input type="hidden" name="product-id" id="product-id" value="${product.id}">
                <div class="grid wide">
                    <div class="row">
                        <div class="col l-12 m-12 c-12">
                            <ul class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                                <li><i class="fa-solid fa-angle-right"></i></li>
                                <li><a href="${pageContext.request.contextPath}/shop?cate-id=${product.category.id}">${product.category.title}</a></li>
                                <li><i class="fa-solid fa-angle-right"></i></li>
                                <li><a href="#">${product.title}</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="row">
                        <!-- Image -->
                        <div class="col l-5 m-12 c-12">
                            <div class="product-image">
                                <div class="big-img">
                                    <img src="${product.thumbnail}" alt="" />
                                </div>
                                <div class="small-img">
                                    <i class="prev-icon fa-solid fa-chevron-left"></i>
                                    <div class="product-slider">
                                        <c:forEach var="p" items = "${product.galeries}">
                                            <div class="slider-item">
                                                <img
                                                    src="${p.thumbnail}"
                                                    alt=""
                                                    class="slider-img"
                                                />
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <i class="next-icon fa-solid fa-chevron-right"></i>
                                </div>
                            </div>
                        </div>

                        <!-- Product information -->
                        <div class="col l-5 m-12 c-12">
                            <div class="product-info">
                                <div class="product-title">${product.title}</div>
                                <div class="product-rating">
                                    <span class="rating">
                                        <i class="star-yellow fa-solid fa-star"></i>
                                        <i class="star-yellow fa-solid fa-star"></i>
                                        <i class="star-yellow fa-solid fa-star"></i>
                                        <i class="star-yellow fa-solid fa-star"></i>
                                        <i class="star-yellow fa-solid fa-star"></i>
                                    </span>
                                </div>

                                <div class="product-quantity">
                                    <span>Đã bán:</span>
                                    <span>999</span>
                                </div>

                                <div class="product-price">
                                    <span><fmt:formatNumber type="number" pattern="###,###đ" value="${product.discount}"/></span>
                                    <del><fmt:formatNumber type="number" pattern="###,###đ" value="${product.price}"/></del>
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
                                        <p class="amount">1</p>
                                        <button class="plus-btn">
                                            <i class="fa-solid fa-plus"></i>
                                        </button>
                                    </div>
                                </div>

                                <form action="" class="add-cart-form">
                                    <div class="btn-form">
                                        <div class="btn add-cart-btn">
                                            <i class="fa-solid fa-cart-plus"></i>
                                            <span>Thêm vào giỏ</span>
                                        </div>
                                        <div class="btn buy-btn">
                                            <i class="fa-solid fa-check"></i>
                                            <span>Mua ngay</span>
                                        </div>
                                    </div>
                                </form>

                                <div class="socials-article">
                                    <div class="like-btn">
                                        <i class="fa-solid fa-thumbs-up"></i>
                                        <span>Thích</span>
                                        <span>0</span>
                                    </div>
                                    <div class="share-btn">
                                        <i class="fa-brands fa-facebook"></i>
                                        <span>Chia sẻ</span>
                                        <span>0</span>
                                    </div>
                                </div>

                                <div class="tag-wrapper">
                                    <label for="">Tag:</label>
                                    <ul class="tags">
                                        <li><a href="./shop.html">*****</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <!-- Service -->
                        <div class="col l-2 m-12 c-12">
                            <div class="box-service">
                                <div class="header-service">
                                    <div class="title">Đón tiếp</div>
                                    <div class="content">Được phục vụ quý khách là vinh dự đối với chúng tôi.</div>
                                </div>
                                <div class="content-service">
                                    <div class="row">
                                        <div class="col l-12 m-12 c-12">
                                            <div class="service-product">
                                                <i class="fa-solid fa-truck"></i>
                                                <div class="desc-service">
                                                    <div class="title">GIAO HÀNG TOÀN QUỐC</div>
                                                    <div class="content">
                                                        Thời gian giao hàng linh động từ 3 - 4 - 5 ngày tùy khu vực, đôi
                                                        khi sẽ nhanh hơn hoặc chậm hơn. Mong Quý Khách hàng thông cảm và
                                                        cố gắng đợi hàng giúp shop.
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col l-12 m-12 c-12">
                                            <div class="service-product">
                                                <i class="fa-solid fa-rotate"></i>
                                                <div class="desc-service">
                                                    <div class="title">CHÍNH SÁCH ĐỔI TRẢ</div>
                                                    <div class="content">
                                                        Sản phẩm được phép đổi hàng trong vòng 36h nếu phát sinh lỗi từ
                                                        nhà sản xuất (Yêu cầu: hình ảnh phần bị lỗi rõ nét, chi tiết và
                                                        đầy đủ).
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col l-12 m-12 c-12">
                                            <div class="service-product">
                                                <i class="fa-solid fa-hand-holding-dollar"></i>
                                                <div class="desc-service">
                                                    <div class="title">GIAO HÀNG NHẬN TIỀN VÀ KIỂM KÊ ĐƠN HÀNG</div>
                                                    <div class="content">
                                                        Được phép kiểm hàng trước khi thanh toán. Lưu ý: Trường hợp Quý
                                                        Khách hàng đã nhận hàng về nhà, vui lòng quay video unbox đơn
                                                        hàng trong tình trạng nguyên vẹn để có căn cứ xác thực đơn hàng
                                                        gặp phải vấn đề, trường hợp không có video shop không thể hỗ
                                                        trợ.
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col l-12 m-12 c-12">
                                            <div class="service-product">
                                                <i class="fa-solid fa-phone"></i>
                                                <div class="desc-service">
                                                    <div class="title">
                                                        ĐẶT HÀNG ONLINE VÀ KIỂM TRA ĐƠN HÀNG VUI LÒNG LIÊN HỆ
                                                    </div>
                                                    <div class="content">037 335 7405</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col l-8 m-12 c-12">
                            <div class="product-detail">
                                <div class="product-tablist">
                                    <div class="tab-desc active">
                                        <span>Mô tả sản phẩm</span>
                                    </div>
                                    <div class="tab-cmt">
                                        <span>Bình luận</span>
                                    </div>
                                </div>
                                <div class="product-description">
                                    <div class="container-desc">
                                        <pre style="
                                        font-family: sans-serif;
                                        font-weight: 400;
                                        font-size: 12px;
                                    ">${product.description}</pre>
                                        <p>
                                            <img src="${url}/images/vgc-tee_size_chart.jpg" alt="" class="desc-size" />
                                        </p>
                                    </div>
                                </div>
                                <div class="product-comment">
                                    <div id="fb-root"></div>
                                    <script
                                        async
                                        defer
                                        crossorigin="anonymous"
                                        src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v16.0"
                                        nonce="wKe25TMD"
                                    ></script>
                                    <div
                                        class="fb-comments"
                                        data-href="https://developers.facebook.com/docs/plugins/comments#configurator"
                                        data-width="100%"
                                        data-numposts="5"
                                    ></div>
                                </div>
                            </div>
                        </div>

                        <div class="col l-4 m-12 c-12">
                            <div class="product-related">
                                <div class="title-related">
                                    <h3 class="title-group">Sản phẩm liên quan</h3>
                                </div>
                                <ul class="list-related">
                                    
                                </ul>
                            </div>

                            <div class="box-banner">
                                <div class="banner">
                                    <a href="./shop.html">
                                        <img src="${url}/images/Blog/banner1.jpg" alt="" />
                                    </a>
                                </div>
                                <div class="banner">
                                    <a href="./shop.html">
                                        <img src="${url}/images/Blog/banner2.jpg" alt="" />
                                    </a>
                                </div>
                                <div class="banner">
                                    <a href="./shop.html">
                                        <img src="${url}/images/Blog/banner3.jpg" alt="" />
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>

            <!-- footer begin -->
            <jsp:include page="./footer/mainFooter.jsp" flush="true" />
            <!-- footer end -->
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
    </body>

    <script src="${url}/js/app.js"></script>
    <script src="${url}/js/context.js"></script>
    <script src="${url}/js/product.js"></script>
</html>
