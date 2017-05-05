import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent }  from './app.component';
import { MovieDetailComponent } from './movie-detail.component';
import { PeliculasComponent } from './peliculas.component';

const routes: Routes = [
  {
    path: '',
    component: PeliculasComponent
  },
  {
    path: 'listaPeliculas',
    component: PeliculasComponent
  },
  {
    path: 'pelicula/:id',
    component: MovieDetailComponent
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
