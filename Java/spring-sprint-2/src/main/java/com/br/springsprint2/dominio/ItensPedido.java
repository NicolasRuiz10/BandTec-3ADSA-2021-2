package com.br.springsprint2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItensPedido {
    @Id
    @GeneratedValue
    private int id;
    private int fkProduto;
    private int fkServico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getFkServico() {
        return fkServico;
    }

    public void setFkServico(int fkServico) {
        this.fkServico = fkServico;
    }
}

//{
//"fkProduto": 1,
//"fkServico": 2
//}
