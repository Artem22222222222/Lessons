function apiCallText(method, url, callback, body) {
    fetch(url, {
            method: method,
            body: JSON.stringify(body)
        }
    ).then((response) => {
            return response.text();
        }
    ).then(callback);
}

function apiCallJson(method, url, callback, body) {
    fetch(url, {
            method: method,
            body: JSON.stringify(body)
        }
    ).then((response) => {
            return response.json();
        }
    ).then(callback);
}
