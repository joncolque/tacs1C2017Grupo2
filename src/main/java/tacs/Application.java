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

		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Alvaro").pass("1234").rol(adm).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Guille").pass("1234").rol(usr).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Martin").pass("1234").rol(usr).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Julio").pass("1234").rol(usr).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Jon").pass("1234").rol(usr).build());
		
		RepoMoviesLists.getInstance().addMovieList(new MovieList("Lista A", 2l));
		RepoMoviesLists.getInstance().addMovieList(new MovieList("Lista B", 2l));
		RepoMoviesLists.getInstance().addMovieList(new MovieList("Lista C", 1l));
	}
}

