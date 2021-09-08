package br.com.felipe.c13adsafelipecruzolegario01202080;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AutenticacaoController {
    private List<Usuario> usuarios = new ArrayList<>(List.of(new Usuario("felipe", "laurinha", "felipe.olegario", true, LocalDate.now())));

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @PostMapping("/usuarios")
    public String cadastrarUsuario(@RequestBody Usuario novoUsuario) {
        usuarios.add(novoUsuario);
        return String.format("Usuário %s cadastrado com sucesso", novoUsuario.getNome());
    }

    @GetMapping("/autenticar/{login}/{senha}")
    public String autenticar(@PathVariable String login, @PathVariable String senha) {
//        for (Usuario u : usuarios) {
//            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
//                u.setAutenticacao(true);
//                u.setDataAutenticacao(LocalDate.now());
//                return u;
//            }
//        }
        usuarios.stream().filter(u -> u.getLogin().equals(login) && u.getSenha().equals(senha)).map(item -> { item.setAutenticacao(true); item.setDataAutenticacao(LocalDate.now()); return item;}).collect(Collectors.toList());

        return "Usuario logado com sucesso!";
    };

    @DeleteMapping("/usuarios/autenticacao/{login}")
    public String logof(@PathVariable String login) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                usuarios.remove(u);
                return String.format("Usuário %s saiu do sistema", login);
            }
        }
        return String.format("Usuário %s não autenticado", login);

    }
}
