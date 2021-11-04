import React from "react";
import './CardProdutos.css';
import { ButtonVerde } from "../../components/button/Button"



const CardProdutos = ({props}) => {
  console.log(props);
  const URL = "https://www.petz.com.br/cachorro/racas/pointer-ingles/img/golden-formula-pointer-ingles.webp"
  return (
      <div className="card">
        <div className="card--imagem">
          <img src={URL} alt="" />
          <hr />
        </div>
        <div className="card--desc">
          <h3>{props.descricao}</h3>
        </div>
        <div className="card--preco">
          <h2>R$ {props.valor}</h2>
        </div>
        <div className="card--label">
          <p>{props.quantidade} disponíveis</p>
        </div>
        <div className="card--btn">
          <ButtonVerde className="btn" title="Adicionar ao carrinho"/>
        </div>
      </div>
  )
}

export {CardProdutos}
