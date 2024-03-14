import "../Styles/LoginNavbar.css";
import { Link } from "react-router-dom";

// Simple navbar that navigates to login and register pages
const LoginNavbar = () => {

    return(
        <div class='login-navbar'>
            <div class='logo'>Expense App</div>
            <ul class='nav-links'>
                <li><Link to="/login">Login</Link></li>
                <li><Link to="/register">Register</Link></li>
            </ul>
        </div>
    )
}

export default LoginNavbar;