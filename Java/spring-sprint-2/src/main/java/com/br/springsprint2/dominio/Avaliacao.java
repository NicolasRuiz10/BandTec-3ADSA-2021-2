package com.br.springsprint2.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAvaliacao;

    private LocalDate data = LocalDate.now();

    private int notaPetshop;

    private int notaUsuario;

    @ManyToOne
    @JoinColumn(name = "fkUsuario")
    private Usuario fkUsuario;

    @ManyToOne
    private Petshop fkPetShop;

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNotaPetshop() {
        return notaPetshop;
    }

    public void setNotaPetshop(int notaPetshop) {
        this.notaPetshop = notaPetshop;
    }

    public int getNotaUsuario() {
        return notaUsuario;
    }

    public void setNotaUsuario(int notaUsuario) {
        this.notaUsuario = notaUsuario;
    }

    public Usuario getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuario fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Petshop getFkPetShop() {
        return fkPetShop;
    }

    public void setFkPetShop(Petshop fkPetShop) {
        this.fkPetShop = fkPetShop;
    }
}

//{
//"notaPetshop": 4,
//"notaUsuario": 2,
//"fkUsuario": 1,
//"fkPetshop": 1
//}
