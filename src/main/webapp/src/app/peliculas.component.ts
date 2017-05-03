import { Component,OnInit } from '@angular/core';
import { Pelicula } from './pelicula';
import { MovieDetailComponent} from './movie-detail.component';
import { PeliculaService } from './pelicula.service';

@Component({
  selector: 'listaPeliculas',
  template: `
    <h1>Peliculas: </h1>
    <ul class="movies">
      <li *ngFor="let movie of movies">
        <movie-detail [movie]="movie"></movie-detail>
      </li>
    </ul>
  `,
  providers: [PeliculaService]
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
