import { combineReducers } from 'redux';
import nasaReducer from './nasaReducer';
import userReducer from './userReducer';

// import all reducers here

// combine reducers
const reducers = combineReducers({
	nasa: nasaReducer,
	user: userReducer,
});

// make the combined reducers available for import
export default reducers;
