import { Injectable } from '@angular/core';
import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Pelicula } from './model/pelicula';
import { MovieDetail } from './model/movie-detail';

@Injectable()
export class PeliculaService {
  getMovies(): Promise<Pelicula[]> {
    return this.http.get('http://localhost:8080/peliculas')
      .toPromise()
      .then(response => response.json() as Pelicula[])
      .catch(this.handleError);
  }

  getMovie(id: number): Promise<MovieDetail> {
    let url = `http://localhost:8080/peliculas/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as MovieDetail)
      .catch(this.handleError);
  }

  handleError(error: any): Promise<any> {
    console.error('Error retrieving movies', error);
    return Promise.reject(error.message || error);
  }

  constructor(private http: Http) {  }
}
