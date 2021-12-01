package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Pedido;
import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.dominio.Produto;
import com.br.springsprint2.dominio.UsuarioLogar;
import com.br.springsprint2.repositorio.PedidoRepository;
import com.br.springsprint2.repositorio.ProdutoRepository;
import com.br.springsprint2.repositorio.UsuarioLogarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private UsuarioLogarRepository userRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @CrossOrigin
    @PostMapping("/{idProduto}/{idUsuario}")
    public ResponseEntity createPedido(@RequestBody Pedido novoPedido, @PathVariable int idProduto,@PathVariable int idUsuario) {

        Produto produto = produtoRepository.findById(idProduto).get();
        novoPedido.setFkProduto(produto);
        UsuarioLogar usuarioLogar = userRepository.findById(idUsuario).get();
        novoPedido.setFkUsuario(usuarioLogar);
        repository.save(novoPedido);
        return status(HttpStatus.CREATED).build();
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity getPedidos() {
        List<Pedido> lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getPedido(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deletePedido(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity putPedido(@PathVariable int id,
                                    @RequestBody Pedido pedidoAtualizado) {
        if (repository.existsById(id)) {
            pedidoAtualizado.setIdPedido(id);
            repository.save(pedidoAtualizado);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
