import React from "react";
import { Intro } from "../../components/intro/Intro";
import { Menu } from "../../components/menu/Menu";
import './HomePage.css';


function HomePage() {
  return (
    <>
      <Menu />
      <Intro />
    </>
  );
}

export default HomePage;