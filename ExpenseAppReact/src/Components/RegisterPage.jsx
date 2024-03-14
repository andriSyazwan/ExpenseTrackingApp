import "../Styles/RegisterPage.css";
import { useState,useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

// Main page for registering users
const RegisterPage = () => {
    const navigate = useNavigate();
    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [password2, setPassword2] = useState('');
    const [company, setCompany] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [companyId, setCompanyId] = useState();
    const [passwordMatchError, setPasswordMatchError] = useState(false);
    const [passwordErrorMessage, setPasswordErrorMessage] = useState('');
    const api = 'http://localhost:9002/api/';

    // Post new user object into the database
    const handleSubmit = (event) => {
        event.preventDefault();

        axios.post(api+'users',
        {username: username,
        password: password,
        company: company,
        expenseList:[],
        firstName: firstname,
        lastName: lastname
        })
        .then(response => {
            // Code for success
            alert("Successfully registered, please go back to login", navigate('/login'))
        })
        .catch(error => {
            // Code to catch error
        setErrorMessage("Failed to upload, please try again")
        })
    }   

    // Gets the company of from the company id set
    useEffect(() => {
        const getCompany = async () => {
        
            axios.get(api+'companies/' + companyId)
            .then(response => {
                setCompany(response.data)
            })
            .catch(error => {
            setErrorMessage("Invalid Company ID, please try again")
            })
        }

        if (companyId) {
            getCompany();
        }
    }, [companyId]);

    // Checks for passwordMismatch for confirm password
    const checkPassword = () => {
        setPasswordMatchError(password === password2);
        {passwordMatchError ? setPasswordErrorMessage(null) : setPasswordErrorMessage("Confirm password does not match")};

    }

    // Main return function
    return(
        <div className="login-container">
            <h2>Register</h2>
            <form onSubmit={handleSubmit}>
                <input
                type="text"
                value={firstname}
                onChange={(e) => setFirstname(e.target.value)}
                placeholder="First Name"
                />
                <input
                type="text"
                value={lastname}
                onChange={(e) => setLastname(e.target.value)}
                placeholder="Last Name"
                />
                <input
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Username"
                />
                <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"
                />
                <input
                type="password"
                value={password2}
                onChange={(e) => { setPassword2(e.target.value); checkPassword(); }}
                placeholder="Confirm Password"
                />
                <br>
                </br>
                {passwordMatchError && <p className="error">{passwordErrorMessage}</p>}
                <input
                type="number"
                value={companyId}
                onChange={(e) => {setCompanyId(e.target.value)}}
                placeholder="Company ID"
                />
                <button type="submit">Register</button>
                {errorMessage && <p className="error">{errorMessage}</p>}
            </form>
        </div>
    );
}

export default RegisterPage;