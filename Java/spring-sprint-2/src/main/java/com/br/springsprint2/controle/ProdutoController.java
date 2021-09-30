package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.dominio.Produto;
import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository prodRepository;

    @Autowired
    private PetshopRepository petRepository;

    @PostMapping("{fkPetshop}")
    public String createProdutos(@RequestBody Produto novoProduto, @PathVariable int fkPetshop) {
        Petshop petshop = petRepository.findById(fkPetshop).get();
        novoProduto.setFkPetShop(petshop);
        prodRepository.save(novoProduto);
        return "Produto cadastrado";
    }

    @GetMapping
    public List<Produto> getProdutos() {
        return prodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto getPetshop(@PathVariable int id) {
        return prodRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteProdutos(@PathVariable int id) {
        prodRepository.deleteById(id);
        return "Produto excluido";
    }
}
