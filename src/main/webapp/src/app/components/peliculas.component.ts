import { Component,OnInit } from '@angular/core';
import { Pelicula } from './../model/pelicula';
import { MovieDetailComponent} from './movie-detail.component';
import { PeliculaService } from './../pelicula.service';

@Component({
  selector: 'listaPeliculas',
  template: `
    <h1>Peliculas: </h1>
    <div class="row">
      <input [(ngModel)]="searchString" placeholder="Ingrese texto a buscar..."/>
      <button (click)="searchClick()" class="btn waves-effect black-text">Buscar</button>
      <button (click)="searchReset()" class="btn waves-effect black-text">Limpiar busqueda</button>
    </div>

    <ul class="movies black-text">
      <li *ngFor="let movie of movies">
      <div class="row">
        <div class="card horizontal teal lighten-2">
          <div class="card-image">
          <img src="{{movie.imagePath}}"/><br/>
          </div>
          <div class="card-stacked">
          <div class="card-content">
            <span class="card-title center-align"><a class="blue-text text-darken-4" [routerLink]="['/pelicula', movie.id]">{{movie.nombre}}</a> ({{movie.anioEstreno}})</span>
            <span class="valign-wrapper">{{movie.descripcion}}</span>
          </div>
          </div>
        </div>
      </div>
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
