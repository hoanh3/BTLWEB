let slider = document.getElementsByClassName("slider-item");
let activeImg = document.getElementsByClassName("active");
let prevBtn = document.querySelector(".prev-icon");
let nextBtn = document.querySelector(".next-icon");

for (let i = 0; i < slider.length; i++) {
    slider[i].addEventListener("click", () => {
        if (activeImg != null) {
            activeImg[0].classList.remove("active");
        }
        slider[i].classList.add("active");
        document.querySelector(".big-img img").src = slider[i].querySelector(".slider-img").src;
    });
}

prevBtn.onclick = function () {
    document.querySelector(".product-slider").scrollLeft -= 85 + 6;
};

nextBtn.onclick = function () {
    document.querySelector(".product-slider").scrollLeft += 85 + 6;
};
