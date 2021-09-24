package com.br.springsprint2.repositorio;

import com.br.springsprint2.dominio.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
