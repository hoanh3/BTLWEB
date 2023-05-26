const pathAPI = `${SERVER}/${CONTEXT}`;

let slider = document.getElementsByClassName("slider-item");
let activeImg = document.getElementsByClassName("active");
let prevBtn = document.querySelector(".prev-icon");
let nextBtn = document.querySelector(".next-icon");
let addToCartBtn = document.querySelector(".add-cart-btn");
let buyBtn = document.querySelector(".buy-btn");

for (let i = 0; i < slider.length; i++) {
    slider[i].addEventListener("click", () => {
        if (activeImg != null) {
            activeImg[0].classList.remove("active");
        }
        slider[i].classList.add("active");
        document.querySelector(".big-img img").src = slider[i].querySelector(".slider-img").src;
    });
}

prevBtn.onclick = function () {
    document.querySelector(".product-slider").scrollLeft -= 85 + 6;
};

nextBtn.onclick = function () {
    document.querySelector(".product-slider").scrollLeft += 85 + 6;
};

async function postData(url = "", data = {}) {
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });
    return response.json();
}

async function getRelatedProduct(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();

    const product_html = await response.map((product) => {
        return `
        <li class="item-related">
            <div class="related-img">
                <img src="${
                    product.thumbnail
                }" alt="" />
            </div>
            <div class="related-info">
                <a href="${window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2))}/product-detail?pid=${product.id}" class="related-link">
                    <h3 class="title">${product.title}</h3>
                    <p class="price">
                        <span class="price-new">${product.price / 1000}.000đ</span>
                        <span class="price-old">${product.discount / 1000}.000đ</span>
                    </p>
                </a>
            </div>
        </li>
        `;
    });
    document.querySelector(".product-related .list-related").innerHTML = await product_html.join("");
}

addToCartBtn.onclick = () => {
    let uid = document.getElementById("user-id").value;
    
    if(uid == 0) {
        let message = document.querySelector(".message");
        message.classList.add('open');
        return;
    }

    let size = document.querySelector("input[name=size]:checked");
    let quantity = document.querySelector(".quantity-select .amount");
    // console.log("productId:", dataProduct.id);
    // console.log("userId:", uid);
    // console.log("quantity:", quantity.textContent);
    // console.log("size:", size.value);

    let pid = document.getElementById("product-id").value;

    data = {
        pid: Number(pid),
        uid: Number(uid),
        num: Number(quantity.textContent),
        size: size.value,
    };
    postData(`${pathAPI}/cart`, data);
};

buyBtn.onclick = () => {
    let uid = document.getElementById("user-id").value;
    
    if(uid == 0) {
        let message = document.querySelector(".message");
        message.classList.add('open');
        return;
    }

    let size = document.querySelector("input[name=size]:checked");
    let quantity = document.querySelector(".quantity-select .amount");
    // console.log("productId:", dataProduct.id);
    // console.log("userId:", uid);
    // console.log("quantity:", quantity.textContent);
    // console.log("size:", size.value);

    let pid = document.getElementById("product-id").value;

    data = {
        pid: Number(pid),
        uid: Number(uid),
        num: Number(quantity.textContent),
        size: size.value,
    };
    postData(`${pathAPI}/cart`, data);
    window.location.replace(`${window.location.protocol}//${window.location.host}${window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2))}/cart-view`);
};

let listSize = document.querySelectorAll(".size-select .size-option input");
let available;

document.querySelector(".btn-form .add-cart-btn").style.pointerEvents  = "none";
document.querySelector(".btn-form .buy-btn").style.pointerEvents  = "none";
for (size in listSize) {
    listSize[size].onchange = async function () {
        const path = `http://localhost:8080/btlweb/avai?pid=${document.getElementById("product-id").value}&sid=${this.value}`;
        available = await getAvailable(path);
        amount.innerHTML = "0";
        amountValue = 0;
        if(Math.max(0, available.avai) == 0 || amount.innerHTML == 0) {    
            document.querySelector(".btn-form .add-cart-btn").style.pointerEvents  = "none";
            document.querySelector(".btn-form .buy-btn").style.pointerEvents  = "none";
        }
    };
}

let amount = document.querySelector(".amount");
let plusBtn = document.querySelector(".plus-btn");
let minusBtn = document.querySelector(".minus-btn");
let amountValue = 0;

plusBtn.addEventListener("click", function () {
    // if (amountValue == amount.getAttribute("data-max")) {
    //     return;
    // }
    // if (amountValue == available.avai) {
    //     return;
    // }
    
    amountValue = Math.min(amountValue + 1, Math.max(available.avai, 0));
    if(amountValue > 0) {
        document.querySelector(".btn-form .add-cart-btn").style.pointerEvents  = "auto";
        document.querySelector(".btn-form .buy-btn").style.pointerEvents  = "auto";
    }
    amount.innerText = amountValue;
});

minusBtn.addEventListener("click", function () {
    if (amountValue > 0) amountValue--;
    if(amountValue > 0) {
        document.querySelector(".btn-form .add-cart-btn").style.pointerEvents  = "auto";
        document.querySelector(".btn-form .buy-btn").style.pointerEvents  = "auto";
    } else {
        document.querySelector(".btn-form .add-cart-btn").style.pointerEvents  = "none";
        document.querySelector(".btn-form .buy-btn").style.pointerEvents  = "none";
    }
    amount.innerText = amountValue;
});

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

function start() {
    let cateId = document.getElementById("cate-id").value;
    getRelatedProduct(pathAPI + `/product?related=${cateId}`);
}

start();