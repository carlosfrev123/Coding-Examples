import React from 'react';
import BigImage from '../Components/BigImage';
import SpaceFact from '../Components/SpaceFact';

const BigImageContainer = () => {
  return (
    <>
      <main className='main'>
        <div className='main-big-image-container'>
          <BigImage />
          <SpaceFact />
        </div>
      </main>
    </>
  );
};

export default BigImageContainer;
