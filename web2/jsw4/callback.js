//add function
let add = function (num1, num2) {
    return num1 + num2;
}
//mult function
let mult = function (num1, num2) {
    return num1 * num2;
}

function calc(num1, num2, Callback) {
    return Callback(num1, num2);
}

console.log(calc(3,9, add));
