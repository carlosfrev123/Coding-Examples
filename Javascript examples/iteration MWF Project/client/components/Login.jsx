import React, { useState, useEffect, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import './login.scss';

function Login({ loggedInSetter }) {
  //direct you anywhere as long as you have specified that path before
  const navigate = useNavigate();

  const URL = 'http://localhost:3000/login';

  const usernameRef = useRef(null);
  const passwordRef = useRef(null);

  const handleSubmit = (event) => {
    event.preventDefault();
    const username = usernameRef.current.value;
    const password = passwordRef.current.value;

    fetch(URL, {
      method: 'POST',
      mode: 'cors',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        username: username,
        password: password,
      }),
    })
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        if (data.error) {
          alert('Wrong Username/Password');
        } else {
          loggedInSetter(data);
          navigate('/home');
        }
      })
      .catch((err) => {
        console.log('Need to doublecheck username/password');
      });
  };

  return (
    <div className='login-background'>
      <form onSubmit={handleSubmit} className='login-form'>
        <p className='title'>ME WANT FOOD</p>
        <input
          ref={usernameRef}
          className='login-input'
          name='username'
          type='text'
          placeholder='Username'
        />
        <input
          ref={passwordRef}
          className='login-input'
          name='password'
          type='password'
          placeholder='Password'
        />
        <button>Login</button>
        <a href='/signup'>SIGN UP</a>
      </form>
    </div>
  );
}

export default Login;
