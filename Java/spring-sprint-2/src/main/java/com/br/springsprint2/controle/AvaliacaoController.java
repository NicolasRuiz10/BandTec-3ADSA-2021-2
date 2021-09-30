package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Avaliacao;
import com.br.springsprint2.repositorio.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoRepository repository;

    @PostMapping
    public String createPetshop(@RequestBody Avaliacao novaAvaliacao) {
        repository.save(novaAvaliacao);
        return "Avaliação cadastrada";
    }

    @GetMapping
    public List<Avaliacao> getAvaliacoes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Avaliacao getAvaliacao(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteAvaliacao(@PathVariable int id) {
        repository.deleteById(id);
        return "Avaliação excluida";
    }
}
