package tacs;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apiResult.MovieListResult;
import apiResult.MovieResult;
import model.Pelicula;
import model.Response;
import repos.RepoPeliculas;

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
	public Pelicula getPeliculaById(@PathVariable("id") Long id) {
		logger.info("getPeliculaById()");
		MovieResult pelicula = api.getForObject(BASE_URL + "/movie/" + id.toString() + "?" + API_KEY, MovieResult.class);
		return pelicula.toMovie();
	}
	
	// Lista de peliculas con varios actores favoritos de un usuario
	@RequestMapping(value="/actoresFavoritos/{usuario}", method=RequestMethod.GET)
	public List<Pelicula> getMovie(@PathVariable("usuario") Long usuario) {
		logger.info("getMovie()");
		List<Pelicula> peliculasFavoritos = new ArrayList<Pelicula>();
		peliculasFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(0));
		return peliculasFavoritos;
	}

}
