import React from 'react';

const PieceContainer = props => (
  <button id={props.id}>
    <img id={props.id} src={props.imgPath} />
    
  </button>
);
export default PieceContainer;
// {selectedImage && <img src={selectedImage} alt="Selected Puzzle" />}
// onlcick run func passed down in props