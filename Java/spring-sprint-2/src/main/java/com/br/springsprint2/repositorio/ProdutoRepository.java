package com.br.springsprint2.repositorio;

import java.util.List;
import com.br.springsprint2.dominio.Produto;
import com.br.springsprint2.resposta.ProdutoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Query("select new com.br.springsprint2.resposta.ProdutoResponse(p.idProduto, p.nome, p.descricao, p.valor, p.marca, p.especie, p.tipoProduto, p.quantidade, p.fkPetShop) from Produto p")
    List<ProdutoResponse> litaProdutosComFkPetshop();

}
