const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// set a schema for the 'users' collectionx
const userSchema = new Schema({
  first_name: {
    type: String,
    required: true,
  },
  last_name: {
    type: String,
    required: true,
  },
  password: {
    type: String,
    required: true,
  },
  username: {
    type: String,
    required: true,
  },
  zipcode: {
    type: Number,
    required: true,
  },
});

const User = mongoose.model('User', userSchema);

module.exports = User;
