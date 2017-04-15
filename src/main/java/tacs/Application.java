package tacs;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import apiResult.Configuration;
import creacionales.UsuarioBuilder;
import model.Actor;
import model.Pelicula;
import model.Rol;
import model.Usuario;
import repos.RepoActores;
import repos.RepoPeliculas;
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
		
		RepoActores.getInstance().addActor(new Actor("Tom Cruise","Tom Cruise biography", 50, "New York, USA", new Date(30, 10, 1950).toString(), "Tom Cruise Image"));
		RepoActores.getInstance().addActor(new Actor("Jeremy Renner","Jeremy Renner biography", 42, "New Jersey, USA", new Date(15, 8, 1958).toString(), "Jeremy Renner Image"));
		RepoActores.getInstance().addActor(new Actor("Ricardo Darin","Ricardo Darin biography", 53, "Buenos Aires, ARG", new Date(3, 3, 1947).toString(), "Ricardo Darin Image"));
		
		
		RepoPeliculas.getInstance().addPelicula(new Pelicula("Noé", "USA", "2014"));
		RepoPeliculas.getInstance().addPelicula(new Pelicula("The Matrix", "USA", "1999"));
		RepoPeliculas.getInstance().addPelicula(new Pelicula("Moana", "USA", "2016"));
	}
}

