package com.br.springsprint2.repositorio;

import com.br.springsprint2.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
