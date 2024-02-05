const { v4: uuidv4 } = require('uuid');
const CookieController = {};

CookieController.setSSID = (req, res, next) => {
  // console.log('----cookiecontroller.setSSID is starting now----');
  // res.cookie('codesmith', 'hi');
  res.locals.ssid = uuidv4();
  // console.log('uuid number: ', res.locals.ssid);
  res.cookie('ssid', res.locals.ssid, {
    httpOnly: true,
    // Secure: true,
    maxAge: 900000000000, // 15 minutes
  });
  return next();
};

module.exports = CookieController;
