package tacs;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Pelicula;
import repos.RepoPeliculas;

@RestController
public class PeliculaController {

	
	private RepoPeliculas repoPeliculas = RepoPeliculas.getInstance();

	@RequestMapping("/peliculas")
	public List<Pelicula> getpeliculas() {
		return repoPeliculas.getAllPeliculas();
	}
	
	@RequestMapping("/peliculas/{id}")
	public Pelicula getActorById(@PathVariable("id") Long id) {
		return repoPeliculas.getPeliculaById(id);
	}	
}
