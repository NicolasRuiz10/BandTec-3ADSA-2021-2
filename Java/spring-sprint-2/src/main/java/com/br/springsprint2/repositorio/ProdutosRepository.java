package com.br.springsprint2.repositorio;

import com.br.springsprint2.dominio.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
}
