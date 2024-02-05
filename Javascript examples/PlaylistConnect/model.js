const mongoose = require('mongoose');


// add schema here

const MainObject = new mongoose.Schema({
  allGroups: {
    // type: String,
    // required: true, -> do we need this property?
  },
  allUsers: {
    //type: String,
    //required: true,
  },
});

module.exports = mongoose.model('mainObj', MainObject);
