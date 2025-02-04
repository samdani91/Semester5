function loadData(myCallBackF) {
    const xhr = new XMLHttpRequest(); //create a new request

    //what to do when req arrives
    xhr.onload = function () {
        myCallBackF(xhr);
    }

    //prepare req - methods: GET,POST,PUT,PATCH,DELETE
    xhr.open("GET", "./data/data.txt");

    //send req
    xhr.send();
}

function myCallBack1(xhr) {
    const container = document.getElementById("demo");
    container.innerHTML = xhr.responseText;
}

function myCallBack2(xhr) {
    const container = document.getElementById("demo2");
    container.innerHTML = xhr.responseText;
}