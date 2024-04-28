import React, { useState } from 'react';
import './RegisterForm.css'; // Import custom CSS file for styling
import axios from 'axios';
import { useNavigate } from 'react-router-dom';



function RegisterForm() {

    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        emailId: '',
        password: '',
        phone: '',
        pan: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Your form submission logic here
        console.log('Form submitted:', formData);
    
        axios.post("http://localhost:8080/customer", formData)
            .then(response => {
                console.log('Response:', response);
                // Handle the response as needed
                alert(response)
            })
            .catch(error => {
                console.error('Error:', error);
                // Handle errors
            });

            navigate('/login');
    };
    
    return (
        <div className="container mt-5">
            <h2 className="text-center mb-4">Register yourself</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <input type="text" className="form-control" id="firstName" name="firstName" value={formData.firstName} onChange={handleChange} required placeholder="First Name" />
                </div>
                <div className="form-group">
                    <input type="text" className="form-control" id="lastName" name="lastName" value={formData.lastName} onChange={handleChange} required placeholder="Last Name" />
                </div>
                <div className="form-group">
                    <input type="email" className="form-control" id="emailId" name="emailId" value={formData.emailId} onChange={handleChange} required placeholder="Email" />
                </div>
                <div className="form-group">
                    <input type="password" className="form-control" id="password" name="password" value={formData.password} onChange={handleChange} required placeholder="Password" />
                </div>
                <div className="form-group">
                    <input type="text" className="form-control" id="phone" name="phone" value={formData.phone} onChange={handleChange} required placeholder="Phone" />
                </div>
                <div className="form-group">
                    <input type="text" className="form-control" id="pan" name="pan" value={formData.pan} onChange={handleChange} required placeholder="PAN" />
                </div>
                <button type="submit" className="btn btn-primary btn-block">Apply Now</button>
            </form>
        </div>
    );
}

export default RegisterForm;
