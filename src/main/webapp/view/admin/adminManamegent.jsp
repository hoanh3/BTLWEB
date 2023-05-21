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
                    <tr>
                        <th>Id</th>
                        <th>Tên đăng nhập</th>
                        <th>Tên admin</th>
                        <th>Hành động</th>
                        <!-- <th>Hành động</th> -->
                    </tr>
                    <tr>
                        <td>1</th>
                        <td>admin1@gmail.com</th>
                        <td>Tran Hoan</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</th>
                        <td>admin2@gmail.com</th>
                        <td>Tran Hoan</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>3</th>
                        <td>admin3@gmail.com</th>
                        <td>Tran Hoan</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                </table>
                <a href="#open">Thêm admin</a>
            </div>
            
        </div>
    </div>
    <!-- modal layout -->
    <div class="modal" id="open">
        <a href="#" class="close"></a>
        <div class="modal-overlay" class=""></div>
        <div class="modal-body">
            <div class="modal-inner">
                <div class="admin-title">
                    <h1>Thêm ADMIN</h1>
                </div>
                <div class="form-group">
                    <label class="id">ID:</label>
                    <input class="form-control" type="text" placeholder="ID" id="tenId" />
                </div>
                <div class="form-group">
                    <label class="username">Username:</label>
                    <input class="form-control" type="text" placeholder="Username" id="tenDn" />
                </div>
                <div class="form-group">
                    <label class="Password">Password</label>
                    <input class="form-control" type="password" placeholder="Password" id="password" />
                </div>
                <div class="form-group">
                    <label class="name">Tên admin</label>
                    <input class="form-control" type="text" placeholder="Tên admin" id="tenAdmin" />
                </div>
                <button class="Add" onclick="add()">Thêm</button>
            </div>
        </div>
    </div>
    <script src="${url}/js/adminManamegent.js"></script>
</body>
</html>