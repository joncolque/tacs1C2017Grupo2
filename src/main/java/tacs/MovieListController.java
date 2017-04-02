package tacs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Pelicula;
import model.Response;
import repos.RepoPeliculas;

@RestController
public class MovieListController {

	@RequestMapping(value="/movielist", method=RequestMethod.POST)
	public Response createMovielist() {
		return new Response(200, "Lista creada exitosamente!");
	}
	
	@RequestMapping(value="/movielist", method=RequestMethod.PUT)
	public Response addMovieToList() {
		return new Response(200,"Pelicula agregada correctamente.");
	}
	
	@RequestMapping(value="/movielist/{usuario}", method=RequestMethod.GET)
	public List<Pelicula> getMovielistForUserId(@PathVariable("usuario") Long usuario) {
		List<Pelicula> listaFavoritos = new ArrayList<Pelicula>();
		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(1));
		listaFavoritos.add(RepoPeliculas.getInstance().getPeliculaById(0));
		
		return listaFavoritos;
	}
	
	@RequestMapping(value="/movielist/{usuario}/{pelicula}", method=RequestMethod.DELETE)
	public Response deleteMovieFromUserListById(@PathVariable("usuario") Long usuario, @PathVariable("pelicula") Long pelicula) {
		return new Response(200,"Pelicula borrada de la lista con exito.");
	}
	
	@RequestMapping(value="/movielist/compare", method=RequestMethod.GET)
	public List<Pelicula> getMovielistComparison(@RequestParam("user1") long usuario1, @RequestParam("user2") long usuario2) {
		List<Pelicula> peliculasEnComun = new ArrayList<Pelicula>();
		peliculasEnComun.add(RepoPeliculas.getInstance().getPeliculaById(1));
		
		return peliculasEnComun;
	}
	
}
