import React from "react";
import { Route, BrowserRouter } from "react-router-dom";

import HomePage from "../Pages/Home/HomePage";
import Login from "../Pages/Login/Login";


const Routes = () => {
   return(
       <BrowserRouter>
           <Route component = { HomePage }  path="/" exact />
           <Route component = { Login }  path="/login" />
       </BrowserRouter>
   )
}

export default Routes;