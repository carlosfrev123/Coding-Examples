import React from 'react';
import { Route, Routes, Link } from 'react-router-dom';
import './card.scss';

const Card = (props) => {
  const { picUrl, name, location, closes, price } = props;
  console.log(location);

  const locationLines = location.map((line) => (
    <p className='location' key={location.indexOf(line)}>
      {line}
    </p>
  ));

  return (
    <div className='card'>
      <div className='detail-container'>
        {' '}
        <div className='img-container'>
          <img src={picUrl} alt='restuarant' className='posted-img img' />
        </div>
        <div className='card-details'>
          <h5 className='card-name'>{name}</h5>
          {locationLines}
          <p className='description'>
            {price ? price : 'Price is not available'}
          </p>
          <p className='cost'>{closes ? 'Open' : 'Closed'}</p>
        </div>
      </div>
    </div>
  );
};

export default Card;
