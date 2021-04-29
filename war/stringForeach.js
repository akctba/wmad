function duplicateEncode(word){
    if(word == null || word === '') return '';
    word = word.toLowerCase();
    let result = '';
    [...word].forEach(l => {
      let parts = word.split(l);
      result += (parts.length-1) == 1 ? '(' : ')';
    });
    return result;
}

console.log(duplicateEncode("abABcd"));
