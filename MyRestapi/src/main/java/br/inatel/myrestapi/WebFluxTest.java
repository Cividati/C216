package br.inatel.myrestapi;

import br.inatel.myrestapi.model.Curso;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class WebFluxTest {

    public static void main(String[] args) {
        List<Curso> listaCurso = new ArrayList<Curso>();
        Flux<Curso> flux = WebClient.create().get().uri("localhost:8080/curso").retrieve().bodyToFlux(Curso.class);
        System.out.println(flux);
        flux.subscribe(c -> listaCurso.add(c));
        flux.blockLast();

        System.out.println("Lista de Cursos:");
        System.out.println(listaCurso);


    }
}
