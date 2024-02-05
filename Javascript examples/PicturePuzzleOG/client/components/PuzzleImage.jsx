import React from 'react';

const PuzzleImage = (props) => {
  const{ imgObject, handleImgSelect} = props;

  const handleClick = () =>{
    handleImgSelect(imgObject.name);
  }
  return(
    <button className="siButton" onClick={handleClick}>
    <img className="puzzleImage" src={imgObject.main} />
  </button>
  
  );
};
export default PuzzleImage;
// {selectedImage && <img src={selectedImage} alt="Selected Puzzle" />}