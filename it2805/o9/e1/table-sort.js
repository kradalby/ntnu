function sortColumn(tbody, col) {
    var arr = columnToArray(tbody.children, col)
    arr.sort(function(a,b) {
        return a.cells[col].innerHTML.localeCompare(b.cells[col].innerHTML);
    })
    updateView(tbody, col, arr)
}

function columnToArray(rows, col) {
    arr = Array()
    for (var i = 0; i < rows.length; i++) {
        arr.push(rows[i])
    }
    return arr
}

function updateView(tbody, col, arr) {
    tbody.innerHTML = ""
    for (var i = 0; i < arr.length; i++) {
        console.log(arr[i], tbody.children[i])
        tbody.insertRow().innerHTML = arr[i].innerHTML
    }
}

window.addEventListener("load", function() {

    var tbody = document.getElementById('the-table-body')
    var btn1 = document.getElementById('sort-button-1')
    var btn2 = document.getElementById('sort-button-2')
    var btn3 = document.getElementById('sort-button-3')
    btn1.addEventListener("click", function() { 
        sortColumn(tbody, 0)
    }) 
    btn2.addEventListener("click", function() { 
        sortColumn(tbody, 1)
    }) 
    btn3.addEventListener("click", function() { 
        sortColumn(tbody, 2)
    }) 

})
