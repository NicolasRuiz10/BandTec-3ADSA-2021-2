import React from 'react'
import './CadastroProdutos.css';
import logo from '../../Assets/logo1.jpeg'
import { Link } from "react-router-dom";
import { ButtonVerde } from '../../components/button/Button';
import Line from '../../Assets/Line.png'
import { Footer } from '../../components/footer/footer';

export function CadastroProdutos() {
    return (
        <>
            <div className="menu">
                <div className="logo">
                    <Link to="/">
                        <img src={logo} alt="Logo iPet" />
                    </Link>
                </div>
                <div className="itens-menu">
                    <Link to="/PetShop">
                        <div className="item-menu">
                            <h3>Catálogo</h3>
                        </div>
                    </Link>
                    <Link to="/produtos">
                        <div className="item-menu">
                            <h3>Pedidos</h3>
                        </div>
                    </Link>
                    <div className="item-menu">
                        <h3>Produtos</h3>
                    </div>
                </div>
                <div className="itens-acesso">
                    <div className="item-acesso">
                        <ButtonVerde title="sair" />
                    </div>
                </div>
            </div>

            <div className="cadastroTitle">
                <h1>Cadastro de produto</h1>
                <img className="Line" src={Line} alt="none" />
            </div>
            <div className="anexoImg">
                <div className="anexoImg1">

                </div>
                <div className="buttonAnexoDiv">
                    <button>Anexar Imagem</button>
                </div>
            </div>

            <h1 className="categoria">Categoria</h1>
            <h1 className="nome">Nome</h1>
            <div className="inputs1">
                <input type="text" size="50" />
                <input type="text" size="50" />
            </div>

            <h1 className="marca">Marca</h1>
            <h1 className="valor">Valor</h1>
            <div className="inputs1">
                <input type="text" size="50" />
                <input type="text" size="50" />
            </div>

            <h1 className="quantidade">Quantidade</h1>
            <div className="inputs3">
                <input type="text" size="20" />
            </div>
            <h1 className="descricaoLabel">Descrição</h1>
            <div className="descricao">
                <input className="descricaoinput" type="text" size="100" height="400" />
            </div>
            <div className="buttonsfinal">
                <button>Limpar</button>
                <button>Adicionar Produto</button>
            </div>

            <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
        </>
    );
}