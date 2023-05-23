<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/admin/assets" var="url" />
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma" , "no-cache");
    response.setHeader("Expires" , "0");
    
    
    if (session.getAttribute("admin") == null){
        response.sendRedirect(request.getContextPath() + "/admin/login"); 
    }
%>
            <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
            <!-- header end -->
            <div class="content">
                <table id="render">
                    
                </table>
            </div>
        </div>
    </div>
    
    
    <div class="modal">
        <div class="modal-overlay"></div>
        <div class="modal-body">
            <i class="close-icon fa-solid fa-xmark"></i>
            <div class="modal-title">
                <h1>Chi tiết đơn hàng</h1>
            </div>
            <div class="modal-content">
                <div class="wrap-product">
                    <div class="product-info">
                        <div class="product-img">
                            <img src="https://res.cloudinary.com/dasj31isc/image/upload/v1684739332/product/nxbwj0mprcdtrr6qhi3s.webp" alt="">
                        </div>
                        <div class="product-detail">
                            <div class="title">Product name</div>
                            <div class="price">
                                <span>89.000đ</span>
                                <span>200.000đ</span>
                            </div>
                            <div class="more">
                                <span>L</span>,
                                <span>1</span>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <div class="product-img">
                            <img src="https://res.cloudinary.com/dasj31isc/image/upload/v1684739332/product/nxbwj0mprcdtrr6qhi3s.webp" alt="">
                        </div>
                        <div class="product-detail">
                            <div class="title">Product name</div>
                            <div class="price">
                                <span>89.000đ</span>
                                <span>200.000đ</span>
                            </div>
                            <div class="more">
                                <span>L</span>,
                                <span>1</span>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <div class="product-img">
                            <img src="https://res.cloudinary.com/dasj31isc/image/upload/v1684739332/product/nxbwj0mprcdtrr6qhi3s.webp" alt="">
                        </div>
                        <div class="product-detail">
                            <div class="title">Product name</div>
                            <div class="price">
                                <span>89.000đ</span>
                                <span>200.000đ</span>
                            </div>
                            <div class="more">
                                <span>L</span>,
                                <span>1</span>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <div class="product-img">
                            <img src="https://res.cloudinary.com/dasj31isc/image/upload/v1684739332/product/nxbwj0mprcdtrr6qhi3s.webp" alt="">
                        </div>
                        <div class="product-detail">
                            <div class="title">Product name</div>
                            <div class="price">
                                <span>89.000đ</span>
                                <span>200.000đ</span>
                            </div>
                            <div class="more">
                                <span>L</span>,
                                <span>1</span>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <div class="product-img">
                            <img src="https://res.cloudinary.com/dasj31isc/image/upload/v1684739332/product/nxbwj0mprcdtrr6qhi3s.webp" alt="">
                        </div>
                        <div class="product-detail">
                            <div class="title">Product name</div>
                            <div class="price">
                                <span>89.000đ</span>
                                <span>200.000đ</span>
                            </div>
                            <div class="more">
                                <span>L</span>,
                                <span>1</span>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <div class="product-img">
                            <img src="https://res.cloudinary.com/dasj31isc/image/upload/v1684739332/product/nxbwj0mprcdtrr6qhi3s.webp" alt="">
                        </div>
                        <div class="product-detail">
                            <div class="title">Product name</div>
                            <div class="price">
                                <span>89.000đ</span>
                                <span>200.000đ</span>
                            </div>
                            <div class="more">
                                <span>L</span>,
                                <span>1</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="user-info">
                    <div class="user">
                        <div class="title">Thông tin khác hàng</div>
                        <p class="user-name">Tên: <span>Nguyen Van A</span></p>
                        <p class="email">Email: <span>email@gmail.com</span></p>
                        <p class="phone">Sđt: <span>0987654321</span></p>
                        <div class="address">
                            Địa chỉ:
                            <span>Mỗ Lao</span>-
                            <span>Hà Đông</span>-
                            <span>Hà Nội</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="${url}/js/app.js"></script>
    <script src="${url}/js/order.js"></script>
</body>
</html>