$(document).ready(function() {
    //Selectors
    // $(".container").hide(); //by class
    // $("#container2").hide(); //by id

    //$('p').hide(); // by element

    //$('.container p').hide(); //as CSS

    //$('.container p').css('color','#aaaaaa');

    //$('.container').fadeToggle();

    $('.changeColor a').click(function() {
        $('container p').toggleClass('text-red');
    });


});

function ex1() {

}