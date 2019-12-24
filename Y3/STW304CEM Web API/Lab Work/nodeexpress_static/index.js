const express = require('express');
const http = require('http');

const app = express();

app.use(express.static(__dirname + '/public'));

app.use('/', (req, res) => {
    res.send('Hello World');
})

app.listen(3000, () => {
    console.log("Server is running at port 3000");
})