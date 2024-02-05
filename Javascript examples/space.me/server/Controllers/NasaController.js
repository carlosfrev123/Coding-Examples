const TOKEN = 'UoizyCJ9LAb16Izq5eFbLulx4xzDSvodXoRV2glO';

const NasaImgController = {

 getData: async (req, res, next) => {
  const { query } = req.body;
  try {
    
    const response = await fetch(`https://images-api.nasa.gov/search?q=${query}&media_type=image`, {});
    if (response.ok) {
      const data = await response.json();

      const results = [];
      for(let i =0; i< 10; i++){
        //fetch the url that contains the array of different image sizes
        let imagesArrayFetch = await fetch(data.collection.items[i].href, {})
        let imagesArray = await imagesArrayFetch.json()
        if(imagesArray===null){
          return next({
            log: `Express error handler caught unknown middleware error: ERROR : ${error}`,
            status: 500,
            message:{
              err:'something went wrong on the server end'
            }
          })
        }
        results.push({
          title: data.collection.items[i].data[0].title,
          thumbnailImage: data.collection.items[i].links[0].href,
          largeImage: imagesArray[1],
          description: data.collection.items[i].data[0].description,
        })
      }

      res.locals.resultsObject = results;
      // res.locals.resultsObject = data;
      
      return next();
    } else {
      throw new Error(`NASA API request failed with status ${response.status}`);
    }
  } catch (error) {
    console.log('caught error', error);
    return next({
      log: `Express error handler caught unknown middleware error: ERROR : ${error}`,
      status: 500,
      message:{
        err:'something went wrong on the server end'
      }
    });
  }
},

picOfDay: async (req, res, next) => {

  try {
    const response = await fetch(`https://api.nasa.gov/planetary/apod?api_key=${TOKEN}`);
    const data = await response.json(); // Parse JSON data from the response
    res.locals.returnObject = {
      title: data.title,
      image: data.hdurl,
      description: data.explanation
    };
    return next();
  } catch (error) {
    console.log('caught error', error);
    return next({
      log: `Express error handler caught unknown middleware error: ERROR : ${error}`,
      status: error.status || 400,
      message: {
        err: "ruh'oh, something went wrong."
      }
    });
  }
},

};

module.exports = { NasaImgController };

//{"copyright":"\nWioleta Gorecka;\nText: Natalia Lewandowska \n(SUNY Oswego)\n","date":"2023-08-15","explanation":"The Sun is not the quiet place it seems.  It expels an unsteady stream of energetic electrons and protons known as the solar wind.  These charged particles deform the Earth's magnetosphere, change paths, and collide with atoms in Earth's atmosphere, causing the generation of light in auroras like that visible in green in the image left.  Earth itself is also geologically active and covered with volcanoes. For example, Fagradalsfjall volcano in Iceland, seen emitting hot gas in orange near the image center. Iceland is one of the most geologically active places on Earth. On the far right is the Svartsengi geothermal power plant which creates the famous human-made Blue Lagoon, shown emitting white gas plumes. The featured composition therefore highlights three different sky phenomena, including both natural and human-made phenomena.","hdurl":"https://apod.nasa.gov/apod/image/2308/TripleIceland_Zarzycka_6501.jpg","media_type":"image","service_version":"v1","title":"A Triply Glowing Night Sky over Iceland","url":"https://apod.nasa.gov/apod/image/2308/TripleIceland_Zarzycka_1080.jpg"}
