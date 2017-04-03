package tacs;

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
public class ActorController {
	
	private RepoActores repoActores = RepoActores.getInstance();
	
	// Lista de actores
	@RequestMapping(value="/actores", method = RequestMethod.GET)
	public List<Actor> getActores() {
		return repoActores.getAllActores();
	}
	
	// Obtener un actor
	@RequestMapping(value="/actores/{usuario}/{id}", method = RequestMethod.GET)
	public Actor getActorById(@PathVariable("usuario") Long usuario, @PathVariable("id") Long id) {
		return repoActores.getActorById(id);
	}
	
	// Agregar un Actor
	@RequestMapping(value="/actores", method = RequestMethod.POST)
	public Response createActor(@RequestBody Actor actorNuevo) throws Exception {
		Actor actor = new Actor();
		actor.setEdad(actorNuevo.getEdad());
		actor.setNombre(actorNuevo.getNombre());
		actor.setFechaNac(actorNuevo.getFechaNac());
		actor.setLugarNac(actorNuevo.getLugarNac());
		repoActores.addActor(actor);
		return new Response(200, "Actor creado exitosamente!"); 
	}
	
	// Actualizar un actor
	@RequestMapping(value="/actores", method=RequestMethod.PUT)
	public Response addMovieToList(@RequestBody Actor actorModificar) throws Exception {
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
	@RequestMapping(value="/actores/{id}", method = RequestMethod.DELETE)
	public Response deleteActor(@PathVariable("id") Long id) throws Exception{
		repoActores.deleteActor(id);
		return new Response(200,"Actor borrado correctamente.");
	}
	
}
