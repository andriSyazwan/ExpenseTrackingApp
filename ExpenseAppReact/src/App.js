import './App.css';
import { Routes, Route } from 'react-router-dom';
import LoginPage from './Components/LoginPage';
import RegisterPage from './Components/RegisterPage.jsx';
import LoginNavbar from './Components/LoginNavbar.jsx';
import UserPage from './Components/UserPage.jsx'
import CompanyPage from './Components/CompanyPage.jsx'

function App() {
  return (
    <div className="App">
      <LoginNavbar/>
      <Routes>
        <Route path='/login' element={<LoginPage/>}/>
        <Route path='/register' element={<RegisterPage/>}/>
        <Route path='/userpage/:user_id' element={<UserPage/>}/>
        <Route path='/companypage/:user_id' element={<CompanyPage/>}/>
      </Routes>
    </div>
  );
}

export default App;
