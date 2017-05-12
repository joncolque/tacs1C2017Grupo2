"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
require("rxjs/add/operator/switchMap");
var Login = (function () {
    function Login() {
    }
    return Login;
}());
exports.Login = Login;
var LoginComponent = (function () {
    function LoginComponent() {
        this.login = {
            username: '',
            password: ''
        };
    }
    LoginComponent.prototype.doLogin = function () {
    };
    return LoginComponent;
}());
LoginComponent = __decorate([
    core_1.Component({
        selector: 'my-login',
        template: "\n      <h2>Ingrese su usuario y contrase\u00F1a:</h2>\n      <form>\n          <div><label> User Name : <input type=\"text\" name=\"username\" [(ngModel)]=\"username\"/> </label></div>\n          <div><label> Password: <input type=\"password\" name=\"password\" [(ngModel)]=\"password\"/> </label></div>\n          <button (click)=\"doLogin()\" class=\"btn waves-effect black-text\">Log in</button>\n      </form>\n    "
    })
], LoginComponent);
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login.component.js.map