package br.inatel.myrestapi.controller;

import br.inatel.myrestapi.model.Curso;
import br.inatel.myrestapi.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService servico;

    @GetMapping
    public List<Curso> listar() {
        List<Curso> listaCurso = servico.pesquisarCurso();
        return listaCurso;
    }

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable("id") Long cursoId) {
        Curso curso = servico.buscarCursoPeloId(cursoId);
        if (curso != null)
            return curso;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public Curso criar(Curso curso){
        curso = servico.criarCurso(curso);
        return curso;
    }
    @DeleteMapping("{id}")
    public void remover(@PathVariable("id") Long cursoId){
        servico.removerCurso(cursoId);

    }


}
