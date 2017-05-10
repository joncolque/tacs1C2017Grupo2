import { SummaryActor } from './summary-actor';
import { Rol } from './rol';
import { MovieList } from './movie-list';

export class UsuarioDetail {
    listaMovieList: MovieList[];
    id: number;
    username: string;
    password: string;
    rol: Rol;
    actoresFavoritos: SummaryActor[];
    ultimaSesion: number;
}

