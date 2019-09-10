function conversion() {

    let promp = prompt("Choose 'F' to Fahrenheit or 'C' to Celcius");
    if(promp != null)
        promp = promp.toUpperCase();
    
    let out = document.getElementById("output");
    let temp = "";

    switch(promp) {
        case "F":
            temp = prompt("What is the tempetrature in Fahreinheits?");
            if (Number.isNaN(temp)) {
                out.innerHTML = temp + " is not a number. Try another one.";
                return;
            }
            temp = Number(temp);

            if (temp < 32 || temp > 212) {
                out.innerHTML = "You choosed [" + temp +    "]. Please choose a number between 32 and 212.";
                return;
            }

            let celcius = (temp-32)*(5/9);
            out.innerHTML = temp + " fahrenheit is "+ celcius.toFixed(1) + " celcius.";
        
        break;
        case "C":
            temp = prompt("What is the tempetrature in Celcius?");
            if (Number.isNaN(temp)) {
                out.innerHTML = temp + " is not a number. Try another one.";
                return;
            }
            temp = Number(temp);

            if (temp < 0 || temp > 110) {
                out.innerHTML = "You choosed [" + temp + "]. Please choose a number between 0 and 100.";
                return;
            }

            let fah = (temp*(9/5))+32;
            out.innerHTML = temp + " celcius is " + fah.toFixed(1) + " fahreinheits.";

        break;
        default: 
            out.innerHTML = promp + " is not a option. Please, choose 'C' or 'F'.";
    }
}