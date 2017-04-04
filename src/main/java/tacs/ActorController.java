package tacs;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Actor;
import model.Response;
import repos.RepoActores;

@RestController
@RequestMapping("/actores")
public class ActorController {
	
	private RepoActores repoActores = RepoActores.getInstance();
	
	// Lista de actores de un usuario
	@RequestMapping(value="/{usuario}", method = RequestMethod.GET)
	public List<Actor> getActores(@PathVariable("usuario") Long usuario) {
		return repoActores.getAllActores();
	}
	
	// Obtener detalle de un actor de un usuario
	@RequestMapping(value="/{usuario}/{actor}", method = RequestMethod.GET)
	public Actor getActorById(@PathVariable("usuario") Long usuario, @PathVariable("actor") Long actor) {
		return repoActores.getActorById(actor);
	}
	
	// Agregar un Actor de un usuario
	@RequestMapping(value="/{usuario}", method = RequestMethod.POST)
	public Response createActor(@PathVariable("usuario") Long usuario, @RequestBody Actor actorNuevo) throws Exception {
		Actor actor = new Actor();
		actor.setEdad(actorNuevo.getEdad());
		actor.setNombre(actorNuevo.getNombre());
		actor.setFechaNac(actorNuevo.getFechaNac());
		actor.setLugarNac(actorNuevo.getLugarNac());
		repoActores.addActor(actor);
		return new Response(200, "Actor creado exitosamente!"); 
	}
	
	// Actualizar un actor de un usuario
	@RequestMapping(value="/{usuario}", method=RequestMethod.PUT)
	public Response addMovieToList(@PathVariable("usuario") Long usuario, @RequestBody Actor actorModificar) throws Exception {
		Actor actor = repoActores.getActorById(actorModificar.getId());
		repoActores.deleteActor(actorModificar.getId());
		actor.setId(actorModificar.getId());
		actor.setEdad(actorModificar.getEdad());
		actor.setNombre(actorModificar.getNombre());
		actor.setFechaNac(actorModificar.getFechaNac());
		actor.setLugarNac(actorModificar.getLugarNac());
		repoActores.addActor(actor);
		return new Response(200,"Actor agregado correctamente.");
	}
	
	// borrar un actor
	@RequestMapping(value="/{usuario}/{actor}", method = RequestMethod.DELETE)
	public Response deleteActor(@PathVariable("usuario") Long usuario, @PathVariable("actor") Long actor) throws Exception{
		repoActores.deleteActor(actor);
		return new Response(200,"Actor borrado correctamente.");
	}
	
	// Marcar como favorito a un actor
	@RequestMapping(value = "/{usuario}/favorito/{actor}", method = RequestMethod.PUT)
	public Response addActorFavorito(@PathVariable("usuario") Long usuario, @PathVariable("actor") Long actor) {
		return new Response(200, "Marcar como Actor Favorito");
	}
	
	// Desmarcar como favorito a un actor
	@RequestMapping(value = "/{usuario}/favorito/{actor}", method = RequestMethod.DELETE)
	public Response removeActorFavorito(@PathVariable("usuario") Long usuario, @PathVariable("actor") Long actor) {
		return new Response(200, "Desmarcar como Actor Favorito");
	}

	// Lista de actores favoritos
	@RequestMapping(value = "/{usuario}/actoresFavoritos", method = RequestMethod.GET)
	public List<Actor> getActoresFavoritos(){
		List<Actor> actoresFavoritos = new ArrayList<Actor>();
		actoresFavoritos = RepoActores.getInstance().getAllActores();
		return actoresFavoritos;
	}	
	
}
