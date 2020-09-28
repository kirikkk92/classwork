let timerID = 0;

function search(text) {
    clearInterval(timerID);
    timerID = setTimeout(()=> {
        sendRequest(text);
    },500);
}

function sendRequest(text) {
    console.log(`request: ${text} sended`);
}