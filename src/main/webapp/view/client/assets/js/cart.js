const sizeName = ["S", "M", "L"];

async function getAvailable(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            Origin: "http://127.0.0.1:5500/",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();
    console.log({ response });
    return response;
}

var PATHAPI = "http://localhost:8080/btlweb/cart";

async function render(url = "") {
    const data = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    });
    let response = await data.json();


    let total_price = 0;
    let stringHTML = await response.map((product) => {
        total_price += product.product.discount * product.num;
        let price = partition((product.product.discount * product.num).toString()).join(".");
        return `
            <div class="cart-product__item">
                <div class="cart-product__img">
                    <a href="${window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2))}/product-detail?pid=${product.product.id}" class="cart-product__link">
                        <img src="${product.product.thumbnail}" alt="">
                    </a>
                </div>
                <div class="cart-product__info">
                    <a href="${window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2))}/product-detail?pid=${product.product.id}" class="cart-product__link">
                        <strong class="cart-product__name">${product.product.title}</strong>
                        <span class="cart-product__size">${sizeName[product.size - 1]}</span>
                    </a>
                    <p class="price-item">
                        <span>${product.product.discount / 1000}.000đ</span>
                        <del>(${product.product.price / 1000}.000đ)</del>
                    </p>
                    <div class="quantity-select">
                        <button class="minus-btn" onclick='reduceItem(${JSON.stringify(product)})'>
                            <i class="fa-solid fa-minus"></i>
                        </button>
                        <p class="amount" max-data="1">${product.num}</p>
                        <button class="plus-btn" onclick='increaseItem(${JSON.stringify(product)})'>
                            <i class="fa-solid fa-plus"></i>
                        </button>
                    </div>
                    <p class="total-price__item">${price}đ</p>
                </div>
                <div class="cart-product__remove">
                    <button class="remove-item" onclick='removeItem(${JSON.stringify(product)})'>Xóa sản phẩm.</button>
                </div>
            </div>
        `;
    });

    if (stringHTML.length == 0) {
        document.querySelector(".head-title-cart").style.display = "none";
        document.querySelector(
            ".form-cart"
        ).innerHTML = `<h1 style="font-size: 3rem; margin-top: 50px; font-weight: 500;">Giỏ hàng của bạn đang trống</h1>`;
    } else {
        document.querySelector(".head-title-cart").style.display = "block";
        document.querySelector(".form-cart").innerHTML = stringHTML.join("");
        document.querySelector(".side-box-group").innerHTML = `
                <div class="continue-shopping">
                    <div class="continue-shopping--btn">
                        <a href="/shop">Tiếp tục mua sản phẩm khác</a>
                    </div>
                </div>
            `;
    }

    let priceStr = total_price.toString();
    function partition(str) {
        str = str.split("").reverse().join("");
        let val = [];
        for (let i = 0; i < str.length; i += 3) {
            val.push(str.substr(i, 3));
        }
        for (let i = 0; i < val.length; i++) {
            // console.log(typeof val[i]);
            val[i] = val[i].split("").reverse().join("");
        }
        return val.reverse();
    }
    document.querySelector(".right-cart .total-price").innerHTML = partition(priceStr).join(".") + "đ";
}

function getItemCart() {
    let userId = document.getElementById("user-id").value;
    let url = `http://localhost:8080/btlweb/cart?uid=${userId}`;
    render(url);
}

async function putItem(url = "", data = {}) {
    const response = await fetch(url, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });
    return response.json();
}

async function deleteItem(url = "", data = {}) {
    const response = await fetch(url, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        }
    });
    return response.json();
}

function reduceItem(product) {
    let productId = product.product.id;
    let userId = document.getElementById("user-id").value;
    let size = product.size;
    let quantity = product.num - 1;

    if(quantity <= 0) {
        removeItem(product);
    }

    let data = { pid: productId, uid: userId, num: quantity, size: size };
    putItem("http://localhost:8080/btlweb/cart", data);
    window.location.reload();
}

async function increaseItem(product) {
    const path = `http://localhost:8080/btlweb/avai?pid=${product.product.id}&sid=${product.size}`;
    let available = await getAvailable(path);
    let amount = available.avai;
    console.log(available);
    console.log(amount);
    
    let productId = product.product.id;
    let userId = document.getElementById("user-id").value;
    let size = product.size;
    let quantity = Math.min(amount, product.num + 1);

    let data = { pid: productId, uid: userId, num: quantity, size: size };
    putItem("http://localhost:8080/btlweb/cart", data);
    window.location.reload();
}

function removeItem(product) {
    deleteItem(PATHAPI + `/${product.id}`);
    window.location.reload();
}

const formCart = document.getElementById("form-cart");
formCart.addEventListener("submit", function (e) {
	e.preventDefault()();
})

function start() {
    getItemCart();
}

start();