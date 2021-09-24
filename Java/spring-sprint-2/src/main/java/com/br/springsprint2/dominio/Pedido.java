package com.br.springsprint2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue
    private int id;
    private int fkIntensPedidos;
    private int fkUsuario;

    public int getFkIntensPedidos() {
        return fkIntensPedidos;
    }

    public void setFkIntensPedidos(int fkIntensPedidos) {
        this.fkIntensPedidos = fkIntensPedidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
}
