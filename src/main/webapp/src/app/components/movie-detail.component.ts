import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { MovieDetail } from './../model/movie-detail';
import { PeliculaService } from './../pelicula.service';
import { MovieListService } from './../movie-list.service';

@Component({
  selector:'movie-detail',
  template:`
    <div *ngIf="movie" class="center-align">
      <div class="card-panel teal lighten-2 black-text">
        <h2>{{movie.nombre}} ({{movie.anioEstreno}})</h2>
        <img src="{{movie.imagePath}}"/><br/>
        <span>{{movie.descripcion}}</span>
      </div>

      <div class="card-panel teal lighten-2 black-text">
        <h3>Actores:</h3>
        <div class="container">
        <table class="centered">
        <thead>
        <tr>
          <th>Nombre</th>
          <th>Personaje</th>
        </tr>
        </thead>
        <tbody>
        <tr *ngFor="let actor of movie.cast">
          <td><a class="blue-text text-darken-4" [routerLink]="['/actor', actor.id]">{{actor.name}}</a></td>
          <td>{{actor.character}}</td>
        </tr>
        </tbody>
        </table>
        </div>
      </div>

      <div class="card-panel teal lighten-2 black-text">
      <h3>Reseñas:</h3>
      <ul class="resenas">
      <li *ngFor="let review of movie.reviews">
        <h5>{{review.author}} dice:</h5>
        <span>{{review.content}}</span>
      </li>
      </ul>
      </div>
    </div>
  `
})

export class MovieDetailComponent implements OnInit {
  movie: MovieDetail;

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.peliculaService.getMovie(+params['id']))
      .subscribe(pelicula => {this.movie = pelicula;});
  }

  constructor(private peliculaService: PeliculaService, private movieListService: MovieListService, private route: ActivatedRoute, private location: Location) {}
}
