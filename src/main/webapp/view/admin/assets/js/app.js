

let inputGalleryImg = document.querySelectorAll(".gallery .form-group .file");


function getParent(element) {
    while (element.parentElement) {
        if (element.parentElement.matches(".form-group")) {
            return element.parentElement;
        }
        element = element.parentElement;
    }
}

if (inputGalleryImg) {
    for (let i = 0; i < inputGalleryImg.length; i++) {
        inputGalleryImg[i].addEventListener("change", function (e) {
            let previewImg = getParent(inputGalleryImg[i]);
            var file = e.target.files[0];
            // Check if the file is an image
            if (file && file.type.startsWith("image/")) {
                // Create a FileReader object
                var reader = new FileReader();
                // Set the callback function when the file is loaded
                reader.onload = function (event) {
                    // Set the source of the preview image
                    previewImg.querySelector(".preview-img").src = event.target.result;
                };
                // Read the file as a data URL
                reader.readAsDataURL(file);
            }
        });
	}
}

function activeNav() {
    let pathInfo = window.location.pathname;
	
	let currentPage = pathInfo.substring(pathInfo.lastIndexOf("/") + 1);
	
	let nav = document.getElementById(currentPage).classList.add("active");
}