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
	idLista1: number;
	idLista2: number;
	movieLists: MovieList[];
	dropDownMovieLists: MovieList[];
	actoresFavoritos: ActorFavorito[];
	peliculasActoresFavoritos: Pelicula[];
	encontro: boolean;

//crear lista de peliculas 
crearClick(): void {
	let user = 1;
	this.movieListService.createMovieList(this.nombreLista, user);
	
	this.nombreLista = "Lista creada exitosamente";
}

textReset(): void {
  this.nombreLista = "";
}

//movielists de un user o de todos si es admin
verListas(): void {
	this.actoresFavoritos = null;
	this.peliculasActoresFavoritos = null;
	
	//Para Admin(ve todas)
	/*
	  this.movieListService.getMovieLists()
		.then(movieLists => {if(movieLists.length==0){
								this.encontro=false;
							}else{
								this.movieLists = movieLists;
								this.encontro=true;
							});
    */
	
	//Para user: asignar user logueado
	let user = 1;
	this.movieListService.getMovieListsByUser(user)
		.then(movieLists => {if(movieLists.length==0){
								this.encontro = false;
							}else{
								this.movieLists = movieLists;
								this.encontro = true;
							}});
}

//actores favoritos del usuario
verActoresFavoritos(): void {
	this.movieLists = null;
	this.peliculasActoresFavoritos = null;
	
	//Para user: asignar user logueado
	let user = 1;
	this.movieListService.getActoresFavoritos(user)
		.then(actores => {if(actores.length==0){
							this.encontro=false;
						 }else{
							this.actoresFavoritos = actores;
							this.encontro=true;
						 }});
}

//peliculas con mas de un actor favorito
verPeliculasVariosActoresFavoritos(): void{
	this.movieLists = null;
	this.actoresFavoritos = null;
	
	let user = 1;

	this.movieListService.getPeliculasVariosActoresFavoritos(user)
		.then(peliculas => {if(peliculas.length == 0){
								this.encontro=false;
							}else{
								this.peliculasActoresFavoritos = peliculas;
								this.encontro=true;
							}});
}

//interseccion de peliculas entre dos listas
verInterseccion(): void {
	console.log(this.idLista1);
	console.log(this.idLista2);

	if(this.idLista1==null || this.idLista2==null){
		console.log('Seleccione una lista');
	}else{
		this.movieListService.getInterseccion(this.idLista1, this.idLista2);
	}
	
}

setLista1(idMovie: number): void {
	this.idLista1=idMovie;
}

setLista2(idMovie: number): void {
	this.idLista2=idMovie;
}

ngOnInit(): void {
  this.encontro=true;
  this.idLista1=null;
  this.idLista2=null;
  let user = 1;
	this.movieListService.getMovieListsByUser(user)
		.then(movieLists => {this.dropDownMovieLists = movieLists;});
}

constructor(private movieListService: MovieListService) {
	
}

}
