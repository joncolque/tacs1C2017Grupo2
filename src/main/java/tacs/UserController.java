package tacs;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import creacionales.UsuarioBuilder;
import hierarchyOfExceptions.UserNotFoundException;
import model.Actor;
import model.Response;
import model.Rol;
import model.SummaryActor;
import model.Usuario;
import repos.RepoUsuarios;

@RestController
@RequestMapping("/usuarios")
public class UserController extends AbstractController{
	
	@Autowired
	private ActorController controladorActores;
	
	// Lista de Usuarios
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> getUsuarios() {
		logger.info("getUsuarios()");
		return RepoUsuarios.getInstance().getAllUsuarios();
	}	
	
	// Mostrar Detalle de un usuario
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Usuario getUsuarioById(@PathVariable("id") long id) throws UserNotFoundException {
		logger.info("getUsuarioById()");
		Usuario user = RepoUsuarios.getInstance().getUserById(id);
		return user;
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
	public List<SummaryActor> getActoresFavoritos(@PathVariable("usuario") long id) {
		logger.info("getActoresFacvoritos()");
		List<SummaryActor> actoresFavoritos = new ArrayList<SummaryActor>();
		Usuario user;
		try {
			user = RepoUsuarios.getInstance().getUserById(id);
		} catch(UserNotFoundException e) {
			logger.error("Usuario inexistente");
			return null;
		}
		return user.getIdsActoresFavoritos();
	}		
	
	// Marcar como favorito a un actor
	@RequestMapping(value = "/{usuario}/favorito/{actor}", method = RequestMethod.PUT)
	public Response addActorFavorito(@PathVariable("usuario") long usuario, @PathVariable("actor") long actor) {
		logger.info("addActorFavorito()");
		
		try {
			RepoUsuarios.getInstance().getUserById(usuario).addIdActorFavorito(controladorActores.getSumActorById(actor));
		} catch(UserNotFoundException e) {
			logger.error(e.getMessage());
			return new Response(404, "Usuario inexistente");
		}
		
		return new Response(200, "Accion realizada correctamente");
	}
	
	// Desmarcar como favorito a un actor
	@RequestMapping(value = "/{usuario}/favorito/{actor}", method = RequestMethod.DELETE)
	public Response removeActorFavorito(@PathVariable("usuario") long usuario, @PathVariable("actor") long actor) {
		logger.info("removeActorFavorito()");
		try {
			RepoUsuarios.getInstance().getUserById(usuario).removeIdActorFavorito(controladorActores.getSumActorById(actor));
		} catch(UserNotFoundException e) {
			logger.error(e.getMessage());
			return new Response(404, "Usuario inexistente");
		}
		
		return new Response(200, "Accion realizada correctamente");
	}
}
