import { CursoService } from './../../services/curso.service';
import { Curso } from './../../models/curso';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent implements OnInit {
  cursos : Curso[] = [];

  constructor(private cursoService: CursoService) { }

  ngOnInit(): void {
    this.cursoService.pesuistar().subscribe(cs => this.cursos = cs);
  }

}
