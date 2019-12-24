const express = require('express');
const bodyParser = require('body-parser');
const heroesRouter = require('./routes/heroesRouter');
const mongoose = require('mongoose');
const app = express();

const url = 'mongodb://localhost:22222/mydb';
const connect = mongoose.connect(url);

connect.then(
    (db) => {
        console.log('Succesfully connected to db')
    },
    (err) => {
        console.log(err);
    }
);

app.use('/heroes', heroesRouter);

express.static(__dirname + "/public");
app.listen(3000, () => {
    console.log("Express is running");
});


/* app.all('/heroes', (req, res, next) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    next();
});

app.get('/heroes', (req, res) => {
    res.end("Will return you heroes.");
});

app.post('/heroes', (req, res) => {
    res.end('Will add a new hero with name: ' + req.body.name + ' and ' + req.body.description);
});

app.put('/heroes', (req, res) => {
    res.statusCode = 403;
    res.end('Operation not supported');
});

app.delete('/heroes', (req, res) => {
    res.end('Deleting all heroes.');
});

app.all('/heroes/:id', (req, res, next) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    next();
});

app.get('/heroes/:id', (req, res) => {
    res.end('Fetching a hero with id: ' + req.params.id);
});

app.post('/heroes/:id', (req, res) => {
    res.statusCode = 403;
    res.end('Operation not supported.');
});

app.put('/heroes/:id', (req, res) => {
    res.end('Updating a hero with id: ' + req.params.id);
});

app.delete('/heroes/:id', (req, res) => {
    res.end('Deleting a hero with id: ' + req.params.id);
}); */