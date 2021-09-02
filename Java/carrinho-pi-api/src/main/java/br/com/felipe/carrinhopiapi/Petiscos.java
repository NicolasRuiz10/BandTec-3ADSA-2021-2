package br.com.felipe.carrinhopiapi;

public class Petiscos extends Produtos{
    private String tipoPetisco;

    public Petiscos(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoPetisco) {
        super(codigo, descricao, valor, marca, tipoPet);
        this.tipoPetisco = tipoPetisco;
    }

    @Override
    public String toString() {
        return "Petiscos{" +
                "tipoPetisco='" + tipoPetisco + '\'' +
                "} " + super.toString();
    }
}
