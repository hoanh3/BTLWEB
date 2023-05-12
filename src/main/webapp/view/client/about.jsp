<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

            <main class="about-page">
                <div class="grid wide">
                    <div class="row">
                        <div class="col l-12 m-12 c-12">
                            <ul class="breadcrumb">
                                <li><a href="./">Trang chủ</a></li>
                                <li><i class="fa-solid fa-angle-right"></i></li>
                                <li><a href="#">VERGENCY</a></li>
                            </ul>
                        </div>
                        <div class="col l-12 m-12 c-12">
                            <h1 class="about-header">CÔNG TY TNHH VERGENCY</h1>
                            <div class="about-desc">
                                <p class="about-text">
                                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Ngoài thị trường họ chỉ quan tâm đến doanh thu,
                                    lợi nhuận. Còn chúng tôi thì tìm đủ mọi cách, làm bất cứ điều gì để khách hàng luôn
                                    cảm thấy hài lòng và hạnh phúc. Chúng tôi chưa dám nghĩ mình là số một, nhưng trong
                                    tương lai chúng tôi tự tin khẳng định sẽ mãi nỗ lực nâng cao, phát triển nhằm mục
                                    đích vươn lên đỉnh điểm về chất lượng dịch vụ và sản phẩm trong từng ngày, từng giờ,
                                    từng phút, từng giây, để đem lại cho khách hàng những item tinh tuý nhất, kèm theo
                                    đó là một mức giá phù hợp với túi tiền của tất cả mọi người.
                                </p>
                                <p class="about-text">
                                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Chào mừng đến với Vergency! Hãy để chúng tôi có
                                    cơ hội được phục vụ bạn một cách chân thành và tận tâm hết sức có thể.
                                </p>
                                <p class="about-banner">
                                    <img src="${url}/images/About/banner1.jpg" alt="" class="banner-img" />
                                </p>
                                <p class="about-banner">
                                    <img src="${url}/images/About/banner2.jpg" alt="" class="banner-img" />
                                </p>
                                <p class="about-banner">
                                    <img src="${url}/images/About/banner3.jpg" alt="" class="banner-img" />
                                </p>
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

        <script src="${url}/js/app.js"></script>
    </body>
</html>
