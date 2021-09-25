package br.com.felipe.carrinhopiapi;

public class Acessorios extends Produtos {
    private String tipoAcessorio;

    public Acessorios(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoAcessorio, Integer quantidade) {
        super(codigo, descricao, valor, marca, tipoPet, quantidade);
        this.tipoAcessorio = tipoAcessorio;
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
        return super.toString()+", tipoProduto: Acessorios, tipoAcessorio: " + tipoAcessorio;
    }
}
