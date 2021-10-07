package com.br.springsprint2.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private LocalDate dataNascimento;
    private String endereco;
    private String cep;
    private int numero;
    private Boolean autenticacao = false;


    @JsonIgnore
    @OneToMany(mappedBy = "fkUsuario")
    private List<Pedido> pedidos = new ArrayList<>();

    public Boolean autenticar(String login, String senha) {
        if (login.equals(this.email) && senha.equals(this.senha)) {
            return true;
        }
        return false;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Boolean getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Boolean autenticacao) {
        this.autenticacao = autenticacao;
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