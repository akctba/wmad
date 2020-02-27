$(() => {
    //$('#galery').html('');
    fetchData();
});

var list;
var page = 1;

function fetchData() {
    fetch(`https://picsum.photos/v2/list?page=${page}&limit=12`)
        .then(resp => {
            if (resp.status !== 200) {
                console.error("error");
            }
            resp.json().then(data => {
                    console.log(data);
                    list = data;
                    //console.log(data.length);

                    let imgPerRow = 3;

                    for(let i=0; i<list.length; i+=imgPerRow) {
                        let row = $('<div class="row"></div>');

                        for(let x=0; x<imgPerRow; x++) {

                            let card = '<div class="col-xm">';
                            card += '<div class="card">';
                            card += '<div class="card-body">';
                            card += `<h3 class="card-title">${list[i+x].id}</h3>`;
                            card += `<a href="#" onclick="seePicture(${i+x});">`
                            card += `<img src="https://i.picsum.photos/id/${list[i+x].id}/200/200.jpg" alt="image ${list[i+x].id}">`;
                            card += '</a>'
                            card += `<p><small>Author: ${list[i+x].author}</small></p>`;
                            card += '</div></div></div>';

                            row.append(card);

                        }

                        $('#galery').append(row);

                    }

                    
                })
                .catch(error => {
                    console.error(`This is an error ${error}`);
                })
        })
}

function seePicture(picid) {
    //obj.preventDefault();

    $('#bigpicture').attr('src', list[picid].download_url);
    $('#bigpicture').attr('alt', 'picture '+list[picid].id);

    $('#original').attr('href', list[picid].url);


    //open modal
    $('#viewPicture').modal('show');
}

function more() {
    page++;
    fetchData();
}