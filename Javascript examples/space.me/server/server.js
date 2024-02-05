// import Express functionality, CORS, and init port on 3000
const express = require('express');
const cors = require('cors');
const path = require('path');
// import routers
const { NasaImgRouter } = require('./Routers/NasaApiRouter.js');
const { UserRouter } = require('./Routers/UserRouter.js');

const db = require('./database/UserModel.js');

const host = '0.0.0.0';
const PORT = process.env.PORT || 3000;

// init const app as express server
const app = express();

app.use(cors());
app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use('/api', NasaImgRouter);
app.use('/user', UserRouter);

// Serve static assets
app.use('/assets', express.static(path.resolve(__dirname, '../assets')));

// Serve index.html
app.get('/', (req, res) => {
  return res.status(200).sendFile(path.join(__dirname, '../client/index.html'));
});

// Catch-all route
app.get('*', (req, res) => {
  res.sendStatus(404);
});

// Global error handler
app.use((err, req, res, next) => {
  console.log(err);
  const defaultErr = {
    log: 'Express error handler caught unknown middleware error',
    status: 400,
    message: { err: 'An error occurred' },
  };
  const errorObj = Object.assign({}, defaultErr, err);
  console.log(errorObj.log);
  return res.status(errorObj.status).json(errorObj.message);
});

app.listen(PORT, host, () => {
  console.log(`server started on ${PORT}`);
});

// API KEY
// UoizyCJ9LAb16Izq5eFbLulx4xzDSvodXoRV2glO
