import React, { useState } from "react";
import "./CadastroProdutos.css";
import {MenuPetshop} from "../menu/MenuPetshop";
import { Footer } from "../../components/footer/footer";
import Toast from "../../components/toast/Toast";
import axios from "axios";
import { Button } from "../../components/button/Button";
import { useAuth } from "../../hooks/Context";

export default function CadastroProdutos() {
  const { idPetshop } = useAuth();
  const [showToast, setShowToast] = useState(false);
  const [img, setImg] = useState("");
  const [file, setFile] = useState("");
  const [colorToast, setColorToast] = useState("");
  const [textToast, setTextToast] = useState("");
  const [nome, setNome] = useState("");
  const [marca, setMarca] = useState("");
  const [valor, setValor] = useState("");
  const [quantidade, setQuantidade] = useState("");
  const [tipoProduto, setTipoProduto] = useState("");
  const [tipoPet, setTipoPet] = useState("");
  const [descricao, setDescricao] = useState("");

   async function gravar() {
     console.log('idPet', idPetshop);
     const response = await axios
      .post(`http://localhost:8080/produtos/${idPetshop}`, {
        nome: nome,
        descricao: descricao,
        valor: valor,
        marca: marca,
        especie: tipoPet,
        quantidade: quantidade,
        tipoProduto: tipoProduto,
      })
    console.log("meu id", response.data);
    var formatImg = new FormData();
    formatImg.append("foto", img);
    if (response.data) {
      axios
        .patch(
          `http://localhost:8080/produtos/atualizar-foto/${response.data}`,
          formatImg,
          {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          }
        )
        .then((res) => {
          console.log(res);
        });
    }
  }

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
    formData.append("image", img);
    if (file !== "" || img !== "") {
      axios
        .post("http://localhost:8080/produtos/txt", formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((res) => {
          setShowToast(true);
          setColorToast("green");
          setTextToast("Produto cadastrado com sucesso");
        });
    } else {
      setShowToast(true);
      setColorToast("red");
      setTextToast("Necessário anexar todos os arquivos");
    }
  }

  function desfazer() {
    axios.delete("http://localhost:8080/produtos/desfazer-cadastro").then(res => {
      console.log(res , 'resposta');
      if (res.status === 200) {
        setShowToast(true);
        setColorToast("green");
        setTextToast("último cadastro foi desfeito com sucesso");
      }
    })
  }
  return (
    <>
      <Toast
        text={textToast}
        color={colorToast}
        showToast={showToast}
        changeValueToast={setValueToast}
      />
      <MenuPetshop />
      <div className="id">
        <p>ID PetShop: {idPetshop}</p>
      </div>
      <div className="cadastroTitleDiv">
        <h1>Cadastro de produto</h1>
        <hr />
      </div>
      <div className="principal-cadastro-div">
        <div className="info-produto-div">
          <h5>Dados do Produto</h5>
          <div className="input-produto-div">
            <p>Nome do produto: </p>
            <input
              type="text"
              placeholder="Digite o nome do produto"
              onChange={(e) => setNome(e.target.value)}
            />
            <p>Marca do produto: </p>
            <input
              type="text"
              placeholder="Digite a marca do produto"
              onChange={(e) => setMarca(e.target.value)}
            />
            <p>Valor do produto: </p>
            <input
              type="number"
              placeholder="Digite o valor do produto"
              onChange={(e) => setValor(e.target.value)}
            />
            <p>Quantidade: </p>
            <input
              type="number"
              placeholder="Digite a quantidade do produto"
              onChange={(e) => setQuantidade(e.target.value)}
            />
            <p>Tipo do produto: </p>
            <input
              type="text"
              placeholder="Digite o tipo do produto"
              onChange={(e) => setTipoProduto(e.target.value)}
            />
            <p>Tipo do pet: </p>
            <input
              type="text"
              placeholder="Digite o tipo do pet"
              onChange={(e) => setTipoPet(e.target.value)}
            />
            <p>Descrição do produto: </p>
            <textarea
              type="text"
              placeholder="Digite a descrição do produto"
              onChange={(e) => setDescricao(e.target.value)}
            />
          </div>
        </div>

        <div className="anexoImg-div">
          <h5>Escolha a foto do produto</h5>
          <label htmlFor="imagem" className="label">
            {!img.name ? "Escolher imagem" : img.name}
          </label>
          <input id="imagem" type="file" onChange={setValueImg} />
        </div>
      </div>
      <div className="buttonsfinal-div">
        <button id="adicionar-produto" onClick={gravar}>
          Adicionar Produto
        </button>
      </div>
      <div className="cadastroTitleDiv">
        <h1>Importação de produtos em lote</h1>
        <hr />
      </div>
      <div className="importacao">
        <div className="enviarText">
          <p>Baixe nosso arquivo modelo e cadastre seus produtos</p>
        </div>
        <div className="baixarButton">
          <label htmlFor="imagem" className="label">
            {!img.name ? "Escolher imagem" : img.name}
          </label>
          <input id="imagem" type="file" onChange={setValueImg} />
        </div>
        <div className="baixarButton">
          <label htmlFor="txt" className="label">
            {!file.name ? "Escolher arquivo txt" : file.name}
          </label>
          <input id="txt" type="file" onChange={setValueTxt} />
        </div>
        <div className="baixarButton">
          <Button btnTitle="Cadastrar produto" clickButton={send} />
          <div id="btn-desfazer">
            <button onClick={desfazer}>Desfazer</button>
          </div>
        </div>
      </div>
      <Footer
        item1="Termos e condições de usos"
        item2="Políticas e termos"
        item3="Help desk"
        item4="Formas de pagamento"
      />
    </>
  );
}
