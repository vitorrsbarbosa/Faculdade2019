const express = require('express');
const DevController = require('./controllers/DevController');

const routes = express.Router();

routes.get('/',(req, res) => {
    return res.json({ message: `hey, ${req.query.name} shounen` });
});


routes.post('/devs',DevController.store);

module.exports = routes;