package tacs;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apiResult.ActorCastResult;
import apiResult.MovieActor;
import apiResult.MovieCastResult;
import apiResult.MovieCredits;
import apiResult.MovieDetailResult;
import apiResult.MovieListResult;
import apiResult.MovieResult;
import model.MovieDetail;
import model.Pelicula;
import model.Response;
import repos.RepoMoviesLists;
import repos.RepoUsuarios;
import util.General;

@RestController
@RequestMapping("/peliculas")
public class MovieController extends AbstractController{
	
	//Buscar peliculas, si no se especifica un filtro trae las populares del momento
	@RequestMapping(method = RequestMethod.GET)
	public List<Pelicula> getPeliculas(@RequestParam("query") Optional<String> queryString) {
		if (queryString.isPresent()) {
			logger.info("Request url: " + BASE_URL + "search/movie?" + API_KEY + "&query=" + queryString.get());
			MovieListResult resultadoRequest = api.getForObject(BASE_URL + "search/movie?" + API_KEY + "&query=" + queryString.get(), MovieListResult.class);
			return resultadoRequest.toMovieList();
		}
		
		MovieListResult resultadoRequest = api.getForObject(BASE_URL + "/movie/popular?" + API_KEY, MovieListResult.class);
		return resultadoRequest.toMovieList();
	}
	
	@RequestMapping("/{id}")
	public MovieDetail getFullMovieById(@PathVariable("id") Long id) {
		return api.getForObject(BASE_URL + "/movie/" + id.toString() + "?" + API_KEY + "&append_to_response=credits,reviews", MovieDetailResult.class).toFullMovie();
	}
	
	
	public Pelicula getPeliculaById(Long id) {
		logger.info("getPeliculaById()");
		MovieResult pelicula = api.getForObject(BASE_URL + "/movie/" + id.toString() + "?" + API_KEY, MovieResult.class);
		return pelicula.toMovie();
	}
	
	// Lista de peliculas con varios actores favoritos de un usuario
	@RequestMapping(value="/actoresFavoritos/{usuario}", method=RequestMethod.GET)
	public List<Pelicula> getMovie(@PathVariable("usuario") Long usuario) {
		List<Pelicula> peliculasFavoritos = new ArrayList<Pelicula>();
		List<Integer> listaTentativa = new ArrayList<Integer>();
		
		List<Integer> idsActoresFavoritosList = new ArrayList<Integer>();
		try {
			RepoUsuarios.getInstance().getUserById(usuario).getIdsActoresFavoritos().forEach((af)->idsActoresFavoritosList.add(af.getId()));
		} catch(Exception e) {
			logger.error("Error pasando los ids de int a long!");
		}
		

		ActorCastResult resultadoRequest;
		for (Integer id : idsActoresFavoritosList) {
			logger.info("Request: " + BASE_URL + "/person/" + id + "/movie_credits?" + API_KEY);
			resultadoRequest = api.getForObject(BASE_URL + "/person/" + id + "/movie_credits?" + API_KEY, ActorCastResult.class);
			for(MovieCastResult m : resultadoRequest.getCast()) {
				listaTentativa.add(m.getId());
			}
		}
		
		Set<Integer> peliculasDondeHayMasDeUno = General.findDuplicateIntegers(listaTentativa);

		for(Integer p : peliculasDondeHayMasDeUno) {
			logger.info("Se agrega pelicula: " + p + "/" + p.longValue());
			peliculasFavoritos.add(getPeliculaById(p.longValue())); 
		}
		
		return peliculasFavoritos;
	}

}
