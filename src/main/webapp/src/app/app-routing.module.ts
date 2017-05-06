import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent }  from './app.component';
import { MovieDetailComponent } from './components/movie-detail.component';
import { PeliculasComponent } from './components/peliculas.component';
import { ActorComponent } from './components/actor.component';

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
  },
  {
    path: 'actor/:id',
    component: ActorComponent
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
