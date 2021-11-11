import React from "react";
import "./CardProdutos.css";
import { ButtonVerde } from "../../components/button/Button";
import api from "../../services/api";




const CardProdutos = ({ produto }) => {
  async function pegarFoto(id) {
    let foto = await api.get(`/produtos/foto/${id}`);
    return foto;
  }
  return (
    <div className="card">
      <div className="card--imagem">
        <img src={pegarFoto(produto.idProduto)} alt="" />
        <hr />
      </div>
      <div className="card--desc">
        <h3>{produto.descricao}</h3>
      </div>
      <div className="card--preco">
        <h2>R$ {produto.valor}</h2>
      </div>
      <div className="card--label">
        <p>{produto.quantidade} disponíveis</p>
      </div>
      <div className="card--btn">
        <ButtonVerde className="btn" title="Adicionar ao carrinho" />
      </div>
    </div>
  );
};

export { CardProdutos };
