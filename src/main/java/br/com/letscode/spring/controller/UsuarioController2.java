package br.com.letscode.spring.controller;

import br.com.letscode.spring.entity.Usuario;
import br.com.letscode.spring.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFlux
public class UsuarioController2 {
    private static String BASE_URL ="/v2/usuarios";
    public  final UsuarioService usuarioService;


    public UsuarioController2(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Bean
    public RouterFunction<ServerResponse> saveUsuario() {
       return RouterFunctions.route()
                .POST(BASE_URL, request -> request.bodyToMono(Usuario.class)
                        .flatMap(usuarioService::saveUsuario)
                        .flatMap(usuario -> ServerResponse.status(HttpStatus.CREATED).bodyValue(usuario)))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> getAllUsuario() {
        return RouterFunctions.route().GET(BASE_URL, request ->
                ServerResponse.ok()
                        .body(usuarioService.findAllUsuarios(), Usuario.class))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> getUsuarioById() {
        return RouterFunctions.route()
                .GET(BASE_URL.concat("/{id}"), request -> {
                    String id = request.pathVariable("id");
                    return ServerResponse.ok().body(usuarioService.findUsuarioById(id), Usuario.class);
                }).build();
    }

    @Bean
    public RouterFunction<ServerResponse> deleteById() {
        return RouterFunctions.route()
                .DELETE(BASE_URL.concat("/{id}"), request -> {
                    String id = request.pathVariable("id");
                    return ServerResponse.ok().body(usuarioService.deleteUsuarioById(id), Usuario.class);
                }).build();
    }
}
