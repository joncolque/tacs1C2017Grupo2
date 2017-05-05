import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { MovieDetail } from './../model/movie-detail';
import { PeliculaService } from './../pelicula.service';

@Component({
  selector:'movie-detail',
  template:`
    <div *ngIf="movie">
      <h2>{{movie.nombre}} ({{movie.anioEstreno}})</h2>
      <img src="{{movie.imagePath}}"/><br/>
      <span>{{movie.descripcion}}</span>

      <h3>Actores:</h3>
      <ul class="actores">
        <li *ngFor="let actor of movie.cast">
          <span>{{actor.name}} en el personaje de {{actor.character}}</span>
        </li>
      </ul>

      <h3>Reseñas:</h3>
      <ul class="resenas">
      <li *ngFor="let review of movie.reviews">
        <h5>{{review.author}} dice:</h5>
        <span>{{review.content}}</span>
      </li>
      </ul>
    </div>
  `
})

export class MovieDetailComponent implements OnInit {
  movie: MovieDetail;
  parametros: number;

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.peliculaService.getMovie(+params['id']))
      .subscribe(pelicula => {this.movie = pelicula; console.log("Pelicula: " + JSON.stringify(this.movie));});
//    this.route.params.switchMap((params: Params) => { this.parametros = (+params['id']) });
  }

  constructor(private peliculaService: PeliculaService, private route: ActivatedRoute, private location: Location) {}
}
