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
	}
}

