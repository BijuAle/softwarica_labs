const express = require('express');
const bodyParser = require('body-parser');

const Heroes = require('../models/heroes');
const heroesRouter = express.Router();

heroesRouter.use(bodyParser.json());

heroesRouter.route('/')
    .get((req, res, next) => {
        Heroes.find()
            .then((heroes) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(heroes);
            }, (err) => next(err))
            .catch((err) => next(err));
    })
    .post((req, res, next) => {
        Heroes.create(req.body)
            .then((hero) => {
                console.log('Hero Created ', hero);
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(hero);
            }, (err) => next(err))
            .catch((err) => next(err));
    })
    .put((req, res, next) => {
        res.statusCode = 403;
        res.end('PUT operation is not supported on /heroes');
    })
    .delete((req, res, next) => {
        Heroes.deleteMany({})
            .then((reply) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(reply);
            }, (err) => next(err)).catch((err) => next(err));
    });


heroesRouter.route('/:id')
    .get((req, res, next) => {
        // res.end('Will send a hero with id: ' + req.params.id);
        Heroes.findById(req.params.id)
            .then((hero) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(hero);
            }, (err) => next(err))
            .catch((err) => next(err));

    })
    .post((req, res) => {
        res.statusCode = 403;
        res.end('POST is not supported on this endpoint');
    })
    .put((req, res) => {
        // res.end("Will update this hero with name: " + req.body.name + "and desc: " + req.body.desc);
        // Heroes.findByIdAndUpdate(req.params.id, req.body)
        Heroes.findOneAndUpdate({ _id: req.params.id }, { $set: req.body }, { new: true, useFindAndModify: false })
            .then((hero) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(hero);
            }, (err) => next(err))
            .catch((err) => next(err));
    })
    .delete((req, res, next) => {
        // res.end('Deleting the hero with id: ' + req.params.id);
        Heroes.findByIdAndDelete(req.params.id)
            .then((reply) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(reply);
            }, (err) => next(err))
            .catch((err) => next(err));
    });


heroesRouter.route('/:id/comments')
    .get((req, res, next) => {
        Heroes.findById(req.params.id)
            .then((hero) => {
                if (hero != null) {
                    res.statusCode = 200;
                    res.setHeader('Content-Type', 'application/json');
                    res.json(hero.comments);
                } else {
                    err = new Error('Hero ' + req.params.id + ' not found!');
                    err.status = 404;
                    return next(err);
                }
            }).catch((err) => next(err));
    });

module.exports = heroesRouter;

