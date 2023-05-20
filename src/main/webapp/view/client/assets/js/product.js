const pathAPI = `${SERVER}/${CONTEXT}`;

let slider = document.getElementsByClassName("slider-item");
let activeImg = document.getElementsByClassName("active");
let prevBtn = document.querySelector(".prev-icon");
let nextBtn = document.querySelector(".next-icon");
let addToCartBtn = document.querySelector(".add-cart-btn");

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


async function getRelatedProduct(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            origin: "http://127.0.0.1:5500/",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();
    console.log({ response });

    const product_html = await response.map((product) => {
        return `
        <li class="item-related">
            <div class="related-img">
                <img src="http://localhost:8080${
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
    // if(uid == 0) {
    //     location.replace("http://localhost:8080/btlweb/login");
    //     return;
    // }

    console.log(uid);
    let size = document.querySelector("input[name=size]:checked");
    let quantity = document.querySelector(".quantity-select .amount");
    // console.log("productId:", dataProduct.id);
    // console.log("userId:", uid);
    // console.log("quantity:", quantity.textContent);
    // console.log("size:", size.value);

    data = {
        pid: Number(product.id),
        uid: Number(uid),
        num: Number(quantity.textContent),
        size: size.value,
    };
    console.log({ data });
    // postData("http://localhost:8080/btlweb/cart", data);
};

function start() {
    let cateId = document.getElementById("cate-id").value;
    getRelatedProduct(pathAPI + `/product?related=${cateId}`);
}

start();