import React from 'react'
import './dashPet.css';
import logo from '../../Assets/logo1.jpeg'
import { Link } from "react-router-dom";
import { ButtonVerde } from '../../components/button/Button';
import bolaAmarela from '../../Assets/bolaAmarela.png'
import Line from '../../Assets/Line.png'
import { Footer } from '../../components/footer/footer';

export function DashPet() {
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

            <div className="pedidos">
                <div className="pedidosTitle">
                    <h1>Pedidos</h1>
                    <img className="line" src={Line} alt="" />
                </div>
                <div className="pedidos-items">
                    <div className="pedidos-andamento">Pedidos em andamento - 0 </div>
                    <div className="pedidos-andamento">Pedidos Concluidos - 0</div>
                </div>
            </div>

            <div className="pedidos2">
                <div className="pedidosTitle">
                    <h1>Pedidos</h1>
                </div>
                <div className="pedidos-items">
                    <div className="pedidos-andamento">Pedidos em andamento - 0</div>
                    <div className="pedidos-andamento">Pedidos Concluidos - 0</div>
                </div>
            </div>

            <div className="produtos">
                <div className="produtosTitle">
                    <h1>Produtos</h1>
                    <img className="line2" src={Line} alt="" />
                </div>
                <div className="produtos-items">
                    <div className="produtos-line1">Cadastrar produtos</div>
                    <div className="produtos-line1">Editar produtos</div>
                </div>
            </div>


            <div className="produtos2">
                <div className="produtosTitle">
                    <h1>Produtos</h1>
                    <img className="line2" src={Line} alt="" />
                </div>
                <div className="produtos-items">
                    <div className="produtos-line1">Excluir produtos</div>
                    <div className="produtos-line1">Visualisar produtos</div>
                </div>
            </div>

            <div className="serviços">
                <div className="serviçosTitle">
                    <h1>Serviços</h1>
                    <img className="line2" src={Line} alt="" />
                </div>
                <div className="serviços-items">
                    <div className="serviços-line1">Cadastrar serviços</div>
                    <div className="serviços-line1">Editar serviços</div>
                </div>
            </div>

            <div className="serviços2">
                <div className="serviços-items">
                    <div className="serviços-line1">Excluir serviços</div>
                    <div className="serviços-line1">Visualisar serviços</div>
                </div>
            </div>
            <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
        </>
    )
}

export default DashPet
