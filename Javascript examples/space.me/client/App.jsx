import React, { useState, useEffect } from 'react';
import { Route, Routes } from 'react-router-dom';
import { useCookies } from 'react-cookie';
import Home from './Containers/Home.jsx';
import Favorites from './Containers/Favorites.jsx';
import Signup from './Containers/Signup.jsx';
import Login from './Containers/Login.jsx';
import SolarSystem from './Containers/SolarSystem.jsx';
import Themes from './Containers/Themes.jsx';
import NotFound from './Containers/NotFound.jsx';
import Navbar from './Containers/Navbar.jsx';

// App is the root container of our React-Redux application
function App() {
  // initialize user as state and setUser as its setter function
  const [user, setUser] = useState('testuser');
  // initialize cookies as state, setUser as setter, removeCookie to remove Cookie
  // Allows access and modification of cookies using React hooks
  const [cookies, setCookie, removeCookie] = useCookies(['user']);

  return (
    <>
      <Navbar />
      {/* Home route  */}
      <Routes>
        <Route
          exact
          path='/'
          element={
            <Home
              user={user}
              setUser={setUser}
              cookies={cookies}
              setCookie={setCookie}
              removeCookie={removeCookie}
            />
          }
        />
        {/* Login route */}
        <Route
          exact
          path='/login'
          element={
            <Login
              user={user}
              setUser={setUser}
              cookies={cookies}
              setCookie={setCookie}
              removeCookie={removeCookie}
            />
          }
        />
        {/* Signup route */}
        <Route
          exact
          path='/signup'
          element={
            <Signup
              user={user}
              setUser={setUser}
              cookies={cookies}
              setCookie={setCookie}
              removeCookie={removeCookie}
            />
          }
        />
        {/* Solarsystem route */}
        <Route
          exact
          path='/solarsystem'
          element={
            <SolarSystem
              user={user}
              setUser={setUser}
              cookies={cookies}
              setCookie={setCookie}
              removeCookie={removeCookie}
            />
          }
        />
        {/* Favorites */}
        <Route
          exact
          path='/favorites'
          element={
            <Favorites
              user={user}
              setUser={setUser}
              cookies={cookies}
              setCookie={setCookie}
              removeCookie={removeCookie}
            />
          }
        />
        {/* Themes */}
        <Route
          exact
          path='/themes'
          element={
            <Themes
              user={user}
              setUser={setUser}
              cookies={cookies}
              setCookie={setCookie}
            />
          }
        />
        {/* 404 unknown route */}
        <Route
          path='*'
          element={
            <NotFound
              user={user}
              setUser={setUser}
              cookies={cookies}
              setCookie={setCookie}
            />
          }
        />
      </Routes>
    </>
  );
}

export default App;
