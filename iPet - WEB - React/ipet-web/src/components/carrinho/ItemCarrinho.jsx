import React, { useState } from "react";
import "./ItemCarrinho.css";
import { useAuth } from "../../hooks/Context";

export function ItemCarrinho({ urlImg, descProduto, preco }) {
  const [quantidade, setQuantidade] = useState(1);
  const { setTotalCarrinho, totalCarrinho } = useAuth();
  console.log(totalCarrinho);

  function aumentarTotal() {
    let total = preco * quantidade;
    setTotalCarrinho(totalCarrinho + total);
  }

  function diminuirTotal() {
    setTotalCarrinho(totalCarrinho - preco);
  }

  function diminuirQuantidade() {
    setQuantidade(quantidade - 1);
    diminuirTotal();
  }

  function aumentarQuantidade() {
    setQuantidade(quantidade + 1);
    aumentarTotal();
  }

  return (
    <>
      <div className="box-item">
        <div className="section-itens--img">
          <img className="imagemProduto" alt="" src={urlImg} />
        </div>

        <div className="section-itens--desc">
          <div className="descricaoProduto">
            <p>{descProduto}</p>
          </div>
        </div>

        <div className="section-itens--preco">
          <div className={preco}>R$ {preco}</div>
        </div>

        <div className="section-itens--qtd">
          <div className="item-quantity">
            <button disabled={quantidade < 2} onClick={diminuirQuantidade}>
              -
            </button>
            <h1>{quantidade}</h1>
            <button onClick={aumentarQuantidade}>+</button>
          </div>
        </div>

        <div className="section-itens--total">
          <div>R$ {totalCarrinho}</div>
        </div>
      </div>
    </>
  );
}
