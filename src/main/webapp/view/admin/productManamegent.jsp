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
                        <th class="product-name">Tên sản phẩm</th>
                        <th class="product-desc">Mô tả</th>
                        <th>Thumbnail</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Discount</th>
                        <th class="product-size">Size</th>
                        <th>Amount</th>
                        <th>Action</th>
                    </tr>
                    <tr>
                        <td>1</th>
                        <td class="product-name">Simple T-Shirt/Pink</th>
                        <td class="product-desc">Thông tin sản phẩm:\n\n SWEATER SWEATER/YELLOW\n\n HOẠ TIẾT: IN LỤA U.S.A INK\n\n
                            COLOR: BLACK / WHITE / DARK GREEN / DARK BROW / DARK GREY / RED\n\n SIZE: M / L / XL\n\n MATERIAL: PREMIUM COTTON."
                        </th>
                        <td>
                            <!-- <img src="./assets/images/bg-shop.jpg" alt="" height="60px" width="60px"> -->
                        </th>
                        <td>T-SHIRTS</th>
                        <td>300.000đ</th>
                        <td>889.000đ</th>
                        <td class="product-size">S</th>
                        <td>100</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</th>
                        <td class="product-name">Simple T-Shirt/Baby Blue</th>
                        <td class="product-desc">Tran Hoan</th>
                        <td>Tran Hoan</th>
                        <td>T-SHIRTS</th>
                        <td>300.000đ</th>
                        <td>889.000đ</th>
                        <td class="product-size">S</th>
                        <td>100</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>3</th>
                        <td class="product-name">Simple T-Shirt/Beige</th>
                        <td class="product-desc">Tran Hoan</th>
                        <td>Tran Hoan</th>
                        <td>T-SHIRTS</th>
                        <td>300.000đ</th>
                        <td>89.000đ</th>
                        <td class="product-size">L</th>
                        <td>100</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>4</th>
                        <td class="product-name">SWEATER SWEATER-YELLOW</th>
                        <td class="product-desc">Tran Hoan</th>
                        <td>Tran Hoan</th>
                        <td>SWEATERS</th>
                        <td>560.000đ</th>
                        <td>159.000đ</th>
                        <td class="product-size">L</th>
                        <td>170</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>5</th>
                        <td class="product-name">SKATEBOARDING T-SHIRT/DARK GREY</th>
                        <td class="product-desc">Tran Hoan</th>
                        <td>Tran Hoan</th>
                        <td>T-SHIRTS</th>
                        <td>300.000đ</th>
                        <td>89.000đ</th>
                        <td class="product-size">L</th>
                        <td>99</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>6</th>
                        <td class="product-name">SKATEBOARDING T-SHIRT/DARK GREY</th>
                        <td class="product-desc">Tran Hoan</th>
                        <td>Tran Hoan</th>
                        <td>T-SHIRTS</th>
                        <td>300.000đ</th>
                        <td>89.000đ</th>
                        <td class="product-size">L</th>
                        <td>99</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>7</th>
                        <td class="product-name">SKATEBOARDING T-SHIRT/DARK GREY</th>
                        <td class="product-desc">Tran Hoan</th>
                        <td>Tran Hoan</th>
                        <td>T-SHIRTS</th>
                        <td>300.000đ</th>
                        <td>89.000đ</th>
                        <td class="product-size">L</th>
                        <td>99</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>8</th>
                        <td class="product-name">SKATEBOARDING T-SHIRT/DARK GREY</th>
                        <td class="product-desc">Tran Hoan</th>
                        <td>Tran Hoan</th>
                        <td>T-SHIRTS</th>
                        <td>300.000đ</th>
                        <td>89.000đ</th>
                        <td class="product-size">L</th>
                        <td>99</th>
                        <td>
                            <button class="act-btn edit-btn" >Sửa</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
                </table>
                <a href="#open">Thêm sản phẩm</a>
            </div>
        </div>
    </div>
    <!-- modal layout -->
    <div class="modal" id="open">
        <a href="#" class="close"></a>
        <div class="modal-overlay" class=""></div>
        <div class="modal-body">
            <div class="modal-inner">
                <div class="admin-title">
                <h1>Thêm Product</h1>
                </div>
                <div class="form-group">
                    <label class="id">Title:</label>
                    <input type="text" placeholder="Title" class="form-control" />
                </div>
                <div class="form-group">
                    <label class="username">Category:</label>
                    <input type="text" placeholder="Category" class="form-control" />
                </div>
                <div class="form-group">
                    <label class="name">Price</label>
                    <input type="text" placeholder="Price" class="form-control" />
                </div>
                <div class="form-group">
                    <label class="name">Discount:</label>
                    <input type="text" placeholder="Discount" class="form-control" />
                </div>
                <div class="form-group">
                    <label class="name">Size:</label>
                    <select class="form-control">
                        <option value="1">S</option>
                        <option value="2">M</option>
                        <option value="3">L</option>
                        <option value="4">XL</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="Password">Date:</label>
                    <input type="date" class="form-control" />
                </div>
                <div class="form-group">
                    <label class="name">Description</label>
                    <textarea cols="10" rows="5" class="form-control" placeholder="Description"></textarea>
                </div>
                <div class="form-group">
                    <label class="name">Thumbnail</label>
                    <input type="file" multiple="multiple" class="file form-control" />
                </div>

                <button class="Add" onclick="add()">Thêm</button>
            </div>
        </div>
    </div>
</body>
</html>