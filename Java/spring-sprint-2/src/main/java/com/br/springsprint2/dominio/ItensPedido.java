package com.br.springsprint2.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIntesPedido;

    @ManyToOne
    private Produto fkProduto;

    @ManyToOne
    private Servico fkServico;

    @JsonIgnore
    @OneToMany(mappedBy = "fkIntensPedidos")
    private List<Pedido> pedido = new ArrayList<>();

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

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
}

//{
//"fkProduto": 1,
//"fkServico": 2
//}
