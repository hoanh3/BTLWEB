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
            <div class="container">
                <div class="box">
                    <div class="card">
                        <div class="card-body">
                            <div class="top">
                                <h4 class="card-title">Đơn hàng</h4>
                            </div>
                            <div class="middle">
                                <div class="middle-wrapper">
                                    <i class="fa-solid fa-arrow-up"></i>
                                    <span id="number-of-order">100</span>
                                </div>
                                <span class="text">Theo tuần</span>
                            </div>
                            <div class="bottom">
                                <span>80%</span>
                                <div class="progress">
                                    <div class="progress-bar" style="width: 80%; height: 6px"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="top">
                                <h4 class="card-title">Lợi nhuận</h4>
                            </div>
                            <div class="middle">
                                <div class="middle-wrapper">
                                    <i class="fa-solid fa-arrow-up"></i>
                                    <span id="revenue">1.200.000đ</span>
                                </div>
                                <span class="text">Theo tuần</span>
                            </div>
                            <div class="bottom">
                                <span>2.6%</span>
                                <div class="progress">
                                    <div class="progress-bar" style="width: 60%; height: 6px"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <canvas id="myChart" style="width: 100%; max-width: 600px; height: auto"></canvas>
            </div>
        </div>
    </div>

    <script>
        async function getStatistical(path) {
            let option = {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                },
            };
            let data = await fetch(path, option);
            let response = await data.json();
            return response;
        }

        async function getChart() {
            var orders = document.getElementById("number-of-order");
            var revenue = document.getElementById("revenue");
            var xValues = [];
            var yValues = [];
            var barColors = ["#ffa8ab", "#00aba9", "#2b5797", "#e8c3b9", "#FD5F32"];

            var thongke = await getStatistical("http://localhost:8080/btlweb/order?mode=thongke");

            console.log(thongke);
            orders.innerHTML = thongke.numberOfOrder;
            revenue.innerHTML = thongke.revenue;

            thongke.list.forEach(cate => {
                xValues.push(cate.title);
                yValues.push(cate.num);
            });

            new Chart("myChart", {
                type: "doughnut",
                data: {
                    labels: xValues,
                    datasets: [
                        {
                            backgroundColor: barColors,
                            data: yValues,
                        },
                    ],
                },
                options: {
                    title: {
                        display: true,
                        text: "Danh mục bán chạy",
                    },
                },
            });
        }
        getChart();
    </script>
</body>
</html>