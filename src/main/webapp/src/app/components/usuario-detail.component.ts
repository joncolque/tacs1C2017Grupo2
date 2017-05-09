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
            <label>Cantidad de Listas: </label> {{usuario.cantidad}}
        </div>
            <div *ngFor="let SummaryActor of listaFavoritos">
               <span>{{SummaryActor.nombre}}</span> 
            </div>
    </div>
    `,
    styles: [`

    `]
})

export class UsuarioDetailComponent implements OnInit {
    usuario: UsuarioDetail;
    listaFavoritos:SummaryActor[];

    constructor(
        private usuarioService: UsuarioService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.usuarioService.getHero(+params['id']))
            .subscribe(usuario => this.usuario = usuario);
        this.route.params
            .switchMap((params: Params) => this.usuarioService.getFavoritos(+params['id']))
            .subscribe(listaFavoritos => this.listaFavoritos = listaFavoritos);
    }

    goBack(): void {
        this.location.back();
    }
}