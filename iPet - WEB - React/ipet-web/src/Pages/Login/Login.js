import React from "react";
import './Login.css';

import { Menu } from "../../components/menu/Menu";
import Input from "../../components/input/Input"
import { ButtonVerde } from "../../components/button/Button"
import { FaFacebook } from 'react-icons/fa';
import { FcGoogle } from 'react-icons/fc';


export function Login() {
  return (
    <>
       <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
       <h2>Acesse sua conta</h2>
       <hr />
       <div className="principal-container">
       <div className="principal-login">
         <h1>Faça o Login</h1>
         <Input txt="CPF ou Email" placeholder="Digite seu email ou CPF"/>
         <Input txt="Senha" placeholder="Digite sua senha"/>
         <p className="esqueceuSenha">Esqueceu sua senha?</p>
         <ButtonVerde title="Entrar"/>
         <hr />
         <h2>Acesso rápido</h2>
         <div className="icones-acessos">
          <FcGoogle size={34}/>
          <FaFacebook size={34} className="icon-face"/>
         </div>
       </div>
       <div className="principal-cadastro">
         <h1>
         Criar uma conta é rápido,
          <br/>fácil e gratuito!
         </h1>
         <p>
         Com a sua conta da IPet você tem acesso
         <br/> Ofertas exclusivas, descontos, pode criar
         <br/> gerenciar a sua Assinatura Petz, acompanhar
         <br/>os seus pedidos e muito mais!
         </p>
         <ButtonVerde title="Crie sua conta"/>
       </div>
       </div>
    </>
  );
}

export default Login;
