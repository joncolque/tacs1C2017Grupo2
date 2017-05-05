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
var pelicula_service_1 = require("./../pelicula.service");
var PeliculasComponent = (function () {
    function PeliculasComponent(peliculaService) {
        this.peliculaService = peliculaService;
    }
    PeliculasComponent.prototype.getPeliculas = function () {
        var _this = this;
        this.peliculaService.getMovies().then(function (movies) { _this.movies = movies; _this.baseMovies = movies; });
    };
    PeliculasComponent.prototype.searchClick = function () {
        var _this = this;
        this.peliculaService.getMoviesByString(this.searchString).then(function (movies) { return _this.movies = movies; });
    };
    PeliculasComponent.prototype.searchReset = function () {
        this.movies = this.baseMovies;
        this.searchString = "";
    };
    PeliculasComponent.prototype.ngOnInit = function () {
        this.getPeliculas();
    };
    return PeliculasComponent;
}());
PeliculasComponent = __decorate([
    core_1.Component({
        selector: 'listaPeliculas',
        template: "\n    <h1>Peliculas: </h1>\n    <div class=\"row\">\n      <input [(ngModel)]=\"searchString\" placeholder=\"Ingrese texto a buscar...\"/>\n      <button (click)=\"searchClick()\" class=\"btn waves-effect black-text\">Buscar</button>\n      <button (click)=\"searchReset()\" class=\"btn waves-effect black-text\">Limpiar busqueda</button>\n    </div>\n\n    <ul class=\"movies black-text\">\n      <li *ngFor=\"let movie of movies\">\n      <div class=\"row\">\n        <div class=\"card horizontal teal lighten-2\">\n          <div class=\"card-image\">\n          <img src=\"{{movie.imagePath}}\"/><br/>\n          </div>\n          <div class=\"card-stacked\">\n          <div class=\"card-content\">\n            <span class=\"card-title center-align\"><a class=\"blue-text text-darken-4\" [routerLink]=\"['/pelicula', movie.id]\">{{movie.nombre}}</a> ({{movie.anioEstreno}})</span>\n            <span class=\"valign-wrapper\">{{movie.descripcion}}</span>\n          </div>\n          </div>\n        </div>\n      </div>\n      </li>\n    </ul>\n  ",
    }),
    __metadata("design:paramtypes", [pelicula_service_1.PeliculaService])
], PeliculasComponent);
exports.PeliculasComponent = PeliculasComponent;
//# sourceMappingURL=peliculas.component.js.map