var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var mongoose = require('mongoose');

const url = 'mongodb://localhost:27017/mydb';
const connect = mongoose.connect(url, { useNewUrlParser: true });

connect.then((db) => {
    console.log("Connected correctly to server.");
}, (err) => { console.log(err); });

// var indexRouter = require('./routes/index');
// var usersRouter = require('./routes/users');

var herosRouter = require('./routes/heroesRouter');
var villiansRouter = require('./routes/villiansRouter');

var app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use(function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, text/plain, Accept");
    next();
});

app.use('/heroes', herosRouter);
app.use('/villians', villiansRouter);
// app.use('/', indexRouter);
// app.use('/users', usersRouter);

module.exports = app;