import React, { useState} from "react";
import './Cadastro.css'
import { Link } from "react-router-dom";
import { Menu } from "../../components/menu/Menu";
import Input from "../../components/input/Input"
import { ButtonVerde } from "../../components/button/Button"
import { FaFacebook } from 'react-icons/fa';
import { FcGoogle } from 'react-icons/fc';


export function Cadastro() {
  const [email, setEmail] = useState('');
  const [nome, setNome] = useState('');
  const [senha, setSenha] = useState('');
  const [cpf, setCpf] = useState('');

  const [validacao, setvalidacao] = useState(true);

  function confirmarSenha(value) {
    if (senha === value) {
      setvalidacao(true);
    } else {
      setvalidacao(false);
    }
  }

  return (
    <>
       <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
       <h2>Crie sua conta iPet</h2>
       <hr />
       <div className="principal">
       <div className="section--cadastro">
         <h1>Dados Pessoais</h1>
         <Input txt="Nome Completo" placeholder="Digite seu nome completo" enviarDados={setNome}/>
         <Input txt="Email" placeholder="Digite seu email" enviarDados={setEmail}/>
         <Input txt="CPF" placeholder="Digite seu CPF" enviarDados={setCpf}/>
         <Input txt="Senha" placeholder="Digite sua senha" enviarDados={setSenha}/>
         <Input txt="Confirme sua senha" placeholder="Digite sua senha" enviarDados={confirmarSenha}/>
         <hr />
         <Input txt="CEP" placeholder="Digite seu CEP"/>
         <Input txt="Endereço" placeholder="Digite seu endereço com Nº"/>
         <Input txt="Bairro" placeholder="Digite o nome do bairro"/>
         <Input txt="Cidade" placeholder="Digite sua cidade"/>
         <Input txt="Estado" placeholder="Digite seu estado"/>
         <Input txt="Complemento" placeholder="Digite seu complemento"/>
         <ButtonVerde title="Criar conta"/>
       </div>
       <div className="section--login">
         <h1>
         Já tem cadastro?
         </h1>
         <Link to="/login">
          <ButtonVerde title="Login"/>
         </Link>
         <hr />
         <h2>Cadastro rápido</h2>
         <div className="icones-acessos">
          <FcGoogle size={34}/>
          <FaFacebook size={34} className="icon-face"/>
         </div>
       </div>
       </div>
    </>
  );
}

export default Cadastro;
