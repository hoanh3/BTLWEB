var PATHAPI = "http://localhost:8080/btlweb/order";

async function putData(url = "", data = {}) {
    const response = await fetch(url, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });
    return response.json();
}

async function deleteData(url = "", data = {}) {
    const response = await fetch(url, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        }
    });
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

    const product_html = await response.map((order) => {
        return `
        <tr>
                        <td>${order.lastName} ${order.firstName}</th>
                        <td>${order.email}</th>
                        <td>${order.phoneNumber}</th>
                        <td>${order.streetAddress}, ${order.district}, ${order.city}</th>
                        <td>${order.orderDate}</th>
                        <td>${order.totalMoney}</th>
                        <td>${order.status == 0 ? "Chờ xác nhận" : "Đang giao hàng"}</th>
                        
                        <td class="action">
                            <button class="act-btn edit-btn" onclick = 'showModal(${JSON.stringify(order)})'>Xem</button> 
                            <button class="act-btn accept-btn" onclick= 'confirm(${order.id})'>Xác nhận</button>
                            <button class="act-btn delete-btn" onclick = 'deleteOrder(${order.id})'>Xóa</button>
                        </td>
                    </tr>
        `;
    });
    product_html.unshift(`<tr>
                        <th>Tên</th>
                        <th>Email</th>
                        <th>SĐT</th>
                        <th>Địa chỉ</th>
                        <th>Ngày đặt</th>
                        <th>Tổng tiền</th>
                        <th>Trạng thái</th>
                        <th>Hành động</th>
                    </tr>`);
    document.querySelector(".content #render-order").innerHTML = await product_html.join("");
}

async function getOrderDetail(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();

    const product_html = await response.map((detail) => {
        return `
        <div class="info-wrapper">
            <div class="product-img">
                <img src="${detail.thumnailProduct}" alt="">
            </div>
            <div class="product-detail">
                <div class="title">${detail.productName}</div>
                <div class="price">
                    <span>${detail.discount}đ</span>
                    <span>${detail.price}đ</span>
                </div>
                <div class="size">Kích thước: ${detail.sizeName}</div>
                <div class="quantity">Số lượng: ${detail.num}</div>
            </div>
        </div>
        `;
    });
    document.querySelector(".modal-content .product-info").innerHTML = await product_html.join("");
}

function confirm(oid) {
    // console.log(oid);
    putData(`${PATHAPI}/${oid}`);
    window.location.reload();
}

function deleteOrder(oid) {
    // console.log(oid);
    deleteData(`${PATHAPI}/${oid}`);
    window.location.reload();

}

function showModal(order) {
    const modal = document.querySelector(".modal");
	modal.classList.add("open");
    

    getOrderDetail(`${PATHAPI}/${order.id}`);

    modal.querySelector(".user-name span").innerHTML = `${order.lastName} ${order.firstName}`;
    modal.querySelector(".email span").innerHTML = `${order.email}`;
    modal.querySelector(".phone span").innerHTML = `${order.phoneNumber}`;
    modal.querySelector(".note").innerHTML = `${order.note}`;
    modal.querySelector(".address span:nth-child(1)").innerHTML = `${order.streetAddress}`;
    modal.querySelector(".address span:nth-child(2)").innerHTML = `${order.district}`;
    modal.querySelector(".address span:nth-child(3)").innerHTML = `${order.city}`;
    
}



async function addEvenClick() {
    await getOrders(PATHAPI);
    modalEvent();
}

window.onload = function() {
	addEvenClick();
    activeNav();
}