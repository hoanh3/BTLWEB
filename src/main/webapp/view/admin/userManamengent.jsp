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
                        <th>Họ</th>
                        <th>Tên</th>
                        <th>Email</th>
                        <th>Số điện thoại</th>
                        <th>Phường</th>
                        <th>Quân</th>
                        <th>Thành phố</th>
                        <th>Hành động</th>
                    </tr>
                    <tr>
                        <td>1</th>
                        <td>Tran Cong</th>
                        <td>Hoan</th>
                        <td>test1@gmail.com</th>
                        <td>0987654321</th>
                        <td>Mỗ Lao</th>
                        <td>Hà Đông</th>
                        <td>Hà Nội</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</th>
                        <td>Tran Cong</th>
                        <td>Hoan</th>
                        <td>test2@gmail.com</th>
                        <td>0987654321</th>
                        <td>Mỗ Lao</th>
                        <td>Hà Đông</th>
                        <td>Hà Nội</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>3</th>
                        <td>Tran Cong</th>
                        <td>Hoan</th>
                        <td>test3@gmail.com</th>
                        <td>0987654321</th>
                        <td>Mỗ Lao</th>
                        <td>Hà Đông</th>
                        <td>Hà Nội</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>