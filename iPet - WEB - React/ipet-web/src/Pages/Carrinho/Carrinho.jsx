import React, { useState } from "react";
import './Carrinho.css';
import { Menu } from "../../components/menu/Menu";
import Progress from "../../components/progress/Progress";
import Cama from '../../Assets/cama.jpg'



export function Carrinho() {
  const product = {
    price: 100,
  }
  const [quantidade, setQuantidade] = useState(0);
  const total = product.price * quantidade;
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
        <div className="box-carrinho">
          <div className="itens-carrinho">
            <div className="item-product">
              <h1>Produto</h1>
              <img src={Cama} width="400" height="300" />
            </div>
            <div className="item-price">
              <h1>Preço</h1>
              <div className="item-priceNumber">R$ - {product.price}</div>
            </div>
            <div className="item-quantity">
              <h1>Quantidade</h1>
              <button onClick={() => setQuantidade(quantidade + 1)}>
                +
              </button>
              <div>
                {quantidade}
              </div>
              <button onClick={() => setQuantidade(quantidade - 1)}>
                -
              </button>
            </div>
            <div className="item-total">
              <h1>Total</h1>
              <div>
                {total}
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Carrinho;
