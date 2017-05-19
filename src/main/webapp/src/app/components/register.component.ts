import { Component } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { UsuarioService } from './../usuario.service';
import { AlertService } from '../alert.service';
import { UserData } from './../model/user-data';

@Component({
    moduleId: module.id,
    templateUrl: './register.component.html'
})

export class RegisterComponent {
    model: any = {};
    loading = false;
    username: string;
    password: string;
    error: string;
    message: string;


    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private usuarioService: UsuarioService,
        private alertService: AlertService,
        private userData: UserData
    ) { }

    register() {
        this.loading = true;
        this.route.params
      .switchMap((params: Params) => this.usuarioService.register(this.username, this.password))
      .subscribe(result => {
        if (result) {
          this.alertService.success("Registrado satisfactoriamente");
          this.userData.setUsername(this.username);
          this.router.navigate(["login"]);
        } else {
          this.error = "No se ha podido registrar. Intente mas tarde";
        }
      }, error => this.error = "No se ha podido registrar. Intente mas tarde");
 
    }
}
