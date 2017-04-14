package tacs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Lista de Usuarios
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> getUsuarios() {
		logger.info("getUsuarios()");
		return RepoUsuarios.getInstance().getAllUsuarios();
	}	
	
	// Mostrar Detalle de un usuario
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Usuario getUsuarioById(@PathVariable("id") long id) {
		logger.info("getUsuarioById()");
		return new Usuario(id, "alumnos-utn", "123456");
	}
	
	// Crear nuevo usuario
	@RequestMapping(method = RequestMethod.POST)
	public Response addUser(@RequestBody Usuario user) {
		logger.info("addUser()");
		RepoUsuarios.getInstance().addUsuario(user);
		return new Response(201, "El usuario " + user.getUsername() + " ha sido creado");
	}
	
	// Lista de actores favoritos
	@RequestMapping(value = "/{usuario}/actoresFavoritos", method = RequestMethod.GET)
	public List<Actor> getActoresFavoritos(){
		logger.info("getActoresFacvoritos()");
		List<Actor> actoresFavoritos = new ArrayList<Actor>();
		actoresFavoritos = RepoActores.getInstance().getAllActores();
		return actoresFavoritos;
	}		
	
	// Marcar como favorito a un actor
	@RequestMapping(value = "/{usuario}/favorito/{actor}", method = RequestMethod.PUT)
	public Response addActorFavorito(@PathVariable("usuario") long usuario, @PathVariable("actor") long actor) {
		logger.info("addActorFavorito()");
		return new Response(200, "Accion realizada correctamente");
	}
	
	// Desmarcar como favorito a un actor
	@RequestMapping(value = "/{usuario}/favorito/{actor}", method = RequestMethod.DELETE)
	public Response removeActorFavorito(@PathVariable("usuario") long usuario, @PathVariable("actor") long actor) {
		logger.info("removeActorFavorito()");
		return new Response(200, "Accion realizada correctamente");
	}
}
