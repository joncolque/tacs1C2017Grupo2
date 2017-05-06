import { Injectable } from '@angular/core';
import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Pelicula } from './model/pelicula';
import { MovieDetail } from './model/movie-detail';
import { Actor } from './model/actor';
import { SummaryActor } from './model/summary-actor';

@Injectable()
export class ActorService {

  getActor(id: number): Promise<Actor> {
    let url = `http://localhost:8080/actores/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Actor)
      .catch(this.handleError);
  }

  getActorByString(query: string): Promise<SummaryActor[]> {
    let url= `http://localhost:8080/actores?query=${query}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as SummaryActor[])
      .catch(this.handleError);
  }

  handleError(error: any): Promise<any> {
    console.error('Error retrieving movies', error);
    return Promise.reject(error.message || error);
  }

  constructor(private http: Http) {  }
}
