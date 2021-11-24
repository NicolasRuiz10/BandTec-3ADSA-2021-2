package com.br.springsprint2.controle;

import com.br.springsprint2.Fila.FilaObj;
import com.br.springsprint2.Pilha.PilhaObj;
import com.br.springsprint2.dominio.Petshop;
import com.br.springsprint2.dominio.Produto;
import com.br.springsprint2.dominio.Usuario;
import com.br.springsprint2.repositorio.PetshopRepository;
import com.br.springsprint2.repositorio.ProdutoRepository;
import com.br.springsprint2.util.ListaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    public static void gravaLista(ListaObj<Produto> lista, String nomeArq) {

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


    public static void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;
        // Abre o arquivo
        try {
            saida = new BufferedWriter (new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " +
                    erro.getMessage());
        }

        // Grava o registro e finaliza
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro na gravação do arquivo: " +
                    erro.getMessage());
        }
    }



    public static void gravaArquivoTxt(List<Produto> lista, String nomeArq) {

        int contaRegistro = 0;

        // Monta o registro de header
        String header = "00PRODUTO";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";

        // Grava o registro do header
        gravaRegistro(nomeArq, header);

        // Monta e grava o corpo
        String corpo;
        for (Produto a : lista) {
            corpo = "02";
            corpo += String.format("%-5.5s",a.getIdProduto());
            corpo += String.format("%-13.8s",a.getNome());
            corpo += String.format("%-50.50s", a.getDescricao());
            corpo += String.format("%09.2f", a.getValor());
            corpo += String.format("%-10.10s", a.getMarca());
            corpo += String.format("%-14.14s", a.getEspecie());
            corpo += String.format("%03d", a.getQuantidade());
            if(a.getFkPetShop() == null) {
                corpo += String.format("%-3.3s", "");
            } else {
                corpo += String.format("%03d", a.getFkPetShop().getIdPetshop());
            }
            gravaRegistro(nomeArq,corpo);
            contaRegistro++;
        }

        // Monta e grava o trailer
        String trailer = "01";
        trailer += String.format("%03d", contaRegistro);
        gravaRegistro(nomeArq,trailer);

    }

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private PetshopRepository petRepository;

    private ListaObj listaObj = new ListaObj(1000);
    private PilhaObj<Produto> pilha = new PilhaObj<>(1000);
    private FilaObj<Produto> fila = new FilaObj<>(1000);

    @CrossOrigin
    @PostMapping("{fkPetshop}")
    public ResponseEntity createProdutos(@RequestBody Produto novoProduto, @PathVariable int fkPetshop) {
        Petshop petshop = petRepository.findById(fkPetshop).get();
        novoProduto.setFkPetShop(petshop);
        repository.save(novoProduto);
        listaObj.adicionar(novoProduto);
        return status(HttpStatus.CREATED).build();
    }



    @CrossOrigin
    @GetMapping
    public ResponseEntity getProdutos() {
        List<Produto> lista = repository.findAll();
        for (Produto p: lista) {
            listaObj.adicionar(p);
        }
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

    @CrossOrigin
    @PostMapping("produto-foto/{fkPetshop}")
    public ResponseEntity createProdutosFoto(@RequestBody Produto novoProduto, @PathVariable int fkPetshop, @RequestBody MultipartFile foto) throws IOException {
        Petshop petshop = petRepository.findById(fkPetshop).get();
        novoProduto.setFkPetShop(petshop);
        byte[] novaFoto = foto.getBytes();
        novoProduto.setFoto(novaFoto);
        repository.save(novoProduto);
        return status(HttpStatus.CREATED).build();
    }



    @CrossOrigin
    @PatchMapping("/foto/{id}")
    public ResponseEntity patchFoto(@PathVariable Integer id,
                                    @RequestParam MultipartFile foto) throws IOException {
        // Não vamos validar se o carro existe
        if (repository.existsById(id)) {
            Produto produto = repository.findById(id).get();

            byte[] novaFoto = foto.getBytes();

            produto.setFoto(novaFoto);
            repository.save(produto);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @CrossOrigin
    @GetMapping("/foto/{id}")
    public ResponseEntity getFoto(@PathVariable int id){
        if (repository.existsById(id)) {
            Produto produto = repository.findById(id).get();
            byte[] foto = produto.getFoto();

            return ResponseEntity
                    .status(200)
                    .header("content-type", "image/png")
                    .body(foto);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @CrossOrigin
    @GetMapping("/doc")
    public ResponseEntity getDoc() throws IOException {

            BufferedReader entrada = new BufferedReader(new FileReader("Documento de Layout.docx"));;

            return ResponseEntity
                    .status(200)
                    .header("content-type", "application/pdf")
                    .body(entrada);
        }


    @CrossOrigin
    @GetMapping("/csv/{produtos}")
    public ResponseEntity getCSV(@PathVariable String produtos) {
        gravaLista(listaObj , produtos);
        return ResponseEntity.status(200).build();
    }

    @CrossOrigin
    @GetMapping("/layout/{nmArq}")
    public ResponseEntity getLayout(@PathVariable String nmArq) {
        List<Produto> produtos = repository.findAll();
        gravaArquivoTxt(produtos, nmArq);
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
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }



    @CrossOrigin
    @DeleteMapping("/desfazer-cadastro")
    public ResponseEntity desfazerCadastro(){
        if( pilha.isEmpty()){
            ResponseEntity.status(404).build();
        }
        Integer id = pilha.peek().getIdProduto();
        deleteProdutos(id);
        pilha.pop();
        return ResponseEntity.status(200).build();
    }

    @CrossOrigin
    @PostMapping("/txt")
    public ResponseEntity postLayout(@RequestBody MultipartFile txt, @RequestBody MultipartFile image) throws IOException {
        BufferedReader entrada = new BufferedReader(new StringReader(new String(txt.getBytes())));
        String registro, tipoRegistro;

        int contaRegDados = 0;
        int qtdRegGravados;
        String nome;
        String descricao;
        Double valor;
        String marca;
        String especie;
        String tipoProduto;
        Integer quantidade;
        Integer petshop;

        try {
            entrada = new BufferedReader(new StringReader(new String(txt.getBytes())));
        }
        catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " +
                    erro.getMessage());
        }

        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0,2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um header");
                    System.out.println("Tipo do arquivo: "+registro.substring(2,10));
                    System.out.println("Data e hora de gravação: "+registro.substring(10,29));
                    System.out.println("Versão do documento: "+registro.substring(29,31));
                }
                else if (tipoRegistro.equals("02")) {
                    // Lê os dados do registro de corpo
                    nome = registro.substring(2, 15).trim();
                    descricao = registro.substring(15, 65);
                    valor = Double.valueOf(registro.substring(65,74).replace(',','.'));
                    marca = registro.substring(74, 84).trim();
                    especie = registro.substring(84, 98).trim();
                    tipoProduto = registro.substring(98, 108).trim();
                    quantidade = Integer.valueOf(registro.substring(108,111));
                    petshop = Integer.valueOf(registro.substring(111,114));

                    Produto produtoTxt = new Produto(nome,descricao,valor,marca,especie,tipoProduto,quantidade);
                    byte[] foto2 = image.getBytes();
                    produtoTxt.setFoto(foto2);
                    createProdutos(produtoTxt,petshop);
                    pilha.push(produtoTxt);
                    contaRegDados++;
                }
                else {
                    System.out.println("Tipo de registro inválido");
                }

                // lê o próximo registro
                registro = entrada.readLine();
            }

            // Fecha o arquivo
            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler arquivo: " + erro.getMessage());
        }

        return ResponseEntity.status(200).build();
    }
}
