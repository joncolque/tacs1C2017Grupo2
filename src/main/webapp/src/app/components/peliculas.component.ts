import { Component,OnInit } from '@angular/core';
import { Pelicula } from './../model/pelicula';
import { SummaryActor } from './../model/summary-actor';
import { MovieDetailComponent} from './movie-detail.component';
import { PeliculaService } from './../pelicula.service';
import { ActorService } from './../actor.service';

@Component({
  selector: 'listaPeliculas',
  templateUrl: './partials/peliculas.component.html',
})
export class PeliculasComponent implements OnInit {
  movies: Pelicula[];
  baseMovies: Pelicula[]; //para el "cacheo" de peliculas populares del inicio
  actores: SummaryActor[];
  searchString: string;

  queBuscarRadio: number;

  getPeliculas(): void {
    this.peliculaService.getMovies().then(movies => {this.movies = movies;});
  }

  searchClick(): void {
    if (this.queBuscarRadio == 1) {
      this.peliculaService.getMoviesByString(this.searchString).then(movies => {this.movies = movies; this.actores = null;});
    } else if (this.queBuscarRadio == 2) {
      this.actorService.getActorByString(this.searchString).then(actores => {this.actores = actores; this.movies = null;});
    } else {
      this.peliculaService.getMoviesByString(this.searchString).then(movies => this.movies = movies);
      this.actorService.getActorByString(this.searchString).then(actores => {this.actores = actores;});
    }
  }

  searchReset(): void {
    this.movies = this.baseMovies;
    this.actores = null;
    this.searchString = "";
  }

  ngOnInit(): void {
    this.getPeliculas();
  }

  constructor(private peliculaService: PeliculaService, private actorService: ActorService) { }
}
