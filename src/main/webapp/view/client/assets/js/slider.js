let slider = document.querySelector('.slider-wrapper');
let firstImg = document.querySelectorAll('.slider-wrapper .slider__img')[0];
let arrowIcons = document.querySelectorAll('.slider i');
let nextBtnSlider = document.getElementById('next-btn');

let isDragStart = false;
let prevPageX, prevScrollLeft, positionDiff;
let firstImgWidth = firstImg.clientWidth;
let count = 0;

console.log(firstImgWidth);

let refreshSlider = setInterval(() => { nextBtnSlider.click() }, 4000);

arrowIcons.forEach((icon) => {
    icon.addEventListener('click', () => {
        count++;
        if(count >= 6) {
            slider.scrollLeft = 0;
            count = 0;
        } else {
            slider.scrollLeft += icon.id == 'prev-btn' ? (-1 * firstImgWidth) : firstImgWidth;
        }
        clearInterval(refreshSlider);
        refreshSlider = setInterval(() => { nextBtnSlider.click() }, 4000);
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