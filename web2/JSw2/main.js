/**
 Alex Kayser
*/

var btnMessage = document.getElementById('sendMessage');
var timeout = 1500;
var clean;

btnMessage.onclick = function () {
    let input = document.getElementById('message');
    let output = document.getElementById('messageOutput');

    if (input.value == '') {
        output.innerHTML = 'Opss..';

        setTimeout(() => {
            output.innerHTML = 'try again';
            setTimeout(() => {
                output.innerHTML = '';
            }, timeout);
        }, timeout);
    } else {
        output.innerHTML = input.value;
        clean = setInterval(cleanInput, timeout/20);
    }
}

function cleanInput() {
    let input = document.getElementById('message');
    let txt = input.value;
    if (txt.length > 0) {
        input.value = txt.substring(0, txt.length-1);
    } else {
        clearInterval(clean);
    }
}