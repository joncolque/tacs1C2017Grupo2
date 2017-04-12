package tacs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Actor;
import model.MovieList;
import model.Pelicula;
import model.Response;
import repos.RepoActores;
import repos.RepoPeliculas;

@RestController
@RequestMapping("/movielist")
public class MovieListController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Crear lista
	@RequestMapping(method=RequestMethod.POST)
	public Response createMovielist(@RequestBody MovieList lista) {
	logger.info("createMovieList()");
		return new Response(200, "Lista creada exitosamente!");
	}
	
	// Agregar pelicula a la lista
	@RequestMapping(value="/{movielist}", method=RequestMethod.PUT)
	public Response addMovieToList(@PathVariable("movielist") Long movielist, @RequestBody Long idPelicula) {
		logger.info("addMovieList()");
		return new Response(200,"Pelicula agregada correctamente.");
	}
	
	// Consultar lista de peliculas
	@RequestMapping(value="/{movielist}", method=RequestMethod.GET)
	public List<Pelicula> getMovielistById(@PathVariable("movielist") Long movielist) {
		logger.info("getMovielistForUserId()");
		List<Pelicula> listaFavoritos = new ArrayList<Pelicula>();
		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(1));
		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(0));
		return listaFavoritos;
	}
	
	// Eliminar pelicula de la lista
	@RequestMapping(value="/{movielist}/{pelicula}", method=RequestMethod.DELETE)
	public Response deleteMovieFromUserListById(@PathVariable("movielist") Long movielist, @PathVariable("pelicula") Long pelicula) {
		logger.info("deleteMovieFromUserListId()");
		return new Response(200,"Pelicula borrada de la lista con exito.");
	}
	
	// comparar dos listas de peliculas
	@RequestMapping(value="/compare", method=RequestMethod.GET)
	public List<Pelicula> getMovielistComparison(@RequestParam("list1") long list1, @RequestParam("list2") long list2) {
		logger.info("getMovielistComparison()");
		List<Pelicula> peliculasEnComun = new ArrayList<Pelicula>();
		peliculasEnComun.add(RepoPeliculas.getInstance().getPeliculaById(1));
		return peliculasEnComun;
	}
	
	// Ranking de actores que se repiten en las peliculas de una lista
	@RequestMapping(value="/{movielist}/actoresRepetidos/", method=RequestMethod.GET)
	public List<Actor> getRankingFromMovie(@PathVariable("movielist") Long movielist) {
		logger.info("getRankingFromMovie()");
		List<Actor> actoresFavoritos = new ArrayList<Actor>();
		actoresFavoritos.add(RepoActores.getInstance().getActorById(0));
		return actoresFavoritos;
	}
}
