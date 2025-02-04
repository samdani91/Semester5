function loadData() {
    const xhr = new XMLHttpRequest(); //create a new request

    //what to do when req arrives
    xhr.onload = function () {
        const container = document.getElementById("demo");
        container.innerHTML = xhr.responseText;

        console.log(xhr.getAllResponseHeaders());
        console.log(xhr.getResponseHeader('last-modified'));
        
    }

    //prepare req - methods: GET,POST,PUT,PATCH,DELETE
    xhr.open("GET", "./data/data.txt");

    //send req
    xhr.send();
}