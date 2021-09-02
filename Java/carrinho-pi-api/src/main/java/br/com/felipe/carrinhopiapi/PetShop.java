package br.com.felipe.carrinhopiapi;

import java.util.ArrayList;
import java.util.List;

public class PetShop {
    private Integer id;
    private String nome;
    private String cnpj;
    private String endereço;
    private String cep;
    private boolean delivery;
    private Boolean plano;
    List<Produtos> listaProdutos;
    List<Servicos> listaServicos;

    public PetShop(Integer id, String nome, String cnpj, String endereço, String cep, boolean delivery) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereço = endereço;
        this.cep = cep;
        this.delivery = delivery;
        listaProdutos = new ArrayList<Produtos>();
        listaServicos = new ArrayList<Servicos>();

    }

    public void adicionarProduto(Produtos p) {
        listaProdutos.add(p);
    }

    public void exibeTodosProdutos() {
        for(Produtos p : listaProdutos) {
            System.out.println(p);
        }
    }

    public void adicionarServico(Servicos s) {
        listaServicos.add(s);
    }


    public void exibeTodosServiccos() {
        for(Servicos s : listaServicos) {
            System.out.println(s);
        }
    }

    public List<Produtos> getListaProdutos() {
        return listaProdutos;
    }

    public List<Servicos> getListaServicos() {
        return listaServicos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getPlano() {
        return plano;
    }

    public void setPlano(Boolean plano) {
        this.plano = plano;
    }

    public void setListaProdutos(List<Produtos> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void setListaServicos(List<Servicos> listaServicos) {
        this.listaServicos = listaServicos;
    }

    @Override
    public String toString() {
        return "PetShop{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereço='" + endereço + '\'' +
                ", cep='" + cep + '\'' +
                ", delivery=" + delivery +
                ", plano=" + plano +
                '}';
    }
}
