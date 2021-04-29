function findOutlier(integers) {
    let par = ((integers[0] % 2) + (integers[1] % 2) + (integers[2] % 2)) <= 1;

    for(let i = 0; i< integers.length; i++) {
        console.log(integers[i]);
        if ((par && abs(integers[i]) % 2 > 0) || (!par && abs(integers[i]) % 2 === 0)) {
            return integers[i];
        }
    };
}

// console.log("Lista par ");
// console.log(findOutlier([2, 4, 0, 100, 4, 11, 2602, 36]));
// console.log("Lista impar ");
// console.log(findOutlier([160, 3, 1719, 19, 11, 13, -21]));

console.log(-44 % 2 == 0);