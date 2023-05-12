function postItem() {
    let userId = document.getElementById("user-id").value;
    let productId;
}

function start() {
    let addToCartBtn = document.querySelector(".modal .quick-view__add-cart span");
    addToCartBtn.onclick = () => {
        console.log("add to cart");
        postItem();
    };
}

start();
