import React from "react";
import { Intro } from "../../components/intro/Intro";
import { Menu } from "../../components/menu/Menu";
import './HomePage.css';

import MagnusLogo from '../../Assets/magnus.png'
import PedigreeLogo from '../../Assets/pedigree.png'
import PurinaLogo from '../../Assets/purina.png'
import WhiskasLogo from '../../Assets/whiskas-logo.png'
import { Footer } from "../../components/footer/footer";

function HomePage() {
  return (
    <>
      <Menu />
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

      <section className="ipet">

      </section>

      <section className="produtos">
        <h3>Produtos de diversas lojas</h3>
      </section>
      <Footer />
    </>
  );
}

export default HomePage;