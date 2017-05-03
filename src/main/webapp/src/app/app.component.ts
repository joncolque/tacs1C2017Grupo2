import { Component } from '@angular/core';
import { Pelicula } from './pelicula';
import { PeliculasComponent } from './peliculas.component';
import { MovieDetailComponent} from './movie-detail.component';
import { PeliculaService } from './pelicula.service';

@Component({
  selector: 'my-app',
  template: `
    <listaPeliculas></listaPeliculas>
  `,
  providers: [PeliculaService]
})
export class AppComponent {

}
