/**
 * JS Challenge
 * Alex Kayser
 */

// chalenge 1
function addition(a, b) {
    return a + b;
}

console.log('\nExercise 1');
console.log(addition(3, 2)); //it prints 5

// challenge 2
function incrementation(a) {
    return a + 1;
}

console.log('\nExercise 2');
console.log(incrementation(0)); //it prints 1

// challenge 3
function convertMintutesToSecond(a) {
    return a * 60;
}

console.log('\nExercise 3');
console.log(convertMintutesToSecond(3)); //it prints 180

//challenge 4
function arrayOfMultiples(num, length) {
    var multiples = [];

    for (let i = 1; i <= length; i++) {
        multiples.push(num * i);
    }

    return multiples;
}

console.log('\nExercise 4');
console.log(arrayOfMultiples(7, 5)); //it prints [7, 14, 21, 28, 35]

//challenge 5
function toArrayTest(obj) {
    if (obj == null || obj == '') {
        return [];
    }

    var list = [];

    Object.entries(obj).forEach(([key, value]) => {
        list.push([key, value]);
    })
    return list;
}

var example = {
    'a': 1,
    'b': 2
}

console.log('\nExercise 5');
console.log(toArrayTest(example));