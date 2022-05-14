package br.com.letscode.spring.repository;

import br.com.letscode.spring.entity.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, String> {
}
