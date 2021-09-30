package com.br.springsprint2.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServico;

    private String nome;

    private String descricao;

    private Double valor;

    private String tipoServico;

    @OneToMany(mappedBy = "fkServico")
    private List<ItensPedido> itens = new ArrayList<>();

    @ManyToOne
    private Petshop fkPetShop;

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
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

    public List<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
    }

    public Petshop getFkPetShop() {
        return fkPetShop;
    }

    public void setFkPetShop(Petshop fkPetShop) {
        this.fkPetShop = fkPetShop;
    }
}
//{
//"nome": "Banho e Tosa",
//"descricao": "Banho e tosa de pets",
//"valor": 45.0,
//"tipoServico": "Higiene",
//"idPetshop": 1
//}