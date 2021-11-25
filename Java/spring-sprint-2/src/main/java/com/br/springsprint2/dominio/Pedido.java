package com.br.springsprint2.dominio;

import javax.persistence.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;


    @ManyToOne
    @JoinColumn(name = "fkUsuario")
    private UsuarioLogar fkUsuario;

    @ManyToOne
    @JoinColumn(name = "fkProduto")
    private Produto fkProduto;


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
