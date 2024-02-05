import React,{ useState } from 'react';

import PuzzleMainContainer from './PuzzleMainContainer.jsx';
import ImageSelectorContainer from './ImageSelectorContainer.jsx';


const MainContainer = () => {
  const imgObjArray = [];

  const pone = {
    name: 'pone',
    main:'client/components/pImages/pone.png',
    scrambled: false
  }
  imgObjArray.push(pone);

  const ptwo = {
    name: 'ptwo',
    main:'client/components/pImages/ptwo.png',
    scrambled: false
  }
  imgObjArray.push(ptwo);
  
  const [puzzleName, setPuzzleName] = useState('d');
  const [piecePositions, setPiecePositions] = useState(['TL', 'TR', 'BL', 'BR']);

  // handleImageSelect
  const handleImgSelect = (name) => {
    if(name){
      setPuzzleName (name);
      const defState = ['TL', 'TR', 'BL', 'BR'];
      setPiecePositions(defState);
      // console.log('name: ', name);
      // console.log('puzzleName: ', name);
    }
  };

  const handleReset = () => {
      const defState = ['TL', 'TR', 'BL', 'BR'];
      setPiecePositions(defState);
    
  };
 
  // handleScramble function
  const handleScramble = () => {
    const scrambledPositions = [...piecePositions]; // need spread operator here for live scramble
    for (let i = scrambledPositions.length - 1; i >= 0; i--) {
      const rn = Math.floor(Math.random() * (i + 1));
      [scrambledPositions[i], scrambledPositions[rn]] = [scrambledPositions[rn], scrambledPositions[i]];
    }
    setPiecePositions(scrambledPositions); // updateState
  };
  // currently scrambling all puzzles


 
  return(
    <div>
      <div className="titleBox">
        <h1 id="mheader">PicturePuzzle</h1> 
      </div>
        <PuzzleMainContainer puzzleName={puzzleName} piecePositions={piecePositions} handleScramble={handleScramble} handleReset = {handleReset}/>
        <ImageSelectorContainer ArrayOfImageObjects={imgObjArray} handleImgSelect={handleImgSelect} />
        <div className="timer"> 0:00.00 ------- Timer doesnt work but wouldnt it be cool if it did.</div>
    </div>
  );
}

export default MainContainer;



/*                     --- RANDOM COMMENTS ---

// /ArrayOfImageObjects={imgObjArray}
imgObjArray[clickedObjectIndex] = {
        ...imgObjArray[clickedObjectIndex],
        TL: `client/components/pImages/${nameOfImgClicked}TL.png`,
        TR: `client/components/pImages/${nameOfImgClicked}TR.png`,
        BL: `client/components/pImages/${nameOfImgClicked}BL.png`,
        BR: `client/components/pImages/${nameOfImgClicked}BR.png`,
      };
 */
