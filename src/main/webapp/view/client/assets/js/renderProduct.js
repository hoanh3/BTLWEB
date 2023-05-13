const pathAPI = "http://localhost:8080/btlweb/product";

async function getProduct() {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        },
    };
    let data = await fetch(pathAPI + "?filter=topsale");
    let response = await data.json();
    console.log({ response });

    const product_html = await response.map((product) => {
        return `
            <div class="col l-3 m-4 c-6">
                <div class="product-information">
                    <a href="#" class="product-item">
                        <div class="product-item__img" style="background-image: url(http://localhost:8080${
                            product.thumbnail
                        });"></div>
                        <h4 class="product-item__name">${product.title}</h4>
                        <p class="product-item__vendor">Vergency</p>
                        <div class="product-item__review">
                            <span class="rating">
                                <i class="star-yellow fa-solid fa-star"></i>
                                <i class="star-yellow fa-solid fa-star"></i>
                                <i class="star-yellow fa-solid fa-star"></i>
                                <i class="star-yellow fa-solid fa-star"></i>
                                <i class="star-yellow fa-solid fa-star"></i>
                            </span>
                        </div>
                        <div class="product-item__price">
                            <span class="price-old">${product.price / 1000}.000đ</span>
                            <span class="price-new">${product.discount / 1000}.000đ</span>
                        </div>
                        <div class="product-item__sale-off">${Math.round((product.price - product.discount) / product.price * 100)}%</div>
                    </a>
                    <div class="product-item__quick-view">
                        <a 
                            class="quick-view--btn" 
                            onclick='showQuickView(${JSON.stringify(product)})'
                        >
                            Xem nhanh
                        </a>
                    </div>
                </div>
            </div>
        `;
    });
    document.querySelector(".product .product-list").innerHTML = await product_html.join("");
}

async function getProductInBestSeller() {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        },
    };
    let data = await fetch(pathAPI + "?filter=bestseller");
    let response = await data.json();
    console.log({ response });

    const product_html = await response.map((product) => {
        return `
            <div class="col l-3 m-4 c-6">
                <div class="product-information">
                    <a href="#" class="product-item">
                        <div class="product-item__img" style="background-image: url(http://localhost:8080${
                            product.thumbnail
                        });"></div>
                        <h4 class="product-item__name">${product.title}</h4>
                        <p class="product-item__vendor">Vergency</p>
                        <div class="product-item__review">
                            <span class="rating">
                                <i class="star-yellow fa-solid fa-star"></i>
                                <i class="star-yellow fa-solid fa-star"></i>
                                <i class="star-yellow fa-solid fa-star"></i>
                                <i class="star-yellow fa-solid fa-star"></i>
                                <i class="star-yellow fa-solid fa-star"></i>
                            </span>
                        </div>
                        <div class="product-item__price">
                            <span class="price-old">${product.price / 1000}.000đ</span>
                            <span class="price-new">${product.discount / 1000}.000đ</span>
                        </div>
                        <div class="product-item__sale-off">${Math.round((product.price - product.discount) / product.price * 100)}%</div>
                    </a>
                    <div class="product-item__quick-view">
                        <a 
                            class="quick-view--btn" 
                            onclick='showQuickView(${JSON.stringify(product)})'
                        >
                            Xem nhanh
                        </a>
                    </div>
                </div>
            </div>
        `;
    });
    document.querySelector(".product .best-saller").innerHTML = await product_html.join("");
}

function showQuickView(product) {
    const dataProduct = product;
    let modal = document.querySelector(".modal");
    let img = "http://localhost:8080" + product.thumbnail;
    let galleries = document.querySelectorAll(".slider-product__item img");
    let addToCartBtn = document.querySelector(".modal .quick-view__add-cart span");

    quickViewEvent();

    modal.querySelector(".quick-view__img img").setAttribute("src", img);
    modal.querySelector(".quick-view__title").innerHTML = product.title;
    modal.querySelector(".price-new").innerHTML = product.discount / 1000 + ".000đ";
    modal.querySelector(".price-old").innerHTML = product.price / 1000 + ".000đ";

    for (let i = 0; i < galleries.length; i++) {
        if (product.galeries[i].thumbnail.length > 0) {
            let thumb = "http://localhost:8080" + product.galeries[i].thumbnail;
            console.log(thumb);
            galleries[i].setAttribute("src", thumb);
        }
    }


    addToCartBtn.onclick = function () {
        console.log("productId: ", dataProduct.id);
        let size = document.querySelector("input[name=size]:checked");
        let quantity = document.querySelector(".quantity-select .amount");
        console.log(size.value);
        console.log(quantity.textContent);
        // let uid = document.getElementById("user-id").value;
        // data = {
        //     "pid": product.id,
        //     "uid": uid,
        //     "num": quantity,
        //     "size": size,
        // }
        // postItem("http://localhost:8947/btlweb/cart", data);
    };
}

function quickViewEvent() {
    let modal = document.querySelector(".modal");
    let modalContent = document.querySelector(".modal__content");
    let closeQuickViewBtn = document.querySelector(".quick-view__close-btn");
    let amount = document.querySelector(".amount");
    let plusBtn = document.querySelector(".plus-btn");
    let minusBtn = document.querySelector(".minus-btn");
    let amountValue = 0;

    modal.classList.add("open");

    closeQuickViewBtn.onclick = () => {
        hideQuickView();
    };
    modal.onclick = () => {
        hideQuickView();
    };
    modalContent.onclick = (e) => {
        e.stopPropagation();
    };

    plusBtn.addEventListener("click", function () {
        amountValue++;
        amount.innerText = amountValue;
    });

    minusBtn.addEventListener("click", function () {
        if (amountValue > 0) amountValue--;
        amount.innerText = amountValue;
    });
}

function hideQuickView() {
    let modal = document.querySelector(".modal");
    modal.classList.remove("open");
}

// async function postData(url = "", data = {}) {}

function start() {
    getProduct();
    getProductInBestSeller();
}

start();
