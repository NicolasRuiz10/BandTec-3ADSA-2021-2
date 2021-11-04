import React from "react";
import Input from "../../components/input/Input";
import { Menu } from "../../components/menu/Menu";
import Progress from "../../components/progress/Progress";
import "./Pagamento.css";
import { Link } from "react-router-dom";
import { ButtonVerde } from "../../components/button/Button";
import { Footer } from "../../components/footer/footer";


export function Pagamento() {
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2>Pagamento</h2>
      <hr />
      <div className="progressBar">
        <Progress />
      </div>
      <div className="principal--pagamento">
        <div className="dados-pagamento">
          <Input
            txt="Número cartão *"
            placeholder="Digite o número do seu cartão"
          />
          <Input
            txt="Bandeira *"
            placeholder="Selecione a bandeira do seu cartão"
          />
          <Input
            txt="Validade Mês/Ano"
            placeholder="Digite o mês e ano do seu cartão"
          />
          <Input
            txt="Nome impresso no seu cartão *"
            placeholder="Digite o nome completo"
          />
          <Input
            txt="Parcelas"
            placeholder="Selecione a quantidade de parcelas"
          />
        </div>
        <div className="div-dados">
          <table border="1">
            <tr>
              <th>Subtotal:</th>
              <td>R$ 1000,00</td>
            </tr>
            <tr>
              <th>Frete:</th>
              <td>Calcular</td>
            </tr>
            <tr>
              <th>Total:</th>
              <td>R$ 1000,00</td>
            </tr>
          </table>
          <img
            src="https://kontaazul.com.br/wp-content/uploads/2020/02/bandeira-dos-cartoes-de-credito.png"
            alt=""
          />
        </div>
      </div>
      <div className="botoes-div">
        <Link to="/status-pedido">
          <div className="btn-finalizar">
            <ButtonVerde title="Finalizar Compra" />
          </div>
        </Link>
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
