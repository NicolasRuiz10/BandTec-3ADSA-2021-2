package br.com.felipe.carrinhopiapi;

public class Acessorios extends Produtos {
    private String tipoAcessorio;

    public Acessorios(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoAcessorio) {
        super(codigo, descricao, valor, marca, tipoPet);
        this.tipoAcessorio = tipoAcessorio;
    }

    @Override
    public String toString() {
        return "Acessorios{" +
                "tipoAcessorio='" + tipoAcessorio + '\'' +
                "} " + super.toString();
    }
}
