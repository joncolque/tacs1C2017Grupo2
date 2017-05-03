import { Injectable } from '@angular/core';
import { Pelicula } from './pelicula';

@Injectable()
export class PeliculaService {
  getMovies(): Promise<Pelicula[]> {
    return Promise.resolve(PELICULAS);
  }
}

const PELICULAS: Pelicula[] = [
  {id:1,nombre:"Matrix",nacionalidad:"en",anioEstreno:"1993", descripcion:"Pelicula sobre un loco con poderes", imagePath:""},
  {id:2,nombre:"Matrix 2",nacionalidad:"en",anioEstreno:"1994", descripcion:"Pelicula sobre un loco con poderes 2", imagePath:""},
  {id:3,nombre:"Matrix 3",nacionalidad:"en",anioEstreno:"1995", descripcion:"Pelicula sobre un loco con poderes 3", imagePath:""}
]
