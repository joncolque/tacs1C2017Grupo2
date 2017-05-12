import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Actor } from './../model/actor';
import { MovieCastResult } from './../model/movie-cast-result';
import { ActorService } from './../actor.service';
import { UsuarioService } from './../usuario.service';

@Component({
  selector:'actor',
  template:`
    <div *ngIf="actor" class="center-align">
      <div class="card-panel teal lighten-2 black-text">
        <img (click)="favorite(isFavorite, actor.id)" [src]="imgUrl" style="cursor: pointer; float: right;"/>
        <h2>{{actor.nombre}}</h2>
        <img src="{{actor.imagePath}}"/><br/>
        <h4>Lugar y fecha de nacimiento: {{actor.fechaNac}} en {{actor.lugarNac}}</h4><br/>
        <h4>Biografia:</h4><br/>
        <span>{{actor.biography}}</span>
      </div>

      <div class="card-panel teal lighten-2 black-text">
        <h3>Peliculas en las que aparece:</h3>
        <div class="container">
        <table class="centered highlight">
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
  imgUrl = "./app/image/star-off.png";
  isFavorite: boolean;
  idActor: number;

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.actorService.getActor(+params['id']))
      .subscribe(actorRes => {this.actor = actorRes;
                              this.usuarioService.actorFavorito(actorRes.id).then(
                                  resp => {console.log("se recibe como respuesta: "+resp.bool);
                                    this.favorite(!resp.bool,actorRes.id);
                                  console.log("id del actor: "+actorRes.id+ "is favorite debe ser: "+resp.bool);
                                })
                            });
  }


  constructor(private usuarioService: UsuarioService, private actorService: ActorService, private route: ActivatedRoute, private location: Location) {}

  favorite(isFav: boolean, id: number){
    if(this.isFavorite == null){
      (isFav) ? this.imgUrl = "./app/image/star-off.png" :  this.imgUrl = "./app/image/star-on.png";
      console.log("cargar var in null "+this.isFavorite+" Resp service: "+isFav);
    }else{
      if(isFav){
        this.imgUrl = "./app/image/star-off.png";
        this.usuarioService.desmarcarFavorito(id);
        console.log("desmarcar "+isFav+" actor con id: "+id);
      }else{
        this.imgUrl = "./app/image/star-on.png";
        this.usuarioService.marcarFavorito(id);
        console.log("marcar "+isFav+" actor con id: "+id);
      }
    }
    this.isFavorite = !isFav;
  }
}
