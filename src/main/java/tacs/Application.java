package tacs;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.Actor;
import model.Pelicula;
import repos.RepoActores;
import repos.RepoPeliculas;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		RepoActores.getInstance().addActor(new Actor("Tom Cruise", 50, "New York, USA", new Date(30, 10, 1950)));
		RepoActores.getInstance().addActor(new Actor("Jeremy Renner", 42, "New Jersey, USA", new Date(15, 8, 1958)));
		RepoActores.getInstance().addActor(new Actor("Ricardo Darin", 53, "Buenos Aires, ARG", new Date(3, 3, 1947)));
		
		
		RepoPeliculas.getInstance().addPelicula(new Pelicula("Noé", "USA", 2014));
		RepoPeliculas.getInstance().addPelicula(new Pelicula("The Matrix", "USA", 1999));
		RepoPeliculas.getInstance().addPelicula(new Pelicula("Moana", "USA", 2016));
	}
}

