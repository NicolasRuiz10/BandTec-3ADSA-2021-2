package br.com.felipe.carrinhopiapi;

public abstract  class Produtos implements Estoque{
    private int codigo;
    private String descricao;
    private Double valor;
    private String marca;
    private String tipoPet;
    private Integer quantidade;

    public Produtos(int codigo, String descricao, Double valor, String marca, String tipoPet, Integer quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.marca = marca;
        this.tipoPet = tipoPet;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(String tipoPet) {
        this.tipoPet = tipoPet;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto = " +
                "codigo: " + codigo +
                ", descricao: " + descricao +
                ", valor: " + valor +
                ", marca: " + marca +
                ", tipoPet: " + tipoPet;
    }
}
