var form = document.getElementById('form-input');
var updateBtn = document.getElementById('update-btn');
var PATHAPI = "http://localhost:8080/btlweb/user";

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

async function getUser(path) {
    let option = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    };
    let data = await fetch(path, option);
    let response = await data.json();
    console.log({ response });

    const product_html = await response.map((user) => {
        return `
        <tr>
            <td>${user.id}</th>
            <td>${user.lastName}</th>
            <td>${user.firstName}</th>
            <td>${user.email}</th>
            <td>${user.phoneNumber}</th>
            <td>${user.streetAddress}</th>
            <td>${user.district}</th>
            <td>${user.city}</th>
            <td>
                <button class="act-btn edit-btn" onclick='editForm(${JSON.stringify(user)})'>Sửa</button> 
                <button class="act-btn delete-btn" onclick='deleteProduct(${JSON.stringify(user)})'>Xóa</button>
            </td>
        </tr>
        `;
    });
    product_html.unshift(`<tr>
        <th>Id</th>
        <th>Họ</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Số điện thoại</th>
        <th>Phường/Đường/Xã</th>
        <th>Quân/Huyện</th>
        <th>Tỉnh/Thành phố</th>
        <th>Hành động</th>
    </tr>`);
    document.querySelector(".content #render").innerHTML = await product_html.join("");
}

const deleteProduct = function(user) {
    deleteData(PATHAPI + `/${user.id}`);

    window.location.reload();
}

const editForm = async function(user) {
    window.location.replace("#open");
    document.getElementById("input-1").value = user.id;
    document.getElementById("input-2").value = user.lastName;
    document.getElementById("input-3").value = user.firstName;
    document.getElementById("input-4").value = user.email;
    document.getElementById("input-5").value = user.phoneNumber;
    document.getElementById("input-6").value = user.streetAddress;
    document.getElementById("input-7").value = user.district;
    document.getElementById("input-8").value = user.city;

    let stt = 1;
    updateBtn.addEventListener('click', async function() {
        
        console.log(stt++);
        let id = document.getElementById("input-1").value;
        let firstName = document.getElementById("input-2").value;
        let lastName = document.getElementById("input-3").value;
        let email = document.getElementById("input-4").value;
        let phoneNumber = document.getElementById("input-5").value;
        let city = document.getElementById("input-6").value;
        let district = document.getElementById("input-7").value;
        let streetAddress = document.getElementById("input-8").value;

        let data = {
            id: id, 
            firstName: firstName,
            lastName: lastName,
            email: email,
            phoneNumber: phoneNumber,
            city: city,
            district: district,
            streetAddress: streetAddress
        };

        console.log(data);

        putData(PATHAPI + `/${user.id}`, data);

        window.location.reload();
    })
}

form.addEventListener('submit',async function(e) {
    e.preventDefault();
    
})

window.onload = function() {
    getUser(PATHAPI);
    activeNav();
}
