function createPage(div, pageindex, totalPage) {
    var container = document.getElementById(div);

    if (pageindex < 1 || pageindex > totalPage) {
        pageindex = 1;
    }
    var container = document.getElementById(div);
    input.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            document.getElementById("div").click();
        }
    });

}