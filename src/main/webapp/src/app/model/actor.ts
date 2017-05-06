import { MovieCastResult } from './movie-cast-result';

export class Actor {
  id: number;
  nombre: string;
  biography: string;
  lugarNac: string;
  fechaNac: string;
  imagePath: string;
  listaPeliculas: MovieCastResult[];
}
