import '../Styles/UserPage.css';
import {useState,useEffect} from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

// User page will display user logged in details with add expense functionality
const UserPage = () => {
    const navigate = useNavigate();
    const { user_id } = useParams();
    const [companyId, setCompanyId] = useState();
    const [company, setCompany] = useState();
    const [user, setUser] = useState(null);
    const [isDataLoaded, setIsDataLoaded] = useState(false);
    const [newExpense, setNewExpense] = useState({
        amount: 0,
        status: true,
        date: "",
        description: "",
        user: {}, // Set the correct user ID here
        company: {}, // Set the correct company ID here
        category: {}, // Set the correct category ID here
    });
    const [categoryId, setCategoryId] = useState(1);
    const api = 'http://localhost:9002/api/';

    // Method to fetch data from user loggend in ID
    useEffect(() => {
        // First useEffect sequence
        const fetchUserData = async () => {
            axios
            .get(api+'users/'+ user_id)
            .then((response) => {
                setUser(response.data);
                setCompanyId(response.data.company.name); 
    
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

    // Method to get the company based on the user logged in data
    useEffect(() => {
        // Second user effect sequence
        const getCompany = async () => {
            if(companyId) {
                // Fetch Company Data
                axios.get(api+'companies/name/' + companyId)
                .then(response => {
                    // Code for success
                    setCompany(response.data);
                    
                })
                .catch(error => {
                    // Code to catch error
                console.error("Error fetching company:", error);
                })
             }
        };

        // Runs function once user and company obj in user is present
        if (user && user.company) {
            getCompany();
        }
     }, [user]);

    // Method that adds the user and company object as soon as both loads
     useEffect(() => {
        const addExpenseUserAndCompany = async () => {
            // Fetch list of expenses
            if(company) {
                setNewExpense({
                    ...newExpense,
                    user: user,
                    company: company, // Update to use the 'company' object directly
                });
                // Finish loading page once this is achieved
                setIsDataLoaded(true);
            }
        };

        // Calls when company and company name is present
        if (company && user) {
            addExpenseUserAndCompany();
        }
    }, [company, user]);

    // Fetches the category object upon change of selection
    useEffect(() => {
        const addExpenseCategory = async () => {
            // Fetch list of expenses
            if(categoryId) {
                console.log("Selected Category ID:", categoryId);
                axios
                .get(api+'categories/'+ categoryId)
                .then((response) => {
                    setNewExpense({ ...newExpense, category: response.data});
                    console.log("Fetched Category:", response.data);
                })
                .catch((error) => {
                    console.error("Error fetching category:", error);
                });
            }
        };

        // Calls when company and company name is present
        if (companyId) {
            addExpenseCategory();
        }
    }, [categoryId]);

    // Post request upon submit
    const handleExpenseSubmit = async (event) => {
        event.preventDefault();
            // API POST request to make a new expense
            axios
            .post(api+'expense',newExpense)
            .then((response) => {
            alert("You have successfully added an expense!")})
            .catch((error) => {
            console.error("Error uploading expenses:", error);
            });

    }

    // Changes value of category object upon changing the category id
    const handleCategoryChange = (e) => {
        e.preventDefault();

        
    } 

    // Until last object required is loaded, displays loading screen
    if(!isDataLoaded) {
        return(
            <div>
                Loading...
            </div>
        );
    }

    // Main output onto webpage
    return(
    <div className="user-page-container">
      <div className="user-info">
        <h2>{user.firstName} {user.lastName}</h2>
        <p>Username: {user.username}</p>
        <button onClick={() => navigate('/companypage/'+user_id)}>Company Page</button>
      </div>

      <div className="expense-form">
        <h3>Create Expense</h3>
        <form onSubmit={handleExpenseSubmit}>
          <label>
            Amount:
            <input
              type="number"
              value={newExpense.amount}
              onChange={(e) =>
                setNewExpense({ ...newExpense, amount: e.target.value })
              }
            />
          </label>
          <label>
            Date:
            <input
              type="date"
              value={newExpense.date}
              onChange={(e) =>
                setNewExpense({ ...newExpense, date: e.target.value })
              }
            />
          </label>
          <label>
            Description:
            <input
              type="text"
              value={newExpense.description}
              onChange={(e) =>
                setNewExpense({ ...newExpense, description: e.target.value })
              }
            />
          </label>
          <label>
            Category:
            <select value={categoryId} onChange={(e) => { setCategoryId(e.target.value); handleCategoryChange(e); }}>
            <option value={1}>Marketing</option>
            <option value={2}>Office Supplies</option>
            <option value={3}>Travel</option>
            <option value={4}>Entertainment</option>
            <option value={5}>Utilities</option>
            <option value={6}>Rent</option>
            <option value={7}>Insurance</option>
            <option value={8}>Client Services</option>
            <option value={9}>Salaries</option>
            <option value={10}>Software</option>
            <option value={11}>Training</option>
            <option value={12}>Employee Benefits</option>
            <option value={13}>Charity</option>
            <option value={14}>Miscellaneous</option>
            </select>
          </label>
          <br></br>
          <button type="submit">Submit Expense</button>
        </form>
      </div>
    </div>
    );
}

export default UserPage;