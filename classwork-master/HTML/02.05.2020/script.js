function getBooks() {
    return new Promise((resolve,reject)=> {
       $.ajax({
           url:"http://gen.lib.rus.ec/json.php?ids=1,2&fields=Title,Author,MD5",
           method:"GET",
           success(data) {
            resolve(data);
           },
           error(err) {
               reject(err);
           }
       }); 
    });
}

function showBooks(data){
    let table = document.getElementsByTagName("table")[0];
    table.tBodies[0].innerHTML = "";
    for(let book of data) {
        //создаем строку в которую поместим описание книги
        let tr = document.createElement("tr");
        let authorTd = document.createElement("td");
        let titleTd = document.createElement("td");
        authorTd.innerText = book.author;
        titleTd.innerText = book.title;
        tr.appendChild(authorTd);
        tr.appendChild(titleTd);
        table.tBodies[0].appendChild(tr);
    }
}

function update() {
    getBooks().then(
        (data) => {
            showBooks(data);
        },
        (err) => {
            console.log(err);
        }
    )
}

update();