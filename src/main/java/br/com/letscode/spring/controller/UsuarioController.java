package br.com.letscode.spring.controller;

import br.com.letscode.spring.entity.Usuario;
import br.com.letscode.spring.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Usuario> getAllUsuario() {
        return usuarioService.findAllUsuarios();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Usuario> findById(@PathVariable String id) {
        return usuarioService.findUsuarioById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteUsuario(@PathVariable String id) {
        return usuarioService.deleteUsuarioById(id);
    }
}
