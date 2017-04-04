package tacs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import creacionales.UsuarioBuilder;
import model.Actor;
import model.Response;
import model.Rol;
import model.Usuario;
import repos.RepoActores;
import repos.RepoPeliculas;
import repos.RepoUsuarios;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	// Lista de Usuarios
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> getActores() {
		return RepoUsuarios.getInstance().getAllUsuarios();
	}	
	
	// Mostrar Detalle de un usuario
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Usuario getActorById(@PathVariable("id") Long id) {
		return new Usuario(id, "alumnos-utn", "123456");
	}
	
	// Crear nuevo usuario
	@RequestMapping(method = RequestMethod.POST)
	public Usuario add(@RequestBody Usuario user) {
		RepoUsuarios.getInstance().addUsuario(user);
		return user;
	}
	
	// Lista de actores favoritos
	@RequestMapping(value = "/{usuario}/actoresFavoritos", method = RequestMethod.GET)
	public List<Actor> getActoresFavoritos(){
		List<Actor> actoresFavoritos = new ArrayList<Actor>();
		actoresFavoritos = RepoActores.getInstance().getAllActores();
		return actoresFavoritos;
	}		
	
	// Marcar como favorito a un actor
	@RequestMapping(value = "/{usuario}/favorito/{actor}", method = RequestMethod.PUT)
	public Response addActorFavorito(@PathVariable("usuario") Long usuario, @PathVariable("actor") Long actor) {
		return new Response(200, "Accion realizada correctamente");
	}
}
