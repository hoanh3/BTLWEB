let slider = document.querySelector('.slider-wrapper');
let firstImg = document.querySelectorAll('.slider-wrapper .slider__img')[0];
let arrowIcons = document.querySelectorAll('.slider i');

let isDragStart = false;
let prevPageX, prevScrollLeft, positionDiff;
let firstImgWidth = firstImg.clientWidth;

console.log(firstImgWidth);

arrowIcons.forEach((icon) => {
    icon.addEventListener('click', () => {
        slider.scrollLeft += icon.id == 'prev-btn' ? (-1 * firstImgWidth) : firstImgWidth;
    });
});

let dragStart = (e) => {
    // updating global variables value on mouse down event
    isDragStart = true;
    prevPageX = e.pageX || e.touches[0].pageX;
    prevScrollLeft = slider.scrollLeft;
}

let autoSlide = () => {
    positionDiff = Math.abs(positionDiff);
    let valueDiff = firstImgWidth - positionDiff;
    if(slider.scrollLeft > prevScrollLeft) {
        return slider.scrollLeft += positionDiff > 0 ? valueDiff : (-1 * positionDiff);
    } else if(slider.scrollLeft < prevScrollLeft) {
        return slider.scrollLeft -= positionDiff > 0 ? valueDiff : (-1 * positionDiff)
    } else {
        return slider.scrollLeft = 0;
    }
}

let dragging = (e) => {
    if(!isDragStart) return;
    e.preventDefault();
    slider.classList.add('dragging');
    positionDiff = (e.pageX || e.touches[0].pageX) - prevPageX;
    // console.log(positionDiff);
    slider.scrollLeft = prevScrollLeft - positionDiff;
}

let dragStop = (e) => {
    isDragStart = false;
    slider.classList.remove('dragging');
    autoSlide();
}

slider.addEventListener('mousedown', dragStart);
slider.addEventListener('touchstart', dragStart);

slider.addEventListener('mousemove', dragging);
slider.addEventListener('touchmove', dragging);

slider.addEventListener('mouseup', dragStop);
slider.addEventListener('touchend', dragStop);