package tacs;

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
import org.springframework.web.client.RestTemplate;

import apiResult.Configuration;
import apiResult.MovieListResult;
import apiResult.MovieResult;
import model.Pelicula;
import model.Response;
import repos.RepoPeliculas;

@RestController
@RequestMapping("/peliculas")
public class MovieController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private RestTemplate api = new RestTemplate();
	private final String baseUri = "https://api.themoviedb.org/3/";
	private final String apiKey = "api_key=3eb489d424860bc6870dc6776d05f6b9";
	
	//Buscar peliculas, si no se especifica un filtro trae las populares del momento
	@RequestMapping(method = RequestMethod.GET)
	public List<Pelicula> getPeliculas(@RequestParam("query") Optional<String> queryString) {
		logger.info("getPeliculas()");
		if (queryString.isPresent()) {
			logger.info("Request url: " + baseUri + "search/movie?" + apiKey + "&query=" + queryString.get());
			MovieListResult resultadoRequest = api.getForObject(baseUri + "search/movie?" + apiKey + "&query=" + queryString.get(), MovieListResult.class);
			return resultadoRequest.toMovieList();
		}
		
		MovieListResult resultadoRequest = api.getForObject(baseUri + "/movie/popular?" + apiKey, MovieListResult.class);
		return resultadoRequest.toMovieList();
	}
	
	@RequestMapping("/{id}")
	public Pelicula getPeliculaById(@PathVariable("id") Long id) {
		logger.info("getPeliculaById()");
		MovieResult pelicula = api.getForObject(baseUri + "/movie/" + id.toString() + "?" + apiKey, MovieResult.class);
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
