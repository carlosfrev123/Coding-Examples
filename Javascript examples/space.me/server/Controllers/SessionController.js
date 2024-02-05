const SessionController = {
  createSession: async (req, res, next) => {
    const { userID } = res.locals.id;

//     INSERT INTO sessions (id, cookie_id, created_at, expires)
//     VALUES (
//     1, -- Replace with the actual member ID
//     'some_cookie_id',
//     now(), -- Replace with the current timestamp
//     now() + interval '1 hour' -- Replace with the desired expiration duration
// );





  }
};


// SessionController.startSession = (req, res, next) => {
//   console.log('----in startSession middleware function----')
  
//   Session.create({ cookieId: res.locals.user })
//     .then(() => next())
//     .catch((err) => {
//       return next({
//         log: `SessionController.startSession ERROR: ${err}`,
//         status: 500,
//         message: { error: 'Error in starting session. See log.' },
//       });
//     });
// };

// SessionController.isLoggedIn = async (req, res, next) => {
//   await Session.find({ cookieId: res.locals.user})
//     .then((session) => {
//             // session is valid
//             console.log('sessionV?: ', session)
//             return next();
//         }
//     )
//     .catch((err) => {
//       // catching database error
//       return next({
//         log: `SessionController.isLoggedIn ERROR: ${err}`,
//         status: 500,
//         message: { error: 'An error occurred, no session active' },
//       });
//     });
// };

// // add logout function

module.exports = { SessionController };
