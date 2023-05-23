<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

        <main class="blog-main">
            <div class="grid wide">
                <div class="row">
                    <div class="col l-12 m-12 c-12">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="#">Blog - Tin tức</a></li>
                        </ul>
                    </div>
                </div>
                <div class="row" id="blog">
                    <div class="col l-8 m-12 c-12">
                        <p class="blog-content">
                            Chưa có bài viết nào trong mục này
                        </p>
                    </div>
                    <div class="col l-4 m-12 c-12">
                        <div class="article-list">
                            <div class="group-related">
                                <h3 class="group-title">Bài viết mới nhất</h3>
                            </div>
                            <ul class="list-article-new">

                            </ul>
                        </div>
                        <div class="box-banner">
                            <a href="${pageContext.request.contextPath}/shop">
                                <img src="${url}/images/Blog/banner1.jpg" alt="" class="banner-img">
                            </a>
                        </div>
                        <div class="box-banner">
                            <a href="${pageContext.request.contextPath}/shop">
                                <img src="${url}/images/Blog/banner2.jpg" alt="" class="banner-img">
                            </a>
                        </div>
                        <div class="box-banner">
                            <a href="${pageContext.request.contextPath}/shop">
                                <img src="${url}/images/Blog/banner3.jpg" alt="" class="banner-img">
                            </a>
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
</body>
</html>