import { Injectable } from '@angular/core';
import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Pelicula } from './model/pelicula';
import { MovieDetail } from './model/movie-detail';
import { MovieList } from './model/movie-list'

import { Headers, RequestOptions } from '@angular/http';

@Injectable()
export class MovieListService {
	
	getMovieLists(): Promise<MovieList[]> {
		return this.http.get('http://localhost:8080/movielists')
	      .toPromise()
	      .then(response => response.json() as MovieList[])
	      .catch(this.handleError);
	}
	
  getMovies(): Promise<Pelicula[]> {
    return this.http.get('http://localhost:8080/peliculas')
      .toPromise()
      .then(response => response.json() as Pelicula[])
      .catch(this.handleError);
  }
  
  createMovieList(nombre: string, id: number): Observable<MovieList>{
	  let url = `http://localhost:8080/movielists`;
		  let headers = new Headers({ 'Content-Type': 'application/json' });
	    let options = new RequestOptions({ headers: headers });

	    return this.http.post(url, { nombre }, options)
	                    .map(this.extractData)
	                    .catch(this.handleError);
  }

  getMovieList(id: number): Promise<MovieList> {
    let url = `http://localhost:8080/movielists/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as MovieList)
      .catch(this.handleError);
  }

  getMoviesByString(query: string): Promise<Pelicula[]> {
    let url= `http://localhost:8080/peliculas?query=${query}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Pelicula[])
      .catch(this.handleError);
  }

  handleError(error: any): Promise<any> {
    console.error('Error creando lista', error);
    return Promise.reject(error.message || error);
  }

  constructor(private http: Http) {  }
}
