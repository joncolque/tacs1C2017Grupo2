import { Component,OnInit } from '@angular/core';

import { MovieListService } from './../movie-list.service';
import { MovieList } from './../model/movie-list';


@Component({
  selector: 'movie-list',
  templateUrl: './partials/movie-list.component.html',
})
export class MovieListComponent implements OnInit {
	nombreLista: string;
	nombreLista1: number;
	nombreLista2: number;
	idLista: number;
	idPelicula: number;
	movieLists: MovieList[];
	

crearClick(): void {
	this.movieListService.createMovieList(this.nombreLista);
	
	this.nombreLista = "Lista creada exitosamente";
}

agregarPeliculaClick():void{
	this.movieListService.addMovieToList(this.idLista,this.idPelicula);
}

textReset(): void {
  this.nombreLista = "";
}

verListas(): void {
    this.movieListService.getMovieLists().then(movieLists => {this.movieLists = movieLists;});
}

verInterseccion(): void {
	this.movieListService.getInterseccion(this.nombreLista1, this.nombreLista2);
}

ngOnInit(): void {
  
}

constructor(private movieListService: MovieListService) {
	
}

}
