import React, { useEffect, useState } from "react";
import "./Produtos.css";
import { Menu } from "../../components/menu/Menu";
import { CardProdutos } from "../../components/CardProdutos/CardProdutos";
import axios from "axios";

export function Produtos() {
  const [produtos, setProdutos] = useState([]);
  const [busca, setBusca] = useState("");
  const [produtosBase, setProdutosBase] = useState("");
  
  useEffect(() => {
    axios.get("http://localhost:8080/produtos").then((res) => {
      setProdutos(res.data);
      setProdutosBase(res.data);
    });
  }, [])
  
  const buscaLowerCase = busca.toLowerCase()
  const produtosFiltados = produtos
  .filter((produto) => produto.nome.toLowerCase().includes(buscaLowerCase))

  function filtroMarca() {
    const filtroMarca = [];
    const filtroPet = [];
    var marcaCheck = document.getElementsByName("marcaCheck");
    console.log('filtro', marcaCheck);
    for (var i = 0; i < marcaCheck.length; i++) {
      if (marcaCheck[i].checked) {
        if (marcaCheck[i].value === "7") {
          var marca_1 = "Golden";
          filtroMarca.push(marca_1);
        } else if (marcaCheck[i].value === "6") {
          var marca_2 = "Me.Au";
          filtroMarca.push(marca_2);
        } else if (marcaCheck[i].value === "5") {
          var marca_3 = "Nutrilus";
          filtroMarca.push(marca_3);
        } else if (marcaCheck[i].value === "4") {
          var marca_4 = "Magnus";
          filtroMarca.push(marca_4);
        } else if (marcaCheck[i].value === "3") {
          var marca_5 = "True";
          filtroMarca.push(marca_5);
        } else if (marcaCheck[i].value === "2") {
          var marca_6 = "LCM";
          filtroMarca.push(marca_6);
        } else if (marcaCheck[i].value === "1") {
          var marca_7 = "Snacks";
          filtroMarca.push(marca_7);
        } else if (marcaCheck[i].value === "Cachorro") {
          var tipoPet_1 = "Cachorro";
          filtroPet.push(tipoPet_1);
        } else if (marcaCheck[i].value === "Gato") {
          var tipoPet_2= "Gato";
          filtroPet.push(tipoPet_2);
        } else if (marcaCheck[i].value === "Outros") {
          var tipoPet_3 = "Outros";
          filtroPet.push(tipoPet_3);
        }
      }
      console.log('Esse é o filtro marca', filtroMarca);
      console.log('Esse é o filtro Pet', filtroPet);
      filtoPesquisa(filtroMarca, filtroPet);
    }
  };

  async function filtoPesquisa(filtroMarca, filtroTipoPet) {
    var novosProdutos = [];
    produtos.map((p) => {
      if (filtroMarca.length > 0) {
        console.log('Entrou filtro marca');
        filtroMarca.forEach((f) => {
          if (p.marca === f) {
            novosProdutos.push(p);
          }
        });
      }
      if (filtroTipoPet.length > 0) {
        console.log('Entrou filtro pet');
        filtroTipoPet.forEach((f) => {
          if (p.especie === f) {
            novosProdutos.push(p);
          }
        });
      }
      return true;
    });
    console.log('Novos produtos', novosProdutos);
    if (novosProdutos.length > 0) {
      setProdutos(novosProdutos);
    } else {
      setProdutos(produtosBase)
    }
  }

  // async function pegarImagem(id) {
  //   console.log("entrou aqui", id);
  //   let foto = await api.get(`/produtos/foto/${id}`);
  //   console.log("entrou aqui 2", foto);
  //   return foto;
  // }

  const servicos = ["Saúde", "Banho e Tosa"];

  return (
    <>
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
          {/* CheckBox Pet */}
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="Cachorro"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Cachorro</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="Gato"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Gato</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="Outros"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Outros</label>
          </div>
          <h3>Tipo Produtos</h3>
          <hr />
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="7"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Ração</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="7"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Petiscos</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="7"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Acessórios</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="7"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Roupas</label>
          </div>
          <div className="checkBox">
            <input
              type="checkbox"
              name="marcaCheck"
              value="7"
              onClick={filtroMarca}
            />
            <label for="marcaCheck">Brinquedos</label>
          </div>
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
          {produtosFiltados.map((produto, key) => (
            <CardProdutos key={key} produto={produto} />
          ))}
        </div>
      </div>
    </>
  );
}

export default Produtos;
