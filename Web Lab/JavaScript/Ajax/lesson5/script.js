function sendRequest(method, url, data) {

    const promise = new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();

        xhr.onload = function () {
            // console.log(xhr.response);
            // console.log(JSON.parse(xhr.responseText));
            if(xhr.status >= 400){
                reject(`There was an application error and the response status is ${xhr.status} and response text is ${xhr.statusText}`);
            }else{
                resolve(xhr.response);
            }
        }

        xhr.onerror = function(){
            console.log("There was an error");
        }

        xhr.open(method, url);

        xhr.responseType = "json";

        xhr.send(data);
    });

    return promise;
}

function getData() {
    sendRequest("GET", "https://jsonplaceholder.typicode.com/tdos/1").then((responseData) => {
        console.log(responseData);
    }).catch((err)=>{
        console.log(err);
    });
}

function sendData() {
    sendRequest("POST", "https://jsonplaceholder.typicode.com/posts",JSON.stringify({
        title: "foo",
        body: "bar",
        userID: 1,
    })).then((responseData) => {
        console.log(responseData);
    }).catch((err)=>{
        console.log(err);
    });
}

const getButton = document.getElementById("get");
const sendButton = document.getElementById("send");

getButton.addEventListener("click", getData);
sendButton.addEventListener("click", sendData);