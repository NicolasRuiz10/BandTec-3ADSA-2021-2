package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.UsuarioLogar;
import com.br.springsprint2.repositorio.UsuarioLogarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UsuarioController.class, UsuarioLogarRepository.class})
class UsuarioControllerTest {

    @Autowired
    UsuarioController usuarioController;

    @MockBean
    UsuarioLogarRepository repository;

    UsuarioLogar usuarioLogar = new UsuarioLogar("nicolas","nicolas","1185445224","18568548654","nicolas","r cbivas tiboias", "08275340","casa",14);


    @Test
    void autenticar() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = usuarioController.autenticar(usuarioLogar);
        assertEquals(304, resposta.getStatusCodeValue());

    }

    @Test
    void createUsuario() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = usuarioController.createUsuario(usuarioLogar);
        assertEquals(201, resposta.getStatusCodeValue());
    }

    @Test
    void getUsuarios() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = usuarioController.getUsuarios();
        assertEquals(204, resposta.getStatusCodeValue());

    }

    @Test
    void getUsuario() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = usuarioController.getUsuario(10);
        assertEquals(404, resposta.getStatusCodeValue());

    }

    @Test
    void deleteUsuario() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = usuarioController.deleteUsuario(10);
        assertEquals(404, resposta.getStatusCodeValue());

    }


    @Test
    void logoff() {

        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = usuarioController.logoff(1);
        assertEquals(404, resposta.getStatusCodeValue());

    }

    @Test
    void putUsuario() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = usuarioController.putUsuario(1,usuarioLogar);
        assertEquals(404, resposta.getStatusCodeValue());

    }
}