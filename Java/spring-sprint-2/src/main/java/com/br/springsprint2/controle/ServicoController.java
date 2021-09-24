package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Servico;
import com.br.springsprint2.repositorio.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servico")
public class ServicoController {
    @Autowired
    private ServicoRepository repository;

    @PostMapping
    public String createServico(@RequestBody Servico novoServico) {
        repository.save(novoServico);
        return "Serviço cadastrado";
    }

    @GetMapping
    public List<Servico> getServico() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Servico getServico(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteServico(@PathVariable int id) {
        repository.deleteById(id);
        return "Petshop excluido";
    }
}
