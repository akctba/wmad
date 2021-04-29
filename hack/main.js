// Add your javascript here. Plagiarism is NOT tolerated!

$(document).ready(()=>{
    $("#addTask").click(()=> {
        blockFields(true);

        let id = 'ts' + (new Date()).getTime();

        let row = $(`<tr id='${id}'></tr>`);
        row.append(`<td class='nametask'>${$('#taskName').val()}</td>`);
        row.append(`<td class='prioritytask'>${$('#taskPriority').val()}</td>`);
        row.append(`<td class='deadlinetask'>${$('#taskDeadline').val()}</td>`);

        let delBtn = `<input type='button' value='Delete' onclick='deleteTask("${id}")' />`;
        let editBtn = `<input type='button' value='Edit' onclick='editTask("${id}")' />`;
        row.append(`<td>${editBtn} ${delBtn}</td>`);
        
        $("#tasklist").append(row);
        clearForm();
        blockFields(false);
    });

    $('#saveTask').click(() => {
        $();
        $('#cancelTask').click();
    });

    $('#cancelTask').click(() => {
        clearForm();
        //change buttons
        $('#addTask').css('display', '');
        $('#saveTask').css('display', 'none');
        $('#cancelTask').css('display', 'none');
        //remove line decoration
        $('.editing').attr('class', '');
    });
});

function blockFields(toBlock) {
    $('#addTask').attr('readOnly',toBlock);
    $('#taskName').attr('readOnly',toBlock);
    $('#taskPriority').attr('readOnly',toBlock);
    $('#taskDeadline').attr('readOnly',toBlock);
}

function clearForm() {
    $('#taskName').val('');
    $('#taskPriority').val('');
    $('#taskDeadline').val('');
}

let delection;
function deleteTask(id) {
    $(`#${id}`).attr('class', 'deleting');
    setTimeout(()=> {

        $(`#${id}`).css('display', 'none');

        //shows alert "undo"
        $('#alertMessage').html(`<a href='#' onclick='unDelete("${id}")'>Undo</a>`);
        $('#alertRow').css('display', '');

        // removes after 3 seconds
        delection = setTimeout(()=> {
            $('#alertRow').css('display', 'none');
            $(`#${id}`).remove();
            //calls API to delete on backend
        }, 3000);

    }, 500);
}

function unDelete(id) {
    //stop delection
    clearTimeout(delection);
    $(`#${id}`).css('display', '');
    $(`#${id}`).attr('class', '');
    $('#alertRow').css('display', 'none');
}

function editTask(id) {
    //clear previous edition 
    $('#cancelTask').click();
    //highlight the line
    $(`#${id}`).attr('class', 'editing');
    //change buttons
    $('#addTask').css('display', 'none');
    $('#saveTask').css('display', '');
    $('#cancelTask').css('display', '');

    $('#taskName').val($(`#${id} > .nametask`).html());
    $('#taskPriority').val($(`#${id} > .prioritytask`).html());
    $('#taskDeadline').val($(`#${id} > .deadlinetask`).html());
}

