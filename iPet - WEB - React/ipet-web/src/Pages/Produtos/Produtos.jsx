import React, { useEffect, useState } from "react";
import "./Produtos.css";
import api from "../../services/api";
import { Menu } from "../../components/menu/Menu";
import { CardProdutos } from "../../components/CardProdutos/CardProdutos";
import Toast from "../../components/toast/Toast";

export function Produtos() {
  const [produtos, setProdutos] = useState([]);
  const [showToast, setShowToast] = useState(false);
  const [busca, setBusca] = useState("");
  produtos.filter((produto) => produto)
  useEffect(() => {
    getProdutos();
  }, []);

  function setValueToast(value) {
    setShowToast(value);
  }
async function getProdutos() {
    
    const marcas = ["Golden", "Me.Au", "Nutrilus", "Magnus", "True", "LCM", "Snacks"]
    console.log("chamou");
    let list = await api.get("/produtos");
    setProdutos(list.data);
  }

  const filtroMarca = async () => {
    const filtoMarcas = [];
    var marcaCheck = document.getElementsByName("marcaCheck");
    for (var i = 0; i < marcaCheck.length; i++) {
      if (marcaCheck[i].checked) {
        if (marcaCheck[i].value === "7") {
          var marca_1 = "Golden";
          filtoMarcas.push(marca_1);
        } else if (marcaCheck[i].value === "6") {
          var marca_2 = "Me.Au";
          filtoMarcas.push(marca_2);
        } else if (marcaCheck[i].value === "5") {
          var marca_3 = "Nutrilus";
          filtoMarcas.push(marca_3);
        } else if (marcaCheck[i].value === "4") {
          var marca_4 = "Magnus";
          filtoMarcas.push(marca_4);
        } else if (marcaCheck[i].value === "3") {
          var marca_5 = "True";
          filtoMarcas.push(marca_5);
        } else if (marcaCheck[i].value === "2") {
          var marca_6 = "LCM";
          filtoMarcas.push(marca_6);
        } else if (marcaCheck[i].value === "1") {
          var marca_7 = "Snacks";
          filtoMarcas.push(marca_7);
        }
      }
      filto(filtoMarcas);
    }
  };

  async function filto(filtro) {
    var novosProdutos = [];
    produtos.map((p) => {
      filtro.forEach((f) => {
        if (p.marca === f) {
          novosProdutos.push(p);
        }
      });
      return true;
    });
    if (novosProdutos.length > 0) {
      setProdutos(novosProdutos);
    }
  }

  // async function pegarImagem(id) {
  //   console.log("entrou aqui", id);
  //   let foto = await api.get(`/produtos/foto/${id}`);
  //   console.log("entrou aqui 2", foto);
  //   return foto;
  // }
  const tiposPets = ["Cachorro", "Gato", "Passaro", "Outros"];
  const outrosProdutos = [
    "Ração",
    "Brinquedos",
    "Petiscos",
    "Acessorios",
    "Roupas",
  ];
  const servicos = ["Saúde", "Banho e Tosa"];

  return (
    <>
      <Toast text="Login ou senha incorretos" color="green" showToast={showToast} changeValueToast={setValueToast}/>
      <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
      <h2>Produtos</h2>
      <hr />
      <div className="principal">
        <div className="filtro--produtos">
          <h3>Filtrar Produtos</h3>
          <hr />
          <input
            onChange={(ev) => setBusca(ev.target.value)}
            type="text"
            value={busca}
            placeholder="Pesquisar produto.."
            className="inputPesquisa"
          />
          <h3>Pet</h3>
          <hr />
          {tiposPets.map((tipo, key) => (
            <div className="checkBox">
              <input type="checkbox" />
              <label key={key}>{tipo}</label>
            </div>
          ))}
          <h3>Tipo Produtos</h3>
          <hr />
          {outrosProdutos.map((op, key) => (
            <div className="checkBox">
              <input type="checkbox" />
              <label key={key}>{op}</label>
            </div>
          ))}
          {/* CHECKBOX MARCAS */}
          <h3>Marca</h3>
          <hr />
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="7"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Golden</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="6"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Me.Au</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="5"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Nutrilus</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="4"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Magnus</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="3"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">True</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="2"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">LCM</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="1"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Snacks</label>
          </div>
          <h3>Serviços</h3>
          <hr />
          {servicos.map((servico, key) => (
            <div className="checkBox">
              <input type="checkbox" />
              <label key={key}>{servico}</label>
            </div>
          ))}
        </div>
        <div className="card--principal">
          {produtos.map((produto, key) => (
            <CardProdutos key={key} produto={produto} emitToast={setValueToast}/>
          ))}
        </div>
      </div>
    </>
  );
}

export default Produtos;
