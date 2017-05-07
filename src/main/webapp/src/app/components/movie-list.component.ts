import { Component,OnInit } from '@angular/core';

import { MovieListService } from './../movie-list.service';

@Component({
  selector: 'movie-list',
  templateUrl: './partials/movie-list.component.html',
})
export class MovieListComponent implements OnInit {
	nombreLista: string;
	movieLists: MovieList[];

crearClick(): void {
	//this.movieListService.createMovieList(this.nombreLista, 2);
	//this.nombreLista = "Lista creada exitosamente";
}

textReset(): void {
  this.nombreLista = "";
}

verListas(): void {
    this.movieListService.getMovieLists().then(movieLists => {this.movieLists = movieLists;});
}

ngOnInit(): void {
  
}

constructor(private movieListService: MovieListService) { }

}
