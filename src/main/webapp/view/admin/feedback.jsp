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
            <div class="container">
                <table class="fb-table">
                    <tbody  id="fb-table">
                        <tr>
                            <th>Họ và tên</th>
                            <th>Email</th>
                            <th>Số điện thoại</th>
                            <th>Tiêu đề</th>
                            <th>Nội dung</th>
                            <th></th>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="fb-modal">
        <div class="fb-content">
            <span class="fb-close">&times;</span>
            <div class="content-header">
                <h3 class="header-subject">Subject</h3>
                <p class="header-name">Trần Công Hoan</p>
                <div class="sub-header">
                    <span><</span>
                    <span class="header-email">honghm211@gmail.com</span>
                    <span>,</span>
                    <span class="header-phoneNumber">0369953662</span>
                    <span>></span>
                </div>
            </div>
            <div class="content-body">
                <p>test</p>
            </div>
        </div>
    </div>
</body>

<script src="${url}/js/app.js"></script>
<script src="${url}/js/feedback.js"></script>
</html>