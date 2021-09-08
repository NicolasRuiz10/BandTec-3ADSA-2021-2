package br.com.felipe.c13adsafelipecruzolegario01202080;

import java.time.LocalDate;

public class Usuario {
    private String nome;
    private String senha;
    private String login;
    private boolean autenticacao;
    private LocalDate dataAutenticacao;

    public Usuario(String nome, String senha, String login, boolean autenticacao, LocalDate dataAutenticacao) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.autenticacao = autenticacao;
        this.dataAutenticacao = dataAutenticacao;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(boolean autenticacao) {
        this.autenticacao = autenticacao;
    }

    public LocalDate getDataAutenticacao() {
        return dataAutenticacao;
    }

    public void setDataAutenticacao(LocalDate dataAutenticacao) {
        this.dataAutenticacao = dataAutenticacao;
    }
}
