import React , { useState } from "react";
import './ItemCarrinho.css';

export function ItemCarrinho({urlImg, descProduto, preco}) {
  const [quantidade, setQuantidade] = useState(1);
  const total = preco * quantidade;
  return (
    <>
      <div className="box-item">
        <div className="section-itens--img">
          <img className="imagemProduto" alt="" src={urlImg}/>
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
            <button disabled={total === 0} onClick={() => setQuantidade(quantidade - 1)}>-</button>
            <h1>{quantidade}</h1>
            <button onClick={() => setQuantidade(quantidade + 1)}>+</button>
          </div>
        </div>
       
        <div className="section-itens--total">
          <div>R$ {total}</div>
        </div>
      </div>
    </>
  );
}
