import { Component } from '@angular/core';
import { PeliculasComponent } from './components/peliculas.component';
import { MovieDetailComponent} from './components/movie-detail.component';
import { PeliculaService } from './pelicula.service';

@Component({
  selector: 'my-app',
  template: `
    <div class="navbar-fixed">
    <nav class="teal lighten-2">
    <div class="nav-wrapper">
       <a href="#" class="brand-logo black-text right" style="margin-right:10%">Show Must Go On</a>
       <ul id="nav-mobile" class="left hide-on-med-and-down" style="margin-left:5%;">
         <li><a class="black-text" routerLink="/">Inicio</a></li>
         <li><a class="black-text" routerLink="/crearLista">Crear lista de peliculas</a></li>
         <li><a class="black-text" routerLink="/listaPeliculas">Ver mis listas de peliculas</a></li>
       </ul>
    </div>
    </nav>
    </div>
    
    <router-outlet></router-outlet>
  `
})
export class AppComponent {

}
