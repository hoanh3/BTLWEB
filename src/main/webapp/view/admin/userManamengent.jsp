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

    <div class="modal" id="open">
        <a href="#" class="close"></a>
        <div class="modal-overlay" class=""></div>
        <div class="modal-body">
            <div class="modal-inner">
                <div class="admin-title">
                <h1>Edit User</h1>
                </div>
                <form action="#" id="form-input">
                    <div class="form-group">
                        <label for="input-1">ID:</label>
                        <input type="text" readonly="readonly" class="form-control" id="input-1" name="input-1"/>
                    </div>
                    <div class="form-group">
                        <label for="input-2">Họ:</label>
                        <input class="form-control" id="input-2" name="input-2" />
                    </div>
                    <div class="form-group">
                        <label for="input-3">Tên: </label>
                        <input type="text" class="form-control" id="input-3" name="input-3"/>
                    </div>
                    <div class="form-group">
                        <label for="input-4">Email: </label>
                        <input type="text" class="form-control" id="input-4" name="input-4"/>
                    </div>
                    <div class="form-group">
                        <label for="input-5">Số điện thoại:</label>
                        <input type="text" class="form-control" id="input-5" name="input-5"/>
                    </div>
                    <div class="form-group">
                        <label for="input-6">Phường/Đường/Xã:</label>
                        <input type="text" class="form-control" id="input-6" name="input-6"/>
                    </div>
                    <div class="form-group">
                        <label for="input-7">Quân/Huyện</label>
                        <input type="text" class="form-control" id="input-7" name="input-7"/>
                    </div>
                    <div class="form-group">
                        <label for="input-8">Tỉnh/Thành phố</label>
                        <input type="text" id="input-8" name="input-8" class="file form-control" />
                    </div>
                    <button class="Add" type="submit" id="update-btn">Cập nhật</button>
                </form>
            </div>
        </div>
    </div>

    
    <script src="${url}/js/user.js"></script>
</body>
</html>