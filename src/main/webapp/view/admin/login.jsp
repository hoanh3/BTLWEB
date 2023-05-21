<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/view/admin/assets" var="url" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="${url}/img/icons8-v-16.png" type="image/x-icon"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="${url}/css/login/main.css">
    <link rel="stylesheet" href="${url}/css/login/login.css">
    <link rel="stylesheet" href="${url}/css/login/base.css">
    <link rel="stylesheet" href="${url}/css/login/responsive.css">
    <link rel="stylesheet" href="${url}/css/login/grid.css">
</head>
<body>
    <div class="app">

        
        <main class="main">
            <div class="grid wide">
                <div class="row">
                   
                    <div class="col l-12 m-12 c-12">
                        <div class="form form-sign-in">
                            <!-- Form login -->
                            <form action="" method="POST" class="form-login" id="form-login">
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
                    
                                <button type="submit" class="form-submit">Đăng nhập</button>
                                <div class="support">
                                    <a href="${pageContext.request.contextPath}/admin/home">Quay về trang chủ?</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</body>
</html>