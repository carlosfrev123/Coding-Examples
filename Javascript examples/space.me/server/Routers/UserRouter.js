const express = require('express');
const UserRouter = express.Router();
const { UserController } = require('../Controllers/UserController.js');
const { FavoritesController } = require('../Controllers/FavoritesController.js');
// const { default: Favorites } = require('../../client/Containers/Favorites.jsx');

UserRouter.post('/signup', UserController.createUser, FavoritesController.fetchFavorites, (req, res) => {
    return res.status(200).json(res.locals.returnObject);
});

UserRouter.post('/login', UserController.verifyUser, FavoritesController.fetchFavorites, (req, res) => {
    return res.status(200).json(res.locals.returnObject);
    // return res.status(200);
});

UserRouter.post('/addFavorite', FavoritesController.addFavorite, FavoritesController.fetchFavorites, (req,res)=>{
  return res.status(200).json(res.locals.returnObject);
});

// UserRouter.delete('/deleteFavorite', FavoritesController.deleteFavorite, (req,res)=>{
//   return res.status(200).json(res.locals.favoritesID);
// });

module.exports = { UserRouter };