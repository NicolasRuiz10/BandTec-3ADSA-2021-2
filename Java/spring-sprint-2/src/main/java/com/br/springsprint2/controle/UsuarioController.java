package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Servico;
import com.br.springsprint2.dominio.Usuario;
import com.br.springsprint2.repositorio.ServicoRepository;
import com.br.springsprint2.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public String createUsuario(@RequestBody Usuario novoUsuario) {
        repository.save(novoUsuario);
        return "Usuario cadastrado";
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable int id) {
        repository.deleteById(id);
        return "Usuario excluido";
    }
}
