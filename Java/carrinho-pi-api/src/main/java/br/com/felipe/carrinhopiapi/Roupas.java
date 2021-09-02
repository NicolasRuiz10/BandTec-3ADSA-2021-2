package br.com.felipe.carrinhopiapi;

public class Roupas extends Produtos {
    private String tipoRoupa;

    public Roupas(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoRoupa) {
        super(codigo, descricao, valor, marca, tipoPet);
        this.tipoRoupa = tipoRoupa;
    }

    @Override
    public String toString() {
        return "Roupas{" +
                "tipoRoupa='" + tipoRoupa + '\'' +
                "} " + super.toString();
    }
}
