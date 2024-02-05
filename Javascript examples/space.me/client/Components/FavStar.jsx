import React, { useState } from 'react';

// favorite star Icon
function FavStar() {
	const [isFavorite, setIsFavorite] = useState(false);

	return (
		<>
			<i
				className="fav-star fa-solid fa-star fa-2xl"
				onClick={() => setIsFavorite((prev) => !prev)}
				style={
					isFavorite ? { color: 'orange' } : { color: '#333', opacity: '50%' }
				}
			></i>
		</>
	);
}

export default FavStar;
