package com.br.springsprint2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private LocalDate dataNascimento;
    private String endereço;
    private String cep;
    private int numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
//{
//"nome": "Felipe Olegario",
//"email": "felipe.olegario@linx3.com",
//"telefone": "11963353621",
//"cpf": "48963818829",
//"senha": "laurinha",
//"dataNascimento": "2021-07-07",
//"endereco": "Rua mario ancona",
//"cep": "05572100",
//"numero": 130
//}