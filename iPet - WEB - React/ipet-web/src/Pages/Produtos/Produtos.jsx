import React, { useEffect, useState } from "react";
import "./Produtos.css";
import api from "../../services/api";
import { Menu } from "../../components/menu/Menu";
import { CardProdutos } from "../../components/CardProdutos/CardProdutos";

export function Produtos() {
  const [produtos, setProdutos] = useState([]);
  useEffect(() => {
    const loadAll = async () => {
      // pegando a lista total de produtos
      let list = await api.get("/produtos");
      setProdutos(list.data);
    };
    loadAll();
  }, []);

  const marcas = ["Golden", "Me.Au", "Nutrilus", "Magnus", "True", "LCM", "Snacks"]
  const tiposPets = ["Cachorro", "Gato", "Passaro", "Outros"];
  const outrosProdutos = [
    "Ração",
    "Brinquedos",
    "Petiscos",
    "Acessorios",
    "Roupas",
  ];
  const servicos = ["Saúde", "Banho e Tosa"];

  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2>Produtos</h2>
      <hr />
      <div className="principal">
        <div className="filtro--produtos">
          <h3>Filtrar Produtos</h3>
          <hr />
          <a href="teste">Limpar filtro</a>
          <h3>Pet</h3>
          <hr />
          {tiposPets.map((tipo, key) => (
            <div className="checkBox">
              <input type="checkbox" />
              <label key={key}>{tipo}</label>
            </div>
          ))}
          <h3>Tipo Produtos</h3>
          <hr />
          {outrosProdutos.map((op, key) => (
            <div className="checkBox">
              <input type="checkbox" />
              <label key={key}>{op}</label>
            </div>
          ))}
          <h3>Marca</h3>
          <hr />
          {marcas.map((marca, key) => (
            <div className="checkBox">
              <input type="checkbox" name="marcaCheck" />
              <label key={key} for="marcaCheck">
                {marca}
              </label>
            </div>
          ))}
          <h3>Serviços</h3>
          <hr />
          {servicos.map((servico, key) => (
            <div className="checkBox">
              <input type="checkbox" />
              <label key={key}>{servico}</label>
            </div>
          ))}
        </div>
        <div className="card--principal">
          {produtos.map((produto, key) => (
            <CardProdutos key={key} props={produto} />
          ))}
        </div>
      </div>
    </>
  );
}

export default Produtos;
