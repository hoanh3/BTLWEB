<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

        
        <main class="account-main">
            <div class="grid wide">
                <div class="row">
                    <div class="col l-12 m-12 c-12">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="${pageContext.request.contextPath}/account">Tài khoản</a></li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col l-12 m-12 c-12">
                        <div class="account-header">
                            <h2 class="header-title">Tài khoản của bạn</h2>
                            <a href="${pageContext.request.contextPath}/logout" class="logout">
                                <i class="fa-solid fa-right-from-bracket"></i>
                                <span>Đăng xuất</span>
                            </a>
                        </div>
                    </div>
                    <div class="col l-5 m-12 c-12">
                        <div class="user-box">
                            <p class="user-name">
                                <span>Họ tên:</span>
                                <span>${user.lastName} ${user.firstName}</span>
                            </p>
                            <p class="user-email">
                                <span>Email:</span>
                                <span>${user.email}</span>
                            </p>
                            <p class="user-address">
                                <span>Địa chỉ:</span>
                                <span>${user.streetAddress}, ${user.district}, ${user.city}</span
                                >
                            </p>
                            <p class="user-phone">
                                <span>Điện thoại:</span>
                                <span>${user.phoneNumber}</span>
                            </p>
                            <div class="view__address">
                                <a href="${pageContext.request.contextPath}/address" class="view__address--link">
                                    <span>Xem địa chỉ</span>
                                    <i class="fa-solid fa-share"></i>
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

    <!-- menu begin -->
    <jsp:include page="./mobile/menu.jsp" flush="true" />
    <!-- menu end -->

    <div class="back-to-top">
        <button><i class="fa-solid fa-chevron-up"></i></button>
    </div>

    <div class="hotline">
        <a href="#"><i class="fa-sharp fa-solid fa-phone"></i></a>
    </div>
</body>
</html>