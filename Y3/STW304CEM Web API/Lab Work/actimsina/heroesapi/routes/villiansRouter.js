const express = require('express');
const bodyParser = require('body-parser');

const Villians = require('../models/villians');
const villiansRouter = express.Router();

villiansRouter.use(bodyParser.json());

villiansRouter.route('/')
    .get((req, res, next) => {
        Villians.find()
            .then((villians) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(villians);
            }, (err) => next(err))
            .catch((err) => next(err));
    })
    .post((req, res, next) => {
        Villians.create(req.body)
            .then((villian) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(villian);
            }, (err) => next(err))
            .catch((err) => next(err));
    })
    .put((req, res, next) => {
        res.statusCode = 403;
        res.end('PUT operation is not supported on /villians');
    })
    .delete((req, res, next) => {
        Villians.deleteMany({})
            .then((reply) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(reply);
            }, (err) => next(err)).catch((err) => next(err));
    });

    villiansRouter.route('/:id')
    .get((req, res, next) => {
        // res.end('Will send a villian with id: ' + req.params.id);
        Villians.findById(req.params.id)
            .then((villian) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(villian);
            }, (err) => next(err))
            .catch((err) => next(err));

    })
    .post((req, res) => {
        res.statusCode = 403;
        res.end('POST is not supported on this endpoint');
    })
    .put((req, res) => {
        // res.end("Will update this villian with name: " + req.body.name + "and desc: " + req.body.desc);
        // Villians.findByIdAndUpdate(req.params.id, req.body)
        Villians.findOneAndUpdate({ _id: req.params.id }, { $set: req.body }, { new: true, useFindAndModify: false })
            .then((villian) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(villian);
            }, (err) => next(err))
            .catch((err) => next(err));
    })
    .delete((req, res, next) => {
        // res.end('Deleting the villian with id: ' + req.params.id);
        Villians.findByIdAndDelete(req.params.id)
            .then((reply) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(reply);
            }, (err) => next(err))
            .catch((err) => next(err));
    });

module.exports = villiansRouter;