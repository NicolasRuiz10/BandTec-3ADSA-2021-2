package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.dominio.Servico;
import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("servico")
public class ServicoController {
    @Autowired
    private ServicoRepository repository;

    @Autowired
    private PetshopRepository petRepository;

    @PostMapping("{fkPetshop}")
    public ResponseEntity createServico(@RequestBody Servico novoServico, @PathVariable int fkPetshop) {
        Petshop petshop = petRepository.findById(fkPetshop).get();
        novoServico.setFkPetShop(petshop);
        repository.save(novoServico);
        return status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity getServico() {
        List<Servico> lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity getServico(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteServico(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
