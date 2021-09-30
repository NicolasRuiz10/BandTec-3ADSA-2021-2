package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.repositorio.PetshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ipet")
public class PetshopController {
    @Autowired
    private PetshopRepository petRepository;

    @PostMapping
    public String createPetshop(@RequestBody Petshop novoPetshop) {
        petRepository.save(novoPetshop);
        return "Petshop cadastrado";
    }

    @GetMapping
    public List<Petshop> getPetshops() {
        return petRepository.findAll();
    }

    @GetMapping("/{id}")
    public Petshop getPetshop(@PathVariable int id) {
        return petRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deletePetshop(@PathVariable int id) {
        petRepository.deleteById(id);
        return "Petshop excluido";
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