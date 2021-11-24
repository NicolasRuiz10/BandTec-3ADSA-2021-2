import React, { useState } from 'react'
import './CadastroProdutos.css';
import { Menu } from '../../components/menu/Menu';
import Line from '../../Assets/Line.png'
import { Footer } from '../../components/footer/footer';
import axios from "axios";
import Toast from "../../components/toast/Toast";

export function CadastroProdutos() {
    const [showToast, setShowToast] = useState(false);
    function setValueToast(value) {
        setShowToast(value);
    }
    function setValueInput(e) {
        var formData = new FormData();
        const file = e.target.files[0];
        formData.append("txt", file);
        axios.post('http://localhost:8080/produtos/txt', formData, {
            headers: {
              'Content-Type': 'multipart/form-data',
            }
        }).then((res) => {
            setShowToast(true);
            document.location.reload(true);
        })
    }
    return (
        <>
            <Toast text="Produto cadastrado com sucesso" color="green" showToast={showToast} changeValueToast={setValueToast} />
            <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
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
            <hr></hr>
            <div className="importacao">
                <div className="importacaoTitle">
                    <h1>Importação de produtos em lote</h1>
                    <img className="Line" src={Line} alt="none" />
                </div>
                <div className="importacaoText">
                    <p>
                        Baixe nosso arquivo modelo e cadastre seus produtos
                    </p>
                </div>
                <div className="baixarButton">
                    <button className="botaoBaixar">Baixar arquivo</button>
                </div>
                <div className="enviarText">
                    <p>
                        Baixe nosso arquivo modelo e cadastre seus produtos
                    </p>
                </div>
                <div className="baixarButton">
                    <input type="file" onChange={setValueInput}/>
                </div>
            </div>
            <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
        </>
    );
}