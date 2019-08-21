function init() {
    let name = prompt("What is your name?");
    let age = prompt("What is your age?");

    var w = document.getElementById("welcome");

    w.innerHTML = "Hi, nice to meet you " + name + " " + age + " years old.";
}

function valor() {
    
    var ini = document.getElementById("ini");

    var fac = factorial(ini.value);

    document.getElementById("output").innerHTML = fac;

}

function factorial(n) {
    if (1 == n) {
        return 1;
    } else {
        return factorial (n-1) * n;
    }
}

