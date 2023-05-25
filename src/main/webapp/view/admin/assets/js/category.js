var form = document.getElementById('form-input');
var addBtn = document.getElementById('add-btn');
var updateBtn = document.getElementById('update-btn');
var PATHAPI = "http://localhost:8080/btlweb/category";

const postData = async function (url = "", data = {}) {
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });
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
    return response.json();
}

async function deleteData(url = "", data = {}) {
    const response = await fetch(url, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        }
    });
    return response.json();
}

async function getCategory(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();

    const product_html = await response.map((category) => {
        return `
        <tr>
            <td>${category.id}</th>
            <td>${category.title}</th>
            <td class="action">
                <button class="act-btn edit-btn" onclick = 'editForm(${JSON.stringify(category)})'>Sửa</button> 
                <button class="act-btn delete-btn" onclick = 'deleteCategory(${JSON.stringify(category)})'>Xóa</button>
            </td>
        </tr>
        `;
    });
    product_html.unshift(`<tr>
        <th>Id</th>
        <th>Tên chuyên chuyên mục</th>
        <th>Hành động</th>
    </tr>`);
    document.querySelector(".content #render").innerHTML = await product_html.join("");
}

const deleteCategory = function(category) {
    deleteData(PATHAPI + `/${category.id}`);

    window.location.reload();
}

const editForm = async function(category) {

    const modal = document.querySelector(".modal");
    modal.classList.add("open");
    document.getElementById("input-1").value = category.id;
    document.getElementById("input-2").value = category.title;

    let stt = 1;
    updateBtn.addEventListener('click', async function() {
        
        let id = document.getElementById("input-1").value;
        let title = document.getElementById("input-2").value;

        let data = {
            id: id,
            title: title
        };


        putData(PATHAPI + `/${category.id}`, data);

        window.location.reload();
    })
}


form.addEventListener('submit',async function(e) {
    e.preventDefault();
})

addBtn.addEventListener('click', async function(e) {

    let id = document.getElementById("input-1").value;
    let title = document.getElementById("input-2").value;

    let data = {
        id: "0",
        title: title
    };


    postData(PATHAPI, data);
    
    window.location.reload();
})

async function addEvenClick() {
    await getCategory(PATHAPI);
    modalEvent();
}

window.onload = function() {
    addEvenClick();
    activeNav();
}
