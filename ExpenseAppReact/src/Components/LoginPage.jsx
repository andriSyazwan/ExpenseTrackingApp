import "../Styles/LoginPage.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from 'axios';

// Page that handles the login
const LoginPage = () => {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [isUsername, setIsUsername] = useState(false);
    const [isPassword, setIsPassword] = useState(false);
    const [isSubmitted, setIsSubmitted] = useState(false);
    const [isError, setIsError] = useState(false);
    const api = 'http://localhost:9002/api/';

    // Called upon successfully pressing the login button without errors
    const handleSubmit = (event) => {
        event.preventDefault();

        // These are common error checkers
        setIsUsername(username.trim() !==''); // Check if blank
        setIsPassword(password.trim() !==''); // Will return true if not blank
        setIsSubmitted(true);


    
        // Make an API request to check if the username and password are valid
        axios.post(api+'users/login',
        {username: username,
        password: password})
        .then(response => {
            // Code for success
            setIsError(false);
            const { user_id } = response.data;
            isUsername && isPassword && isSubmitted ? navigate('/userpage/'+user_id): navigate('/login');
        })
        .catch(error => {
            // Code to catch error
            setIsError(true)
            console.log(error);
            console.log(username, password);
        })
        

    }

    // Main return line for login
    return(
        <div className="login-container">
            <h2>Log In</h2>
            {isSubmitted && isError && <p class="error">Username and Password mismatch!</p>}
            <form onSubmit={handleSubmit}>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Username"/>
                <br></br>
                {isSubmitted && !isUsername && <p class="error">Username cannot be blank!</p>}
                <br></br>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Password"/>
                {isSubmitted && !isPassword && <p class="error">Password cannot be blank!</p>}
                <br></br>
                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default LoginPage;