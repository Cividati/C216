package br.inatel.myrestapi.controller;

import br.inatel.myrestapi.model.Curso;
import br.inatel.myrestapi.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
