package br.com.felipe.carrinhopiapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class PetShopController {

    PetShop petshop1 = new PetShop(1, "Cobasi", "1234567891021", "Rua mario ancona, 130", "05572100", true);


    @GetMapping("/servicos")
    public List<Servicos> listServiços() {
        return petshop1.getListaServicos();
    }

    @GetMapping("/produtos")
    public List<Produtos> listProdutos() {
    Racao racao1 = new Racao(2, "dsdaas", 4.50, "dadsa", "dsadsa", "Qualquer", 12);

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
    public String adicionarServico(@RequestBody Servicos novoServico) {
        petshop1.adicionarServico(novoServico);
        return "Serviço cadastrado com sucesso!";
    }
}
