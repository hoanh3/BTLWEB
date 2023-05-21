// let func = function () {
//     let totalPriceCheckout = Number(document.querySelector(".total-price").textContent.trim().slice(0, -5));
//     let productItem = document.querySelectorAll(".cart-product__item");
//     for (let i = 0; i < productItem.length; i++) {
//         let plusBtn = productItem[i].querySelector(".quantity-select .plus-btn");
//         let minusBtn = productItem[i].querySelector(".quantity-select .minus-btn");
//         let amount = productItem[i].querySelector(".quantity-select .amount");
//         let amountValue = productItem[i].querySelector(".amount").textContent.trim();
//         plusBtn.addEventListener("click", function (e) {
//             // update quantity
//             e.preventDefault();
//             amountValue++;
//             amount.innerHTML = amountValue;
//             // update total price one product
//             let priceOneProduct = productItem[i].querySelector(".price-item span").textContent.trim();
//             let totalPrice = amountValue * Number(priceOneProduct.slice(0, -5));
//             productItem[i].querySelector(".total-price__item").innerHTML = totalPrice + ".000đ";
//             // update total price all product
//             totalPriceCheckout += Number(priceOneProduct.slice(0, -5));
//             document.querySelector(".total-price").innerHTML = totalPriceCheckout + ".000đ";
//         });
//         minusBtn.addEventListener("click", function (e) {
//             // update quantity
//             e.preventDefault();
//             if (amountValue > 1) {
//                 amountValue--;
//                 amount.innerHTML = amountValue;
//                 // update total price one product
//                 let priceOneProduct = productItem[i].querySelector(".price-item span").textContent.trim();
//                 let totalPrice = amountValue * Number(priceOneProduct.slice(0, -5));
//                 productItem[i].querySelector(".total-price__item").innerHTML = totalPrice + ".000đ";
//                 // update total price all product
//                 totalPriceCheckout -= Number(priceOneProduct.slice(0, -5));
//                 document.querySelector(".total-price").innerHTML = totalPriceCheckout + ".000đ";
//             }
//         });
//     }
// }

async function render(url = "") {
    const data = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    });
    let response = await data.json();

    console.log(response);

    let total_price = 0;
    let stringHTML = await response.map((product) => {
        total_price += product.product.discount * product.num;
        let price = partition((product.product.discount * product.num).toString()).join(".");
        return `
            <div class="cart-product__item">
                <div class="cart-product__img">
                    <a href="product.html" class="cart-product__link">
                        <img src="${product.product.thumbnail}" alt="">
                    </a>
                </div>
                <div class="cart-product__info">
                    <a href="product.html" class="cart-product__link">
                        <strong class="cart-product__name">${product.product.title}</strong>
                        <span class="cart-product__size">${product.size}</span>
                    </a>
                    <p class="price-item">
                        <span>${product.product.discount / 1000}.000đ</span>
                        <del>(${product.product.price / 1000}.000đ)</del>
                    </p>
                    <div class="quantity-select">
                        <button class="minus-btn" onclick='reduceItem(${JSON.stringify(product)})'>
                            <i class="fa-solid fa-minus"></i>
                        </button>
                        <p class="amount" min-data="1">${product.num}</p>
                        <button class="plus-btn" onclick='increaseItem(${JSON.stringify(product)})'>
                            <i class="fa-solid fa-plus"></i>
                        </button>
                    </div>
                    <p class="total-price__item">${price}đ</p>
                </div>
                <div class="cart-product__remove">
                    <a href="#" class="remove-item" onclick='removeItem(${JSON.stringify(product)})'>Xóa sản phẩm</a>
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
                <h3>Ghi chú đơn hàng</h3>
                <div class="checkout-note">
                    <textarea id="box-note" rows="5" placeholder="Ghi chú:"></textarea>
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
    console.log("response:", response);
    return response.json();
}

function reduceItem(product) {
    let amount = document.querySelector(".amount").getAttribute("min-data");
    if (amount == product.quantity) return;

    let productId = product.product.id;
    let userId = document.getElementById("user-id").value;
    let size = product.size;
    let quantity = product.num - 1;
    let data = { pid: productId, uid: userId, num: quantity, size: size };
    console.log({ data });
    putItem("http://localhost:8080/btlweb/cart", data);
    location.reload();
    // let url = `http://localhost:8080/btlweb/cart?uid=${userId}`;
    // render(url);
}

function increaseItem(product) {
    let productId = product.product.id;
    let userId = document.getElementById("user-id").value;
    let size = product.size;
    let quantity = product.num + 1;
    let data = { pid: productId, uid: userId, num: quantity, size: size };
    console.log({ data });
    putItem("http://localhost:8080/btlweb/cart", data);
    location.reload();
    // let url = `http://localhost:8080/btlweb/cart?uid=${userId}`;
    // render(url);
}

function removeItem(product) {
    console.log(product);
}

function start() {
    getItemCart();
}

start();