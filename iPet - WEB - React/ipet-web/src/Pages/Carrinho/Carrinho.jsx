import React from "react";
import './Carrinho.css';
import { Menu } from "../../components/menu/Menu";
import Progress from "../../components/progress/Progress";

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
      </div>
    </>
  );
}

export default Carrinho;
