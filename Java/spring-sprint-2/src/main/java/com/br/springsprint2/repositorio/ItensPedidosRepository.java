package com.br.springsprint2.repositorio;

import com.br.springsprint2.dominio.ItensPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidosRepository extends JpaRepository<ItensPedido, Integer> {
}
