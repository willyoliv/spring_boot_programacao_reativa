package br.com.letscode.spring.service;

import br.com.letscode.spring.entity.Usuario;
import br.com.letscode.spring.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Mono<Usuario> saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Flux<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Mono<Usuario> findUsuarioById(String id) {
        return usuarioRepository.findById(id);
    }

    public Mono<Void> deleteUsuarioById(String id) {
        return usuarioRepository.deleteById(id);
    }
}
