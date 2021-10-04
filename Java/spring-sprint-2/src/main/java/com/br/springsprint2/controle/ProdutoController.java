package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.dominio.Produto;
import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private PetshopRepository petRepository;

    @PostMapping("{fkPetshop}")
    public ResponseEntity createProdutos(@RequestBody Produto novoProduto, @PathVariable int fkPetshop) {
        Petshop petshop = petRepository.findById(fkPetshop).get();
        novoProduto.setFkPetShop(petshop);
        repository.save(novoProduto);
        return status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity getProdutos() {
        List<Produto> lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPetshop(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProdutos(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
