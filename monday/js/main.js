function callDay() {
    var today = new Date();
    var hour = today.getHours();
    
    var out = document.getElementById("output");

    if(hour >= 18) {
        out.innerHTML = "Good evening!";
    } else if (hour >= 12) {
        out.innerHTML = "Good afternoon!"
    } else if (hour > 0) {
        out.innerHTML = "Good morning!"
    } else {
        out.innerHTML = "Hello!"
    }
}