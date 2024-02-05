const db = require("../database/UserModel.js");

const FavoritesController = {

// ---------------------------------- GRAB FAVORITES FUNCTION -----------------------------------------------------
  // on user login / sign up

  fetchFavorites: async (req, res, next) => {
    const userID = res.locals.userID;
    console.log('USER ID: ', userID);
    
    // QUERIES
    const getUserFavortiesQuery = 'SELECT favorites.id, favorites.title, favorites.href, favorites.description FROM favorites INNER JOIN member_favorites ON favorites.id = member_favorites.favorites_id INNER JOIN member ON member.id = member_favorites.member_id WHERE member.id = $1';
    const getUsernameQuery = 'SELECT username FROM member WHERE id=$1';
 
    try{
      const usernameResponse = await db.query(getUsernameQuery, [userID]);
      const favoritesResponse = await db.query(getUserFavortiesQuery, [userID]);
      console.log('FAVORITES RESPONSE: ', favoritesResponse)
      console.log('USERNAME ASSOCIATED WITH USERID: ', usernameResponse);
      res.locals.returnObject = {
        userID: userID,
        username: usernameResponse.rows[0].username,
        favorites: favoritesResponse.rows
      }
      return next()
        
    }catch (error) {
      return next({
        log: `Error occured in FavoritesController.fetchFavorites, error ${error}`, // to the develpoper
        status: 500,
        message: {
          err: "an error occured, something went wrong when fetching favs", // message to the user
        },
      }); 

    }
  },
    
// ---------------------------------- ADD FAVORITE FUNCTION -----------------------------------------------------
  //
  addFavorite: async (req, res, next) => {
  const { memberID, title, href, description } = req.body;
    // QUERIES
  const insertFavoriteQuery = 'INSERT INTO favorites (title, href, description) VALUES ($1, $2, $3) RETURNING id';
  const insertMIDnFIDJTQuery = 'INSERT INTO member_favorites (member_id, favorites_id) VALUES ($1, $2)';
  try{
    const insertFavoriteResponse = await db.query(insertFavoriteQuery, [title, href, description]);
    await db.query(insertMIDnFIDJTQuery, [memberID, insertFavoriteResponse.rows[0].id]);
    // console.log('RESPONSE FROM ADD FAV: ',insertFavoriteResponse)
    res.locals.userID = memberID;
    return next();

  }catch (error) {
      return next({
        log: `Error occured in FavoritesController.addFavorite, error ${error}`, // to the develpoper
        status: 500,
        message: {
          err: "an error occured, something went wrong when adding a fav", // message to the user
        },
      });
    }
},  

  /*

 "title": "Mars Celebration",
        "thumbnailImage": "https://images-assets.nasa.gov/image/NHQ201905310026/NHQ201905310026~thumb.jpg",
        "largeImage": "http://images-assets.nasa.gov/image/NHQ201905310026/NHQ201905310026~large.jpg",
        "description": "The Mars celebration Friday, May 31, 2019, in Mars, Pennsylvania. NASA is in the small town to celebrate Mars exploration and share the agency’s excitement about landing astronauts on the Moon in five years. The celebration includes a weekend of Science, Technology, Engineering, Arts and Mathematics (STEAM) activities. Photo Credit: (NASA/Bill Ingalls)"


  // create join table entries
  query.createMemberWorkout =
    'INSERT INTO member_workout (member_id, workout_id) VALUES ($1, $2)';
  query.createWorkoutExercise =
    'INSERT INTO workout_exercise (workout_id, exercise_id) VALUES ($1, $2)';
  */

  // ---------------------------------- DELETE FAVORITE FUNCTION -----------------------------------------------------
  // //
  // deleteFavorite: async (req, res, next) => {
  //   const { memberID, favoritesID } = req.query;
  //   // QUERY
  //   const getUserFavortiesQuery = 'DELETE FROM member_favorites WHERE member_id = $1 AND favorites_id = $2';

  //   try{
  //     const response = await db.query(getUserFavortiesQuery, [memberID, favoritesID])
  //     console.log('RESPONSE FROM DELETEFAV: ', response);
  //     res.locals.favoritesID = favoritesID;
  //     return next()
  //   }catch(error) {
  //     return next({
  //       log: `Error occured in FavoritesController.deleteFavorite, error ${error}`, // to the develpoper
  //       status: 500,
  //       message: {
  //         err: "an error occured, something went wrong when deleting fav", // message to the user
  //       },
  //     });
  //   }
    
  // },  

  
// ---------------------------------- FORGOT PASSWORD FUNCTION -----------------------------------------------------
  // forgotPassword: (req, res, next) => {},
    //Stretch Feature for now.
};

module.exports = { FavoritesController };
