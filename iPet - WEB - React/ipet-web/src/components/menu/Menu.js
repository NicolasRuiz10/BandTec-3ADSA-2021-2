import React from "react";
import './Menu.css';
import logo from '../../Assets/logo1.jpeg'
import { FaShoppingCart } from 'react-icons/fa';


export function Menu(props) {
  return (
    <>
      <div className="menu">
        <div className="logo">
          <img src={logo} alt="Logo iPet" />
        </div>
        <div className="itens-menu">
          <div className="item-menu">
            <h3>{props.menuItem1}</h3>
          </div>
          <div className="item-menu">
            <h3>{props.menuItem2}</h3>
          </div>
          <div className="item-menu">
            <h3>{props.menuItem3}</h3>
          </div>
        </div>
        <div className="itens-acesso">
          <div className="item-acesso">
            <button className="btn-login">Login</button>
          </div>
          <div className="item-acesso">
            <button className="btn-cadastro">Cadastro</button>
          </div>
          <div className="item-acesso">
            <div className="icon-car">
              <FaShoppingCart size={34} />
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
