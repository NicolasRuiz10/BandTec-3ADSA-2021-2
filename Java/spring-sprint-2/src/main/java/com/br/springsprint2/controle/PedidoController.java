package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Pedido;
import com.br.springsprint2.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public String createPedido(@RequestBody Pedido novoPedido) {
        repository.save(novoPedido);
        return "Petshop cadastrado";
    }

    @GetMapping
    public List<Pedido> getPedidos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable int id) {
        repository.deleteById(id);
        return "Petshop excluido";
    }
}
