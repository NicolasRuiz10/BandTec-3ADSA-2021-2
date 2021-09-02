package br.com.felipe.carrinhopiapi;

public class Produtos {
    private int codigo;
    private String descricao;
    private Double valor;
    private String marca;
    private String tipoPet;

    public Produtos(int codigo, String descricao, Double valor, String marca, String tipoPet) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.marca = marca;
        this.tipoPet = tipoPet;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipoPet() {
        return tipoPet;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipoPet(String tipoPet) {
        this.tipoPet = tipoPet;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", marca='" + marca + '\'' +
                ", tipoPet='" + tipoPet + '\'' +
                '}';
    }
}
