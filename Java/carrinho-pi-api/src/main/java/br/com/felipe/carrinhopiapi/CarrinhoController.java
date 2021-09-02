package br.com.felipe.carrinhopiapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class CarrinhoController {

    PetShop petshop1 = new PetShop(1, "Cobasi", "1234567891021", "Rua mario ancona, 130", "05572100", true);

    @GetMapping("/servicos")
    public List<Servicos> listServiços() {

        Servicos banho = new Servicos("Banho e tosa", "Banho e tosa de pets", 50.0);

        petshop1.adicionarServico(banho);

        return petshop1.getListaServicos();
    }

    @GetMapping("/produtos")
    public List<Produtos> listProdutos() {

        Racao racao1 = new Racao(2, "Preparada com nobres ingredientes, a Ração Golden Special é o alimento ideal para manter o seu cão saudável.", 199.99, "Golden", "Cachorro", "Cães Adultos Frango e Carne");

        Petiscos petisco1 = new Petiscos(3, "Bifinho com sabor e aroma especial, feitos com ingredientes nobres.", 3.50, "Joy", "Cachorro", "Petisco Bifinho Joy Beef Carne");

        return petshop1.getListaProdutos();
    }

    @GetMapping("/petshop")
    public PetShop listPetshop() {
        return petshop1;
    }

    @PostMapping("adicionar/produto")
    public String adicionarProduto(@RequestBody Racao novaRacao) {
        novaRacao.setCodigo(ThreadLocalRandom.current().nextInt(0,100));
        petshop1.adicionarProduto(novaRacao);
        return "Produto cadastrado com sucesso!";
    }

    @PostMapping("adicionar/servico")
    public String adicionarServiço(@RequestBody Servicos novoServico) {
        petshop1.adicionarServico(novoServico);
        return "Serviço cadastrado com sucesso!";
    }
}
