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
var http_1 = require("@angular/http");
require("rxjs/add/operator/toPromise");
var usuario_service_1 = require("./usuario.service");
var ActorService = (function () {
    function ActorService(http, usuarioService) {
        this.http = http;
        this.usuarioService = usuarioService;
    }
    ActorService.prototype.getActor = function (id) {
        var url = "http://localhost:8080/actores/" + id;
        return this.http.get(url)
            .toPromise()
            .then(function (response) {
            return response.json();
        })
            .catch(this.handleError);
    };
    ActorService.prototype.getActorByString = function (query) {
        var url = "http://localhost:8080/actores?query=" + query;
        return this.http.get(url)
            .toPromise()
            .then(function (response) { return response.json(); })
            .catch(this.handleError);
    };
    ActorService.prototype.getActoresFavoritos = function (token) {
        var headers = new http_1.Headers;
        headers.append('Authorization', '' + token);
        var url = "http://localhost:8080/actores/rankingFavoritos";
        return this.http.get(url, headers)
            .toPromise()
            .then(function (response) { return response.json(); })
            .catch(this.handleError);
    };
    ActorService.prototype.handleError = function (error) {
        console.error('Error retrieving movies', error);
        return Promise.reject(error.message || error);
    };
    return ActorService;
}());
ActorService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http, usuario_service_1.UsuarioService])
], ActorService);
exports.ActorService = ActorService;
//# sourceMappingURL=actor.service.js.map