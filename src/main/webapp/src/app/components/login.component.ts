import { Component,OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';


export class Login{
  username: string;
  password: string;
}

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
  login: Login = {
    username: '',
    password: ''
  };

  doLogin(): void {

  }
}
