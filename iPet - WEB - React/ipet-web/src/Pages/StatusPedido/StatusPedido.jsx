import React from "react";
import "./StatusPedido.css";
import { Link, useHistory } from "react-router-dom";
import { Menu } from "../../components/menu/Menu";
import { Button } from "../../components/button/Button";
import Progress from "../../components/progress/Progress";
import { Footer } from "../../components/footer/footer";

export function StatusPedido() {
  const history = useHistory();
  function redirectProdutos() {
    history.push('/produtos');
  }
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2>Pedido confirmado</h2>
      <hr />
      <div className="progressBar">
        <Progress />
      </div>
      <h3 className="txt-agradecimento">Agradecemos sua compra até breve</h3>
      <div className="status">
        <h3 className="txt-statusPedido">Status Pedido</h3>
        <h3 className="txt-situacaoPedido">Pedido Enviado</h3>
      </div>
      <h3 className="txt-pedido">Pedido: #v133344GH900</h3>
      <div className="informacoes">
        <h1>Informações do pedido, do cliente e da entrega</h1>
        <h1>Em construção...</h1>
      </div>
      <div className="section-botoes">
        <Button btnTitle="Realizar nova compra" clickButton={redirectProdutos} />
      </div>
      <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
    </>
  );
}

export default StatusPedido;
