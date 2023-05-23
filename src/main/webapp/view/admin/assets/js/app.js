

function activeNav() {
    let pathInfo = window.location.pathname;
	
	let currentPage = pathInfo.substring(pathInfo.lastIndexOf("/") + 1);
	
	let nav = document.getElementById(currentPage).classList.add("active");
}