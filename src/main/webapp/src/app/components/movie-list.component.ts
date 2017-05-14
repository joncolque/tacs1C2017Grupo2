import { Component,OnInit } from '@angular/core';

import { MovieListService } from './../movie-list.service';
import { MovieList } from './../model/movie-list';
import { ActorFavorito } from './../model/actor-favorito';
import { Pelicula } from './../model/pelicula';



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
	actoresFavoritos: ActorFavorito[];
	peliculasActoresFavoritos: Pelicula[];
	

crearClick(): void {
	let user = 2;
	this.movieListService.createMovieList(this.nombreLista, user);
	
	this.nombreLista = "Lista creada exitosamente";
}

agregarPeliculaClick():void{
	this.movieListService.addMovieToList(this.idLista,this.idPelicula);
	this.idLista=null;
	this.idPelicula=null;
}

textReset(): void {
  this.nombreLista = "";
}

verListas(): void {
	this.actoresFavoritos = null;
	this.peliculasActoresFavoritos = null;
	
	//Para Admin(ve todas)
	//this.movieListService.getMovieLists().then(movieLists => {this.movieLists = movieLists;});
    
	//Para user: asignar user logueado
	let user = 2;
	this.movieListService.getMovieListsByUser(user).then(movieLists => {this.movieLists = movieLists;});
}

verActoresFavoritos(): void {
	this.movieLists = null;
	this.peliculasActoresFavoritos = null;
	
	//Para user: asignar user logueado
	let user = 2;
	this.movieListService.getActoresFavoritos(user).then(actores => {this.actoresFavoritos = actores;});
}

verPeliculasVariosActoresFavoritos(): void{
	this.movieLists = null;
	this.actoresFavoritos = null;
	
	let user = 2;

	console.log('lista de peliculas con mas de un actor favorito');
	console.log(this.movieListService.getPeliculasVariosActoresFavoritos(user)
		.then(peliculas => {this.peliculasActoresFavoritos = peliculas;}));
}

verInterseccion(): void {
	this.movieListService.getInterseccion(this.nombreLista1, this.nombreLista2);
}

ngOnInit(): void {
  
}

constructor(private movieListService: MovieListService) {
	
}

}
