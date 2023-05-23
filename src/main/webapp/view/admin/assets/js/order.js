var PATHAPI = "http://localhost:8080/btlweb/order";

async function deleteData(url = "", data = {}) {
    const response = await fetch(url, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        }
    });
    console.log("response:", response);
    return response.json();
}

async function getOrders(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();
    console.log({ response });

    const product_html = await response.map((order) => {
        return `
        <tr>
                        <td>${order.id}</th>
                        <td>${order.userId}</th>
                        <td>${order.lastName}</th>
                        <td>${order.firstName}</th>
                        <td>${order.email}</th>
                        <td>${order.phoneNumber}</th>
                        <td>${order.city}</th>
                        <td>${order.district}</th>
                        <td>${order.streetAddress}</th>
                        <td>${order.note == undefined ? "" : order.note}...</th>
                        <td>${order.orderDate}</th>
                        <td>${order.totalMoney}</th>
                        <td>${order.status}</th>
                        <td>
                            <button class="act-btn edit-btn" >Xem chi tiết</button> 
                            <button class="act-btn delete-btn" >Xóa</button>
                        </td>
                    </tr>
        `;
    });
    product_html.unshift(`<tr>
                        <th>ID</th>
                        <th>Tài khoản user</th>
                        <th>Họ</th>
                        <th>Tên</th>
                        <th>Email</th>
                        <th>Sđt</th>
                        <th>Tỉnh/Thành phố</th>
                        <th>Quân/Huyện</th>
                        <th>Phường/Đường/Xã</th>
                        <th>Ghi chú</th>
                        <th>Ngày đặt</th>
                        <th>Tổng tiền</th>
                        <th>Trạng thái</th>
                        <th>Hành động</th>
                    </tr>`);
    document.querySelector(".content #render").innerHTML = await product_html.join("");
}

window.onload = function() {
	getOrders(PATHAPI);
    activeNav();
}