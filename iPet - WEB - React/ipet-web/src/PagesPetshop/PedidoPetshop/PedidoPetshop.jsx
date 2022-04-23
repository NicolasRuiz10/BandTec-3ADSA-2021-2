import React, { useState, useEffect } from "react";
import "./PedidoPetshop.css";
import { MenuPetshop } from "../menu/MenuPetshop";
import axios from "axios";
import { FaOpencart } from "react-icons/fa";
import { MdDeliveryDining } from "react-icons/md";
import { BsCartCheckFill } from "react-icons/bs";
import Modal from "react-modal"

Modal.setAppElement("#root")
export default function PedidoPetshop() {
    // let history = useHistory();
    // const { idPetshop, itemsCarrinho } = useAuth();
    const [pedido, setPedido] = useState([]);
    const [modalIsOpen, setIsOpen] = useState(false);

    function openModal() {
        setIsOpen(true);
    }

    function cleseModal() {
        setIsOpen(false);
    }
    useEffect(() => {
        const fetchPedido = async () => {
            const { data } = await axios.get(
              "http://ec2-34-226-239-106.compute-1.amazonaws.com:8080/itens"
            );
            setPedido(data);
        };
        fetchPedido(); 
    }, [])
    return (
        <>
            <MenuPetshop menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
            <div id="principal-pedido">
                <div id="pedidos">
                    <div id="pedidos-card">
                        <div className="card-pedidos-status" id="card-yellow">
                            <h2>Abertos</h2>
                            <h2>9</h2>
                            <FaOpencart size={30} />
                        </div>
                        <div className="card-pedidos-status" id="card-blue">
                            <h2>Em andamento</h2>
                            <h2>2</h2>
                            <MdDeliveryDining size={30} />
                        </div>
                        <div className="card-pedidos-status"  id="card-green">
                            <h2>Finalizados</h2>
                            <h2>19</h2>
                            <BsCartCheckFill size={30} />
                        </div>
                    </div>
                    <h4 id="title-ped">Pedidos</h4>
                    {
                        pedido.map((p) => 
                            <div className="pedidos-list">
                            <div className="pedido-card">
                                <div className="pedido-card-info">
                                    <span>ID Pedido</span>
                                    <p>{p.id}</p>
                                </div>
                                <div className="pedido-card-info">
                                    <span>Produto</span>
                                    <p>{p.produto.nome}</p>
                                </div>
                                <div className="pedido-card-info">
                                    <span>Valor Total</span>
                                    <p>{p.pedido.valorTotal}</p>
                                </div>
                                <div className="pedido-card-info">
                                    <span>Pagamento</span>
                                    <p>{p.pedido.pagamento}</p>
                                </div>
                                <div className="pedido-card-info">
                                    <span>Cliente</span>
                                    <p>{p.pedido.fkUsuario.nome}</p>
                                </div>
                                <div className="pedido-card-info">
                                    <span>Telefone</span>
                                    <p>{p.pedido.fkUsuario.telefone}</p>
                                </div>
                                <div className="pedido-card-info">
                                    <span>Status</span>
                                    <p>Aberto</p>
                                </div>
                            </div>
                            <div id="btn-pedidos">
                                <button id="btn-detalhes-pedido" onClick={openModal}>Detalhe do pedido</button>
                                <button id="btn-detalhes-entrega">Entregar Pedido</button>
                            </div>
                    </div>
                        )
                    }

                    <Modal
                        isOpen={modalIsOpen}
                        onRequestClose={cleseModal}
                        contentLabel="Exemplo Modal"
                        overlayClassName="modal-overlay"
                        className="model-content"
                    >
                        <div id="container-modal">
                            <div className="modal-info-pedido">
                                <p>Informações do pedido</p>
                                <div className="dados-pedidos-modal">
                                    <div className="input-pedidos-modal">
                                    </div>
                                    <div className="input-pedidos-modal">
                                    </div>
                                    <div className="input-pedidos-modal">
                                    </div>
                                </div>
                            </div>
                            <div className="modal-info-cliente">
                                <p>Informações do cliente</p>
                                <div className="dados-pedidos-modal">
                                    <div className="input-pedidos-modal">
                                    </div>
                                    <div className="input-pedidos-modal">
                                    </div>
                                </div>
                            </div>
                            <div className="modal-info-endereco">
                                <p>Endereço</p>
                                <div className="dados-pedidos-modal">
                                    <div className="input-pedidos-modal">

                                    </div>
                                    <div className="input-pedidos-modal">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="btn-modal">
                                <button id="btn-detalhes-recebe">Receber Pedido</button>
                                <button id="btn-detalhes-close" onClick={cleseModal}>Fechar Modal</button>
                        </div>
                    </Modal>  
                </div>
            </div>            
        </>
    );
}
