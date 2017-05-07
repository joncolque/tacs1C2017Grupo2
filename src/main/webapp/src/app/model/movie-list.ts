import { Pelicula } from './pelicula';

export class MovieList {
	id: number;
	nombre: string;
	ownerId: number; 
	listaPeliculas: Pelicula[];
}
