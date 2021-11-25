import React from "react";
import "./CadastroProdutos.css";

import { Menu } from "../../components/menu/Menu";
import { Footer } from "../../components/footer/footer";

export function CadastroProdutos() {
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <div className="id">
        <p>ID PetShop: 11</p>  
      </div>
      <div className="cadastroTitle">
        <h1>Cadastro de produto</h1>
        <hr />
      </div>
      <div className="principal-cadastro">
        <div className="info-produto">
          <h5>Dados do Produto</h5>
          <div className="input-produto">
            <p>Nome do produto: </p>
            <input type="text" placeholder="Digite o nome do produto" />
            <p>Marca do produto: </p>
            <input type="text" placeholder="Digite a marca do produto" />
            <p>Valor do produto: </p>
            <input type="number" placeholder="Digite o valor do produto" />
            <p>Quantidade: </p>
            <input type="number" placeholder="Digite a quantidade do produto" />
            <p>Tipo do produto: </p>
            <select name="select">
              <option value="valor1">Valor 1</option>
              <option value="valor2" selected>
                Valor 2
              </option>
              <option value="valor3">Valor 3</option>
            </select>
            <p>Tipo do pet: </p>
            <select name="select">
              <option value="valor1">Valor 1</option>
              <option value="valor2" selected>
                Valor 2
              </option>
              <option value="valor3">Valor 3</option>
            </select>
            <p>Descrição do produto: </p>
            <textarea type="text" placeholder="Digite a descrição do produto" />
          </div>
        </div>
        <div className="anexoImg">
          <h5>Escolha a foto do produto</h5>
          <input type="file" />
        </div>
      </div>
      <div className="buttonsfinal">
        <button id="btn-adicionar-produto">Adicionar Produto</button>
      </div>
      <div className="importacao">
        <div className="importacaoTitle">
          <h1>Cadastro de produto em lote</h1>
          <hr />
        </div>
        <div className="importacaoText">
          <h5>Baixe nosso arquivo modelo e cadastre seus produtos</h5>
        </div>
        <div className="baixarButton">
          <button className="botaoBaixar">Baixar arquivo</button>
        </div>
        <div className="enviarText">
          <h5>Envie seu arquivo preenchido e uma imagem</h5>
        </div>
        <div className="enviar-arq">
           <label htmlFor="">Arquivo: </label>
          <input type="file"></input>
        </div>
        <div className="enviar-arq">
        <label htmlFor="">Imagem: </label>
          <input type="file"></input>
        </div>
        <div className="adicionarButton">
          <button>Adicionar arquivos</button>
          <button id="btn-desfazer-cadastro">Desfazer último cadastro</button>
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
