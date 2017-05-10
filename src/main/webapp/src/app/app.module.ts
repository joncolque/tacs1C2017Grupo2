import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { PeliculaService } from './pelicula.service';
import { ActorService } from './actor.service';
import { AppComponent }  from './app.component';
import { MovieDetailComponent } from './components/movie-detail.component';
import { PeliculasComponent } from './components/peliculas.component';
import { ActorComponent } from './components/actor.component';
import { MovieListComponent } from './components/movie-list.component';
import { MovieListService } from './movie-list.service';
import { MovieListDetailComponent } from './components/movie-list-detail.component';
import { LoginComponent } from './components/login.component';
import { UsuariosComponent } from './components/usuarios.component';
import { UsuarioService } from './usuario.service';
import { UsuarioDetailComponent } from './components/usuario-detail.component';

@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    MovieDetailComponent,
    PeliculasComponent,
    ActorComponent,
    MovieListComponent,
    MovieListDetailComponent,
    UsuariosComponent,
    UsuarioDetailComponent,
  ],
  providers: [
    PeliculaService,
    ActorService,
    UsuarioService,
    MovieListService
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
