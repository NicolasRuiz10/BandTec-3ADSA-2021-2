import React, { useState } from "react";
import "./PedidoPetshop.css";
import { MenuPetshop } from "../menu/MenuPetshop";
import { ButtonVerde } from "../../components/button/Button";
import axios from "axios";
import Toast from "../../components/toast/Toast";
import { useHistory } from "react-router-dom";
import { Footer } from "../../components/footer/footer";
import { useAuth } from '../../hooks/Context';

export default function PedidoPetshop() {
    let history = useHistory();
    const { setIdPetshop, setNomePetshop, setAutenticadoPetshop } = useAuth();
    function redirectCadastro() {
        history.push("/petshop/cadastro");
    }
    return (
        <>
            <MenuPetshop menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
            <h2 className='h2-carrinho'>Pedidos</h2>
            <hr />
            <div className="principal--carrinho">
                <div className="box-carrinho">
                    <div className="itens-carrinho">
                        <div className="item-title">
                            <h1>Produto</h1>
                            <hr />
                            <h1>Descrição</h1>
                            <hr />
                            <h1>Preço</h1>
                            <hr />
                            <h1>Quantidade</h1>
                            <hr />
                            <h1>Total</h1>
                        </div>
                    </div>
                </div>
            </div>
            <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
        </>
    );
}
