package com.br.springsprint2.dominio;

import javax.persistence.*;

@Entity
public class ItensPedido {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private Integer qtdProduto;


    @ManyToOne
    @JoinColumn(name = "fkProduto")
    private Produto fkProduto;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;


    public ItensPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Produto getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Produto fkProduto) {
        this.fkProduto = fkProduto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
