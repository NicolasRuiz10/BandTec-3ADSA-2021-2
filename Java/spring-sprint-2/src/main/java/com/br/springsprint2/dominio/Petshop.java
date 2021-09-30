package com.br.springsprint2.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
public class Petshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPetshop;

    private String nome;

    private String cnpj;

    private String endereco;

    private int numero;

    private int delivery;

    private int plano;

    private String veterinario;

    @OneToMany(mappedBy = "fkPetShop")
    private List<Produto> produtos;

    @OneToMany(mappedBy = "fkPetShop")
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = "fkPetShop")
    private List<Servico> servico;

    public int getIdPetshop() {
        return idPetshop;
    }

    public void setIdPetshop(int idPetshop) {
        this.idPetshop = idPetshop;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getPlano() {
        return plano;
    }

    public void setPlano(int plano) {
        this.plano = plano;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
    }
}
