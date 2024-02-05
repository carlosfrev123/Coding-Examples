import React,{ useState } from 'react';
// import { useSelector, useDispatch } from 'react-redux';
import PieceContainer from '../components/PieceContainer.jsx';

const PuzzleMainContainer = (props) => {
  const { puzzleName, piecePositions, handleScramble, handleReset} = props;
 

  const piecePositionsID =['idTL', 'idTR', 'idBL', 'idBR'];
  const puzzlePieces = [];
  for(let i =0; i < 4; i++){
    puzzlePieces.push(
      <PieceContainer
        key={i}
        id={piecePositionsID[i]}
        imgPath={`/client/components/pImages/${puzzleName}${piecePositions[i]}.png`}
        />
    );
  }
  
  return(
      <div id="puzzleContainer">
        <div className='piecesContainer'>{puzzlePieces}</div>
        <div className='startReset'> <button id='startButton' onClick={handleScramble}>SRAMBLE/ START-TIMER</button> 
        <button id='resetButton' onClick={handleReset}>RESET</button>
        </div>
      </div>
  );
};
export default PuzzleMainContainer;

