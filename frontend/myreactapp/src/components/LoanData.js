import React, { useState, useEffect } from 'react';
import axios from 'axios';

function LoanData() {
    const [loanData, setLoanData] = useState([]);

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        try {
            const emailId = localStorage.getItem('emailId');
            const emailidObj = {
                emailId: emailId
            };

            const response = await axios.post('http://localhost:8080/loanapp/getData', emailidObj);
            
            // Ensure that the response data is an object with the expected keys
            if (response.data.applicationId && response.data.customer && response.data.loan && response.data.status) {
                // Set the loanData state with an array containing the single data object
                setLoanData([response.data]);
            } else {
                console.error('Invalid response data format:', response.data);
            }
        } catch (error) {
            console.error('Error fetching loan data:', error);
        }
    };

    return (
        <div className="container">
            <h2>Loan Data</h2>
            <table className="table">
                <thead>
                    <tr>
                        <th>Application ID</th>
                        <th>Customer Name</th>
                        <th>Email ID</th>
                        <th>Loan Type</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {loanData.map((data, index) => (
                        <tr key={index}>
                            <td>{data.applicationId}</td>
                            <td>{`${data.customer.firstName} ${data.customer.lastName}`}</td>
                            <td>{data.customer.emailId}</td>
                            <td>{data.loan.loanType}</td>
                            <td>{data.status}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default LoanData;
