import React from "react";
import { Route, BrowserRouter } from "react-router-dom";

import HomePage from '../Pages/Home/HomePage'
import HomePetShop from "../Pages/HomePetShop/homePetShop"
import Login from "../Pages/Login/Login"
import Cadastro from "../Pages/Cadastro/Cadastro"
import Carrinho from "../Pages/Carrinho/Carrinho"
import Produtos from "../Pages/Produtos/Produtos.jsx"
import Pagamento from "../Pages/Pagamento/Pagamento"
import StatusPedido from "../Pages/StatusPedido/StatusPedido";
import { CadastroProdutos } from "../Pages/CadastroProdutos/CadastroProdutos";



const Routes = () => {
    return (
        <BrowserRouter>
            <Route component={HomePage} path="/" exact />
            <Route component={HomePetShop} path="/PetShop" />
            <Route component={CadastroProdutos} path="/cadastroProdutos" />
            <Route component={Login} path="/login" />
            <Route component={Cadastro} path="/cadastro" />
            <Route component={Carrinho} path="/carrinho" />
            <Route component={Pagamento} path="/pagamento" />
            <Route component={Produtos} path="/produtos" />
            <Route component={StatusPedido} path="/status-pedido" />
        </BrowserRouter>
    )
}

export default Routes;