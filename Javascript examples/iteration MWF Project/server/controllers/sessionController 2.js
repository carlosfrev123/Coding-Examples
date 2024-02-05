const Session = require('../models/sessionModel');

const SessionController = {};

SessionController.startSession = (req, res, next) => {
  console.log('----session is starting now----')
  Session.create({ cookieId: res.locals.ssid })
    .then(() => next())
    .catch((err) => {
      return next({
        log: `SessionController.startSession ERROR: ${err}`,
        status: 500,
        message: { error: 'Error in starting session. See log.' },
      });
    });
};

SessionController.isLoggedIn = (req, res, next) => {
  Session.findOne({ cookieId: req.cookies.ssid })
    .then((session) => {
        if (!session) {
            // session invalid or expired
            return res.redirect('/login');
        } else {
            // session is valid
            return next();
        }
    })
    .catch((err) => {
      // catching database error
      return next({
        log: `SessionController.isLoggedIn ERROR: ${err}`,
        status: 500,
        message: { error: 'An error occurred in SessionController.isLoggedIn' },
      });
    });
};

module.exports = SessionController;
