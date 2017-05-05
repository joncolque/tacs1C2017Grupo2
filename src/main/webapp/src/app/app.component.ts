import { Component } from '@angular/core';
import { PeliculasComponent } from './peliculas.component';
import { MovieDetailComponent} from './movie-detail.component';
import { PeliculaService } from './pelicula.service';

@Component({
  selector: 'my-app',
  template: `
    <h1>Show Must Go On</h1>
    <nav>
      <a routerLink="/">Inicio</a>
      <a routerLink="/listaPeliculas">Listas de peliculas</a>
    </nav>
    <router-outlet></router-outlet>
  `
})
export class AppComponent {

}
