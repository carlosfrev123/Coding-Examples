import React, { useState, useEffect } from 'react';
import { Route, Routes } from 'react-router-dom';
import Login from './Login.jsx';
import Signup from './Signup.jsx';
import Dashboard from './Dashboard.jsx';
import './app.scss';

function App() {
  const [loggedInUser, setLoggedInUser] = useState();

  const loggedInSetter = setLoggedInUser;

  return (
    <>
      <Routes>
        {!loggedInUser && <Route exact path='/' element={<Login loggedInSetter={loggedInSetter}/>}></Route>}
        <Route exact path='/signup' element={<Signup />}></Route>
        {loggedInUser && <Route exact path='/home' element={<Dashboard loggedInUser={loggedInUser} loggedInSetter={loggedInSetter}/>}></Route>}
      </Routes>
    </>
  );
}

export default App;
