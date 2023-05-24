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
                <a href="#">Thêm sản phẩm</a>
                <table id="render">
                    <!-- <tr>
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
                    </tr> -->
                </table>
            </div>
        </div>
    </div>
    <!-- modal layout -->
    <div class="modal">
        <div class="modal-overlay"></div>
        <div class="modal-body">
            <i class="close-icon fa-solid fa-xmark"></i>
            <div class="modal-title">
                <h1>Thêm sản phẩm</h1>
            </div>
            <div class="modal-content">
                <div class="wrapper">
                    <form action="#" id="form-input">
                        <div class="form-group">
                            <label class="id" for="input-0">ID:</label>
                            <input type="text" readonly="readonly" class="form-control" id="input-0" name="input-0" value="1"/>
                        </div>
                        <div class="form-group">
                            <label class="id">Title:</label>
                            <input type="text" placeholder="Title" class="form-control" id="input-1" name="input-1"/>
                        </div>
                        <div class="form-group">
                            <label class="username">Category:</label>
                            <select class="form-control" id="input-2" name="input-2">
                                <c:forEach items="${categories}" var="cate">
                                    <option value="${cate.id}">${cate.title}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="name">Price</label>
                            <input type="text" placeholder="Price" class="form-control" id="input-3" name="input-3"/>
                        </div>
                        <div class="form-group">
                            <label class="name">Discount:</label>
                            <input type="text" placeholder="Discount" class="form-control" id="input-4" name="input-4"/>
                        </div>
                        
                        <div class="form-group">
                            <label class="name">Avaiability:</label>
                            <input type="text" placeholder="Avaiability" class="form-control" id="input-9" name="input-9"/>
                        </div>
                        <div class="form-group">
                            <label class="name">Size:</label>
                            <select class="form-control" id="input-5" name="input-5">
                                <option value="1">S</option>
                                <option value="2">M</option>
                                <option value="3">L</option>
                                <option value="4">XL</option>
                            </select>
                        </div>
                        <!-- <div class="form-group">
                            <label class="Password">Date:</label>
                            <input type="date" class="form-control" id="input-6" name="input-6"/>
                        </div> -->
                        <div class="form-group">
                            <label class="name">Description</label>
                            <textarea cols="10" rows="5" class="form-control" id="input-7" name="input-7" placeholder="Description"></textarea>
                        </div>
                        <div class="form-group">
                            <div class="box-thumb">
                                <label class="input-8" for="">Thumbnail</label>
                                <input type="file" multiple="multiple" class="file form-control" id="input-8" name="input-8"/>
                                <img src="" alt="" class="preview-img">
                            </div>
                        </div>
                        <button class="Add" type="submit" id="add-btn">Thêm</button>
                        <button class="Add" type="submit" id="update-btn">Cập nhật</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="${url}/js/app.js"></script>
    <script src="${url}/js/modal.js"></script>
    <script src="${url}/js/product.js"></script>
</body>
</html>