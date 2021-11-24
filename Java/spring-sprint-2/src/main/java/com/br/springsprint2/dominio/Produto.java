package com.br.springsprint2.dominio;

import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.ProdutoRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
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
    private String tipoProduto;
    private int quantidade;





    public Produto(String nome, String descricao, Double valor, String marca, String especie, String tipoProduto, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.marca = marca;
        this.especie = especie;
        this.tipoProduto = tipoProduto;
        this.quantidade = quantidade;
    }

    public Produto() {
    }

    @JsonIgnore
    @Column(length = 20_000_000)
    private byte[] foto;

    @JsonIgnore
    @ManyToOne
    private Petshop fkPetShop;

    @JsonIgnore
    @OneToMany(mappedBy = "fkProduto")
    private List<ItensPedido> itens = new ArrayList<>();

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

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

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
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
