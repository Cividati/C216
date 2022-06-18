import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursoComponent } from './views/curso/curso.component';
import { NotFoundComponent } from './views/not-found/not-found.component';

const routes: Routes = [
  {
  path: 'curso',
  component: CursoComponent
  },
  {
    path: '**',
    component: NotFoundComponent
    },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
