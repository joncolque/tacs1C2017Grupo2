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
import repos.RepoUsuarios;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		ConfigHolder.getInstance();

		Rol adm = new Rol("Administrador");
		Rol usr = new Rol("Usuario");
		
		MovieList ml = new MovieList("Lista Alvarada",2);
		
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Alvaro").pass("1234").rol(adm).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Guille").pass("1234").rol(usr).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Martin").pass("1234").rol(usr).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Julio").pass("1234").rol(usr).build());
		
		try {
			RepoUsuarios.getInstance().getUserById(2).addMovieList(ml);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

