// Header Search PC
const headerSearch = document.querySelector('.header__search');
const searchIcon = document.querySelector('.form-search');
const closeIcon = document.querySelector('.form-input .close-icon');

searchIcon.onclick = () => {
    document.querySelector('.header__control').classList.toggle('active');
    headerSearch.classList.toggle('active');
}

closeIcon.onclick = () => {
    document.querySelector('.form-input .search-input').value = '';
}

// Header Search Mobile
const mobileSearchBtn = document.querySelector('.mobile__search-icon .control-icon');
const mobileSearchBox = document.querySelector('.mobile__search-box');

mobileSearchBtn.onclick = () => {
    mobileSearchBox.classList.toggle('active');
}

// Toggle menu
const toggleMenu = document.querySelector('.toggle-box');

toggleMenu.onclick = () => {
    document.querySelector('.app').classList.toggle('open');
    document.querySelector('#menu-mobile').classList.toggle('open');
    document.querySelector('body').classList.toggle('helper-overflow-hidden');
}

// Count time
// function displayTime() {
//     let dateTime = new Date();
//     let hours = dateTime.getHours();
//     let minutes = dateTime.getMinutes();
//     let seconds = dateTime.getSeconds();
//     let date = dateTime.getDate();

//     document.querySelector('.box-time .date').innerHTML = date;
//     document.querySelector('.box-time .hours').innerHTML = hours;
//     document.querySelector('.box-time .minutes').innerHTML = minutes;
//     document.querySelector('.box-time .seconds').innerHTML = seconds;
// }

// setInterval(displayTime, 10);

// Mobile menu
let showBtn = document.querySelector('.menu-mobile__item:nth-child(2) i');

showBtn.onclick = () => {
    document.querySelector('.menu-mobile__item:nth-child(2)').classList.toggle('active');
}

// Back to top button
let backToTop = document.querySelector('.back-to-top');
let backToTopBtn = document.querySelector('.back-to-top button');

window.onscroll = () => {
    scrollFunction();
}

function scrollFunction() {
    if(document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        backToTop.classList.add('display');
    } else {
        backToTop.classList.remove('display');
    }
}

backToTopBtn.onclick = () => {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}