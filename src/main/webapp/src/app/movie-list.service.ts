import { Injectable } from '@angular/core';
import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Pelicula } from './model/pelicula';
import { MovieDetail } from './model/movie-detail';
import { MovieList } from './model/movie-list'

@Injectable()
export class MovieListService {
	results:Object[];
	loading:boolean;

	getMovieLists(): Promise<MovieList[]> {
		return this.http.get('http://localhost:8080/movielists')
	      .toPromise()
	      .then(response => response.json() as MovieList[])
	      .catch(this.handleError);
	}	
  
  createMovieList(body: Object): void{
	  let url = 'http://localhost:8080/movielists';
	  let bodyString = JSON.stringify(body);
		  let headers = new Headers({ 'Content-Type': 'application/json' });
	    let options = new RequestOptions({ headers: headers });

	    return this.http.post(this.commentsUrl, body, options) // ...using post request
                .map((res:Response) => res.json()) // ...and calling .json() on the response to return data
                .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  }   
	    	        

  getMovieList(id: number): Promise<MovieList> {
    let url = `http://localhost:8080/movielists/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as MovieList)
      .catch(this.handleError);
  }

  getInterseccion(list1: number, list2: number) {
	  let promise = new Promise((resolve, reject) => {
		    let url = `http://localhost:8080/movielists/compare?list1=${list1}&list2=${list2}`;
		    this.http.get(url)
		      .toPromise()
		      .then(
		        res => { // Success
		        
		          this.results = res.json() as Pelicula[];
		          
		          resolve();
		        },
		        msg =>{ //Error
		        	reject(msg);
		        }
		      );
		  });
	  return promise;
  }
  
  
  handleError(error: any): Promise<any> {
    console.error('Error', error);
    return Promise.reject(error.message || error);
  }

  constructor(private http: Http) {
	  this.results = [];
	  this.loading = false;
  }
}
