"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var movie_list_service_1 = require("./../movie-list.service");
var MovieListComponent = (function () {
    function MovieListComponent(movieListService) {
        this.movieListService = movieListService;
    }
    MovieListComponent.prototype.crearClick = function () {
        var user = 2;
        this.movieListService.createMovieList(this.nombreLista, user);
        this.nombreLista = "Lista creada exitosamente";
    };
    MovieListComponent.prototype.agregarPeliculaClick = function () {
        this.movieListService.addMovieToList(this.idLista, this.idPelicula);
        this.idLista = null;
        this.idPelicula = null;
    };
    MovieListComponent.prototype.textReset = function () {
        this.nombreLista = "";
    };
    MovieListComponent.prototype.verListas = function () {
        var _this = this;
        this.actoresFavoritos = null;
        this.peliculasActoresFavoritos = null;
        //Para Admin(ve todas)
        //this.movieListService.getMovieLists().then(movieLists => {this.movieLists = movieLists;});
        //Para user: asignar user logueado
        var user = 2;
        this.movieListService.getMovieListsByUser(user).then(function (movieLists) { _this.movieLists = movieLists; });
    };
    MovieListComponent.prototype.verActoresFavoritos = function () {
        var _this = this;
        this.movieLists = null;
        this.peliculasActoresFavoritos = null;
        //Para user: asignar user logueado
        var user = 2;
        this.movieListService.getActoresFavoritos(user).then(function (actores) { _this.actoresFavoritos = actores; });
    };
    MovieListComponent.prototype.verPeliculasVariosActoresFavoritos = function () {
        var _this = this;
        this.movieLists = null;
        this.actoresFavoritos = null;
        var user = 2;
        console.log('lista de peliculas con mas de un actor favorito');
        console.log(this.movieListService.getPeliculasVariosActoresFavoritos(user)
            .then(function (peliculas) { _this.peliculasActoresFavoritos = peliculas; }));
    };
    MovieListComponent.prototype.verInterseccion = function () {
        this.movieListService.getInterseccion(this.nombreLista1, this.nombreLista2);
    };
    MovieListComponent.prototype.ngOnInit = function () {
    };
    return MovieListComponent;
}());
MovieListComponent = __decorate([
    core_1.Component({
        selector: 'movie-list',
        templateUrl: './partials/movie-list.component.html',
    }),
    __metadata("design:paramtypes", [movie_list_service_1.MovieListService])
], MovieListComponent);
exports.MovieListComponent = MovieListComponent;
//# sourceMappingURL=movie-list.component.js.map