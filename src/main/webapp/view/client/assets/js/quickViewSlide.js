let thumbnails = document.getElementsByClassName('slider-product__item');
let activeImg = document.getElementsByClassName('active');

for(var i = 0; i < thumbnails.length; i++) {
    thumbnails[i].addEventListener('click', function() {
        if(activeImg != null) {
            activeImg[0].classList.remove('active');
        }
        // console.log(this);
        // console.log(thumbnails[i]);
        this.classList.add('active');
        document.querySelector('.quick-view__img img').src = this.querySelector('.item-img').src;
    });
}

let prevBtn = document.querySelector('.quick-view-prev');
let nextBtn = document.querySelector('.quick-view-next');

prevBtn.onclick = function() {
    document.querySelector('.slider-product').scrollLeft -= 66 + 6;
}

nextBtn.onclick = function() {
    document.querySelector('.slider-product').scrollLeft += 66 + 6;
}