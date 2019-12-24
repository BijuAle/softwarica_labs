// install express, morgan, parser, modemon (with -g)

const express = require('express');
const morgan = require('morgan');
const app = express();

app.use(morgan('dev'));

app.listen(3000, ()=>{
    console.log("Express is running.");    
});

app.all('/heroes',(rep, res, next)=>{
    res.statusCode = 200;
    res.setHeader('Content-Type','text/plain');
    next();
});

app.get('/heroes', (req, res)=>{
    res.end("Will send all heroes.");
});

app.get('/heroes/:id', (req, res)=>{
    res.end("Will send you a hero. " + req.params.id);
});