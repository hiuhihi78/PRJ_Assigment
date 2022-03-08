function checkInputEmpty(number) {
    if (number.localeCompare("") === 0){
        document.getElementById("alter").innerHTML = "All field must be not empty!";
    }
}