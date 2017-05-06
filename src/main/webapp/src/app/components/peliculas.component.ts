import { Component,OnInit } from '@angular/core';
import { Pelicula } from './../model/pelicula';
import { MovieDetailComponent} from './movie-detail.component';
import { PeliculaService } from './../pelicula.service';

@Component({
  selector: 'listaPeliculas',
  templateUrl: './partials/peliculas.component.html',
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
