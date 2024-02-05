import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';

// Login is a function that handles the login logic and renders the Login parent container
function Login() {
	// navigate is an instance of useNavigate that allows redirecting using React-Router
	const navigate = useNavigate();
	const dispatch = useDispatch();
	// userLogin retrieves email and password information and sends a POST request to frontend
	const userLogin = () => {
		// init email and password as values of email and password input fields
		const email = document.forms['login']['email'].value;
		const password = document.forms['login']['password'].value;
		// send POST request to login endpoint
		fetch('/user/login', {
			method: 'POST',
			body: { email: email, password: password },
		})
			// parse data from JSON into JS
			.then((data) => data.json())
			// then, dispatch action to userReducer
			.then((data) => {
				dispatch(data);
			})
			// throw new error if fetch request runs into any errors
			.catch((err) => {
				throw new Error('Error logging user in:', err);
			});
	};
	return (
		<div className="form-container">
			<div className="login-container">
				<h2>Log In</h2>
				<form
					className="login-form"
					name="login"
					onSubmit={userLogin}
					action="/user/login"
					method="POST"
				>
					<label htmlFor="email">Email</label>
					<input
						type="text"
						id="email"
						name="email"
						placeholder="Enter your email here"
						pattern="[/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g]"
						autoFocus
						required
					></input>
					<label htmlFor="password">password</label>
					<input
						type="text"
						id="password"
						name="password"
						placeholder="Enter your password here"
						required
					></input>
				</form>
				{/* need to add logic for handling when user forgets their password */}
				<div className="login-form-links">
					<button className="login-form-button" type="submit">
						Log In
					</button>
					<button className="form-links" onClick={() => navigate('/signup')}>
						Forgot your password?
					</button>
					<button className="form-links" onClick={() => navigate('/signup')}>
						Don't have an account? Sign up
					</button>
				</div>
			</div>
		</div>
	);
}

export default Login;
