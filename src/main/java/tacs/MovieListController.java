package tacs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Actor;
import model.Pelicula;
import model.Response;
import repos.RepoActores;
import repos.RepoPeliculas;

@RestController
@RequestMapping("/movielist")
public class MovieListController {

	// Crear lista
	@RequestMapping(value="/{usuario}", method=RequestMethod.POST)
	public Response createMovielist(@PathVariable("usuario") Long usuario) {
		return new Response(200, "Lista creada exitosamente!");
	}
	
	// Agregar pelicula a la lista
	@RequestMapping(value="/{usuario}", method=RequestMethod.PUT)
	public Response addMovieToList(@PathVariable("usuario") Long usuario) {
		return new Response(200,"Pelicula agregada correctamente.");
	}
	
	// Consultar lista de peliculas
	@RequestMapping(value="/{usuario}", method=RequestMethod.GET)
	public List<Pelicula> getMovielistForUserId(@PathVariable("usuario") Long usuario) {
		List<Pelicula> listaFavoritos = new ArrayList<Pelicula>();
		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(1));
		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(0));
		return listaFavoritos;
	}
	
	// Eliminar pelicula de la lista
	@RequestMapping(value="/{usuario}/{pelicula}", method=RequestMethod.DELETE)
	public Response deleteMovieFromUserListById(@PathVariable("usuario") Long usuario, @PathVariable("pelicula") Long pelicula) {
		return new Response(200,"Pelicula borrada de la lista con exito.");
	}
	
	// Detalle de una pelicula
	@RequestMapping(value="/{usuario}/{pelicula}", method=RequestMethod.GET)
	public Pelicula getMovie(@PathVariable("usuario") Long usuario, @PathVariable("pelicula") Long pelicula) {
		return RepoPeliculas.getInstance().getPeliculaById(pelicula);
	}
	
	// comparar dos listas de peliculas
	@RequestMapping(value="/compare", method=RequestMethod.GET)
	public List<Pelicula> getMovielistComparison(@RequestParam("user1") long usuario1, @RequestParam("user2") long usuario2) {
		List<Pelicula> peliculasEnComun = new ArrayList<Pelicula>();
		peliculasEnComun.add(RepoPeliculas.getInstance().getPeliculaById(1));
		return peliculasEnComun;
	}

	// Ranking de peliculas favoritas de los usuarios
	@RequestMapping(value = "{administrador}/ranking/{idlistMovies}", method = RequestMethod.GET)
	public List<Actor> rakingActores(@PathVariable("administrador") Long administrador, @PathVariable (value = "idlistMovies") Long idlistMovies){
		List<Actor> rankingActores = new ArrayList<Actor>();
		rankingActores = RepoActores.getInstance().getAllActores();
		
		return rankingActores;
	}	
	
	// Lista de peliculas con actores favoritos
	@RequestMapping(value="/{usuario}/actoresFavoritos", method=RequestMethod.GET)
	public List<Pelicula> getMovie(@PathVariable("usuario") Long usuario) {
		List<Pelicula> peliculasFavoritos = new ArrayList<Pelicula>();
		peliculasFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(0));
		return peliculasFavoritos;
	}
	
	// Ranking de actores que se repiten en las peliculas de una lista
	@RequestMapping(value="/{usuario}/ranking/actoresFavoritosDePeliculas", method=RequestMethod.GET)
	public List<Actor> getRankingFromMovie(@PathVariable("usuario") Long usuario) {
		List<Actor> actoresFavoritos = new ArrayList<Actor>();
		actoresFavoritos.add(RepoActores.getInstance().getActorById(0));
		return actoresFavoritos;
	}
	
	// Consultar lista de peliculas
	@RequestMapping(value="/{usuario}/intersection", method=RequestMethod.POST)
	public List<Pelicula> getMovieIntersection(@PathVariable("usuario") Long usuario, @RequestBody RepoPeliculas repo)throws Exception {
		List<Pelicula> listaFavoritos = new ArrayList<Pelicula>();
		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(1));
		return listaFavoritos;
	}
}
