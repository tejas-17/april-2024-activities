import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './LoanDashboard.css'; // Import custom CSS file for styling

function LoanDashboard() {
    const [loanTypes, setLoanTypes] = useState([]);
    const [selectedLoanId, setSelectedLoanId] = useState(null);
    const [errorMessage, setErrorMessage] = useState('');
    const [successMessage, setSuccessMessage] = useState('');
    const emailId = localStorage.getItem('emailId');

    useEffect(() => {
        fetchLoanTypes();
    }, []);

    const fetchLoanTypes = async () => {
        try {
            // Mock data for loan types
            const loanTypesData = [
                { loanId: 101, loanType: 'Home Loan' },
                { loanId: 102, loanType: 'Car Loan' },
                { loanId: 103, loanType: 'Personal Loan' },
                { loanId: 104, loanType: 'Education Loan' }
            ];
            setLoanTypes(loanTypesData);
        } catch (error) {
            console.error('Error fetching loan types:', error);
            setErrorMessage('Error fetching loan types. Please try again later.');
        }
    };

    const handleLoanTypeSelect = (loanId) => {
        setSelectedLoanId(loanId);
    };

    const handleSubmit = async () => {
        if (!selectedLoanId) {
            setErrorMessage('Please select a loan type.');
            return;
        }

        const loanAppData = {
            
            customer: {
                emailId: emailId
            },
            loan: {
                loanId: selectedLoanId
            },
            status: "Pending"
        };

        console.log('loanappdata to be sent',loanAppData);

        try {
            const response = await axios.post('http://localhost:8080/loanapp/apply', loanAppData);
            console.log('Response:', response.data);
            setSuccessMessage('Loan application submitted successfully!');
            setErrorMessage('');
        } catch (error) {
            console.error('Error:', error);
            setErrorMessage('An error occurred while submitting the loan application. Please try again later.');
            setSuccessMessage('');
        }
    };

    return (
        <div className="loan-dashboard">
            <h2>Loan Dashboard</h2>
            <div className="loan-cards">
                {loanTypes.map((loanType) => (
                    <div
                        key={loanType.loanId}
                        className={`loan-card ${selectedLoanId === loanType.loanId ? 'selected' : ''}`}
                        onClick={() => handleLoanTypeSelect(loanType.loanId)}
                    >
                        <h3>{loanType.loanType}</h3>
                    </div>
                ))}
            </div>
            <div>
                {errorMessage && <div className="alert alert-danger" role="alert">{errorMessage}</div>}
                {successMessage && <div className="alert alert-success" role="alert">{successMessage}</div>}
                <button type="button" className="btn btn-primary" onClick={handleSubmit}>Apply Now</button>
            </div>
        </div>
    );
}

export default LoanDashboard;
