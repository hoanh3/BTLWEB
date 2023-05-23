var updateBtn = document.getElementById("update-btn");

async function putUser(url = "", data = {}) {
    const response = await fetch(url, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });
    return response.json();
}

function updateUser() {
    let uid = document.getElementById("user-id").value;
    let firstName = document.getElementsByName("first-name")[0].value;
    let lastName = document.getElementsByName("last-name")[0].value;
    let email = document.getElementsByName("email")[0].value;
    let phoneNumber = document.getElementsByName("phone-number")[0].value;
    let city = document.getElementsByName("city")[0].value;
    let district = document.getElementsByName("district")[0].value;
    let streetAddress = document.getElementsByName("street-address")[0].value;

    let data = {id: uid, firstName: firstName, lastName: lastName, email: email, phoneNumber: phoneNumber,
         city: city, district: district, streetAddress: streetAddress};
    putUser(`${SERVER}/${CONTEXT}/user/${uid}`, data);
    window.location.replace(`/${CONTEXT}/address`);
}

updateBtn.addEventListener("click", function(event) {
    event.preventDefault();
    updateUser();
});