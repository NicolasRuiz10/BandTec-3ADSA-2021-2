package br.com.felipe.carrinhopiapi;

public class Petiscos extends Produtos{
    private String tipoPetisco;

    public Petiscos(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoPetisco, Integer quantidade) {
        super(codigo, descricao, valor, marca, tipoPet, quantidade);
        this.tipoPetisco = tipoPetisco;
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
        return "Petiscos{" +
                "tipoPetisco='" + tipoPetisco + '\'' +
                "} " + super.toString();
    }
}
