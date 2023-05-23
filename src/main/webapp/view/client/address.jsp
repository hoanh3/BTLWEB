<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/client/assets" var="url" />
        <!-- header begin -->
            <jsp:include page="./header/mainHeader.jsp" flush="true" />
        <!-- header end -->

        
        <main class="account-main">
            <div class="grid wide">
                <div class="row">
                    <div class="col l-12 m-12 c-12">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="${pageContext.request.contextPath}/account">Tài khoản</a></li>
                            <li><i class="fa-solid fa-angle-right"></i></li>
                            <li><a href="#">Địa chỉ</a></li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col l-12 m-12 c-12">
                        <div class="account-header">
                            <h2 class="header-title">Thông tin địa chỉ</h2>
                            <a href="" class="logout">
                                <i class="fa-solid fa-circle-plus"></i>
                                <span>Nhập địa chỉ mới</span>
                            </a>
                        </div>
                    </div>
                    <div class="col l-9 m-12 c-12">
                        <div class="row">
                            <div class="col l-6 m-12 c-12">
                                <div class="user-box view-address address-default">
                                    <p class="user-name">
                                        <span>Họ tên:</span>
                                        <span>${user.lastName} ${user.firstName}</span>
                                    </p>
                                    <p class="user-email">
                                        <span>Email:</span>
                                        <span>${user.email}</span>
                                    </p>
                                    <p class="user-address">
                                        <span>Địa chỉ:</span>
                                        <span>${user.streetAddress}, ${user.district}, ${user.city}</span>
                                    </p>
                                    <p class="user-phone">
                                        <span>Điện thoại:</span>
                                        <span>${user.phoneNumber}</span>
                                    </p>
                                    <div class="address-actions">
                                        <div class="edit-btn" id="edit-btn">Sửa</div>
                                        <div class="delete-btn">Xóa</div>
                                    </div>
                                </div>
                                <div class="user-box edit-address" style="display: none;">
                                    <form action="" class="new-address">
                                        <div class="form-group">
                                            <input type="text" name="last-name" class="form-control" placeholder=" " value="${user.lastName}"/>
                                            <label for="last-name" class="form-label">Họ</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="first-name" class="form-control" placeholder=" " value="${user.firstName}"/>
                                            <label for="first-name" class="form-label">Tên</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="email" class="form-control" placeholder=" " value="${user.email}"/>
                                            <label for="email" class="form-label">Email</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="phone-number" class="form-control" placeholder=" " value="${user.phoneNumber}"/>
                                            <label for="phone-number" class="form-label">Điện thoại</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="street-address" class="form-control" placeholder=" " value="${user.streetAddress}"/>
                                            <label for="street-address" class="form-label">Phường/Xã</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="district" class="form-control" placeholder=" " value="${user.district}"/>
                                            <label for="district" class="form-label">Quận/Huyện</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="city" class="form-control" placeholder=" " value="${user.city}"/>
                                            <label for="city" class="form-label">Tỉnh/Thành Phố</label>
                                        </div>
                                        <div class="form-group vertical-input">
                                            <input type="checkbox" name="" id="address-default" />
                                            <span>Đặt làm địa chỉ mặc định</span>
                                        </div>
                                        <div class="form-submit">
                                            <button type="submit" class="submit-btn" id="update-btn">Cập nhật</button>
                                            <a href="#" class="submit-btn" id="cancel-btn" style="text-decoration: none;">Hủy</a>
                                        </div>
                                    </form>
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
    <jsp:include page="./menu/menu.jsp" flush="true" />
    <!-- menu end -->

    <div class="back-to-top">
        <button><i class="fa-solid fa-chevron-up"></i></button>
    </div>

    <div class="hotline">
        <a href="#"><i class="fa-sharp fa-solid fa-phone"></i></a>
    </div>

    <script>
        var cancelBtn = document.getElementById("cancel-btn");
        cancelBtn.onclick = function() {
            document.querySelector(".user-box.view-address").style.display = "block";
            document.querySelector(".user-box.edit-address").style.display = "none";
        }

        var cancelBtn = document.getElementById("edit-btn");
        cancelBtn.onclick = function() {
            document.querySelector(".user-box.view-address.address-default").style.display = "none";
            document.querySelector(".user-box.edit-address").style.display = "block";
        }
    </script>
    <script src="${url}/js/address.js"></script>
    <script src="${url}/js/context.js"></script>
</body>
</html>