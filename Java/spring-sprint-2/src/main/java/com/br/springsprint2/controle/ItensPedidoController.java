package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.ItensPedido;
import com.br.springsprint2.dominio.Pedido;
import com.br.springsprint2.dominio.Produto;
import com.br.springsprint2.repositorio.ItensPedidoRepository;
import com.br.springsprint2.repositorio.PedidoRepository;
import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens")
public class ItensPedidoController {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PetshopRepository petshopRepository;

    @GetMapping
    public ResponseEntity getAllItensPedido() {
        List<ItensPedido> listaItensPedido = itensPedidoRepository.findAll();
        if (listaItensPedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaItensPedido);
    }

    @PostMapping("/{idProduto}")
    public ResponseEntity postItensPedido(@PathVariable Integer idProduto,@RequestBody ItensPedido itensPedido) {
        ItensPedido itensPedido1 = itensPedidoRepository.findOneById(itensPedido.getId());
        if (itensPedido == null) {
            Produto produto = produtoRepository.getById(idProduto);
            itensPedido.setFkProduto(produto);
            return ResponseEntity.status(201).body(itensPedidoRepository.save(itensPedido));
        }
        return ResponseEntity.ok(itensPedido);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity putItensPedido(
            @PathVariable Integer idItens,
            @PathVariable Integer idProduto,
            @RequestBody ItensPedido itensPedido
    ) {
        if (itensPedidoRepository.existsById(idItens)) {
            itensPedido.setId(idItens);
            Produto produto = produtoRepository.getById(idProduto);
            itensPedido.setFkProduto(produto);
            return ResponseEntity.ok(itensPedidoRepository.save(itensPedido));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteItensPedido(@PathVariable Integer id) {
        if (itensPedidoRepository.existsById(id)) {
            itensPedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pedido/id/{id}")
    public ResponseEntity getAllItensProdutoByPedidoId(@PathVariable Integer id) {
        if (pedidoRepository.existsById(id)) {
            List<ItensPedido> listaItensPedido = itensPedidoRepository.findAllByPedidoIdPedido(id);
            if (listaItensPedido.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(listaItensPedido);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pedido/petshop/{id}")
    public ResponseEntity getAllItensProdutoByPetshopId(@PathVariable Integer idPetshop) {
        if (petshopRepository.existsById(idPetshop)) {
            List<ItensPedido> listaItensPedido = itensPedidoRepository.findAllByPetshopIdPetshop(idPetshop);
            if (listaItensPedido.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(listaItensPedido);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pedido/numero/{numero}")
    public ResponseEntity getAllItensPedidoByPedidoId(@PathVariable Integer id) {
        if (pedidoRepository.existsById(id)) {
            List<ItensPedido> listaItensPedido = itensPedidoRepository.findAllByPedidoIdPedido(id);
            if (listaItensPedido.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(listaItensPedido);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/pedido/id/{idPedido}/{idProduto}")
    public ResponseEntity postItensPedidoByPedidoId(
            @PathVariable Integer idPedido,
            @PathVariable Integer idProduto,
            @RequestBody ItensPedido itensPedido
    ) {
        Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
        Optional<Produto> produtos = produtoRepository.findById(idProduto);
        if (pedido.isPresent()) {
            itensPedido.setPedido(pedido.get());
            itensPedido.setFkProduto(produtos.get());
            itensPedidoRepository.save(itensPedido);
            return ResponseEntity.status(201).body(itensPedido);
        }
        return ResponseEntity.notFound().build();
    }
}
