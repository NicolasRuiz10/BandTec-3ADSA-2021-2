package br.com.felipe.carrinhopiapi;

public class Servicos {
    private String tipoServico;
    private String Descricao;
    private Double preco;

        public Servicos(String tipoServico, String descricao, Double preco) {
        this.tipoServico = tipoServico;
        Descricao = descricao;
        this.preco = preco;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public String getDescricao() {
        return Descricao;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Servicos{" +
                "tipoServico='" + tipoServico + '\'' +
                ", Descricao='" + Descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
