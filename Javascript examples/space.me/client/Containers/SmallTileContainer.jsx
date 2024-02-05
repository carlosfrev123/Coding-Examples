import React from 'react';
import SmallTile from '../Components/SmallTile';

const SmallTileContainer = () => {
  const imageArray = ['x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'];
  const smallTiles = imageArray.map((e) => <SmallTile />);

  return <div className='small-tile-container'>{smallTiles}</div>;
};

export default SmallTileContainer;
