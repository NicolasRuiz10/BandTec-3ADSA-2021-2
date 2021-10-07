package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Avaliacao;
import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.dominio.Usuario;
import com.br.springsprint2.repositorio.AvaliacaoRepository;
import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoRepository repository;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PetshopRepository petRepository;

    @CrossOrigin
    @PostMapping("{fkUsuario}/{fkPetShop}")
    public ResponseEntity createPetshop(@RequestBody Avaliacao novaAvaliacao, @PathVariable int fkUsuario, @PathVariable int fkPetShop) {
        Usuario usuario = userRepository.findById(fkUsuario).get();
        novaAvaliacao.setFkUsuario(usuario);
        Petshop petshop = petRepository.findById(fkPetShop).get();
        novaAvaliacao.setFkPetShop(petshop);
        repository.save(novaAvaliacao);
        return status(HttpStatus.CREATED).build();
    }
    @CrossOrigin
    @GetMapping
    public ResponseEntity getAvaliacoes() {
        List<Avaliacao> lista = repository.findAll();
        return lista.isEmpty() ? noContent().build() : ResponseEntity.ok().body(lista);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getAvaliacao(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAvaliacao(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity putAvaliacao(@PathVariable int id,
                                   @RequestBody Avaliacao avaliacaoAtualizado) {
        if (repository.existsById(id)) {
            avaliacaoAtualizado.setIdAvaliacao(id);
            repository.save(avaliacaoAtualizado);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
