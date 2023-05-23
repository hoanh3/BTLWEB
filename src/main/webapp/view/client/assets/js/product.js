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

function start() {
    let cateId = document.getElementById("cate-id").value;
    getRelatedProduct(pathAPI + `/product?related=${cateId}`);
}

start();