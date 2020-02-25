/*
You can state the vowels challenge as follows: write a function that takes a string as
argument and returns the number of vowels contained in that string.

The vowels are “a”, “e”, “i”, “o”, “u”.
findVowels("hello") ==>> 2;
*/
const vowels = ['a', 'e', 'i', 'o', 'u'];
let findVowels = (word) => {
    let qtd = 0;
    word.split('').map((v) => qtd += (vowels.includes(v) ? 1 : 0));
    return qtd;
}

console.log(findVowels("hello"));

