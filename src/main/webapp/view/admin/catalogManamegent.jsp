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
                <a href="#">Thêm chuyên mục</a>
                <table id="render">
                    
                </table>
            </div>
        </div>
    </div>
    <!-- modal layout -->
    <div class="modal">
        <div class="modal-overlay"></div>
        <div class="modal-body">
            <i class="close-icon fa-solid fa-xmark"></i>
            <div class="modal-title">
                <h1>Thêm chuyên mục</h1>
            </div>
            <div class="modal-content">
                <div class="wrapper">
                    <form action="" id="form-input">
                        <div class="admin-title">
                            <h1>Thêm chuyên mục</h1>
                        </div>
                        <div class="form-group">
                            <label class="id">ID:</label>
                            <input class="form-control" readonly="readonly" name="input-1" type="text" placeholder="ID" id="input-1" />
                        </div>
                        <div class="form-group">
                            <label class="username">Tên chuyển mục</label>
                            <input class="form-control" name="input-2" type="text" placeholder="Tên chuyên mục" id="input-2" />
                        </div>
                        <button class="Add" id="add-btn">Thêm</button>
                        <button class="Add" id="update-btn">Cập nhật</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="${url}/js/app.js"></script>
    <script src="${url}/js/modal.js"></script>
    <script src="${url}/js/category.js"></script>
</body>
</html>