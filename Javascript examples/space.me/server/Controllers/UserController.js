const db = require("../database/UserModel.js");
const bcrypt = require("bcrypt");

const UserController = {
// ---------------------------------- CREATE USER FUNCTION -----------------------------------------------------

  createUser: async (req, res, next) => {
    const { username, email, password } = req.body;

    // Check if the username already exists
    const checkForUser = `SELECT COUNT(*) FROM member WHERE username = $1 OR email = $2`;
    try {
      const response = await db.query(checkForUser, [username, email]);
      const userCount = response.rows[0].count; // Extract the count value
      // console.log("response.rows: ", response.rows);
      // console.log("userCount OR  response.rows[0].count: ", userCount);
      if (userCount !== "0") {
        console.log('username/ email taken')
        res.sendStatus(401);
        return; // Return here to prevent further execution
      }
    } catch (error) {
      return next({
        log: `Error occured in UserController.createUser, line 21 error: ${error}`, // to the develpoper
        status: 500,
        message: {
          err: "an error occured, something went wrong", // message to the user
        },
      });
    }
    // Hash the password
    const hashedPassword = await bcrypt.hash(password, 10);
    // Insert the user into the database
    const insertUser = `INSERT INTO member (username, email, password) VALUES ($1, $2, $3)`;
    try {
      const response = await db.query(insertUser, [
        username,
        email,
        hashedPassword,
      ]);
      // console.log("line 36: ", response[0]);
      const grabUserIdQuery = 'SELECT id FROM member WHERE email = $1'
      const idResponse = await db.query(grabUserIdQuery, [email]);
      res.locals.userID = idResponse.rows[0].id;
    } catch (error) {
      return next({
        log: `Error occured in UserController.createUser, line 39 error: ${error}`, // to the develpoper
        status: 500,
        message: {
          err: "an error occured, something went wrong", // message to the user
        },
      });
    }
    return next();
  },

// ---------------------------------- VERIFY USER FUNCTION -----------------------------------------------------

  verifyUser: async (req, res, next) => {
    const { email, password } = req.body;
    // console.log("email: ", email);
    // console.log("password: ", password);

    //Verify the username exists before checking password
    const findUser = 'SELECT * FROM member WHERE email = $1';
    try {
      const response = await db.query(findUser, [email]);
      const hashedPassword = response.rows[0].password;
      // if username is true and (bycrypt.compare(password and username.password)) is true
      const passwordFromDB = await bcrypt.compare(password, hashedPassword);
      if (email && passwordFromDB) {
        const grabUserIdQuery = 'SELECT id FROM member WHERE email = $1'
        const idResponse = await db.query(grabUserIdQuery, [email]);
        res.locals.userID = idResponse.rows[0].id;
        console.log("res.locals.userID from verify function: ", res.locals.userID);
        return next();
      }
      // res.locals.userId = response[0]
      //
    } catch (error) {
      return next({
        log: `Error occured in verifyUser Catch: ${error}`, // to the develpoper
        status: 400,
        message: {
          err: "username or password incorrect", // message to the user
        },
      });
    }
  },

// ---------------------------------- FORGOT PASSWORD FUNCTION -----------------------------------------------------
  // forgotPassword: (req, res, next) => {},
    //Stretch Feature for now.
};

module.exports = { UserController };
