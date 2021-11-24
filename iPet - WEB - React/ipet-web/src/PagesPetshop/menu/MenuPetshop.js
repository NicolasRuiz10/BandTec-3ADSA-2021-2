import React from "react";
import "./Menu.css";
import logo from "../../Assets/logo1.jpeg";
import { Link } from "react-router-dom";
import { useAuth } from '../../hooks/Context';
import axios from "axios";
import { useHistory } from "react-router-dom";


export function MenuPetshop(props) {
	let history = useHistory();
	const { autenticadoPetshop, setAutenticadoPetshop, idPetshop, nomePetshop } = useAuth();

	const RealizarLogoff = () => {
		axios.post("http://localhost:8080/ipet/logoff/" + idPetshop).then((res) => {
			setAutenticadoPetshop(false);
			history.push("/petshop/login");
		});
	}
	return (
		<>
			<div className="menu">
				<div className="logo">
					<Link to="/">
						<img src={logo} alt="Logo iPet" />
					</Link>
				</div>
				{!autenticadoPetshop ?
					<div className="itens-acesso">
						<div className="item-acesso">
							<Link to="/petshop/login">
								<button className="btn-login">Login</button>
							</Link>
						</div>
						<div className="item-acesso">
							<Link to="/petshop/cadastro">
								<button className="btn-cadastro">Cadastro</button>
							</Link>
						</div>
					</div>
					:
					<div className="itens-acesso">
						<div className="item-acesso">
							<button className="btn-cadastro" onClick={RealizarLogoff}>Loggof</button>
						</div>
						<div className="item-acesso">
							<div className="icon-car">
								Olá, {nomePetshop}
							</div>
						</div>
					</div>
				}

			</div>
		</>
	);
}
