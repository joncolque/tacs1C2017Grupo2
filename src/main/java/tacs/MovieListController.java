package tacs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apiResult.MovieResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.MovieList;
import model.Pelicula;
import model.Ranking;
import model.Response;
import repos.RepoMoviesLists;
import repos.RepoUsuarios;
import util.LongsWrapper;
import util.Sort;

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
	
	// Consultar MovieList
	@RequestMapping(value="/{movielist}", method=RequestMethod.GET)
	public MovieList getMovielistById(@PathVariable("movielist") long movielist){
		logger.info("getMoviesForMoviesListId()");
		
		return RepoMoviesLists.getInstance().getMovieList(movielist);
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
		logger.info("getMovielistComparison()" + "Listas: " +list1 + " - "+ list2);
		
		return RepoMoviesLists.getInstance().getMovieList(list1).interseccion(RepoMoviesLists.getInstance().getMovieList(list2));
	}
	
	// Ranking de actores que se repiten en las peliculas de una lista
	@RequestMapping(value="/actoresRepetidos/{movieListId}", method=RequestMethod.GET)
	public Map<String,Integer> getRankingFromActorsByMovies(@PathVariable("movieListId") long movieListId) {
		logger.info("getRankingFromMovie()");

		List<Pelicula> ml = RepoMoviesLists.getInstance().getMovieList(movieListId).getListaPeliculas();
		Ranking rk = new Ranking();
		ml.forEach(p-> {
			rk.processRankingFromActorByMovieList(Connection.getActorsMovie(Long.toString(p.getId())));
		} );
		
		Map<String,Integer> ran = new HashMap<String,Integer>();
		
		rk.getRankingFromActorsByMovies().forEach((k,v)-> {
			ran.put(v.getName(),v.getCount());
		});

		return Sort.sortByValue(ran);
	}
}
