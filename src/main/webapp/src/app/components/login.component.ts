import { Component,OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { UsuarioService } from './../usuario.service';
import { AlertService } from '../alert.service';
import { UserData } from './../model/user-data';

@Component({
  selector: 'my-login',
  templateUrl: './login.component.html'

})
export class LoginComponent {
  username: string;
  password: string;
  token: string;


  doLogin(): void {

    this.route.params
      .switchMap((params: Params) => this.usuarioService.authenticate(this.username, this.password))
      .subscribe(unString => {
        this.alertService.success("Logueo Satisfactorio");
        this.token = unString;
        //console.log('El token es ' + unString);
        //this.usuarioService.setToken(unString);
        this.userData.setToken(unString);
        this.userData.setUsername(this.username);
        this.router.navigate(["listaPeliculas"]);
        });
  }
   constructor(
    private usuarioService: UsuarioService,
    private alertService: AlertService,
    private route: ActivatedRoute,
    private location: Location,
    private router: Router,
    private userData: UserData) {}
}
