import React, { useState } from "react";
import "./Login.css";
import { Menu } from "../../components/menu/Menu";
import Input from "../../components/input/Input";
import { ButtonVerde } from "../../components/button/Button";
import { FaFacebook } from "react-icons/fa";
import { FcGoogle } from "react-icons/fc";
import axios from "axios";
import Toast from "../../components/toast/Toast";
import { useHistory } from "react-router-dom";
import { useAuth } from '../../hooks/Context';

export default function Login() {
    let history = useHistory();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [showToast, setShowToast] = useState(false);

    const { mudarAutenticacao, setIdUsuario, setNomeUsuario } = useAuth();

    function setValueEmail(value) {
        setEmail(value);
    }

    function setValuePasssword(value) {
        setPassword(value);
    }

    function setValueToast(value) {
        setShowToast(value);
    }

    function verificarLogin() {
        axios.post("http://localhost:8080/usuarios/autenticar", {
            email: email,
            senha: password,
        }).then((res) => {
            if (res.status === 200) {
                mudarAutenticacao();
                setIdUsuario(res.data.idUsuario);
                setNomeUsuario(res.data.nome);
                history.push("/");
            } else {
                setShowToast(true);
            }
        });
    };
    function redirectCadastro() {
        history.push("/cadastro");
    }
    return (
        <>
            <Toast text="Login ou senha incorretos" color="red" showToast={showToast} changeValueToast={setValueToast} />
            <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
            <div className="acessaConta">
            <h2>Acesse sua conta</h2>
            </div>
            <hr />
            <div className="principal-container">
                <div className="principal-login">
                    <h1>Faça o Login</h1>
                    <Input txt="CPF ou Email" placeholder="Digite seu email ou CPF" value={email} enviarDados={setValueEmail} />
                    <Input txt="Senha" placeholder="Digite sua senha" value={password} enviarDados={setValuePasssword} />
                    <p className="esqueceuSenha">Esqueceu sua senha?</p>
                    <ButtonVerde title="Entrar" clickButton={verificarLogin} />
                    <hr />
                    <h2>Acesso rápido</h2>
                    <div className="icones-acessos">
                        <FcGoogle size={34} />
                        <FaFacebook size={34} className="icon-face" />
                    </div>
                </div>
                <div className="section-login">
                    <h1>
                        Criar uma conta é rápido,
                        <br />
                        fácil e gratuito!
                    </h1>
                    <p className="p">
                        Com a sua conta da IPet você tem acesso. Ofertas exclusivas, descontos, pode criar gerenciar a sua Assinatura Petz!
                    </p>
                    <ButtonVerde title="Crie sua conta" clickButton={redirectCadastro} />
                </div>
            </div>
        </>
    );
}
