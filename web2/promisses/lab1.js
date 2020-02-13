function scaryClown(isScary) {
    return new Promise((resolve, reject) => {
        isScary ? resolve('clown') : reject('Not scary');
    });
}

// resolved with success
scaryClown(true).then((result) => {
    console.log(result);
}).catch(function(error) {
    console.log(error);
});

// throwing error
scaryClown(false).then((result) => {
    console.log(result);
}).catch(function(error) {
    console.log(error);
});

/*
1 - 





*/