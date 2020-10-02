function getAllVideo() {
    return new Promise((resolve,reject) => {
        $.ajax({
            url: 'http://b2ae410e4ff9.ngrok.io/video',
            method: 'GET',
            success(data) {
                resolve(data);
            },
            error(err) {
                reject(err);
            }
        });   
    });
}

function creatPage(data) {
    for(let video of data) {
        let card = document.createElement('button');
        card.className = "pageOne";
        let image = document.createElement('img');
        let prew = video.preview;
        image.setAttribute('src',prew);
        let br = document.createElement('br');
        let nameVideo = document.createElement('div');
        let timeVideo = document.createElement('div');
        let id = video.id;
        nameVideo.innerText = video.name;
        timeVideo.innerText = video.duration;
        card.appendChild(image);
        card.appendChild(br);
        card.appendChild(nameVideo);
        card.appendChild(br);
        card.appendChild(timeVideo);
        document.body.appendChild(card);
        card.onclick = () => {
            onVideo(id).then(
                (data) => {
                    showDialog(data);
                }
            );
        }
        
    }
}
function onePage () {
    getAllVideo().then(
        (data) =>{ 
            creatPage(data);
        },
        (err) =>{
        console.log (err);
        }
    )
}
onePage();

function showDialog(data) {
    let close = document.createElement('img');
    close.innerText = '&times';
    let vid = document.getElementById('video');
    vid.setAttribute('src',data.url)    
    let dialog = document.getElementById('dialog');
    dialog.style.display = 'block';
    dialog.appendChild(close);
    
    
    
}

function onVideo(id) {
    return new Promise((resolve,reject) => {
        $.ajax({
               url: 'http://b2ae410e4ff9.ngrok.io/video/' + id,
           success(data) {
               resolve(data);
           },
           error(err) {
               reject(err);
           }
       });   
   });
}
