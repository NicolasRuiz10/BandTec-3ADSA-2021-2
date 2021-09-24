package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Produtos;
import com.br.springsprint2.repositorio.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosRepository prodRepository;

    @PostMapping
    public String createProdutos(@RequestBody Produtos novoProduto) {
        prodRepository.save(novoProduto);
        return "Petshop cadastrado";
    }

    @GetMapping
    public List<Produtos> getProdutos() {
        return prodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produtos getPetshop(@PathVariable int id) {
        return prodRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteProdutos(@PathVariable int id) {
        prodRepository.deleteById(id);
        return "Petshop excluido";
    }
}
