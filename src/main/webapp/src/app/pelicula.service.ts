import { Injectable } from '@angular/core';
import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Pelicula } from './model/pelicula';

@Injectable()
export class PeliculaService {
  getMovies(): Promise<Pelicula[]> {
    return this.http.get('http://localhost:8080/peliculas')
      .toPromise()
      .then(response => response.json() as Pelicula[])
      .catch(this.handleError);
  }

  getMovie(id: number): Promise<Pelicula> {
    let url = `http://localhost:8080/peliculas/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Pelicula)
      .catch(this.handleError);
  }

  handleError(error: any): Promise<any> {
    console.error('Error retrieving movies', error);
    return Promise.reject(error.message || error);
  }

  constructor(private http: Http) {  }
}

const PELICULAS: Pelicula[] = [
  {id:1,nombre:"Matrix",nacionalidad:"en",anioEstreno:"1993", descripcion:"Pelicula sobre un loco con poderes", imagePath:""},
  {id:2,nombre:"Matrix 2",nacionalidad:"en",anioEstreno:"1994", descripcion:"Pelicula sobre un loco con poderes 2", imagePath:""},
  {id:3,nombre:"Matrix 3",nacionalidad:"en",anioEstreno:"1995", descripcion:"Pelicula sobre un loco con poderes 3", imagePath:""}
]
