var maxSequence = function(arr){
    let somas = [];
    
    if (arr != null && arr.length > 0) {
      for(let i=0; i<arr.length; i++) {
        let t = [arr[i]];
        let sub = arr[i];
        console.log("sub-> " + sub);
        //if(sub < 0) continue;
        for(let j=i+1; j<arr.length; j++) {
            sub += arr[j];
          t.push(sub);
          
            console.log("t-> " + t);
        }
        somas.push(Math.max(...t));
        console.log("somas-> " + somas);
      }   
    }
    return Math.max(...somas);
  }

//console.log(maxSequence([]));
console.log(maxSequence([-2, 1, -3, 4, -1, 2, 1, -5, 4]));