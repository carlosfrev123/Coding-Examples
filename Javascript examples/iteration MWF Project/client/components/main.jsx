import React, { useState, useEffect } from 'react';
import Card from './Card';
import './main.scss';
import axios from 'axios';

const Main = ({ fetchedData, loggedInUser }) => {
  // const zipcode = loggedInUser.zipcode ? loggedInUser.zipcode : '11238';
  // console.log('console log zipcode from MAIN.jsx : ', loggedInUser.zipcode);
  // const [fetchedData, setFetchedData] = useState([]);

  // useEffect(() => {
  //   axios
  //     // .get(`http://localhost:3000/yelp/${loggedInUser.zipcode}`)
  //     .get(`http://localhost:3000/yelp/${zipcode}`)
  //     .then((response) => {
  //       const rawData = response.data.businesses;
  //       setFetchedData(rawData);
  //     })
  //     .catch((err) => console.log(err));
  // }, []);

  return (
    <article className='main'>
      {fetchedData.map((item) => (
        <Card
          key={item.id}
          name={item.name}
          location={item.location.display_address}
          closes={item.is_closed}
          price={item.price}
          picUrl={item.image_url}
        />
      ))}
    </article>
  );
};

export default Main;
