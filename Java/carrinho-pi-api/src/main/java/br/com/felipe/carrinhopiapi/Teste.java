package br.com.felipe.carrinhopiapi;

public class Teste {
    public static void main(String[] args) {
        PetShop petshop1 = new PetShop(1, "Cobasi", "1234567891021", "Rua mario ancona, 130", "05572100", true);

        Servicos banho = new Servicos("Banho e tosa", "Banho e tosa de pets", 50.0);

        Racao racao1 = new Racao(2, "Preparada com nobres ingredientes, a Ração Golden Special é o alimento ideal para manter o seu cão saudável.", 199.99, "Golden", "Cachorro", "Cães Adultos Frango e Carne");

        Petiscos petisco1 = new Petiscos(3, "Bifinho com sabor e aroma especial, feitos com ingredientes nobres.", 3.50, "Joy", "Cachorro", "Petisco Bifinho Joy Beef Carne");

        petshop1.adicionarProduto(racao1);
        petshop1.adicionarProduto(petisco1);
        petshop1.adicionarServico(banho);

        petshop1.exibeTodosProdutos();
        petshop1.exibeTodosServiccos();
    }
}
