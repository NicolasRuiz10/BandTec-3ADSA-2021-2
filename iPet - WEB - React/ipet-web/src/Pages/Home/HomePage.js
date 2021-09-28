import React from "react";
import { Intro } from "../../components/intro/Intro";
import { Menu } from "../../components/menu/Menu";
import './HomePage.css';


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
            Aqui você encontra as melhores marcas que oferecemos com suma confiançais
          </h2>
        </div>
        <div className="brandsImages">
          <div className="brand1">
            <img clasName="brand1" src="logoPetz.png" height="200px" width="250px" alt="none" />
          </div>
          <div className="brand2">
            <img clasName="brand2" src="mi-au_logo.png" height="200px" width="250px" alt="none" />
          </div>
          <div className="brand3">
            <img src="vitaprime_logo.png" height="200px" width="250px" alt="none" />
          </div>
          <div className="brand4">
            <img src="americanPets.png" height="200px" width="250px" alt="none" />
          </div>
        </div>
      </section>
    </>
  );
}

export default HomePage;