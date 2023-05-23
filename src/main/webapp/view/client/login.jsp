<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->
        
        <main class="main">
            <div class="grid wide">
                <div class="row">
                    <div class="col l-12 m-12 c-12">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="${pageContext.request.contextPath}/login">Tài khoản</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
                        </ul>
                    </div>
                    <div class="col l-12 m-12 c-12">
                        <div class="form form-sign-in">
                            <!-- Form login -->
                            <form action="${pageContext.request.contextPath}/login" method="POST" class="form-login" id="form-login">
                                <h3 class="heading">Đăng nhập</h3>
                                <p class="description">Welcome to Vergency</p>
                    
                                <div class="spacer"></div>
                
                                <div class="form-group">
                                    <input type="text" name="email" class="form-control email" placeholder=" ">
                                    <label for="username" class="form-label">Email</label>
                                    <span class="form-message"></span>
                                </div>
                    
                                <div class="form-group">
                                    <input type="password" name="password" class="form-control password" placeholder=" ">
                                    <label for="password" class="form-label">Mật khẩu</label>
                                    <span class="form-message"></span>
                                </div>
                    
                                <button type="submit" class="form-submit">Đăng nhập</button>
                                
                                <div class="req-pass">
                                    <a href="#" class="recover-password">Quên mật khẩu</a>
                                    <a href="#" class="sign-up-link">Đăng ký</a>
                                </div>
                
                                <div class="or">
                                    <div></div>
                                    <span class="or-text">Hoặc</span>
                                    <div></div>
                                </div>
                
                                <div class="form-btn">
                                    <button class="sign-in-btn sign-in-with-fb">
                                        <i class="fb-icon fa-brands fa-facebook"></i>
                                        <span>Facebook</span>
                                    </button>
                                    <button class="sign-in-btn sign-in-with-google">
                                        <i class="fa-brands fa-google"></i>
                                        <span>Google</span>
                                    </button>
                                </div>
                
                                <div class="support">
                                    <a href="#">Bạn cần giúp đỡ?</a>
                                </div>

                                
                            </form>

                            <!-- Form register -->
                            <form action="${pageContext.request.contextPath}/register" method="POST" class="form-register" id="form-register">
                                <h3 class="heading">Đăng ký</h3>
                                <p class="description">Welcome to Vergency</p>
                    
                                <div class="spacer"></div>
                    
                                <div class="form-group">
                                    <input type="text" name="last-name" class="form-control firstname" placeholder=" ">
                                    <label for="last-name" class="form-label">Họ</label>
                                    <span class="form-message"></span>
                                </div>

                                <div class="form-group">
                                    <input type="text" name="first-name" class="form-control lastname" placeholder=" ">
                                    <label for="first-name" class="form-label">Tên</label>
                                    <span class="form-message"></span>
                                </div>

                                <div class="form-group">
                                    <input type="text" name="email" class="form-control email" placeholder=" ">
                                    <label for="email" class="form-label">Email</label>
                                    <span class="form-message"></span>
                                </div>
                    
                                <div class="form-group">
                                    <input type="password" name="password" class="form-control password" placeholder=" ">
                                    <label for="password" class="form-label">Mật khẩu</label>
                                    <span class="form-message"></span>
                                </div>
                    
                                <div class="form-group">
                                    <input type="password" id="repeat_password" name="repeat_password" class="form-control" placeholder=" ">
                                    <label for="repeat_password" class="form-label">Nhập lại mật khẩu</label>
                                    <span class="form-message"></span>
                                </div>
                
                                <button class="form-submit">Đăng ký</button>
                                <div class="req-pass">
                                    <span>Bạn đã có tài khoản?</span>
                                    <a href="#" class="sign-in-link">Đăng nhập</a>
                                </div>
                
                                <div class="or">
                                    <div></div>
                                    <span class="or-text">Hoặc</span>
                                    <div></div>
                                </div>
                
                                <div class="form-btn">
                                    <button class="sign-in-btn sign-in-with-fb">
                                        <i class="fb-icon fa-brands fa-facebook"></i>
                                        <span>Facebook</span>
                                    </button>
                                    <button class="sign-in-btn sign-in-with-google">
                                        <i class="fa-brands fa-google"></i>
                                        <span>Google</span>
                                    </button>
                                </div>
                
                                <div class="support">
                                    <a href="#">Bạn cần giúp đỡ?</a>
                                </div>
                            </form>
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
    <script src="${url}/js/validator.js"></script>
    <script>
        Validator({
            form: '#form-login',
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired('.email'),
                Validator.isEmail('.email'),
                Validator.isRequired('.password'),
                Validator.minLength('.password', 6),
            ]
        });
        Validator({
            form: '#form-register',
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired('.firstname'),
                Validator.isRequired('.lastname'),
                Validator.isRequired('.email'),
                Validator.isEmail('.email'),
                Validator.isRequired('.password'),
                Validator.minLength('.password', 6),
                Validator.isRequired('#repeat_password'),
                Validator.isConfirmation('#repeat_password', function() {
                    return document.querySelector('.form-register .password').value;
                }, 'Mật khẩu nhập lại không khớp. Vui lòng nhập lại!'),
            ]
        });
    </script>

</body>
</html>