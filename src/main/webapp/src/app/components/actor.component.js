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
var router_1 = require("@angular/router");
var common_1 = require("@angular/common");
require("rxjs/add/operator/switchMap");
var pelicula_service_1 = require("./../pelicula.service");
var ActorComponent = (function () {
    function ActorComponent(peliculaService, route, location) {
        this.peliculaService = peliculaService;
        this.route = route;
        this.location = location;
    }
    ActorComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.params
            .switchMap(function (params) { return _this.peliculaService.getMovie(+params['id']); })
            .subscribe(function (pelicula) { _this.movie = pelicula; console.log("Pelicula: " + JSON.stringify(_this.movie)); });
        //    this.route.params.switchMap((params: Params) => { this.parametros = (+params['id']) });
    };
    return ActorComponent;
}());
ActorComponent = __decorate([
    core_1.Component({
        selector: 'actor',
        template: "\n    <div *ngIf=\"actor\" class=\"center-align\">\n      <div class=\"card-panel teal lighten-2 black-text\">\n        <h2>{{actor.nombre}}</h2>\n        <img src=\"{{actor.imagePath}}\"/><br/>\n\n        <span>{{actor.biography}}</span>\n      </div>\n\n      <div class=\"card-panel teal lighten-2 black-text\">\n        <h3>Actores:</h3>\n        <div class=\"container\">\n        <table class=\"centered\">\n        <thead>\n        <tr>\n          <th>Nombre</th>\n          <th>Personaje</th>\n        </tr>\n        </thead>\n        <tbody>\n        <tr *ngFor=\"let actor of movie.cast\">\n          <td>{{actor.name}}</td>\n          <td>{{actor.character}}</td>\n        </tr>\n        </tbody>\n        </table>\n        </div>\n      </div>\n\n      <div class=\"card-panel teal lighten-2 black-text\">\n      <h3>Rese\u00F1as:</h3>\n      <ul class=\"resenas\">\n      <li *ngFor=\"let review of movie.reviews\">\n        <h5>{{review.author}} dice:</h5>\n        <span>{{review.content}}</span>\n      </li>\n      </ul>\n      </div>\n    </div>\n  "
    }),
    __metadata("design:paramtypes", [pelicula_service_1.PeliculaService, router_1.ActivatedRoute, common_1.Location])
], ActorComponent);
exports.ActorComponent = ActorComponent;
//# sourceMappingURL=actor.component.js.map