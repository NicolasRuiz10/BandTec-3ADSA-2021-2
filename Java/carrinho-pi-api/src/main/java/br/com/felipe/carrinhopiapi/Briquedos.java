package br.com.felipe.carrinhopiapi;

public class Briquedos extends Produtos{
    private String tipoBrinquedo;

    public Briquedos(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoBrinquedo, Integer quantidade) {
        super(codigo, descricao, valor, marca, tipoPet, quantidade);
        this.tipoBrinquedo = tipoBrinquedo;
    }

    @Override
    public String toString() {
        return super.toString()+", tipoProduto: Briquedos, tipoBrinquedo: " + tipoBrinquedo;
    }

    @Override
    public void adicionarProduto(Integer qtd) {
        setQuantidade(getQuantidade() + qtd);
    }

    @Override
    public void excluirProduto(Integer qtd) {
        setQuantidade(getQuantidade() - qtd);
    }
}
