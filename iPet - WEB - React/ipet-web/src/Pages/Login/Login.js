import React, { useState } from "react";
import "./Login.css";
import { Link } from "react-router-dom";
import { Menu } from "../../components/menu/Menu";
import Input from "../../components/input/Input";
import { ButtonVerde } from "../../components/button/Button";
import { FaFacebook } from "react-icons/fa";
import { FcGoogle } from "react-icons/fc";
import axios from "axios";

export function Login() {
    const [user, setUser] = useState('');
    const [password, setPassword] = useState('');


    const verificarLogin = () => {
        console.log('entrou aqui');
        axios.post("http://localhost:8080/usuarios/1", 
            this.user = "",
            this.password = ""
        ).then((res) => {
          console.log(res.data);
        });
    };
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2>Acesse sua conta</h2>
      <hr />
      <div className="principal-container">
        <div className="principal-login">
          <h1>Faça o Login</h1>
          <Input txt="CPF ou Email" placeholder="Digite seu email ou CPF" />
          <Input txt="Senha" placeholder="Digite sua senha" value={() => this.setPassword('password')}/>
          <p className="esqueceuSenha">Esqueceu sua senha?</p>
            <div onClick={verificarLogin}>
                <ButtonVerde title="Entrar"/>
            </div>
          <hr />
          <h2>Acesso rápido</h2>
          <div className="icones-acessos">
            <FcGoogle size={34} />
            <FaFacebook size={34} className="icon-face" />
          </div>
        </div>
        <div className="principal-cadastro">
          <h1>
            Criar uma conta é rápido,
            <br />
            fácil e gratuito!
          </h1>
          <p>
            Com a sua conta da IPet você tem acesso
            <br /> Ofertas exclusivas, descontos, pode criar
            <br /> gerenciar a sua Assinatura Petz, acompanhar
            <br />
            os seus pedidos e muito mais!
          </p>
          <Link to="/cadastro">
            <ButtonVerde title="Crie sua conta" />
          </Link>
        </div>
      </div>
    </>
  );
}

export default Login;
