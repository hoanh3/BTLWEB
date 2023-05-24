function modalEvent() {

    const modal = document.querySelector(".modal");
    const modalBody = document.querySelector(".modal-body");
    const closeBtn = document.querySelector(".close-icon");
    const add = document.querySelector(".slidebar .content > a");
    
    if (add) {
        add.addEventListener("click", () => {
            var inputs = document.querySelectorAll("#form-input input[type=text]");
            for(var i = 0; i < inputs.length; i++) {
                inputs[i].value = "";
            }
            modal.classList.add("open");
        });
    }
    
    closeBtn.onclick = () => {
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

}
