import React from "react";
import './Carrinho.css';
import { Menu } from "../../components/menu/Menu";
import { ItemCarrinho } from "../../components/carrinho/ItemCarrinho";
import Progress from "../../components/progress/Progress";
import { ButtonVerde } from "../../components/button/Button"




export function Carrinho() {
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2>Meu Carrinho</h2>
      <hr />
      <div className="principal--carrinho">
        <div className="navBar--carrinho">
          <div className="progressBar">
            <Progress />
          </div>
        </div>
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
            <div className="itens">
              <ItemCarrinho  
                urlImg="https://essaseoutras.com.br/wp-content/uploads/2011/02/acessorios-para-caes-2.png" 
                descProduto="Cama Viena Ziper G" 
                preco="250" />
            </div>
            <div className="itens">
              <ItemCarrinho  
                urlImg="https://www.casadaracaobh.com.br/wp-content/uploads/2017/10/Ra%C3%A7%C3%A3o-Magnus-Premium-Original-C%C3%A3es-Adultos.png" 
                descProduto="Ração Seca PremieR" 
                preco="100" />
            </div>
            <div className="itens">
              <ItemCarrinho  
                urlImg="https://petcamp.vteximg.com.br/arquivos/ids/156124-1000-1000/7896029064344-png.png?v=637672210510900000 " 
                descProduto="Ração Pet Golden" 
                preco="100" />
            </div>
            <div className="itens">
              <ItemCarrinho  
                urlImg="https://petcamp.vteximg.com.br/arquivos/ids/156124-1000-1000/7896029064344-png.png?v=637672210510900000 " 
                descProduto="Ração Pet Golden" 
                preco="100" />
            </div>
            <div className="itens">
              <ItemCarrinho  
                urlImg="https://petcamp.vteximg.com.br/arquivos/ids/156124-1000-1000/7896029064344-png.png?v=637672210510900000 " 
                descProduto="Ração Pet Golden" 
                preco="100" />
            </div>
          </div>
        </div>
      </div>

      <div className="btn-proximo">
          <ButtonVerde title="Fechar pedido"/> 
      </div>
    </>
  );
}

export default Carrinho;
