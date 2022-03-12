/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function createPage(div, pageindex, gap, totalPage) {
    var container = document.getElementById(div);
//    container.innerHTML += div + ' ' + pageindex + ' ' + gap + ' ' + totalPage;
    if (pageindex - gap > 1) {
        container.innerHTML += '<a href="search?page=1">First</a>';
    }

    for (var i = pageindex - gap; i < pageindex; i++) {
        if (i > 0) {
            container.innerHTML += '<a href="search?page=' + i + '">' + i + '</a>';
        }
    }
    container.innerHTML += '<span>' + pageindex + '</span>';

    for (var i = pageindex + 1; i <= pageindex + gap; i++) {
        if (i <= totalPage) {
            container.innerHTML += '<a href="search?page=' + i + '">' + i + '</a>';
        }
    }

    if (pageindex + gap < totalPage) {
        container.innerHTML += '<a href="search?page="' + totalPage + '">Last</a>';
    }
}