<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

            <main class="cart_main">
                <div class="grid wide">
                    <div class="row">
                        <div class="col l-12 m-12 c-12">
                            <ul class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                                <li><i class="fa-solid fa-angle-right"></i></li>
                                <li><a href="${pageContext.request.contextPath}/cart-view">Giỏ hàng</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="row" id="cart">
                        <div class="col l-8 m-12 c-12">
                            <h1 class="head-title-cart">Giỏ hàng</h1>
                            <form action="" method="post" class="form-cart" id="form-cart"></form>
                            <div class="side-box-group">
                                <!-- <div class="continue-shopping">
                                <div class="continue-shopping--btn">
                                    <a href="#">Tiếp tục mua sản phẩm khác</a>
                                </div>
                            </div>
                            <h3>Ghi chú đơn hàng</h3>
                            <div class="checkout-note">
                                <textarea id="box-note" rows="5" placeholder="Ghi chú:"></textarea>
                            </div> -->
                            </div>
                        </div>
                        <div class="col l-4 m-12 c-12">
                            <h1 class="head-title-cart">Đơn hàng</h1>
                            <div class="right-cart">
                                <h2>
                                    <label>Tổng tiền</label>
                                    <label class="total-price">0đ</label>
                                </h2>
                                <a href="${pageContext.request.contextPath}/checkout" class="checkout">Thanh toán</a>
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

        <script src="${url}/js/app.js"></script>
        <script src="${url}/js/cart.js"></script>
    </body>
</html>
