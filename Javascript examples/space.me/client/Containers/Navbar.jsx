import React from 'react';
import { useNavigate } from 'react-router-dom';

const Navbar = () => {
  const navigate = useNavigate();

  return (
    <>
      <header className='navbar'>
        <h1 className='navbar-title' onClick={() => navigate('/')}>
          Space.me
        </h1>
        <div className='navbar-menu-dropdown'>
          <button className='navbar-menu'>
            <i
              className='fa-solid fa-bars fa-2xl'
              style={{ color: '#eee' }}
            ></i>
          </button>
          <div className='navbar-menu-dropdown-content'>
            <ul>
              <li onClick={() => navigate('/favorites')}>Stars</li>
              <li onClick={() => navigate('/solarsystem')}>Solar System</li>
              <li onClick={() => navigate('/themes')}>Themes</li>
              <li onClick={() => navigate('/signup')}>Sign Up</li>
              <li onClick={() => navigate('/login')}>Login</li>
            </ul>
          </div>
        </div>
      </header>
    </>
  );
};

export default Navbar;
