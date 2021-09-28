import React from "react";
import './HomePage.css';
import Menu from './menu/Menu';
import Intro from './intro/Intro';

function HomePage() {
  return (
    <React.Fragment>
      <Menu />
      <Intro />
    </React.Fragment>
  );
}

export default HomePage;