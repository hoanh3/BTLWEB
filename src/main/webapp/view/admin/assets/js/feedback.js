/**
 * 
 */

var PATH = "http://localhost:8080/btlweb/feedback";

var modal = document.querySelector(".fb-modal");

async function getData(path) {
    const response = await fetch(path);

    const data = await response.json();

    return data;
}

async function previewData(path) {
    const data = await getData(path);
    console.log(data);

    const htmls = data.map((feedback) => {
        return `
            <tr>
                <td>${feedback.lastName} ${feedback.firstName}</td>
                <td>${feedback.email}</td>
                <td>${feedback.phoneNumber}</td>
                <td>${feedback.subject.substring(0, Math.min(16, feedback.subject.length))}...</td>
                <td>${feedback.note.substring(0, Math.min(16, feedback.note.length))}...</td>
                <td>
                    <button class="btn-act" onclick='showDetail(${JSON.stringify(feedback)})'>Chi tiết</button>
                </td>
            </tr>
        `;
    })

    let table = document.getElementById("fb-table");
    table.innerHTML += htmls.join(" ");
}

function showDetail(feedback) {
    modal.classList.add("open");
    
    document.querySelector(".content-header .header-subject").innerHTML = feedback.subject;
    document.querySelector(".content-header .header-name").innerHTML = feedback.lastName + " " + feedback.firstName;
    document.querySelector(".content-header .sub-header .header-email").innerHTML = feedback.email;
    document.querySelector(".content-header .sub-header .header-phoneNumber").innerHTML = feedback.phoneNumber;
    document.querySelector(".content-body p").innerHTML = feedback.note;
}

window.onclick = function(event) {
    if(event.target == modal) {
        modal.classList.remove("open");
    }
}

document.querySelector(".fb-content .fb-close").onclick = function() {
    modal.classList.remove("open");
}

window.onload = function() {
    activeNav();
    previewData(PATH);
}