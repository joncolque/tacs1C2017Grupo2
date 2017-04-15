package tacs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.SessionIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import apiResult.MovieListResult;
import hierarchyOfExceptions.UserNotFoundException;
import model.Actor;
import model.MovieList;
import model.Pelicula;
import model.Response;
import model.Usuario;
import repos.RepoUsuarios;
import model.Usuario;

@RestController
@RequestMapping("/movielist")
public class MovieListController extends AbstractController{

	// Crear lista
	@RequestMapping(method=RequestMethod.POST)
	public void createMovielist(@RequestBody MovieList lista) throws UserNotFoundException {
		logger.info("createMovieList()");
		Usuario user = RepoUsuarios.getInstance().getUserById(lista.getUserId());
	
//		//Required
////		String header = "application/json;charset=utf-8";
//		String sessionId = "&session_id=";
//		
//		api.postForEntity(BASE_URL + "list?" + API_KEY + sessionId , lista, MovieList.class);

		
	}
	
	// Agregar pelicula a la lista
	@RequestMapping(value="/{movielist}", method=RequestMethod.PUT)
	public Response addMovieToList(@PathVariable("movielist") long movielist, @RequestBody long idPelicula) {
		logger.info("addMovieList()");
		return new Response(200,"Pelicula agregada correctamente.");
	}
	
	// Consultar lista de peliculas
	@RequestMapping(value="/{movielist}", method=RequestMethod.GET)
	public List<Pelicula> getMovielistById(@PathVariable("movielist") long movielist) {
		logger.info("getMovielistForUserId()");
		List<Pelicula> listaFavoritos = new ArrayList<Pelicula>();
//		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(1));
//		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(0));
		return listaFavoritos;
	}
	
	// Eliminar pelicula de la lista
	@RequestMapping(value="/{movielist}/{pelicula}", method=RequestMethod.DELETE)
	public Response deleteMovieFromUserListById(@PathVariable("movielist") long movielist, @PathVariable("pelicula") long pelicula) {
		logger.info("deleteMovieFromUserListId()");
		return new Response(200,"Pelicula borrada de la lista con exito.");
	}
	
	// comparar dos listas de peliculas
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
