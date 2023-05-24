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
                <div class="wrapper">
                    <div class="order">
                        <div class="product-info">
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
                                <div class="note">Ghi chú của khách hàng: Lorem ipsum dolor sit amet consectetur adipisicing
                                    elit. Quibusdam voluptas ipsam velit vel. Deserunt, quia autem. Hic eaque illo harum.
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="${url}/js/app.js"></script>
    <script src="${url}/js/modal.js"></script>
    <script src="${url}/js/order.js"></script>
</body>
</html>