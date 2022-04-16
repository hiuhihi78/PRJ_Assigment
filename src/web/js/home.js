function openNav(){
    var nav = document.getElementById('mySidenav');
    nav.style.display = 'block';
}   


function closeNav(){
    var nav = document.getElementById('mySidenav');
    nav.style.display = 'none';
}

function doNavigation(url){
    location.href = url;    
}