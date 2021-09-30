package com.br.springsprint2.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;

    private String nome;

    private String descricao;

    private Double valor;

    private String marca;

    private String especie;

    private int quantidade;

    @ManyToOne
    private Petshop fkPetShop;

    @OneToMany(mappedBy = "fkProduto")
    private List<ItensPedido> itens = new ArrayList<>();

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Petshop getFkPetShop() {
        return fkPetShop;
    }

    public void setFkPetShop(Petshop fkPetShop) {
        this.fkPetShop = fkPetShop;
    }

    public List<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
    }
}

//{
//"nome": "Ração Seca PremieR Pet Golden Special Cães Adultos Frango e Carne",
//"descricao": "A Ração Seca PremieR Pet Golden Special Cães Adultos Frango",
//"valor": 152.91,
//"marca": "Golden, Premier",
//"especie": "Cachorro",
//"quantidade": 30,
//"idPetshop": 1
//}
