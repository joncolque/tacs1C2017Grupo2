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
        this.peliculaService.getMovies().then(function (movies) { return _this.movies = movies; });
    };
    PeliculasComponent.prototype.ngOnInit = function () {
        this.getPeliculas();
    };
    return PeliculasComponent;
}());
PeliculasComponent = __decorate([
    core_1.Component({
        selector: 'listaPeliculas',
        template: "\n    <h1>Peliculas: </h1>\n    <ul class=\"movies\">\n      <li *ngFor=\"let movie of movies\">\n        <img src=\"{{movie.imagePath}}\"/>\n        <h2><a [routerLink]=\"['/pelicula', movie.id]\">{{movie.nombre}}</a> ({{movie.anioEstreno}})</h2>\n        <span>{{movie.descripcion}}</span>\n      </li>\n    </ul>\n  ",
    }),
    __metadata("design:paramtypes", [pelicula_service_1.PeliculaService])
], PeliculasComponent);
exports.PeliculasComponent = PeliculasComponent;
//# sourceMappingURL=peliculas.component.js.map