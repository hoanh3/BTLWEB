const pathAPI = "http://localhost:8080/btlweb/product";

async function getProduct(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            origin: "http://127.0.0.1:5500/",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();

    const product_html = await response.map((product) => {
        let sale = (1 - product.discount / product.price).toFixed(2) * 100;
        return `
            <div class="col l-3 m-4 c-6">
                <div class="product-information">
                    <a href="${window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2))}/product-detail?pid=${product.id}" class="product-item">
                        <div class="product-item__img" style="background-image: url(${product.thumbnail});"></div>
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
                        <div class="product-item__sale-off">${sale}%</div>
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

async function getBestSeller(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            origin: "http://127.0.0.1:5500/",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();

    const product_html = await response.map((product) => {
        let sale = (1 - product.discount / product.price).toFixed(2) * 100;
        return `
            <div class="col l-3 m-4 c-6">
                <div class="product-information">
                    <a href="${window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2))}/product-detail?pid=${product.id}" class="product-item">
                        <div class="product-item__img" style="background-image: url(${
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
                        <div class="product-item__sale-off">${sale}%</div>
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
    let modal = document.querySelector(".modal");
    let img = product.thumbnail;
    let galleries = document.querySelectorAll(".slider-product__item img");
    let addToCartBtn = document.querySelector(".modal .quick-view__add-cart span");

    quickViewEvent(product.id);

    modal.querySelector(".quick-view__img img").setAttribute("src", img);
    modal.querySelector(".quick-view__title").innerHTML = product.title;
    modal.querySelector(".price-new").innerHTML = product.discount / 1000 + ".000đ";
    modal.querySelector(".price-old").innerHTML = product.price / 1000 + ".000đ";

    if(product.galeries.length > 0) {
        for (let i = 0; i < galleries.length; i++) {
            if (product.galeries[i] && product.galeries[i].thumbnail.length > 0) {
                let thumb = product.galeries[i].thumbnail;
                galleries[i].setAttribute("src", thumb);
            }
        }
    }

    let listSize = document.querySelectorAll(".size-select .size-option input");
    for (size in listSize) {
        if (listSize[size].checked === true) {
            listSize[size].checked = false;
        }
    }

    addToCartBtn.onclick = () => {
        let uid = document.getElementById("user-id").value;
        // console.log(uid);


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

        data = {
            pid: Number(product.id),
            uid: Number(uid),
            num: Number(quantity.textContent),
            size: size.value,
        };
        console.log({ data });
        postData("http://localhost:8080/btlweb/cart", data);
        hideQuickView();
    };
}

function quickViewEvent(pid) {
    document.querySelector(".modal .quick-view__add-cart").style.pointerEvents  = "none";
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

    let listSize = document.querySelectorAll(".size-select .size-option input");
    let available;
    for (size in listSize) {
        listSize[size].onchange = async function () {
            const path = `http://localhost:8080/btlweb/avai?pid=${pid}&sid=${this.value}`;
            available = await getAvailable(path);
            amount.innerHTML = "0";
            amountValue = 0;
            if(Math.max(0, available.avai) == 0 || amount.innerHTML == 0) {    
                document.querySelector(".modal .quick-view__add-cart").style.pointerEvents  = "none";
            }
        };
    }

    plusBtn.addEventListener("click", function () {
        // if (amountValue == amount.getAttribute("data-max")) {
        //     return;
        // }
        // if (amountValue == available.avai) {
        //     return;
        // }
        amountValue = Math.min(amountValue + 1, Math.max(available.avai, 0));
        if(amountValue > 0) {
            document.querySelector(".modal .quick-view__add-cart").style.pointerEvents  = "auto";
        } 
        amount.innerText = amountValue;
    });

    minusBtn.addEventListener("click", function () {
        if (amountValue > 0) amountValue--;
        if(amountValue > 0) {
            document.querySelector(".modal .quick-view__add-cart").style.pointerEvents  = "auto";
        } else {
            document.querySelector(".modal .quick-view__add-cart").style.pointerEvents  = "none";
        }
        amount.innerText = amountValue;
    });
}

function hideQuickView() {
    let modal = document.querySelector(".modal");
    modal.classList.remove("open");
}

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

function start() {
    getProduct(pathAPI + "?filter=topsale");
    getBestSeller(pathAPI + "?filter=bestseller");
}

start();