package tacs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Pelicula;
import repos.RepoPeliculas;

@RestController
@RequestMapping("/peliculas")
public class MovieController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Pelicula> getPeliculas() {
		logger.info("getPeliculas()");
		return RepoPeliculas.getInstance().getAllPeliculas();
	}
	
	@RequestMapping("/{id}")
	public Pelicula getPeliculaById(@PathVariable("id") Long id) {
		logger.info("getPeliculaById()");
		return RepoPeliculas.getInstance().getPeliculaById(id);
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
