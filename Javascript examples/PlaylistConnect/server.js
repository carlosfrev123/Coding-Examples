const express = require('express');
const app = express();
const path = require('path');
const mainObj = require('./Model.js');
const Controller = require('./Controller.js');


// Select the database to use.
use('mainDataStorage');

// Insert a few documents into the sales collection.
db.getCollection('users').insertMany([
  { username: 'dummyUser', password: 'asdf', groupIDs:['1'] },
]);



// mongoose.connect('insert url'{ useNewUrlParser: true, useUnifiedTopology: true })
// mongoose.connection.once('open', () => {
//   console.log('Connected to Database');
// });
// app.use(express.urlencoded({ extended: true }));
// app.use(express.json());

// app.get('/signup',..)

// statically serve everything in the build folder on the route '/build'
app.use('/', express.static(path.join(__dirname, '../')));
// serve index.html on the route '/'
app.get('/', (req, res) => {
  return res.status(200).sendFile(path.join(__dirname, '../index.html'));
});

app.listen(3000); //listens on port 3000 -> http://localhost:3000/

// d3KkR6wrS8ZWDkQN
// carlosfrev123


// mongodb+srv://carlosfrev123:d3KkR6wrS8ZWDkQN@maindb.kcu0qnr.mongodb.net/