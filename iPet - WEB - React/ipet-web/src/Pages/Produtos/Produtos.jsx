import React, { useEffect, useState } from "react";
import "./Produtos.css";
import api from "../../services/api"
import { Menu } from "../../components/menu/Menu";
import { CheckBox } from "../../components/CheckBox/CheckBox";
import { CardProdutos } from "../../components/CardProdutos/CardProdutos";

export function Produtos() {
  const [produtos, setProdutos] = useState([]);

    useEffect(() => {
    api
      .get("/produtos")
      .then((response) => setProdutos(response.data));
  }, []);

 
  const tiposPets = ["Cachorro", "Gato", "Passaro", "Outros"];
  const marcas = [
    "Pedigree",
    "Royal",
    "Adimax",
    "Affinity",
    "BR4DOGS",
    "Outros",
  ];
  const outrosProdutos = ["Brinquedos", "Petiscos", "Acessorios", "Roupas"];
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
            <CheckBox key={key} label={tipo} />
          ))}
          <h3>Marca</h3>
          <hr />
          {marcas.map((marca, key) => (
            <CheckBox key={key} label={marca} />
          ))}
          <h3>Outros Produtos</h3>
          <hr />
          {outrosProdutos.map((op, key) => (
            <CheckBox key={key} label={op} />
          ))}
          <h3>Serviços</h3>
          <hr />
          {servicos.map((servico, key) => (
            <CheckBox key={key} label={servico} />
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
