const express = require("express");
const app = express();
const path = require("path");
const cors = require("cors");
const mongoose = require("mongoose");
const axios = require("axios");

const userController = require("./controllers/userController");

// add route import
// add model import

const dbUrl =
  "mongodb+srv://sebastiansarm:1234@cluster0.at2e2ez.mongodb.net/?retryWrites=true&w=majority";

mongoose
  .connect(dbUrl, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    dbName: "MeWantFood",
  })
  .then(() => console.log("Connected to DB"))
  .catch((err) => console.log(err));

// handle parsing request body
app.use(cors());
app.use(express.urlencoded({ extended: true }));
app.use(express.json());

console.log("HI");
// allows us to store the cookie on our backend
// app.use(cookieParser());

// statically serve everything in the build folder on the route '/build'
app.use(express.static(path.join(__dirname, "../build")));
// serve index.html on the route '/'
app.get("/", (req, res) => {
  return res.status(200).sendFile(path.join(__dirname, "../index.html"));
});

//YELP API REQUEST
// get request for yelp.
const yelpRouter = require("./routes/yelp");
app.use("/yelp", yelpRouter);

// post method for user to db
app.post("/signup", userController.createUser, (req, res) => {
  console.log("--entering post method for route--");
  return res.status(200).json(res.locals.newUser);
});

app.post("/login", userController.getUser, (req, res) => {
  // upon successful sign up
  return res.status(200).json(res.locals.user);
});
// app.use('/dashboard', routenamevar);

// Serve index.html for all routes
app.get("*", (req, res) => {
  res.sendFile(path.join(__dirname, "../index.html"));
});

// // ----------- TESTING STUFFS -----------

// const BEARER_TOKEN3 =
//   "3fL-Z1zOIZnAWPYAVo462Sbf4R9ODxQ0CQXTW2KXAFRQeLuHyX38jrBGDIeplBuy04evgJvqVMj3zUhR1mFN2WzaxnyVRwvwboqceelX108pa3gL2jFOoyTXnj-fZHYx";

// // dummy zipCode
// // const location = ;

// // config file for fetching from yelp
// // use the limit to adjust the number of restaurants displayed
// // you can also change the term to another one to get any business
// const fetchInfo = {
//   headers: {
//     Authorization: `Bearer ${BEARER_TOKEN3}`,
//     Origin: "localhost",
//     withCredentials: true,
//   },
//   params: {
//     term: "restaurants",
//     location: 22181,
//     radius: 5000,
//     limit: 3,
//   },
// };

// const getData = async () => {
//   axios
//     .get("https://api.yelp.com/v3/businesses/search", fetchInfo)
//     .then((response) => {
//       console.log("logging response.data", response.data);
//       console.log(
//         "logging categories for one object",
//         response.data.businesses[2].categories
//       );
//       console.log(
//         "logging categories for one object",
//         response.data.businesses[2].transactions
//       );
//       return response.data;
//     })
//     .catch((error) => {
//       console.log(error);
//       // return next({
//       //   log: `Express error handler caught unknown middleware error: ERROR : ${error}`,
//       //   status: error.status || 400,
//       // });
//     });
// };

// getData();

/**
 * HELLO!
 * global express error handler
 */
app.use((err, req, res, next) => {
  const defaultErr = {
    log: "Express error handler caught unknown middleware error",
    status: 500,
    message: { err: "An error occurred" },
  };
  const errorObj = Object.assign({}, defaultErr, err);
  console.log(errorObj.log);
  return res.status(errorObj.status).json(errorObj.message);
});

app.listen(3000, () => {
  console.log("Express listening on port 3000");
}); //listens on port 3000 -> http://localhost:3000/

module.exports = app;
