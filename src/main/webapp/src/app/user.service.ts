import { Injectable } from '@angular/core';
import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class UserService {
  resp: boolean = false;
  actorFavorito(idActor: number): boolean{
    let url = `http://localhost:8080/usuarios/2/actorFavorito/${idActor}`;
    this.http.get(url).
    subscribe(response => { this.resp = response.json() as boolean; 
                         console.log(response.json())});
    return this.resp;
  }

  marcarFavorito(idActor: number){
    let headers = new Headers;
    headers.append('Content-Type', 'application/json');

    let url = `http://localhost:8080/usuarios/2/favorito/${idActor}`;
    this.http.put(url, "" );
    console.log("macarFavorito: "+idActor);
  }  
  handleError(error: any): Promise<any> {
    console.error('Error retrieving favorite', error);
    return Promise.reject(error.message || error);
  }

  constructor(private http: Http) {  }
}
