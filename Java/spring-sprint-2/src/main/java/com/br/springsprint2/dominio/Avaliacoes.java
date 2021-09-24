package com.br.springsprint2.dominio;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Avaliacoes {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate data = LocalDate.now();
    private int notaPetshop;
    private int notaUsuario;
    private int fkUsuario;
    private int fkPetshop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkPetshop() {
        return fkPetshop;
    }

    public void setFkPetshop(int fkPetshop) {
        this.fkPetshop = fkPetshop;
    }
}

//{
//"notaPetshop": 4,
//"notaUsuario": 2,
//"fkUsuario": 1,
//"fkPetshop": 1
//}
