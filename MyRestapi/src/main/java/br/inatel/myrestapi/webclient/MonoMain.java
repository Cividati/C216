package br.inatel.myrestapi.webclient;

import br.inatel.myrestapi.model.Curso;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class MonoMain {
    public static String cursoUri = "localhost:8080/curso";

    public static void main(String[] args) {

        Mono<Curso> monoCurso = WebClient.create(cursoUri+"/2")
                .get()
                .retrieve()
                .bodyToMono(Curso.class);

        monoCurso.subscribe();
        Curso curso = monoCurso.block();
        System.out.println("Curso encontrado: " + curso);

    }
}
