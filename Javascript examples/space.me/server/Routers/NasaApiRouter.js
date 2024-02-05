const express = require('express');
const NasaImgRouter = express.Router();
const { NasaImgController } = require('../Controllers/NasaController.js');

NasaImgRouter.get('/apod', NasaImgController.picOfDay, (req, res) => {
  return res.status(200).json(res.locals.returnObject);
});

NasaImgRouter.post('/search', NasaImgController.getData, (req, res) => {
  console.log('inside the NasaImgRouter');
  return res.status(200).json(res.locals.resultsObject);
});
//localhost:3000/api/search?=

module.exports = { NasaImgRouter };
