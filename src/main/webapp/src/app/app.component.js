"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var AppComponent = (function () {
    function AppComponent() {
    }
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'my-app',
        template: "\n    <div class=\"navbar-fixed\">\n    <nav class=\"teal lighten-2\">\n    <div class=\"nav-wrapper\">\n       <a href=\"#\" class=\"brand-logo black-text right\" style=\"margin-right:10%\">Show Must Go On</a>\n       <ul id=\"nav-mobile\" class=\"left hide-on-med-and-down\" style=\"margin-left:5%;\">\n         <li><a class=\"black-text\" routerLink=\"/\">Inicio</a></li>\n         <li><a class=\"black-text\" routerLink=\"/crearLista\">Crear lista de peliculas</a></li>\n         <li><a class=\"black-text\" routerLink=\"/listaPeliculas\">Ver mis listas de peliculas</a></li>\n       </ul>\n    </div>\n    </nav>\n    </div>\n    \n    <router-outlet></router-outlet>\n  "
    })
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map