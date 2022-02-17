import React, { useEffect, useState } from "react";
import "./Produtos.css";
import { Menu } from "../../components/menu/Menu";
import Input from "../../components/input/Input";
import { CardProdutos } from "../../components/CardProdutos/CardProdutos";
import Toast from "../../components/toast/Toast";
import axios from "axios";
import ContentLoader from "react-content-loader";

export function Produtos(props) {
    const [produtos, setProdutos] = useState([]);
    const [showToast, setShowToast] = useState(false);
    const [busca, setBusca] = useState("");
    const [produtosBase, setProdutosBase] = useState("");
    const [petshopProduto, setPetshopProduto] = useState("");

    function setValueToast(value) {
        setShowToast(value);
    }

    useEffect(() => {
        axios.get("http://localhost:8080/produtos").then((res) => {
            setProdutos(res.data);
            setProdutosBase(res.data);
        });
    }, [])

    const buscaLowerCase = busca.toLowerCase()
    const produtosFiltrados = produtos
        .filter((produto) => produto.nome.toLowerCase().includes(buscaLowerCase))

    function filtroMarca() {
        const filtroMarca = [];
        const filtroPet = [];
        const filtroProduto = [];
        const filtroPetShop = [];
        var marcaCheck = document.getElementsByName("marcaCheck");
        for (var i = 0; i < marcaCheck.length; i++) {
            if (marcaCheck[i].checked) {
                if (marcaCheck[i].value === "9") {
                    var lojapet2 = 2;
                    setPetshopProduto(2);
                    filtroPetShop.push(lojapet2);
                }
                if (marcaCheck[i].value === "8") {
                    var lojapet1 = 1;
                    setPetshopProduto(1);
                    filtroPetShop.push(lojapet1);
                }
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
                    var tipoPet_2 = "Gato";
                    filtroPet.push(tipoPet_2);
                } else if (marcaCheck[i].value === "Outros") {
                    var tipoPet_3 = "Outros";
                    filtroPet.push(tipoPet_3);
                } else if (marcaCheck[i].value === "Ração") {
                    var tipoProduto_1 = "Ração";
                    filtroProduto.push(tipoProduto_1);
                } else if (marcaCheck[i].value === "Ração") {
                    var tipoProduto_2 = "Pestiscos";
                    filtroProduto.push(tipoProduto_2);
                } else if (marcaCheck[i].value === "Acessório") {
                    var tipoProduto_3 = "Acessório";
                    filtroProduto.push(tipoProduto_3);
                } else if (marcaCheck[i].value === "Roupas") {
                    var tipoProduto_4 = "Roupas";
                    filtroProduto.push(tipoProduto_4);
                } else if (marcaCheck[i].value === "Brinquedos") {
                    var tipoProduto_5 = "Brinquedos";
                    filtroProduto.push(tipoProduto_5);
                }
            }
            filtoPesquisa(filtroMarca, filtroPet, filtroProduto, filtroPetShop);
        }
    };

    async function filtoPesquisa(filtroMarca, filtroTipoPet, filtroProduto, filtroPetShop) {
        var novosProdutos = [];
        produtos.map((p) => {
            if (filtroMarca.length > 0) {
                filtroMarca.forEach((f) => {
                    if (p.marca === f) {
                        novosProdutos.push(p);
                    }
                });
            }
            if (filtroTipoPet.length > 0) {
                filtroTipoPet.forEach((f) => {
                    if (p.especie === f) {
                        novosProdutos.push(p);
                    }
                });
            }
            if (filtroPetShop.length > 0) {
                filtroPetShop.forEach((f) => {
                    if (p.idPet === f) {
                        novosProdutos.push(p);
                    }
                });
            }
            if (filtroProduto.length > 0) {
                filtroProduto.forEach((f) => {
                    if (p.tipoProduto === f) {
                        novosProdutos.push(p);
                    }
                });
            }
            return true;
        });
        if (novosProdutos.length > 0) {
            setProdutos(novosProdutos);
        } else {
            setProdutos(produtosBase)
        }
    }
    return (
        <>
            <Toast text="Login ou senha incorretos" color="green" showToast={showToast} changeValueToast={setValueToast} />
            <Menu menuItem1="PetShop" menuItem2="Produtos" menuItem3="Serviços" />
            <section className="section-produtos-intro">
                <h2>Produtos</h2>
                <hr />
            </section>

            <section className="card-empresas">
                <div className="filtro--produtos">
                    <h3>Filtrar Produtos</h3>
                    <hr />
                    <Input
                        enviarDados={setBusca}
                        value={busca}
                        placeholder="Pesquisar produto.."
                    />
                </div>

                <div className="card-empresas-info">
                    <div className="logo-empresa">
                        <img src="https://isinaliza.vteximg.com.br/arquivos/ids/173981-1000-1000/1943-placa-atencao-area-de-teste-pvc-semi-rigido-26x18cm-fixacao-1.jpg?v=636848934015200000" alt="" srcset="" />
                    </div>
                    <div className="detalhes-empresa">
                        <h3>Teste</h3>
                        <p>R$ 3,00 <span>Taxa de entrega</span></p>
                        <p>40 min <span>Entrega</span></p>
                    </div>
                    <div className="button-empresa">
                        <a>Ver produtos</a>
                    </div>

                </div>
            </section>
        </>
    );
}

export default Produtos;
