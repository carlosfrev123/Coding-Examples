import React from 'react';
import MainContainer from './containers/MainContainer.jsx';

const App =() => {

  // add sign in button
  // add create account button

  return (
    <div className='container'>
      <div className='signInCreateAcc'>
        <button id='signInButton'>SIGN IN</button>
        <button id='createAccountButton'>CREATE ACCOUNT</button>
      </div>
      <div className="mainContainer">
        <MainContainer/>
      </div>
    </div>
  );
}
export default App;
