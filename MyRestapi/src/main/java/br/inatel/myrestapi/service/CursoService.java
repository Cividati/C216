package br.inatel.myrestapi.service;

import br.inatel.myrestapi.model.Curso;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private Map<Long, Curso> mapa = new HashMap<>();

    private void inicializarMapa(){
        Curso c1 = new Curso(1L, "Curso 1", 20);
        Curso c2 = new Curso(2L, "Curso 2", 80);
        Curso c3 = new Curso(3L, "Curso 3", 120);

        this.mapa.put(c1.getId(), c1);
        this.mapa.put(c2.getId(), c2);
        this.mapa.put(c3.getId(), c3);

    }

    public List<Curso> pesquisarCurso() {

        this.inicializarMapa();
        return mapa.entrySet()
                    .stream()
                    .map(m -> m.getValue())
                    .collect(Collectors.toList());
    }
}
