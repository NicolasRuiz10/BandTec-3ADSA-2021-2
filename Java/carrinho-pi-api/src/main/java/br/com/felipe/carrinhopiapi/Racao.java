package br.com.felipe.carrinhopiapi;

public class Racao extends Produtos {
    private String tipoRacao;

    public Racao(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoRacao, Integer quantidade) {
        super(codigo, descricao, valor, marca, tipoPet, quantidade);
        this.tipoRacao = tipoRacao;
    }

    public String getTipoRacao() {
        return tipoRacao;
    }

    public void setTipoRacao(String tipoRacao) {
        this.tipoRacao = tipoRacao;
    }

    @Override
    public void adicionarProduto(Integer qtd) {
        setQuantidade(getQuantidade() + qtd);
    }

    @Override
    public void excluirProduto(Integer qtd) {
        setQuantidade(getQuantidade() - qtd);
    }

    @Override
    public String toString() {
        return "Racao{" +
                "tipoRacao='" + tipoRacao + '\'' +
                "} " + super.toString();
    }
}
