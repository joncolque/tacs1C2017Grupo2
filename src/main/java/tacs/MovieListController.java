package tacs;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import ch.qos.logback.core.util.SystemInfo;
import hierarchyOfExceptions.UserNotFoundException;
import model.Actor;
import model.MovieList;
import model.Pelicula;
import model.Response;
import model.Usuario;
import repos.RepoMoviesLists;
import repos.RepoUsuarios;

@RestController
@RequestMapping("/movielist")
public class MovieListController extends AbstractController{

	// Crear lista
	@RequestMapping(method=RequestMethod.POST)
	public void createMovielist(@RequestBody MovieList aMovieList){
		logger.info("createMovieList()");
		RepoMoviesLists.getInstance().addMovieList(aMovieList);
	}
	
	// Agregar pelicula a la lista
	@RequestMapping(value="/{movielist}", method=RequestMethod.PUT)
	public Response addMovieToList(@PathVariable("movielist") long movielist, @RequestBody Pelicula peli){
		logger.info("addMovieList()");
		RepoMoviesLists.getInstance().getMovieList(movielist).addPelicula(peli);
		
		return new Response(200, "Pelicula agregada correctamente");
	}
	
	// Consultar lista de peliculas
	@RequestMapping(value="/{movielist}", method=RequestMethod.GET)
	public List<Pelicula> getMovielistById(@PathVariable("movielist") long movielist){
		logger.info("getMoviesForMoviesListId()");
		
		return RepoMoviesLists.getInstance().getMovieList(movielist).getListaPeliculas();
	}
	
	// Consultar listas
	@RequestMapping(method=RequestMethod.GET)
	public List<MovieList> getList(){
		logger.info("getAllMoviesLists()");

		return RepoMoviesLists.getInstance().getAllMovieLists();
	}
	
	// Eliminar pelicula de la lista
	@RequestMapping(value="/{movielist}/{pelicula}", method=RequestMethod.DELETE)
	public Response deleteMovieFromUserListById(@PathVariable("movielist") long movielist, @PathVariable("pelicula") long pelicula) {
		logger.info("deleteMovieFromUserListId()");
		return new Response(200,"Pelicula borrada de la lista con exito.");
	}
	
	// Comparar dos listas de peliculas
	@RequestMapping(value="/compare", method=RequestMethod.GET)
	public List<Pelicula> getMovielistComparison(@RequestParam("list1") long list1, @RequestParam("list2") long list2) {
		logger.info("getMovielistComparison()");
		List<Pelicula> peliculasEnComun = new ArrayList<Pelicula>();
//		peliculasEnComun.add(RepoPeliculas.getInstance().getPeliculaById(1));
		
		return peliculasEnComun;
	}
	
	// Ranking de actores que se repiten en las peliculas de una lista
	@RequestMapping(value="/{movielist}/actoresRepetidos/", method=RequestMethod.GET)
	public List<Actor> getRankingFromMovie(@PathVariable("movielist") long movielist) {
		logger.info("getRankingFromMovie()");
		List<Actor> actoresFavoritos = new ArrayList<Actor>();
//		actoresFavoritos.add(RepoActores.getInstance().getActorById(0));
		return actoresFavoritos;
	}
}
