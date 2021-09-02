package br.com.felipe.carrinhopiapi;

public class Briquedos extends Produtos{
    private String tipoBrinquedo;

    public Briquedos(int codigo, String descricao, Double valor, String marca, String tipoPet, String tipoBrinquedo) {
        super(codigo, descricao, valor, marca, tipoPet);
        this.tipoBrinquedo = tipoBrinquedo;
    }

    @Override
    public String toString() {
        return "Briquedos{" +
                "tipoBrinquedo='" + tipoBrinquedo + '\'' +
                "} " + super.toString();
    }
}
