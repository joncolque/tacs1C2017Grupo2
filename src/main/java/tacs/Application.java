package tacs;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import apiResult.Configuration;
import creacionales.UsuarioBuilder;
import hierarchyOfExceptions.UserNotFoundException;
import model.Actor;
import model.MovieList;
import model.Pelicula;
import model.Rol;
import model.SummaryActor;
import model.Usuario;
import repos.RepoMoviesLists;
import repos.RepoUsuarios;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		ConfigHolder.getInstance();

		Rol adm = new Rol("Administrador");
		Rol usr = new Rol("Usuario");

		SummaryActor actorFavorito = new SummaryActor(1,"algo","Tom Hanks");
		Usuario guille = new UsuarioBuilder("Guille").pass("1234").rol(usr).build();
		guille.addIdActorFavorito(actorFavorito);
		Pelicula peli1 = new Pelicula("Matrix", "eeuu", "1997");
		Pelicula peli2 = new Pelicula("Matrix2", "eeuu", "2002");
		MovieList movielist1 = new MovieList("Lista A", 2l);
		movielist1.addPelicula(peli1);
		MovieList movielist2 = new MovieList("Lista B", 2l);
		movielist2.addPelicula(peli2);
		
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Alvaro").pass("1234").rol(adm).build());
		RepoUsuarios.getInstance().addUsuario(guille);
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("martin").pass("1234").rol(adm).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Julio").pass("1234").rol(usr).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Jon").pass("1234").rol(usr).build());
		
		RepoMoviesLists.getInstance().addMovieList(movielist1);
		RepoMoviesLists.getInstance().addMovieList(movielist2);
		RepoMoviesLists.getInstance().addMovieList(new MovieList("Lista C", 1l));
	}
}

