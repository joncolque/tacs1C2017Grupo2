import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Usuario } from './model/usuario';
import { UsuarioDetail } from './model/usuario-detail';
import { SummaryActor } from './model/summary-actor';

@Injectable()
export class UsuarioService {
    constructor(private http: Http) { }

    getUsuarios(): Promise<Usuario[]> {
        let url = `http://localhost:8080/usuarios`;
        return this.http.get(url)
            .toPromise()
            .then(response => response.json() as Usuario[])
            .catch(this.handleError);
    }

    getHero(id: number): Promise<UsuarioDetail> {
        let url = `http://localhost:8080/usuarios/${id}`;
        return this.http.get(url)
            .toPromise()
            .then(response => response.json() as UsuarioDetail)
            .catch(this.handleError);
    }

    getFavoritos(id: number): Promise<SummaryActor[]> {
        let url = `http://localhost:8080/usuarios/${id}/actoresFavoritos`;
        return this.http.get(url)
            .toPromise()
            .then(response => response.json() as SummaryActor[])
            .catch(this.handleError);
    }
    handleError(error: any): Promise<any> {
        console.error('Error retrieving usuarios', error);
        return Promise.reject(error.message || error);
    }
}