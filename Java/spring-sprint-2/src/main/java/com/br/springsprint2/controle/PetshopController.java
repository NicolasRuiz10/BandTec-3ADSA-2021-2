package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.repositorio.PetshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/ipet")
public class PetshopController {
    @Autowired
    private PetshopRepository repository;

    @PostMapping
    public ResponseEntity createPetshop(@RequestBody Petshop novoPetshop) {
        repository.save(novoPetshop);
        return status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity getPetshops() {
        List<Petshop> lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPetshop(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePetshop(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}

//{
//"nome": "Pets",
//"cnpj": "78457148000147",
//"endereco": "Av. Politecnica",
//"numero": "1400",
//"delivery": 1,
//"plano": 1,
//"veterinario": 0
//}