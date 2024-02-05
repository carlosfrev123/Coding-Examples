import React, { useState } from 'react';
import PuzzleImage from '../components/PuzzleImage.jsx';
// import PuzzleMainContainer from './puzzleMainContainer.jsx';
// import PuzzleMainContainer from './PuzzleMainContainer.jsx';
// import pone from '/client/components/pImages/pone.png';
// import ptwo from '/client/components/pImages/ptwo.png';

const ImageSelectorContainer = (props) => {
  const { ArrayOfImageObjects, handleImgSelect } = props;
  const imgSelectButtons = ArrayOfImageObjects.map((imageObject, index) => (
    <PuzzleImage
      key={index}
      imgObject={imageObject}
      handleImgSelect={handleImgSelect}
    />
  ));
  // const puzzleOne = ArrayOfImageObjects[0];
  // const puzzleTwo = ArrayOfImageObjects[1];
  
  // const [selectedImage, setSelectedImage] = useState(null);

  // const handleImageClick = (image) => {
  //   console.log('Image clicked!');
  //   setSelectedImage(image);
  //   onSelectImage(image);
  // };

  return(
    <div id="imgSelectInnerbox">
      <h4 id="spHeader">PUZZLES</h4>
      <div className="selectImageGrid">{imgSelectButtons}</div>
    </div>
  );
};
export default ImageSelectorContainer;

// onClick={()=>handleImageClick('client/components/pImages/codeSmithLogo.png')}