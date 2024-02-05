import React from 'react';
import BigImageContainer from '../Containers/BigImageContainer.jsx';
import SmallTileContainer from '../Containers/SmallTileContainer.jsx';

const Home = () => {
	return (
		<div className="home">
			<BigImageContainer />
			<button className="main-button">Give me more, Spaceman</button>
			<SmallTileContainer />
		</div>
	);
};

export default Home;
