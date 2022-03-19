package br.inatel.myrestapi.webclient;

import br.inatel.myrestapi.model.Curso;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class FluxMain {
    public static String cursoUri = "localhost:8080/curso";

    public static void main(String[] args) {

        List<Curso> listaCurso = new ArrayList<Curso>();
        Flux<Curso> flux = WebClient.create()
                .get()
                .uri(cursoUri)
                .retrieve()
                .bodyToFlux(Curso.class);
        //System.out.println(flux);
        flux.subscribe(c -> listaCurso.add(c));
        flux.blockLast();

        System.out.println("Lista de Cursos:");
        System.out.println(listaCurso);
    }
}
