
function pagger(id,pageindex,totalpage)
{
    container = document.getElementById(id);
    var result = '';
    result += 'Page:<input id="pageindex_input" type="text" value="'+pageindex+'"/> over '+totalpage;
    container.innerHTML = result;
    
    // Get the input field
    var input = document.getElementById("pageindex_input");

    // Execute a function when the user releases a key on the keyboard
    input.addEventListener("keyup", function(event) {
      // Number 13 is the "Enter" key on the keyboard
      if (event.keyCode === 13) {
            window.location.href = 'list?page='+input.value; 
      }
    });
}

