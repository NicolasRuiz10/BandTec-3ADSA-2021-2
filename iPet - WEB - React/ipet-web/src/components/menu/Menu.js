import React from "react";
import './Menu.css';
import logo from '../../Assets/logo1.jpeg'
import { FaShoppingCart } from 'react-icons/fa';
import { Link } from "react-router-dom";


export function Menu(props) {
  return (
    <>
      <div className="menu">
        <div className="logo">
          <Link to="/">
            <img src={logo} alt="Logo iPet" />
          </Link>  
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
            <Link to="/login">
              <button className="btn-login">Login</button>
            </Link>
          </div>
          <div className="item-acesso">
            <Link to="/cadastro">
              <button className="btn-cadastro">Cadastro</button>
            </Link>
          </div>
          <div className="item-acesso">
            <div className="icon-car">
              <Link to="/carrinho">
                <FaShoppingCart size={34} className="icon--carrinho"/>
              </Link>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
