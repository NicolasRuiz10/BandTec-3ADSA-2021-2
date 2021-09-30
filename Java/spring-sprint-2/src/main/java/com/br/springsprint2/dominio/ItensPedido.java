package com.br.springsprint2.dominio;

import javax.persistence.*;

@Entity
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIntesPedido;

    @ManyToOne
    private Produto fkProduto;

    @ManyToOne
    private Servico fkServico;

    public Produto getFkProdutos() {
        return fkProduto;
    }

    public void setFkProdutos(Produto fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getIdIntesPedido() {
        return idIntesPedido;
    }

    public void setIdIntesPedido(int idIntesPedido) {
        this.idIntesPedido = idIntesPedido;
    }

    public Produto getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Produto fkProduto) {
        this.fkProduto = fkProduto;
    }

    public Servico getFkServico() {
        return fkServico;
    }

    public void setFkServico(Servico fkServico) {
        this.fkServico = fkServico;
    }
}

//{
//"fkProduto": 1,
//"fkServico": 2
//}
