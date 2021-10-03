import React from "react";
import './HomePage.css';
import { Intro } from "../../components/intro/Intro";
import { Menu } from "../../components/menu/Menu";
import { Footer } from "../../components/footer/footer";
import MagnusLogo from '../../Assets/magnus.png'
import PedigreeLogo from '../../Assets/pedigree.png'
import PurinaLogo from '../../Assets/purina.png'
import WhiskasLogo from '../../Assets/whiskas-logo.png'
import banhoTosa from '../../Assets/banhoTosa.png'
import Button from "../../components/button/Button";


function HomePage() {
  return (
    <>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <Intro />
      <section className="brands">
        <div>
          <h1 className="brandTitle">
            Principais marcas
          </h1>
          <br />
          <h2 className="brandText">
            Aqui você encontra as melhores marcas que oferecemos com suma confianças
          </h2>
        </div>
        <div className="brandsImages">
          <div className="brand1">
            <img clasName="brand1" src={MagnusLogo} height="80px" width="120px" alt="none" />
          </div>
          <div className="brand2">
            <img clasName="brand2" src={PedigreeLogo} height="80px" width="120px" alt="none" />
          </div>
          <div className="brand3">
            <img src={PurinaLogo} height="80px" width="120px" alt="none" />
          </div>
          <div className="brand4">
            <img src={WhiskasLogo} height="80px" width="120px" alt="none" />
          </div>
        </div>
      </section>
      <section className="products">
        <h3>Produtos de diversas lojas</h3>
      </section>
      <section className="bathAndGroom">
        <div className="bathAndGroomContent">
          <div className="bathAndGroomImage">
            <img clasName="" src={banhoTosa} height="400px" width="580px" alt="none" />
          </div>
          <div className="bathAndGroomText">
            <p>
              <h2>BANHO E TOSA</h2>
              Todos os cuidados higienicos com os melhores produtos!<br />
              Encontre agora o petshop mais próximo do seu lar<br />
            </p>
            <Button btnTitle="Faça parte" />
          </div>
        </div>

      </section>

      <Footer item1="Termos e condições de usos" item2="Políticas e termos" item3="Help desk" item4="Formas de pagamento" />
    </>
  );
}

export default HomePage;