import React, { useState } from "react";
import "./Login.css";
import {MenuPetshop} from "../menu/MenuPetshop";
import Input from "../../components/input/Input";
import { ButtonVerde } from "../../components/button/Button";
import axios from "axios";
import Toast from "../../components/toast/Toast";
import { useHistory } from "react-router-dom";
import { useAuth } from '../../hooks/Context';

export default function LoginPetshop() {
    let history = useHistory();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [showToast, setShowToast] = useState(false);
    const { setIdPetshop, setNomePetshop, setAutenticadoPetshop } = useAuth();

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
        axios.post("http://localhost:8080/ipet/autenticar", {
            email: email,
            senha: password,
        }).then((res) => {
            if (res.status === 200) {
                setAutenticadoPetshop(true);
                setIdPetshop(res.data.idPetshop);
                setNomePetshop(res.data.nome);
                history.push("/petshop/cadastro-produtos");
            } else {
                setShowToast(true);
            }
        });
    };
    function redirectCadastro() {
        history.push("/petshop/cadastro");
    }
    return (
        <>
            <Toast text="Login ou senha incorretos" color="red" showToast={showToast} changeValueToast={setValueToast} />
            <MenuPetshop />
            <div className="acessaConta">
            <h2>Acesse sua conta</h2>
            </div>
            <hr />
            <div className="principal-container">
                <div className="principal-login">
                    <h1>Acessar sua conta</h1>
                    <Input txt="Email" placeholder="Digite seu email" value={email} enviarDados={setValueEmail} />
                    <Input txt="Senha" placeholder="Digite sua senha" value={password} enviarDados={setValuePasssword} />
                    <div className="divisao-login"><span></span></div>
                    <ButtonVerde title="Entrar" clickButton={verificarLogin} />
                </div>
                <div className="secundary-login">
                    <h1>
                        Cadastre seu PetShop e venda como nunca! 
                    </h1>
                    <ButtonVerde title="Crie sua conta" clickButton={redirectCadastro} />
                </div>
            </div>
        </>
    );
}
