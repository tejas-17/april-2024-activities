import React, { useState } from 'react';
import './LoginForm.css'; // Import custom CSS file for styling
import axios from 'axios';
import { useNavigate } from 'react-router-dom'; // Import useNavigate hook from react-router-dom

function LoginForm() {
    const navigate = useNavigate(); // Initialize useNavigate hook
    const [formData, setFormData] = useState({
        emailId: '',
        password: ''
    });
    const [errorMessage, setErrorMessage] = useState('');
    const [successMessage, setSuccessMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/customer/login', formData);
            console.log('Form submitted:', formData);
            console.log('Response:', response.data);
            setSuccessMessage('Login successful!');
            setErrorMessage('');

            localStorage.setItem('emailId', formData.emailId);

            
            // Redirect to a specific route after successful login
            navigate('/dashboard'); // Change '/dashboard' to the route you want to navigate to
        } catch (error) {
            console.error('Error:', error);
            if (error.response && error.response.status === 401) {
                setErrorMessage('Invalid username or password');
            } else {
                setErrorMessage('An error occurred. Please try again later.');
            }
            setSuccessMessage('');
        }
    };

    return (
        <div className="container">
            <h2 className="text-center mb-4">Bank Login</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <input type="email" className="form-control" id="emailId" name="emailId" value={formData.emailId} onChange={handleChange} required placeholder="Email" />
                </div>
                <div className="form-group">
                    <input type="password" className="form-control" id="password" name="password" value={formData.password} onChange={handleChange} required placeholder="Password" />
                </div>
                {errorMessage && <div className="alert alert-danger" role="alert">{errorMessage}</div>}
                {successMessage && <div className="alert alert-success" role="alert">{successMessage}</div>}
                <button type="submit" className="btn btn-primary btn-block">Login</button>
            </form>
        </div>
    );
}

export default LoginForm;
