package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Avaliacoes;
import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.repositorio.AvaliacoesRepository;
import com.br.springsprint2.repositorio.PetshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("avaliacoes")
public class AvaliacoesController {
    @Autowired
    private AvaliacoesRepository repository;

    @PostMapping
    public String createPetshop(@RequestBody Avaliacoes novaAvaliacao) {
        repository.save(novaAvaliacao);
        return "Avaliação cadastrada";
    }

    @GetMapping
    public List<Avaliacoes> getAvaliacoes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Avaliacoes getAvaliacao(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteAvaliacao(@PathVariable int id) {
        repository.deleteById(id);
        return "Avaliação excluida";
    }
}
