import { MovieActor } from './movie-actor';
import { Review } from './review';

export class MovieDetail {
  id: number;
  nombre: string;
  nacionalidad: string;
  anioEstreno: string;
  descripcion: string;
  imagePath: string;
  cast: MovieActor[];
  reviews: Review[];
}
