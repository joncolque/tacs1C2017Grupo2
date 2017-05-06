import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Actor } from './../model/actor';
import { PeliculaService } from './../pelicula.service';

@Component({
  selector:'actor',
  template:`
    <div *ngIf="actor" class="center-align">
      <div class="card-panel teal lighten-2 black-text">
        <h2>{{actor.nombre}}</h2>
        <img src="{{actor.imagePath}}"/><br/>

        <span>{{actor.biography}}</span>
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
          <td>{{actor.name}}</td>
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

export class ActorComponent implements OnInit {
  actor: Actor;
  parametros: number;

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.peliculaService.getMovie(+params['id']))
      .subscribe(pelicula => {this.movie = pelicula; console.log("Pelicula: " + JSON.stringify(this.movie));});
//    this.route.params.switchMap((params: Params) => { this.parametros = (+params['id']) });
  }

  constructor(private peliculaService: PeliculaService, private route: ActivatedRoute, private location: Location) {}
}
