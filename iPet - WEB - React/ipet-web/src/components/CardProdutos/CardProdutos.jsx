import React from "react";

import "./CardProdutos.css";
import { ButtonVerde } from "../../components/button/Button";
import api from "../../services/api";
import { useAuth } from '../../hooks/Context';

const CardProdutos = (props, { produto }) => {
  const { setItemsCarrinho } = useAuth();
  async function pegarFoto(id) {
    let foto = await api.get(`/produtos/foto/${id}`);
    return foto;
  }
  function adicionarProduto() {
    setItemsCarrinho(produto);
    props.emitToast(true);
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
        <ButtonVerde className="btn" title="Adicionar ao carrinho" clickButton={adicionarProduto}/>
      </div>
    </div>
  );
};

export { CardProdutos };
