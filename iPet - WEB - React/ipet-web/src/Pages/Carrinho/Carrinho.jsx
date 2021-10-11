import React from "react";
import './Carrinho.css';
import { Menu } from "../../components/menu/Menu";

export function Carrinho() {
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2>Meu Carrinho</h2>
      <hr />
      <div className="principal--carrinho">
        <div className="navBar--carrinho">
          <div className="etapas">
            <div className="section--etapas">
              <div className="btn--etapa">1</div>
              <p className="txt--etapa">Carrinho</p>
              <hr />
            </div>
            <div className="section--etapas">
              <div className="btn--etapa">2</div>
              <p className="txt--etapa">Pagamento</p>
              <hr />
            </div>
            <div className="section--etapas">
              <div className="btn--etapa">3</div>
              <p className="txt--etapa">Confirmação</p>
            </div>
          </div>
          
        </div>
      </div>
    </>
  );
}

export default Carrinho;
