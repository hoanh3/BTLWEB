var form = document.getElementById('form-input');
var addBtn = document.getElementById('add-btn');
var updateBtn = document.getElementById('update-btn');
var PATHAPI = "http://localhost:8080/btlweb/product";

var inputImg = document.querySelector(".modal .form-group .file");
var previewImage = document.querySelector(".preview-img");
console.log(inputImg);

inputImg.addEventListener("change", function (e) {
    var file = e.target.files[0];

    console.log(file);

    // Check if the file is an image
    if (file && file.type.startsWith("image/")) {
        // Create a FileReader object
        var reader = new FileReader();

        // Set the callback function when the file is loaded
        reader.onload = function (event) {
            // Set the source of the preview image
            previewImage.src = event.target.result;
        };

        // Read the file as a data URL
        reader.readAsDataURL(file);
    }
});

const postData = async function (url = "", data = {}) {
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });
    console.log("response:", response);
    return response.json();
}

async function putData(url = "", data = {}) {
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

async function getProduct(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();
    console.log({ response });

    const product_html = await response.map((product) => {
        return `
        <tr>
            <td>${product.id}</td>
            <td class="product-name">${product.title}</td>
            <td class="product-desc">${product.description.substring(0, 20)}...</td>
            <td>
                <img src="${product.thumbnail}" alt="" style="height:60px; width:60px;">
            </td>
            <td>${product.category.title}</td>
            <td>${product.price}</td>
            <td>${product.discount}</td>
            <td class="action">
                <button class="act-btn edit-btn" onclick = 'editForm(${JSON.stringify(product)})'>Sửa</button> 
                <button class="act-btn delete-btn" onclick = 'deleteProduct(${JSON.stringify(product)})'>Xóa</button>
            </td>
        </tr>
        `;
    });
    product_html.unshift(`<tr>
        <th>Id</th>
        <th class="product-name">Tên sản phẩm</th>
        <th class="product-desc">Mô tả</th>
        <th>Thumbnail</th>
        <th>Category</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Action</th>
    </tr>`);
    document.querySelector(".content #render").innerHTML = await product_html.join("");
}

const deleteProduct = function(product) {
    deleteData(PATHAPI + `/${product.id}`);

    window.location.reload();
}

const editForm = async function(product) {

    const modal = document.querySelector(".modal");
    modal.classList.add("open");

    document.getElementById("input-0").value = product.id;
    document.getElementById("input-1").value = product.title;
    document.getElementById("input-2").value = product.category.id;
    document.getElementById("input-3").value = product.price;
    document.getElementById("input-4").value = product.discount;
    document.getElementById("input-5").value = product.size;
    document.getElementById("input-7").value = product.description;
    // document.getElementById("input-8").files = product.image;
    document.getElementById("input-9").value = 1;

    let stt = 1;
    updateBtn.addEventListener('click', async function() {
        
        console.log(stt++);
        let title = document.getElementById("input-1").value;
        let category = document.getElementById("input-2").value;
        let price = document.getElementById("input-3").value;
        let discount = document.getElementById("input-4").value;
        let size = document.getElementById("input-5").value;
        let description = document.getElementById("input-7").value;
        let image = document.getElementById("input-8").files[0];
        let avai = document.getElementById("input-9").value;

        let thumbnail = product.thumbnail;

        if(image != undefined) {
            thumbnail = await uploadFile(image);
        }

        let data = {
            title: title, 
            category: category,
            price: price,
            discount: discount,
            size: size,
            description: description,
            avai: avai,
            thumbnail: thumbnail
        };

        console.log(data);

        putData(PATHAPI + `/${product.id}`, data);

        window.location.reload();
    })
}

const uploadFile = async (file) => {
    const CLOUD_NAME = "dasj31isc";
    const PRESET_NAME = "btlweb";
    const FOLDER_NAME = "product";
    const API = `https://api.cloudinary.com/v1_1/${CLOUD_NAME}/image/upload`
  
    var urlimg;
    const formData = new FormData();
    
  
    formData.append("upload_preset", PRESET_NAME);
    formData.append("folder", FOLDER_NAME);
    formData.append("file", file);
  
    const response = await fetch(API, {
      method: 'POST',
      body: formData
    }).then(response => response.json())
    .then(url => {
      urlimg = url.secure_url;
    });
  
    return urlimg;
  }

form.addEventListener('submit',async function(e) {
    e.preventDefault();
    
})

addBtn.addEventListener('click', async function(e) {

    let title = document.getElementById("input-1").value;
    let category = document.getElementById("input-2").value;
    let price = document.getElementById("input-3").value;
    let discount = document.getElementById("input-4").value;
    let size = document.getElementById("input-5").value;
    let description = document.getElementById("input-7").value;
    let image = document.getElementById("input-8").files[0];
    let avai = document.getElementById("input-9").value;

    let thumbnail = await uploadFile(image);

    let data = {
        title: title, 
        category: category,
        price: price,
        discount: discount,
        size: size,
        description: description,
        avai: avai,
        thumbnail: thumbnail
    };

    console.log(data);

    postData(PATHAPI, data);
})


async function addEvenClick() {
    await getProduct(PATHAPI);
    modalEvent();
}

window.onload = function() {
    addEvenClick();
    activeNav();
}
