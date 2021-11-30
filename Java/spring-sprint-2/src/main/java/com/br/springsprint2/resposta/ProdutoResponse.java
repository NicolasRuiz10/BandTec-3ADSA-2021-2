package com.br.springsprint2.resposta;

public class ProdutoResponse {
    private int idProduto;
    private String nome;
    private String descricao;
    private Double valor;
    private String marca;
    private String especie;
    private String tipoProduto;
    private int quantidade;
    private int fkPetShop;

    public ProdutoResponse(int idProduto, String nome, String descricao, Double valor, String marca, String especie, String tipoProduto, int quantidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.marca = marca;
        this.especie = especie;
        this.tipoProduto = tipoProduto;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getFkPetShop() {
        return fkPetShop;
    }

    public void setFkPetShop(int fkPetShop) {
        this.fkPetShop = fkPetShop;
    }
}
