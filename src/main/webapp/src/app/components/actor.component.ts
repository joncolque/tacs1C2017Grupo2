import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Actor } from './../model/actor';
import { MovieCastResult } from './../model/movie-cast-result';
import { ActorService } from './../actor.service';

@Component({
  selector:'actor',
  template:`
    <div *ngIf="actor" class="center-align">
      <div class="card-panel teal lighten-2 black-text">
        <h2>{{actor.nombre}}</h2>
        <img src="{{actor.imagePath}}"/><br/>
        <h4>Lugar y fecha de nacimiento: {{actor.fechaNac}} en {{actor.lugarNac}}</h4><br/>
        <h4>Biografia:</h4><br/>
        <span>{{actor.biography}}</span>
      </div>

      <div class="card-panel teal lighten-2 black-text">
        <h3>Peliculas en las que aparece:</h3>
        <div class="container">
        <table class="centered">
        <thead>
        <tr>
          <th>Pelicula</th>
          <th>Personaje</th>
        </tr>
        </thead>
        <tbody>
        <tr *ngFor="let pelicula of actor.listaPeliculas">
          <td><a class="blue-text text-darken-4" [routerLink]="['/pelicula', pelicula.id]">{{pelicula.original_title}}</a></td>
          <td>{{pelicula.character}}</td>
        </tr>
        </tbody>
        </table>
        </div>
      </div>
    </div>
  `
})

export class ActorComponent implements OnInit {
  actor: Actor;

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.actorService.getActor(+params['id']))
      .subscribe(actorRes => {this.actor = actorRes;});
  }

  constructor(private actorService: ActorService, private route: ActivatedRoute, private location: Location) {}
}
