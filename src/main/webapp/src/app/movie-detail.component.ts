import { Component, Input } from '@angular/core';
import { Pelicula } from './pelicula';

@Component({
  selector:'movie-detail',
  template:`
    <h2><a href="#" (click)="onSelect(movie)">{{movie.nombre}}</a> ({{movie.anioEstreno}})</h2>
    <span>{{movie.descripcion}}</span>
  `
})

export class MovieDetailComponent {
  @Input() movie: Pelicula;

  onSelect(pelicula: Pelicula): void {
    alert("Pelicula seleccionada: " + pelicula.nombre);
  }
}
