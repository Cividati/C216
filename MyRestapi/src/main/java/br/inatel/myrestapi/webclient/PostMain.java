package br.inatel.myrestapi.webclient;

import br.inatel.myrestapi.model.Curso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class PostMain {

    public static void criarCurso(){
        Curso novoCurso = new Curso(4L, "Curso novo por post", 250);

        Curso cursoCriado = WebClient.create("localhost:8080/curso")
                .post()
                .bodyValue(novoCurso)
                .retrieve()
                .bodyToMono(Curso.class)
                .block();

        System.out.println("Curso criado: ");
        System.out.println(cursoCriado);
    }

    public static void atualizarCurso(){
        Curso cursoExistente = new Curso(1L, "Curso editado", 120);

        ResponseEntity<Void> responseEntity = WebClient.create("localhost:8080/curso")
                .put()
                .bodyValue(cursoExistente)
                .retrieve()
                .toBodilessEntity()
                .block();

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("Curso atualizado. Status: "+ statusCode);
    }

    public static void deleteCurso(int cursoId){

        ResponseEntity<Void> responseEntity = WebClient.create("localhost:8080/curso/"+cursoId)
                .delete()
                .retrieve()
                .toBodilessEntity()
                .block();

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("Curso deletado. Status: "+ statusCode);
    }

    public static void main(String[] args) {

        // criarCurso();
        atualizarCurso();
        //deleteCurso(3);



    }
}
