package tacs;

import java.util.ArrayList;
import java.util.List;

import apiResult.MovieResult;
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
import repos.RepoMoviesLists;
import repos.RepoUsuarios;
import util.LongsWrapper;

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
	@RequestMapping(value="/{movielistId}/{movieId}", method=RequestMethod.PUT)
	public Response addMovieToList(@PathVariable("movielistId") long movielistId, @PathVariable Long movieId){ //@RequestBody Pelicula peli){
		try {
			MovieResult pelicula = api.getForObject(BASE_URL + "/movie/" + movieId.toString() + "?" + API_KEY, MovieResult.class);
			MovieList movieList = RepoMoviesLists.getInstance().getMovieList(movielistId);
			movieList.addPelicula(pelicula.toMovie());
			logger.info("addMovieList()");
		}catch (Exception e){
			logger.error("Usuario inexistente");
		}
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
		
	// Eliminar varias peliculas de la lista
	@RequestMapping(value="/{movieListId}", method=RequestMethod.DELETE)
	public void deleteMovieFromUserListById(@PathVariable("movieListId") long movieListId, @RequestBody LongsWrapper idMovies) {
		logger.info("deleteMoviesFromUserListbyId()");
		
		idMovies.getIds().stream().forEach(mId ->
		RepoMoviesLists.getInstance().getMovieList(movieListId).getListaPeliculas().removeIf(mv -> mv.getId()==mId));
		
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
