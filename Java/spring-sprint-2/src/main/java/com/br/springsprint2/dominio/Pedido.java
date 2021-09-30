package com.br.springsprint2.dominio;

import javax.persistence.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @ManyToOne
    @JoinColumn(name = "fkIntensPedidos")
    private ItensPedido fkIntensPedidos;

    @ManyToOne
    @JoinColumn(name = "fkUsuario")
    private Usuario fkUsuario;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public ItensPedido getFkIntensPedidos() {
        return fkIntensPedidos;
    }

    public void setFkIntensPedidos(ItensPedido fkIntensPedidos) {
        this.fkIntensPedidos = fkIntensPedidos;
    }

    public Usuario getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuario fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
}
