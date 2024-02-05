const express = require('express');
const path = require('path');
const router = express.Router();
const yelpController = require('../controllers/yelpController');

// 'http://localhost:3000/yelp/12238'


router.get('/', yelpController.getData, (req, res) => {
  return res.status(200).json(res.locals.rawData);
});

router.get('/:zip', yelpController.getData, (req, res) => {
  return res.status(200).json(res.locals.rawData);
});

router.post('/search', yelpController.searchData, (req, res) => {
  console.log('inside the yelp router');
  return res.status(200).json(res.locals.rawData);
});

module.exports = router;
