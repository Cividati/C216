package br.inatel.myrestapi.MyRestapi.controller;

import br.inatel.myrestapi.model.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CursoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void listarCursos(){
        webTestClient.get()
                .uri("/curso")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .returnResult();
    }

    @Test
    public void validaCurso(){
        Long idCurso = 1L;

        Curso curso = webTestClient.get()
                .uri("/curso/" + idCurso)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Curso.class)
                .returnResult()
                .getResponseBody();

        assertEquals(curso.getId(), idCurso);
    }
}
