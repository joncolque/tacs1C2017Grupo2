import { Component,OnInit } from '@angular/core';
import { Pelicula } from './../model/pelicula';
import { MovieDetailComponent} from './movie-detail.component';
import { PeliculaService } from './../pelicula.service';

@Component({
  selector: 'listaPeliculas',
  template: `
    <h1>Peliculas: </h1>
    <ul class="movies">
      <li *ngFor="let movie of movies">
        <img src="{{movie.imagePath}}"/>
        <h2><a [routerLink]="['/pelicula', movie.id]">{{movie.nombre}}</a> ({{movie.anioEstreno}})</h2>
        <span>{{movie.descripcion}}</span>
      </li>
    </ul>
  `,
})
export class PeliculasComponent implements OnInit {
  //movies = PELICULAS;
  movies: Pelicula[];

  getPeliculas(): void {
    this.peliculaService.getMovies().then(movies => this.movies = movies);
  }

  ngOnInit(): void {
    this.getPeliculas();
  }

  constructor(private peliculaService: PeliculaService) { }
}
