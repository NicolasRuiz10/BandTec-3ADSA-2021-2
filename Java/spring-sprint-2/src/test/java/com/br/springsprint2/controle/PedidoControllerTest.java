package com.br.springsprint2.controle;

import com.br.springsprint2.dominio.Pedido;
import com.br.springsprint2.dominio.UsuarioLogar;
import com.br.springsprint2.repositorio.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {PedidoController.class, PedidoRepository.class})
class PedidoControllerTest {

    @Autowired
    PedidoController controller;

    @Autowired
    UsuarioLogar userController;

    @MockBean
    PedidoRepository repository;

    UsuarioLogar usuarioLogar = new UsuarioLogar("nicolas","nicolas","1185445224","18568548654","nicolas","r cbivas tiboias", "08275340","casa",14);

    Pedido pedido = new Pedido("cartao", 300.0);


    @Test
    void postPedidoByUsuarioId() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.postPedidoByUsuarioId(1,pedido);
                assertEquals(404, resposta.getStatusCodeValue());
    }

    @Test
    void getPedidos() {
    }

    @Test
    void getPedido() {
    }

    @Test
    void deletePedido() {
    }

    @Test
    void putPedido() {
    }
}