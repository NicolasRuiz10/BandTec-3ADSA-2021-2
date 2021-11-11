import React, { useState } from "react";
import "./Login.css";
import { Link } from "react-router-dom";
import { Menu } from "../../components/menu/Menu";
import Input from "../../components/input/Input";
import { ButtonVerde } from "../../components/button/Button";
import { FaFacebook } from "react-icons/fa";
import { FcGoogle } from "react-icons/fc";
import axios from "axios";
import Toast from "../../components/toast/Toast";
import { useHistory } from "react-router-dom";
import { useAuth } from '../../hooks/Context.jsx'

// eslint-disable-next-line import/no-anonymous-default-export
export default () => {
    let history = useHistory();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [showToast, setShowToast] = useState(false);

    const { mudarAutenticacao, setIdUsuario } = useAuth();

    function setValueEmail(value) {
        setEmail(value);
    }

    function setValuePasssword(value) {
        setPassword(value);
    }

    function setValueToast(value) {
        setShowToast(value);
    }

    const verificarLogin = () => {

        axios.post("http://localhost:8080/usuarios/autenticar", {
            email: email,
            senha: password,
        }
        ).then((res) => {
            if (res.status === 200) {
                mudarAutenticacao();
                setIdUsuario(res.data);
                history.push("/");
            } else {
                setShowToast(true);
            }
        });
    };
    return (
        <>
            <Toast text="Login ou senha incorretos" color="red" showToast={showToast} changeValueToast={setValueToast}/>
            <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
            <h2>Acesse sua conta</h2>
            <hr />
            <div className="principal-container">
                <div className="principal-login">
                    <h1>Faça o Login</h1>
                    <Input txt="CPF ou Email" placeholder="Digite seu email ou CPF" value={email} enviarDados={setValueEmail} />
                    <Input txt="Senha" placeholder="Digite sua senha" value={password} enviarDados={setValuePasssword} />
                    <p className="esqueceuSenha">Esqueceu sua senha?</p>
                    <div onClick={verificarLogin}>
                        <ButtonVerde title="Entrar" />
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
