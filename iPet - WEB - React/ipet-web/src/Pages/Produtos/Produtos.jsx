import React from "react";
import './Produtos.css';
import { Menu } from "../../components/menu/Menu";

export function Produtos() {
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2>Produtos</h2>
      <hr />  
    </>
  );
}

export default Produtos;
