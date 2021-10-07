import React from "react";
import './Login.css';

import { Menu } from "../../components/menu/Menu";

export function Login() {
  return (
    <>
       <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
       <div className="principal-container"></div>
        <h2>Acessar a sua conta iPet</h2>
       <div className="borda"></div>
       <div className="principal-login">
       </div>
       <div className="principal-cadastro">
         cadastro
       </div>
    </>
  );
}

export default Login;
