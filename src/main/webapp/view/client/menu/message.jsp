<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
<div class="message">
    <div class="message__overlay"></div>
    <div class="message__content">
        <div class="message__header">
            <i class="message-icon fa-solid fa-xmark"></i>
            <h3 class="message__title">Thông báo !</h3>
        </div>
        <div class="message__body">
            <div class="subtext">
                <span>Bạn chưa đăng nhập. Vui lòng đăng nhập để mua hàng!</span>
            </div>
            <div class="action-btn">
                <a href="${pageContext.request.contextPath}/login" class="login--link">Đăng nhập</a>
            </div>
        </div>
    </div>
</div>