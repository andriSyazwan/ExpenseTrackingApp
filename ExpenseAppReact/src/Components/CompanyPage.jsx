import "../Styles/CompanyPage.css";
import { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom'

// Page that mainly displays the lsit of expenses
const CompanyPage = () => {
    // Initializing of all necessary variables
    const navigate = useNavigate();
    const { user_id } = useParams();
    const [company, setCompany] = useState({});
    const [user, setUser] = useState(null);
    const [expenses, setExpenses] = useState([]);
    const [isDataLoaded, setIsDataLoaded] = useState(false);
    const [companyId, setCompanyId] = useState();
    const [errorMessage, setErrorMessage] = useState();
    const api = 'http://localhost:9002/api/'
    
    useEffect(() => {
        // First useEffect sequence
        const fetchUserData = async () => {
            // Fetches the user from userId
            axios
            .get(api+'users/'+ user_id)
            .then((response) => {
                setUser(response.data);
                setCompanyId(response.data.company);         
            })
            .catch((error) => {
                console.error("Error fetching user please re-login:", error);
            });
        };

        // Calls the fetching of user upon receiving user_id
        if (user_id) {
            fetchUserData();
        }

    }, [user_id]);

    useEffect(() => {
        // Second user effect sequence
        const getCompany = async () => {
        // Goes through once companyId is present    
            if(companyId ) {
                axios.get(api+'companies/' + companyId)
                .then(response => {
                    // Code for success
                    setCompany(response.data)
                    
                })
                .catch(error => {
                    // Code to catch error
                setErrorMessage("Invalid Company ID, please try again")
                })
            }   
        }

        // Calls when user and company obj in user is present
        if (user && user.company) {
            getCompany();
        }
    }, [user])


    useEffect(() => {
        const fetchExpenseData = async () => {
            // Fetch list of expenses
            if(company) {
                axios.get(api+'expense/company/'+company.name)
                .then((response) => {
                    setExpenses(response.data);
                    setIsDataLoaded(true);
                })
                .catch((error) => {
                    console.error('Error fetching expenses:', error)
                });            
            }
        };

        // Calls when company and company name is present
        if (company && company.name) {
            fetchExpenseData();
        };
    }, [company]);

    // Returns loading screen up until all data is fetched 
    if(!isDataLoaded) {
        return(
            <div>
                Loading...
            </div>
        );
    }
    
    // Once all data us fetched, then all the required variables become available to show the main screen
    return(
        <div>
            <div className="company-info">
                <h2>{company.name}</h2>
                <p>Budget: ${company.budget}</p>
            </div>

            <div className="expense-list">
                <h3>Expense List</h3>
                {expenses.map(expense => (
                    <div key={expense.expense_id} className="expense-card">
                        <p>Amount: ${expense.amount}</p>
                        <p>Status: {expense.status ? 'Approved' : 'Pending'}</p>
                        <p>Date: {expense.date}</p>
                        <p>Description: {expense.description || 'N/A'}</p>
                        <p>Category: {expense.category || 'N/A'}</p>
                    </div>
                ))}
                <button onClick={() => navigate('/userpage/'+user_id)}>User Page</button>
            </div>
        </div>
    );
}

export default CompanyPage;