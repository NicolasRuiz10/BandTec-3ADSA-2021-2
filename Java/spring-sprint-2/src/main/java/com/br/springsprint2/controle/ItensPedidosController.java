package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.*;
import com.br.springsprint2.repositorio.ItensPedidosRepository;
import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.ProdutoRepository;
import com.br.springsprint2.repositorio.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("itens")
public class ItensPedidosController {
    @Autowired
    private ItensPedidosRepository repository;

    @Autowired
    private ProdutoRepository prodRepository;

    @Autowired
    private ServicoRepository servRepository;

    @CrossOrigin
    @PostMapping("/{fkServico}/{fkProduto}")
    public ResponseEntity createItens(@RequestBody ItensPedido novoItem, @PathVariable int fkProduto, @PathVariable int fkServico) {
        Produto produto = prodRepository.findById(fkProduto).get();
        novoItem.setFkProduto(produto);
        Servico servico = servRepository.findById(fkServico).get();
        novoItem.setFkServico(servico);
        repository.save(novoItem);
        return status(HttpStatus.CREATED).build();
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity getItens() {
        List<ItensPedido> lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);

    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getItem(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity putItens(@PathVariable int id,
                                       @RequestBody ItensPedido itensAtualizado) {
        if (repository.existsById(id)) {
            itensAtualizado.setIdIntesPedido(id);
            repository.save(itensAtualizado);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
