package com.br.springsprint2.repositorio;

import com.br.springsprint2.dominio.Produto;
import com.br.springsprint2.util.ListaObj;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
