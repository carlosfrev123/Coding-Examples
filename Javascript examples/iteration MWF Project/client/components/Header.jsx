import React, { useState } from 'react';
import { Link, Outlet } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import './header.scss';
import axios from 'axios';

const Header = ({ loggedInUser, loggedInSetter, zipcodeSetter }) => {
  const [searchParams, setSearchParams] = useState({
    term: '',
    location: '',
  });

  const navigate = useNavigate();

  const logout = () => {
    loggedInSetter(null);
    navigate('/');
  }  

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('clicked');
    console.log(searchParams.location);
    zipcodeSetter(searchParams.location);

    // axios
    //   .post('/yelp/search', searchParams)
    //   .then((response) => {
    //     console.log('data sent to server');
    //     console.log(response.data);
    //   })
    //   .catch((error) => console.log(error));
  };

  return (
    <>
      <main className='header'>
        {/* left corner logo  */}
        <h3 className='logo-form'>MeWantFood</h3>
        <form onSubmit={handleSubmit} className='nav-btn-container'>
          <input
            name='preference'
            type='text'
            placeholder='WHAT TO EAT?'
            className='input-header'
            value={searchParams.term}
            onChange={(e) =>
              setSearchParams({ ...searchParams, term: e.target.value })
            }
          />
          <input
            name='preference'
            type='text'
            placeholder='Enter Location'
            className='input-header'
            value={searchParams.location}
            onChange={(e) =>
              setSearchParams({ ...searchParams, location: e.target.value })
            }
          />
          <button className='btn search-btn'>Search</button>
        </form>
        <div className='account-container'>
        <div className='account-name-container'>
            <p className='account-name'>{loggedInUser.first_name} {loggedInUser.last_name}</p>
          </div>
          <div onClick={logout} className='profile-pic-plain-color'>LogOut</div>
        </div>
      </main>
    </>
  );
};

export default Header;
