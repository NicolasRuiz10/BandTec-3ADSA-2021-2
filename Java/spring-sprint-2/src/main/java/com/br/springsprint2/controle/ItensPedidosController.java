package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.ItensPedido;
import com.br.springsprint2.repositorio.ItensPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itens")
public class ItensPedidosController {
    @Autowired
    private ItensPedidosRepository repository;

    @PostMapping
    public String createItens(@RequestBody ItensPedido novoItem) {
        repository.save(novoItem);
        return "Item cadastrado";
    }

    @GetMapping
    public List<ItensPedido> getItens() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ItensPedido getItem(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
        repository.deleteById(id);
        return "Petshop excluido";
    }
}
