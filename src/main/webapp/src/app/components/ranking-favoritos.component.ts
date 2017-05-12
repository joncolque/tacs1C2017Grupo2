import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { SummaryActor } from './../model/summary-actor';
import { ActorFavorito } from './../model/actor-favorito';
import { ActorService } from './../actor.service';

@Component({
  selector: 'ranking-favoritos',
  template: `
    <div class="card-panel teal lighten-2 black-text">
    <div class="container">
    <table class="centered">
      <thead>
      <tr>
        <th>Actor</th>
        <th>Cantidad de favoritos</th>
      </tr>
      </thead>
      <tbody>
      <tr *ngFor="let actorFav of listaFavoritos">
        <td>{{actorFav.actor.nombre}}</td>
        <td>{{actorFav.cantidadFavoritos}}</td>
      </tr>
      </tbody>
    </table>
    </div>
    </div>
  `
})

export class RankingFavoritosComponent implements OnInit {
  listaFavoritos: ActorFavorito[];

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.actorService.getActoresFavoritos())
      .subscribe(listaActores => this.listaFavoritos = listaActores);
  }

  constructor(private actorService: ActorService, private route: ActivatedRoute, private location: Location) {}
}
