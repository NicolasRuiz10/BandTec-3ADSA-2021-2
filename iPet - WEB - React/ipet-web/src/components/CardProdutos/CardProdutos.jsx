import React from "react";
import "./CardProdutos.css";
import { ButtonVerde } from "../../components/button/Button";
import { useAuth } from "../../hooks/Context";


const CardProdutos = ({ produto }) => {
  const { itemsCarrinho, setItemsCarrinho, setTotalCarrinho, totalCarrinho  } = useAuth();
  function adicionarItem() {
    setItemsCarrinho([...itemsCarrinho, produto])
    setTotalCarrinho(totalCarrinho + produto.valor);
  }
  return (
    <div className="card">
      <div className="card--imagem">
        <img src={`http://localhost:8080/produtos/foto/${produto.idProduto}`} alt="" />
        <hr />
      </div>
      <div className="card--desc">
        <div className="text-area-desc">
          <h3>{produto.descricao}</h3>
        </div>
      </div>
      <div className="card--preco">
        <h2>R$ {produto.valor}</h2>
      </div>
      <div className="card--label">
        <p className="p">{produto.quantidade} disponíveis</p>
      </div>
      <div className="card--btn">
        <ButtonVerde className="btn" title="Adicionar ao carrinho" clickButton={adicionarItem}/>
      </div>
    </div>
  );
};

export { CardProdutos };
