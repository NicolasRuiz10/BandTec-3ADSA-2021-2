package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Usuario;
import com.br.springsprint2.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @CrossOrigin
    @PostMapping
    public ResponseEntity createUsuario(@RequestBody Usuario novoUsuario) {
        repository.save(novoUsuario);
        return status(HttpStatus.CREATED).build();
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity getUsuarios() {
        List<Usuario> lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getUsuario(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
