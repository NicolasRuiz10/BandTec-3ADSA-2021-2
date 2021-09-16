package br.com.felipe.carrinhopiapi;

public class Roupas extends Produtos {
    private String tipoRoupa;

    public Roupas(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoRoupa, Integer quantidade) {
        super(codigo, descricao, valor, marca, tipoPet, quantidade);
        this.tipoRoupa = tipoRoupa;
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
        return "Roupas{" +
                "tipoRoupa='" + tipoRoupa + '\'' +
                "} " + super.toString();
    }
}
