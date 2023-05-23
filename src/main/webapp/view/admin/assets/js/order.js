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
                        
                        <td class="action">
                            <button class="act-btn edit-btn" onclick='showModal(${JSON.stringify(order)})'>Xem</button> 
                            <button class="act-btn accept-btn" >Xác nhận</button>
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

async function getOrderDetail(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();
    console.log({ response });

    const product_html = await response.map((detail) => {
        return `
        <div class="product-info">
            <div class="product-img">
                <img src="${detail.thumnailProduct}" alt="">
            </div>
            <div class="product-detail">
                <div class="title">${detail.productName}</div>
                <div class="price">
                    <span>${detail.discount}đ</span>
                    <span>${detail.price}đ</span>
                </div>
                <div class="more">
                    <span>${detail.num}</span>,
                    <span>${detail.sizeName}</span>
                </div>
            </div>
        </div>
        `;
    });
    document.querySelector(".modal-content .wrap-product").innerHTML = await product_html.join("");
}



function showModal(order) {
    const modalBody = document.querySelector(".modal-body");
    const closeBtn = document.querySelector(".close-icon");
    const modal = document.querySelector(".modal");
    
    console.log(order);

    getOrderDetail(`http://localhost:8947/btlweb/order/${order.id}`);

    modal.querySelector(".user-name span").innerHTML = `${order.lastName} ${order.firstName}`;
    modal.querySelector(".email span").innerHTML = `${order.email}`;
    modal.querySelector(".phone span").innerHTML = `${order.phoneNumber}`;
    modal.querySelector(".address span:nth-child(1)").innerHTML = `${order.streetAddress}`;
    modal.querySelector(".address span:nth-child(2)").innerHTML = `${order.district}`;
    modal.querySelector(".address span:nth-child(3)").innerHTML = `${order.city}`;
    
	modal.classList.add("open");
    closeBtn.onclick = () => {
	    hideModal();
	};
	
	modal.onclick = () => {
	    hideModal();
	};
	
	modalBody.onclick = (e) => {
	    e.stopPropagation();
	};
	
	function hideModal() {
	    modal.classList.remove("open");
	}
}

window.onload = function() {
	getOrders(PATHAPI);
    activeNav();
}