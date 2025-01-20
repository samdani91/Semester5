function loadData() {
    const xhr = new XMLHttpRequest(); //create a new request

    //what to do when req arrives
    xhr.onload = function () {
        const container = document.getElementById("demo");
        container.innerHTML = xhr.responseText;
        console.log("Response Finished");
    }

    //prepare req - methods: GET,POST,PUT,PATCH,DELETE ---- false:sync
    xhr.open("GET", "./data/data.txt",false);

    //send req
    xhr.send();

    console.log("Async/Sync AJAX");
}