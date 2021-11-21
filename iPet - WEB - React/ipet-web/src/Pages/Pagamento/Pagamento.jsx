import React from "react";
import { Menu } from "../../components/menu/Menu";
import Progress from "../../components/progress/Progress";
import "./Pagamento.css";
import { Link, useHistory } from "react-router-dom";
import { ButtonVerde } from "../../components/button/Button";
import { Footer } from "../../components/footer/footer";


export function Pagamento() {
  const history = useHistory();
  function redirectStatus() {
    history.push('/status-pedido');
  }
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2 className="h2">Pagamento</h2>
      <hr />
      <div className="progressBar">
        <Progress />
      </div>
      <div className="principal--pagamento">
        <div className="pagamento-radios">
          <h3>Escolha a forma de pagamento</h3>
          <div className="radios">
            <div className="radio-pag">
            <input type="radio" name="FormaPagamento" value="pix"/>
              <label for="pix">Pix</label>       
              <input type="radio" name="FormaPagamento" value="dinheiro" />
              <label for="dinheiro">Dinheiro</label>

              <input type="radio" name="FormaPagamento" value="cartao" />
              <label for="cartao">Cartão</label>
            </div>
          </div>
          <p>*Pagamento em Dinheiro e Cartão deve ser realizado no ato da entrega</p>
        </div>
          <div className="pix">
            <h3>Chave Pix para o pagamento: A5YYYTWW28882JJJ27712</h3>
            <p>Chave Aleatória : iPet</p>
            <img src="https://logopng.com.br/logos/pix-106.png" alt="" />
            <p>Valor da compra: R$ 120,00</p>
            <span>Comprovante</span>
            <input type="file" />
          </div>

      </div>
      <div className="botoes-div">
        <div className="btn-finalizar">
          <ButtonVerde title="Finalizar Compra" clickButton={redirectStatus} />
        </div>
        <Link to="/carrinho">
          <div className="btn-voltar">
            <a href="/carrinho">Voltar carrinho</a>
          </div>
        </Link>
      </div>
      <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
    </>
  );
}

export default Pagamento;
