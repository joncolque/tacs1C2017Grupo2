import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { SummaryActor } from './../model/summary-actor';
import { ActorFavorito } from './../model/actor-favorito';
import { ActorService } from './../actor.service';
import { UsuarioService } from './../usuario.service';
import { UserData } from './../model/user-data';

@Component({
  selector: 'ranking-favoritos',
  template: `
    <h4 *ngIf="error">No tiene los permisos para acceder a esta sección.</h4>
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
  error: string;

  ngOnInit(): void {
    console.log('El token es ' + this.userData.getToken() + ' con user: ' + this.userData.getUsername());

    this.route.params
      .switchMap((params: Params) => this.actorService.getActoresFavoritos())
      .subscribe(listaActores => { this.listaFavoritos = listaActores; },
        error => this.error = error);
  }

  constructor(private actorService: ActorService, private route: ActivatedRoute, private location: Location, private usuarioService: UsuarioService, private userData: UserData) {}
}
