package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.dominio.Produto;
import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.ProdutoRepository;
<<<<<<< HEAD
import com.br.springsprint2.util.ListObj;
=======
import com.br.springsprint2.util.ListaObj;
>>>>>>> 19cba0ce1329c842739a05876184ff1df32fd384
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
>>>>>>> 19cba0ce1329c842739a05876184ff1df32fd384

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

<<<<<<< HEAD
    public static void gravaLista(ListObj<Produto> lista, String nomeArq) {
=======
    public static void gravaLista(ListaObj<Produto> lista, String nomeArq) {
>>>>>>> 19cba0ce1329c842739a05876184ff1df32fd384

        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;

        nomeArq += ".csv";


        try {
            arq = new FileWriter(nomeArq, true);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }


        try {

            for (int i=0; i< lista.getTamanho(); i++) {
                Produto a = lista.getElemento(i);

                saida.format("%d;%s;%s;%.2f;%s;%s;%d\n",a.getIdProduto(),
                        a.getNome(),a.getDescricao(), a.getValor(), a.getMarca(), a.getEspecie(), a.getQuantidade());
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally {

            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }


<<<<<<< HEAD





=======
>>>>>>> 19cba0ce1329c842739a05876184ff1df32fd384
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private PetshopRepository petRepository;

<<<<<<< HEAD
    private ListObj<Produto> lista = new ListObj(1000);


=======
    private ListaObj listaObj = new ListaObj(1000);
>>>>>>> 19cba0ce1329c842739a05876184ff1df32fd384


    @CrossOrigin
    @PostMapping("{fkPetshop}")
    public ResponseEntity createProdutos(@RequestBody Produto novoProduto, @PathVariable int fkPetshop) {
        Petshop petshop = petRepository.findById(fkPetshop).get();
        novoProduto.setFkPetShop(petshop);
        repository.save(novoProduto);
<<<<<<< HEAD
        lista.adicionar(novoProduto);
=======
        listaObj.adicionar(novoProduto);
>>>>>>> 19cba0ce1329c842739a05876184ff1df32fd384
        return status(HttpStatus.CREATED).build();
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity getProdutos() {
        List<Produto> lista = repository.findAll();
        /*
        List listao = new ArrayList();
        for (int x = 0; x < listaObj.getTamanho(); x++) {
           listao.add(listaObj.getElemento(x));
        }*/

        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

<<<<<<< HEAD

    @GetMapping("/csv/{produtos}")
    public ResponseEntity getCSV(@PathVariable String produtos) {
       gravaLista(lista , produtos);
=======
    @GetMapping("/csv/{produtos}")
    public ResponseEntity getCSV(@PathVariable String produtos) {
        gravaLista(listaObj , produtos);
>>>>>>> 19cba0ce1329c842739a05876184ff1df32fd384
        return ResponseEntity.status(200).build();
    }

    @CrossOrigin
    @GetMapping("/{id}/teste")
    public ResponseEntity getPetshop(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProdutos(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity putProduto(@PathVariable int id,
                                     @RequestBody Produto produtoAtualizado) {
        if (repository.existsById(id)) {
            produtoAtualizado.setIdProduto(id);
            repository.save(produtoAtualizado);
            lista.adicionar(produtoAtualizado);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
