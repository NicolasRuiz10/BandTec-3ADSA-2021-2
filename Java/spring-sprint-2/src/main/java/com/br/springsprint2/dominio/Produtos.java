package com.br.springsprint2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produtos {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String descricao;
    private Double valor;
    private String marca;
    private String especie;
    private int quantidade;
    private int idPetshop;

    public int getIdPetshop() {
        return idPetshop;
    }

    public void setIdPetshop(int idPetshop) {
        this.idPetshop = idPetshop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

//{
//    "nome": "Ração Seca PremieR Pet Golden Special Cães Adultos Frango e Carne",
//    "descricao": "A Ração Seca PremieR Pet Golden Special Cães Adultos Frango",
//    "valor": 152.91,
//    "marca": "Golden, Premier",
//    "especie": "Cachorro",
//    "quantidade": 30,
//    "idPetshop": 1
//    }
