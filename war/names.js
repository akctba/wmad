function list(names) {
    let result = '';

    names.forEach((n, i) => {
        //console.log(i + " - " + n.name);
        result += n.name;
        result += (i < names.length - 2 ? ', ' : (i < names.length - 1 ? ' & ' : ''));
    });

    return result;
}

console.log(
    list([{
        name: 'Bart'
    }, {
        name: 'Lisa'
    }, {
        name: 'Maggie'
    }, {
        name: 'Homer'
    }, {
        name: 'Marge'
    }]));