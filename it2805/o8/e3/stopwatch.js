var Watch = (function(){
    var running = false,
        delay = 1.0,
        start,
        interval,
        temp = 0,
        display
    



    var startStop = function() {
        if (!running) {
            start = new Date()
            interval = window.setInterval(updateOutput, delay)
            running = true
            console.log("Started watch")
        } else {
            temp += (Date.now() - start)
            window.clearInterval(interval)
            running = false
            console.log("Stopped")
        }
    }

    var clear = function() {
        running = false
        display.innerHTML = "00:00:00.000"
        window.clearInterval(interval)
        start = null
        temp = 0
    }

    var formatTime = function(time) {
        var h = m = s = ms = 0;
        var newTime = "";
        h = Math.floor(time / (60 * 60 * 1000));
        time = time % (60 * 60 * 1000);
        m = Math.floor(time / (60 * 1000));
        time = time % (60 * 1000);
        s = Math.floor(time / 1000);
        ms = time % 1000;
        newTime = padTime(h, 2) + ":" + padTime(m, 2) + ":" + padTime(s, 2) + "."+ padTime(ms, 3); 
        return newTime;
    }

    var padTime = function(time, size) {
        var s = "000" + time;
        return s.substr(s.length - size);
    }

    var updateOutput = function() {
        var time = new Date().getTime() - start.getTime() + temp
        display.innerHTML = formatTime(time)
    }

    return {
        addListeners: function() {
            var toggleBtn = document.getElementById("toggle-button")
            var resetBtn = document.getElementById("reset-button")
            display = document.getElementById("display-area")
            toggleBtn.addEventListener("click", function(event){
                startStop()
            })
            resetBtn.addEventListener("click", function(event){
                clear()
            })
        }
    }

})()


window.addEventListener("load", function() {
    Watch.addListeners()   
})
