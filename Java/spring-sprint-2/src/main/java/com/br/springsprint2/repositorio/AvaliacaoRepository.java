package com.br.springsprint2.repositorio;

import com.br.springsprint2.dominio.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
}
