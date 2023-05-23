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
        total_price += product.price * product.num;
        let price = partition((product.price * product.num).toString()).join(".");
        return `
            <tr class="product">
                <td class="product-img">
                    <div class="product-thumbnail">
                        <img
                            src="${product.product.thumbnail}"
                            alt=""
                            class="product-thumb-img"
                        />
                    </div>
                    <span class="product-quantity">${product.num}</span>
                </td>
                <td class="product-description">
                    <span class="product-name">${product.product.title}</span>
                    <span class="product-size">${product.size}</span>
                </td>
                <td class="product-price">${product.price}đ</td>
            </tr>
        `;
    });

    if (stringHTML.length == 0) {
        
    } else {
        document.querySelector(".product-table-body").innerHTML = stringHTML.join("");
    }

    let priceStr = total_price.toString();
    let total = (total_price + 35000).toString();
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
    document.querySelector(".total-subtotal .price").innerHTML = partition(priceStr).join(".") + "đ";
    document.querySelector(".total-price .price").innerHTML = partition(total).join(".") + "đ";
}

function start() {
    let userId = document.getElementById("user-id").value;
    render(`http://localhost:8080/btlweb/cart?uid=${userId}`);
}

start();