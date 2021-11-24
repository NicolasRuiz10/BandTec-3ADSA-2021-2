import React from "react";
import { Route, BrowserRouter } from "react-router-dom";
import HomePage from '../Pages/Home/HomePage'
import Login from "../Pages/Login/Login"
import Cadastro from "../Pages/Cadastro/Cadastro"
import Carrinho from "../Pages/Carrinho/Carrinho"
import Produtos from "../Pages/Produtos/Produtos.jsx"
import Pagamento from "../Pages/Pagamento/Pagamento"
import StatusPedido from "../Pages/StatusPedido/StatusPedido";
// import CadastroProdutos from "../PagesPetshop/CadastroProdutos/CadastroProdutos.jsx";
import HomePetShop from '../PagesPetshop/HomePetShop/homePetShop';
import LoginPetshop from '../PagesPetshop/loginPetshop/LoginPetshop';
import CadastroPetshop from '../PagesPetshop/CadastroPetshop/CadastroPetshop';

const Routes = () => {
    return (
        <BrowserRouter>
            <Route component={HomePage} path="/" exact />
            {/* <Route component={CadastroProdutos} path="/petshop/cadastro-produtos" /> */}
            <Route component={LoginPetshop} path="/petshop/login" />
            <Route component={CadastroPetshop} path="/petshop/cadastro" />
            <Route component={HomePetShop} path="/petshop/home" />
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