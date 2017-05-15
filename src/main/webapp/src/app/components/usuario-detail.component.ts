import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { UsuarioDetail } from '../model/usuario-detail';
import { UsuarioService } from '../usuario.service';
import { SummaryActor } from '../model/summary-actor';

@Component({
    selector: 'usuario-detail',
    template: `
    <div *ngIf="usuario">
            <h2>{{usuario.name}} Detalle de {{usuario.username}}</h2>
        <div>
            <label>id: </label>{{usuario.id}}
        </div>
        
        <div>
            <label>Nombre: </label> {{usuario.username}}
        </div>

        <div>
            <label>Cantidad de Listas: </label> {{usuario.listaMovieList.length}}
        </div>

        <div>
            <label> Cantidad de Actores Favoritos: </label> {{usuario.actoresFavoritos.length}}
        </div>

        <div>
            <label> Ultima Sesion: </label> {{usuario.ultimaSesion | date:'medium' }}
        </div>
        <div>
            <div *ngFor="let movieList of usuario.listaMovieList">
            <label> Detalle de Lista: </label> 
            <span>{{movieList.nombre}}</span>
                <li *ngFor="let pelicula of movieList.listaPeliculas">
                <label> Detalle de Pelicula: </label> 
                <span>{{pelicula.nombre}}</span>
                </li>
            </div>
        </div>
    </div>
    `,
    styles: [`

    `]
})

export class UsuarioDetailComponent implements OnInit {
    usuario: UsuarioDetail;

    constructor(
        private usuarioService: UsuarioService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.usuarioService.getUsuario(+params['id']))
            .subscribe(usuario => this.usuario = usuario);
    }

    goBack(): void {
        this.location.back();
    }
}