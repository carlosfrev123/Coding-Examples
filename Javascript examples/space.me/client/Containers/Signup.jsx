import React from 'react';
import { useNavigate } from 'react-router-dom';

// renders Signup page components
function Signup() {
	const navigate = useNavigate();
	const inputValidate = () => {
		let password = document.forms['signup']['password'].value;
		let confirmPassword = document.forms['signup']['confirmpassword'].value;
		if (password !== confirmPassword) {
			alert('passwords must match');
			return false;
		}
	};
	return (
		<div className="form-container">
			<div className="login-container">
				<h2>Sign Up</h2>
				<form
					className="login-form"
					name="signup"
					action="/user/signup"
					method="POST"
					onSubmit={inputValidate}
				>
					<label for="username">Username</label>
					<input
						type="text"
						id="username"
						name="username"
						placeholder="Enter your username"
						autoFocus
						required
					></input>
					<label for="email">Email</label>
					<input
						type="text"
						id="email"
						name="email"
						placeholder="Enter your email"
						pattern="[^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$]"
						required
					></input>
					<label for="password">password</label>
					<input
						type="text"
						id="password"
						name="password"
						placeholder="Enter your password"
						required
					></input>
				</form>
				<div className="login-form-links">
					<button
						className="login-form-button"
						type="submit"
						placeholder="Sign Up"
					>
						Sign Up
					</button>
					<button className="form-links" onClick={() => navigate('/login')}>
						Already have an account? Log in
					</button>
				</div>
			</div>
		</div>
	);
}

export default Signup;
