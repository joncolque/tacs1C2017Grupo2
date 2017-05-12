import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { MovieDetailComponent } from './components/movie-detail.component';
import { PeliculasComponent } from './components/peliculas.component';
import { ActorComponent } from './components/actor.component';
import { LoginComponent } from './components/login.component';

import { MovieListComponent } from './components/movie-list.component';
import { MovieListDetailComponent } from './components/movie-list-detail.component';
import { UsuariosComponent } from './components/usuarios.component'
import { UsuarioDetailComponent } from './components/usuario-detail.component';
import { RankingFavoritosComponent } from './components/ranking-favoritos.component';

const routes: Routes = [
  {
    path: '',
    component: PeliculasComponent
  },
  {
    path: 'login',
    component: LoginComponent
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
  },
  {
    path: 'misListas',
    component: MovieListComponent
  },
  {
    path: 'movielists/:id',
    component: MovieListDetailComponent
  },
  {
    path: 'listaUsuarios',
    component: UsuariosComponent
  },
  {
    path: 'detail/:id',
    component: UsuarioDetailComponent
  },
  {
    path: 'actoresFavoritos',
    component: RankingFavoritosComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
