import { SummaryActor } from './summary-actor';
import { Rol } from './rol';

export class Usuario {
  id: number;
  username: string;
  password: string;
  rol: Rol;
  actoresFavoritos: SummaryActor[];
  ultimaSesion: number;
}