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
            }).catch(err => next(err));
    })

    .post((req, res, next) => {
        Heroes.create(req.body)
            .then((hero) => {
                res.statusCode = 200;
                res.setHeader('Content-Type', 'application/json');
                res.json(hero);
            })
            .catch(err => next());
    })

    .put((req, res) => {
        res.statusCode = 403;
        res.setHeader('Content-Type', 'application/json');
        res.end('Operation not supported');
    })

    .delete((req, res) => {
        Heroes.remove()
            .then((reply) => {
                res.statusCode(200);
                res.setHeader('Content-Type', 'application/json')
            }).catch(err => next(err));
    });

heroesRouter.route('/:id')
    .get((req, res, next) => {

    }).post((req, res, next) => {
        res.statusCode = 403;
        res.setHeader('Content-Type', 'application/json');
        res.json(hero);
    }).put((req, res, next) => {

    }).delete((req, res, next) => {

    });

module.exports = heroesRouter;