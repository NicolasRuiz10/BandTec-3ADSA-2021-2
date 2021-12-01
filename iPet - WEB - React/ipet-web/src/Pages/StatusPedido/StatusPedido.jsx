import React from "react";
import "./StatusPedido.css";
import { useHistory } from "react-router-dom";
import { Menu } from "../../components/menu/Menu";
import { useAuth } from "../../hooks/Context";
import { Button } from "../../components/button/Button";
import Progress from "../../components/progress/Progress";
import { Footer } from "../../components/footer/footer";

export function StatusPedido() {
  const history = useHistory();
  const {itemsCarrinho} = useAuth();
  const { totalCarrinho } = useAuth();

  console.log(itemsCarrinho);

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
        <div className="informacoes-pedido">
          <h1>Informações do pedido</h1>
          <ol>
            {itemsCarrinho.map((item, key) => (
              <li key={key}>✔ {item.nome}</li>
            ))}
          </ol>
          <p>Valor total da compra: R$ {totalCarrinho.toFixed(2)}</p>
          <span className="color-gren">Pagamento aprovado</span>
        </div>
        <div className="informacoes-pet">
          <h1>Informações da entrega</h1>
          <p>PetShop: NobrePet</p>
          <p>Tempo estimado: 2 horas</p>
          <span className="color-gren">Pedido aprovado</span>
        </div>
      </div>
      <div className="section-botoes">
        <button className="btn-nova-compra" onClick={redirectProdutos}>Realizar nova compra</button>
      </div>
      <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
    </>
  );
}

export default StatusPedido;
