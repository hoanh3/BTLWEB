<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Vergency</title>
        <link rel="icon" href="${url}/images/icons8-v-16.png" type="image/x-icon" />
        <!-- <link rel="stylesheet" href="${url}/font/fontawesome-free-6.3.0/css/all.min.css"> -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
        <link rel="stylesheet" href="${url}/css/main.css" />
        <link rel="stylesheet" href="${url}/css/checkout.css" />
        <link rel="stylesheet" href="${url}/css/base.css" />
        <link rel="stylesheet" href="${url}/css/responsive.css" />
        <link rel="stylesheet" href="${url}/css/grid.css" />
    </head>
    <body>
        <div class="app">
            <div class="grid wide">
                <div class="app-wrap">
                    <div class="banner">
                        <a href="${pageContext.request.contextPath}/home" class="logo">
                            <h1 class="logo-text">Vergency</h1>
                        </a>
                    </div>
                    <div class="toggle-order">
                        <div class="toggle-wrap">
                            <div class="toggle-icon">
                                <i class="fa-sharp fa-solid fa-cart-shopping"></i>
                            </div>
                            <div class="toggle-text-show active">
                                <span>Hiển thị thông tin đơn hàng</span>
                                <i class="fa-solid fa-chevron-down"></i>
                            </div>
                            <div class="toggle-text-hide">
                                <span>Ẩn thông tin đơn hàng</span>
                                <i class="fa-solid fa-chevron-up"></i>
                            </div>
                            <div class="toggle-total-recap">
                                <span class="final-price">271.000đ</span>
                            </div>
                        </div>
                    </div>
                    <div class="input-discount-mobile display">
                        <div class="section-discount">
                            <div class="form-group form-discount">
                                <input type="text" name="" class="form-control" placeholder="Mã giảm giá" />
                                <button class="discount-submit">Sử dụng</button>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar">
                        <div class="section-order">
                            <table class="product-table">
                                <tbody>
                                    <tr class="product">
                                        <td class="product-img">
                                            <div class="product-thumbnail">
                                                <img
                                                    src="${url}/images/products/product1.png"
                                                    alt=""
                                                    class="product-thumb-img"
                                                />
                                            </div>
                                            <span class="product-quantity">1</span>
                                        </td>
                                        <td class="product-description">
                                            <span class="product-name">DISSOLVE 3D T-SHIRT/RED</span>
                                            <span class="product-size">L</span>
                                        </td>
                                        <td class="product-price">59.000đ</td>
                                    </tr>
                                    <tr class="product">
                                        <td class="product-img">
                                            <div class="product-thumbnail">
                                                <img
                                                    src="${url}/images/products/product2.png"
                                                    alt=""
                                                    class="product-thumb-img"
                                                />
                                            </div>
                                            <span class="product-quantity">2</span>
                                        </td>
                                        <td class="product-description">
                                            <span class="product-name">DISSOLVE 3D T-SHIRT/DARK GREY</span>
                                            <span class="product-size">L</span>
                                        </td>
                                        <td class="product-price">118.000đ</td>
                                    </tr>
                                    <tr class="product">
                                        <td class="product-img">
                                            <div class="product-thumbnail">
                                                <img
                                                    src="${url}/images/products/product3.png"
                                                    alt=""
                                                    class="product-thumb-img"
                                                />
                                            </div>
                                            <span class="product-quantity">1</span>
                                        </td>
                                        <td class="product-description">
                                            <span class="product-name">DISSOLVE 3D T-SHIRT/DARK BROW</span>
                                            <span class="product-size">L</span>
                                        </td>
                                        <td class="product-price">59.000đ</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="section-discount">
                            <div class="form-group form-discount">
                                <input type="text" name="" class="form-control" placeholder="Mã giảm giá" />
                                <button class="discount-submit">Sử dụng</button>
                            </div>
                        </div>
                        <div class="section-total-price">
                            <div class="total-subtotal">
                                <span class="title">Tạm tính</span>
                                <span class="price">236.000đ</span>
                            </div>
                            <div class="total-shipping">
                                <span class="title">Phí vận chuyện</span>
                                <span class="price">35.000đ</span>
                            </div>
                            <div class="total-price">
                                <span class="title">Tổng tiền</span>
                                <span class="price">
                                    <span>VND</span>
                                    <span>271.000đ</span>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="main">
                        <div class="main-header">
                            <a href="${pageContext.request.contextPath}/home" class="logo">
                                <h1 class="logo-text">Vergency</h1>
                            </a>
                            <ul class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/cart-view">Giỏ hàng</a></li>
                                <li><i class="fa-solid fa-angle-right"></i></li>
                                <li><a href="#">Thông tin giao hàng</a></li>
                            </ul>
                        </div>

                        <div class="main-content">
                            <section class="section">
                                <div class="section-header">
                                    <h2 class="section-title">Thông tin giao hàng</h2>
                                </div>
                                <div class="section-content">
                                    <p class="section-text">
                                        Bạn đã có tài khoản?
                                        <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                                    </p>
                                    <div class="section-info">
                                        <form action="" method="POST" class="form-info" id="form-info">
                                            <div class="form-group">
                                                <input
                                                    type="text"
                                                    name="username"
                                                    class="form-control"
                                                    placeholder=" "
                                                />
                                                <label for="username" class="form-label">Họ và tên</label>
                                                <span class="form-message"></span>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" name="email" class="form-control" placeholder=" " />
                                                <label for="email" class="form-label">Email</label>
                                                <span class="form-message"></span>
                                            </div>
                                            <div class="form-group">
                                                <input
                                                    type="text"
                                                    name="phone"
                                                    class="form-control phone"
                                                    placeholder=" "
                                                />
                                                <label for="phone" class="form-label">Số điện thoại</label>
                                                <span class="form-message required"
                                                    >Số điện thoại phải bắt đầu bằng số 0 và bắt buộc đủ 10 số, không
                                                    chứa ký tự đặc biệt và khoảng trắng</span
                                                >
                                            </div>
                                            <div class="wrapper-form">
                                                <div class="form-group">
                                                    <input
                                                        type="text"
                                                        name="address"
                                                        class="form-control address1"
                                                        placeholder=" "
                                                    />
                                                    <label for="address" class="form-label">Tỉnh/Thành Phố</label>
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="form-group">
                                                    <input
                                                        type="text"
                                                        name="address"
                                                        class="form-control address2"
                                                        placeholder=" "
                                                    />
                                                    <label for="address" class="form-label">Quận/Huyện</label>
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="form-group">
                                                    <input
                                                        type="text"
                                                        name="address"
                                                        class="form-control address3"
                                                        placeholder=" "
                                                    />
                                                    <label for="address" class="form-label">Phường/Xã</label>
                                                    <span class="form-message"></span>
                                                </div>
                                            </div>
                                        </form>

                                        <div class="section-shipping-rate">
                                            <div class="section-header">
                                                <h2 class="section-title">Phương thức vận chuyển</h2>
                                            </div>
                                            <div class="section-box">
                                                <label for="" class="radio-label">
                                                    <div class="radio-input">
                                                        <input
                                                            type="radio"
                                                            class="input-radio"
                                                            name="shipping-rate"
                                                            id="shipping-rate"
                                                            checked
                                                        />
                                                        <span class="radio-desc">
                                                            Giao hàng tận nơi (thời gian giao hàng dự kiến từ 3 ~ 4
                                                            ngày, có thể lâu hơn vì các vấn đề bất khả kháng, mong Quý
                                                            KH đợi đơn hàng giúp shop. Chân thành cảm ơn)
                                                        </span>
                                                        <span class="shipping-fee">35.000đ</span>
                                                    </div>
                                                </label>
                                            </div>
                                        </div>

                                        <div class="section-payment">
                                            <div class="section-header">
                                                <h2 class="section-title">Phương thức thanh toán</h2>
                                            </div>
                                            <div class="section-box">
                                                <label for="" class="radio-label">
                                                    <div class="radio-input">
                                                        <input
                                                            type="radio"
                                                            class="input-radio"
                                                            name="payment-method"
                                                            id="payment-method"
                                                            checked
                                                        />
                                                        <img
                                                            src="https://hstatic.net/0/0/global/design/seller/image/payment/cod.svg?v=4"
                                                            alt=""
                                                            class="input-img"
                                                        />
                                                        <div class="payment-method">
                                                            <span class="radio-desc">
                                                                Thanh toán khi giao hàng (COD)
                                                            </span>
                                                        </div>
                                                    </div>
                                                </label>
                                                <div class="section-desc">
                                                    1. Khi click vào nút hoàn tất đơn hàng thì đơn hàng sẽ được hệ thống
                                                    tự động xác nhận mà không cần phải gọi qua điện thoại, nếu điền
                                                    thông tin địa chỉ và số điện thoại chính xác thì đơn hàng sẽ được
                                                    vận chuyển từ 3-4-5 ngày tùy vùng miền. 2. Trường hợp đặt hàng xong
                                                    nhưng muốn HỦY ĐƠN, vui lòng soạn tin nhắn theo cú pháp: SĐT ĐÃ ĐẶT
                                                    ĐƠN (hoặc MÃ ĐƠN hoặc GMAIL ĐƠN HÀNG) + TÊN NGƯỜI NHẬN sau đó gửi
                                                    qua các kênh online: Page Facebook, Intagram. Nhân viên check tin
                                                    nhắn sẽ xử lý hủy giúp Quý KH.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="section-footer">
                                    <a href="${pageContext.request.contextPath}/cart-view" class="previous-link">Giỏ hàng</a>
                                    <form action="" method="POST" class="form-submit">
                                        <button class="submit">
                                            <span>Hoàn tất đơn hàng</span>
                                        </button>
                                    </form>
                                </div>
                            </section>
                        </div>

                        <div class="main-footer">Powered by Haravan</div>
                    </div>
                </div>
            </div>
        </div>

        <script src="${url}/JS/validator.js"></script>
        <script>
            let toggleOrder = document.querySelector(".toggle-order");
            toggleOrder.onclick = function () {
                document.querySelector(".toggle-text-show").classList.toggle("active");
                document.querySelector(".toggle-text-hide").classList.toggle("active");
                document.querySelector(".sidebar").classList.toggle("display");
                document.querySelector(".input-discount-mobile").classList.toggle("display");
            };

            Validator({
                form: "#form-info",
                errorSelector: ".form-message",
                rules: [
                    Validator.isPhone(
                        ".phone",
                        "Số điện thoại phải bắt đầu bằng số 0 và bắt buộc đủ 10 số, không chứa ký tự đặc biệt và khoảng trắng"
                    ),
                    Validator.isRequired(".address1"),
                    Validator.isRequired(".address2"),
                    Validator.isRequired(".address3"),
                ],
            });
        </script>
    </body>
</html>
