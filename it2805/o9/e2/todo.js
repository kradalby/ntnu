window.addEventListener("load", function() {

    var clear = document.getElementById("clear")
    var add = document.getElementById("add")
    var stuff = document.getElementById("stuff")
    var input = document.getElementById("input")
    
    add.addEventListener("click", function() {
        addToDo()
    })
    
    input.addEventListener("keypress", function(e) {
        var key = e.which || e.keyCode;
        if (key == 13) {
            addToDo()
        }
    })

    clear.addEventListener("click", function() {
        clearComplete()
    })
    

    function addToDo() {
        check = document.createElement("input")
        check.type = "checkbox"
        p = document.createElement("p")
        p.innerHTML = input.value
        li = document.createElement("li")
        
        li.appendChild(check)
        li.appendChild(p)

        stuff.appendChild(li)

    }
    
    function clearComplete() {
        var unchecked = ""
        for (var i = 0; i < stuff.children.length; i++) {
            if (!stuff.children[i].children[0].checked) {
                unchecked += "<li>" + stuff.children[i].innerHTML + "</li>"
            }
        }
        stuff.innerHTML = unchecked
        
    }
    
})
