package com.br.springsprint2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Servico {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String descricao;
    private Double valor;
    private String tipoServico;
    private int idPetshop;

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

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public int getIdPetshop() {
        return idPetshop;
    }

    public void setIdPetshop(int idPetshop) {
        this.idPetshop = idPetshop;
    }
}
//{
//"nome": "Banho e Tosa",
//"descricao": "Banho e tosa de pets",
//"valor": 45.0,
//"tipoServico": "Higiene",
//"idPetshop": 1
//}