import { Component,OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { UsuarioService } from './../usuario.service';

@Component({
  selector: 'my-login',
  template: `
      <h2>Ingrese su usuario y contraseña:</h2>
      <form>
          <div><label> User Name : <input type="text" name="username" [(ngModel)]="username"/> </label></div>
          <div><label> Password: <input type="password" name="password" [(ngModel)]="password"/> </label></div>
          <button (click)="doLogin()" class="btn waves-effect black-text">Log in</button>
      </form>
    `

})
export class LoginComponent {
  username: string;
  password: string;
  token: string;

  doLogin(): void {
    this.route.params
      .switchMap((params: Params) => this.usuarioService.authenticate(this.username, this.password))
      .subscribe(unString => {this.token = unString; console.log('El token es ' + unString); this.usuarioService.setToken(unString);});
  }

  constructor(private usuarioService: UsuarioService, private route: ActivatedRoute, private location: Location) {}
}
