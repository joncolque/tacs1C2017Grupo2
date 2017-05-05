import { Component,OnInit } from '@angular/core';
import { Pelicula } from './../model/pelicula';
import { MovieDetailComponent} from './movie-detail.component';
import { PeliculaService } from './../pelicula.service';

@Component({
  selector: 'listaPeliculas',
  template: `
    <h1>Peliculas: </h1>
    <input [(ngModel)]="searchString"/><button (click)="searchClick()" type="button">Buscar</button>
    <button (click)="searchReset()" type="button">Limpiar busqueda</button>

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
  movies: Pelicula[];
  baseMovies: Pelicula[]; //para el "cacheo" de peliculas populares del inicio
  searchString: string;

  getPeliculas(): void {
    this.peliculaService.getMovies().then(movies => {this.movies = movies; this.baseMovies = movies;});
  }

  searchClick(): void {
    this.peliculaService.getMoviesByString(this.searchString).then(movies => this.movies = movies);
  }

  searchReset(): void {
    this.movies = this.baseMovies;
    this.searchString = "";
  }

  ngOnInit(): void {
    this.getPeliculas();
  }

  constructor(private peliculaService: PeliculaService) { }
}
