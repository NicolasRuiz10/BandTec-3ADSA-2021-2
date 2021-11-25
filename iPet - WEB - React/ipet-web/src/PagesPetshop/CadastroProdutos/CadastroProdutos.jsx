import React, { useState } from 'react'
import './CadastroProdutos.css';
import { Menu } from '../../components/menu/Menu';
import Line from '../../Assets/Line.png'
import { Footer } from '../../components/footer/footer';
import Toast from "../../components/toast/Toast";
import axios from "axios";
import { Button } from "../../components/button/Button";

export default function CadastroProdutos() {
    const [showToast, setShowToast] = useState(false);
    const [img, setImg] = useState('');
    const [file, setFile] = useState('');
    const [colorToast, setColorToast] = useState('');
    const [textToast, setTextToast] = useState('');
    function setValueToast(value) {
        setShowToast(value);
    }

    function setValueImg(e) {
        setImg(e.target.files[0]);
    }

    function setValueTxt(e) {
        setFile(e.target.files[0]);
    }

    function send(e) {
        var formData = new FormData();
        formData.append("txt", file);
        formData.append('image', img);
        if (file !== '' || img !== '') {
            axios.post('http://localhost:8080/produtos/txt', formData, {
                headers: {
                  'Content-Type': 'multipart/form-data',
                }
            }).then((res) => {
                setShowToast(true);
                setColorToast('green');
                setTextToast('Produto cadastrado com sucesso');
            })
        } else {
            setShowToast(true);
            setColorToast('red');
            setTextToast('Necessário anexar todos os arquivos');
        }
    }
    return (
        <>
            <Toast text={textToast} color={colorToast} showToast={showToast} changeValueToast={setValueToast} />
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
                    <label htmlFor="imagem" className="label">{!img.name ? 'Escolher imagem' : img.name}</label>
                    <input id="imagem" type="file" onChange={setValueImg}/>
                </div>
                <div className="baixarButton">
                    <label htmlFor="txt" className="label">{!file.name ? 'Escolher arquivo txt' : file.name}</label>
                    <input id="txt" type="file" onChange={setValueTxt}/>
                </div>
                <div className="baixarButton">
                    <Button btnTitle="Cadastrar produto" clickButton={send} />
                </div>
            </div>
            <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
        </>
    );
}