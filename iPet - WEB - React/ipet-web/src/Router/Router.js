import React from "react";
import { Route, BrowserRouter } from "react-router-dom";

import HomePage from '../Pages/Home/HomePage';
import { HomePetShop } from "../Pages/HomePetShop/homePetShop";
import Login from "../Pages/Login/Login";
import Cadastro from "../Pages/Cadastro/Cadastro";
import Carrinho from "../Pages/Carrinho/Carrinho"
import Produtos from "../Pages/Produtos/Produtos.jsx"



const Routes = () => {
   return(
       <BrowserRouter>
           <Route component = { HomePetShop }  path="/" exact />
           <Route component = { Login }  path="/login" />
           <Route component = { Cadastro }  path="/cadastro" />
           <Route component = { Carrinho }  path="/carrinho" />
           <Route component = { Produtos } path="/produtos" />
       </BrowserRouter>
   )
}

export default Routes;