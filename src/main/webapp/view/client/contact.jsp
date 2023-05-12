<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

        <main class="contact-main">
            <div class="grid wide">
                <div class="row">
                    <div class="col l-12 m-12 c-12">
                        <ul class="breadcrumb">
                            <li><a href="./">Trang chủ</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="#">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>
                <div class="row" id="contact">
                    <div class="col l-12 m-12 c-12">
                        <h2 class="contact-title">Liên hệ</h2>
                        <iframe class="contact-map" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.65135631891!2d105.78955900990663!3d21.046631687085373!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab306caa83a7%3A0xbfe4b316823e38f7!2zSOG7jWMgdmnhu4duIEPDtG5nIG5naOG7hyBCxrB1IGNow61uaCBWaeG7hW4gdGjDtG5nIChQVElUKQ!5e0!3m2!1svi!2s!4v1682436237389!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        <div class="row">
                            <div class="col l-6 m-12 c-12">
                                <div class="contact-left">
                                    <div class="contact-left-title">
                                        <i class="fa-solid fa-envelope"></i>
                                        <span>Để lại lời nhắn cho chúng tôi</span>
                                    </div>
                                    <form action="" class="contact-form">
                                        <div class="row">
                                            <div class="col l-6 m-6 c-12">
                                                <div class="form-group">
                                                    <input type="text" name="username" class="form-control" placeholder=" ">
                                                    <label for="username" class="form-label">Họ và tên</label>
                                                </div>
                                                <div class="form-group">
                                                    <input type="text" name="username" class="form-control" placeholder=" ">
                                                    <label for="username" class="form-label">Email</label>
                                                </div>
                                                <div class="form-group">
                                                    <input type="text" name="username" class="form-control" placeholder=" ">
                                                    <label for="username" class="form-label">Số điện thoại</label>
                                                </div>
                                            </div>
                                            <div class="col l-6 m-6 c-12">
                                                <div class="m-l-r-12">
                                                    <textarea name="" placeholder="Viết lời nhắn"></textarea>
                                                </div>
                                            </div>
                                            <div class="col l-12 m-12 c-12">
                                                <button class="send-btn">Gửi lời nhắn</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col l-6 m-12 c-12">
                                <div class="contact-right">
                                    <div class="contact-right-title">
                                        <span>Chúng tôi sẽ kết nối ngay lập tức khi bạn cần trợ giúp</span>
                                    </div>
                                    <div class="contact-phone">
                                        <i class="fa-solid fa-mobile-retro"></i>
                                        <span>Vergency</span>
                                    </div>
                                    <div class="contact-phone">
                                        <i class="fa-solid fa-phone"></i>
                                        <span>037 335 7405.</span>
                                    </div>
                                    <div class="contact-address">
                                        <i class="fa-solid fa-location-dot"></i>
                                        <span>
                                            891 Hương Lộ 2, Bình Trị Đông A, Bình Tân, TP. Hồ Chí Minh (AM: 08H30 -> 11H45, PM: 13H30 -> 17H45) KH vui lòng đến đúng khung giờ mở cửa trên để mua hàng. Vergency chân thành cảm ơn!
                                        </span>
                                    </div>
                                    <div class="contact-email">
                                        <i class="fa-solid fa-envelope"></i>
                                        <span>vergency.contact@gmail.com</span>
                                    </div>
                                </div>
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

    <script src="${url}/js/app.js"></script>
</body>
</html>