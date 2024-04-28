import logo from './logo.svg';
import './App.css';
import RegisterForm from './components/RegisterForm';
import LoginForm from './components/login';
import LoanDashboard from './components/LoanDashboard';
import { Routes,Route,Link } from 'react-router-dom';
import LoanData from './components/LoanData';






function App() {

  return(
    <div>
      <Link to="/register">register Profile</Link>||
      <Link to="/login">Login</Link>||
      <Link to="/getApplicationData">Application status</Link>||
      <Link to="/dashboard">Loan Dashboard</Link>


      {/* <Link to="/serachAndDelete">delete profile and Serach</Link>|| */}

      {/* <Link to="/userJson">Users JSON</Link>|| */}
        <hr/>

        <Routes>
           <Route path='' element={<LoginForm/>}></Route>
           <Route path='/login' element={<LoginForm/>}></Route>

           <Route path='/register' element={< RegisterForm/>}></Route>
           <Route path="/dashboard" element={<LoanDashboard />} />
         <Route path="/getApplicationData" element={<LoanData/>} />


        


      </Routes>

    </div>
   
  )

}

export default App;
