"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var PeliculaService = (function () {
    function PeliculaService() {
    }
    PeliculaService.prototype.getMovies = function () {
        return Promise.resolve(PELICULAS);
    };
    return PeliculaService;
}());
PeliculaService = __decorate([
    core_1.Injectable()
], PeliculaService);
exports.PeliculaService = PeliculaService;
var PELICULAS = [
    { id: 1, nombre: "Matrix", nacionalidad: "en", anioEstreno: "1993", descripcion: "Pelicula sobre un loco con poderes", imagePath: "" },
    { id: 2, nombre: "Matrix 2", nacionalidad: "en", anioEstreno: "1994", descripcion: "Pelicula sobre un loco con poderes 2", imagePath: "" },
    { id: 3, nombre: "Matrix 3", nacionalidad: "en", anioEstreno: "1995", descripcion: "Pelicula sobre un loco con poderes 3", imagePath: "" }
];
//# sourceMappingURL=pelicula.service.js.map