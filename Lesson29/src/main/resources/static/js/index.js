
function add() {
    apiCallText('POST', '/api/add');
}

function read() {
    apiCallText('GET', '/api/read', (text) => {
        document.getElementById('number').innerText = text;
    });
}

//read();
