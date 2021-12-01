import React, { useState } from "react";
import "./PedidoPetshop.css";
import { MenuPetshop } from "../menu/MenuPetshop";
import axios from "axios";
import { useHistory } from "react-router-dom";
import { Footer } from "../../components/footer/footer";
import { ItemCarrinho } from "../../components/carrinho/ItemCarrinho";
import { useAuth } from '../../hooks/Context';

export default function PedidoPetshop() {
    let history = useHistory();
    const { idPetshop, itemsCarrinho } = useAuth();
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
                {
                    itemsCarrinho.map((item, key) => (
                        <div className="itens" key={key}>
                        <ItemCarrinho
                            urlImg={`http://localhost:8080/produtos/pegar-foto/${item.idProduto}`}
                            descProduto={item.nome}
                            preco={item.valor}
                        />
                        </div>
                    ))
                }
            </div>
            <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
        </>
    );
}
