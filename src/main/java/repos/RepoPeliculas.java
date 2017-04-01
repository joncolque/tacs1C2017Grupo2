package repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import model.Pelicula;

@Component
public class RepoPeliculas {

	private static RepoPeliculas instance;
	private List<Pelicula> Peliculas = new ArrayList<Pelicula>();
	private int counter = 0;
	
	public static RepoPeliculas getInstance() {
		if (instance == null) {
			instance = new RepoPeliculas();
		}
		return instance;
	}
	
	public List<Pelicula> getAllPeliculas() {
		return Peliculas;
	}
	
	public void addPelicula(Pelicula unPelicula) {
		unPelicula.setId(counter);
		Peliculas.add(unPelicula);
		counter++;
	}
	
	public Pelicula getPeliculaById(long unId) {
		return Peliculas.get((int)unId);
	}
}
