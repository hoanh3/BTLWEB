function modalEvent() {

    const modal = document.querySelector(".modal");
    const modalBody = document.querySelector(".modal-body");
    const add = document.querySelector(".slidebar .content > a");
    const gallery = document.querySelector(".gallery");
    const galleryBody = document.querySelector(".gallery-body");
    const closeModalBtn = document.querySelector(".modal .close-icon");
    const closeGalleryBtn = document.querySelector(".gallery .close-icon");
    
    if (add) {
        add.addEventListener("click", () => {
            var inputs = document.querySelectorAll("#form-input input[type=text]");
            for(var i = 0; i < inputs.length; i++) {
                inputs[i].value = "";
            }
            modal.classList.add("open");
        });
    }
    
    closeModalBtn.onclick = () => {
        hideModal();
    };
    
    modal.onclick = () => {
        hideModal();
    };
    
    modalBody.onclick = (e) => {
        e.stopPropagation();
    };
    
    function hideModal() {
        modal.classList.remove("open");
    }

    if (closeGalleryBtn) {
        closeGalleryBtn.onclick = () => {
            hideGallery();
        };
    }
    
    if (gallery) {
        gallery.onclick = () => {
            hideGallery();
        };
    }
    
    if (galleryBody) {
        galleryBody.onclick = (e) => {
            e.stopPropagation();
        };
    }
    
    function hideGallery() {
        gallery.classList.remove("open");
    }
}
