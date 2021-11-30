package com.br.springsprint2.dominio;

import javax.persistence.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    private String pagamento;

    private Double valorTotal;

    private Double troco;

    @ManyToOne
    @JoinColumn(name = "fkUsuario")
    private UsuarioLogar fkUsuario;

    @ManyToOne
    @JoinColumn(name = "fkProduto")
    private Produto fkProduto;


    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public Produto getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Produto fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public UsuarioLogar getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(UsuarioLogar fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
}
