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
                            <li><a href="./">Trang chủ</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="#">Tài khoản</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="#">Đăng nhập</a></li>
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
                                    <input type="text" name="username" class="form-control email" placeholder=" ">
                                    <label for="username" class="form-label">Email</label>
                                    <span class="form-message"></span>
                                </div>
                    
                                <div class="form-group">
                                    <input type="password" name="password" class="form-control password" placeholder=" ">
                                    <label for="password" class="form-label">Mật khẩu</label>
                                    <span class="form-message"></span>
                                </div>
                    
                                <button type="submit" value="submit" class="form-submit">Đăng nhập</button>
                                
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
                            <form action="" method="POST" class="form-register" id="form-register">
                                <h3 class="heading">Đăng ký</h3>
                                <p class="description">Welcome to Vergency</p>
                    
                                <div class="spacer"></div>
                    
                                <div class="form-group">
                                    <input type="text" name="username" class="form-control email" placeholder=" ">
                                    <label for="username" class="form-label">Email</label>
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

    <div id="menu-mobile">
        <div class="account-mobile">
            <div class="avatar-mobile">
                <i class="fa-regular fa-circle-user"></i>
            </div>
            <div class="account-text">
                <div class="account-login">Login</div>
                <div class="account-register">Register</div>
            </div>
        </div>
        <ul class="menu-mobile">
            <li class="menu-mobile__item">
                <a href="#" class="menu-mobile__link">Home</a>
            </li>
            <li class="menu-mobile__item">
                <a href="#" class="menu-mobile__link">
                    Shop
                    <i class="fa-solid fa-chevron-down"></i>
                </a>
                <ul class="list-product">
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">T-SHIRTS</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">SHIRTS</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">SWEATERS</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">HOODIES</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">SHORTS</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">BAGS</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">PERFUME</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">JACKET</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">ACCESSORIES</a>
                    </li>
                    <li class="menu__product">
                        <a href="#" class="menu__product-link">POLO</a>
                    </li>
                </ul>
            </li>
            <li class="menu-mobile__item">
                <a href="#" class="menu-mobile__link">Blog</a>
            </li>
            <li class="menu-mobile__item">
                <a href="#" class="menu-mobile__link">Contact</a>
            </li>
            <li class="menu-mobile__item">
                <a href="#" class="menu-mobile__link">About</a>
            </li>
            <li class="menu-mobile__item">
                <a href="#" class="menu-mobile__link">Group</a>
            </li>
            <li class="menu-mobile__item">
                <a href="#" class="menu-mobile__link">Instagram</a>
            </li>
        </ul>
    </div>

    <!-- <script src="${url}/js/app.js"></script> -->
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