package tacs;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Actor;
import model.FavoritoActor;
import model.Response;
import repos.RepoActores;
import repos.RepoPeliculas;

@RestController
@RequestMapping("/actores")
public class ActorController {
	
	private RepoActores repoActores = RepoActores.getInstance();
	
	// Lista de actores de un usuario
	@RequestMapping(method = RequestMethod.GET)
	public List<Actor> getActores() {
		return repoActores.getAllActores();
	}
	
	// Obtener detalle de un actor de un usuario
	@RequestMapping(value="/{actor}", method = RequestMethod.GET)
	public Actor getActorById(@PathVariable("actor") Long actor) {
		return repoActores.getActorById(actor);
	}
	
	// Ranking de actores favoriteados
	@RequestMapping(value = "/rankingFavoritos", method = RequestMethod.GET)
	public List<FavoritoActor> rankingActores(){
		List<FavoritoActor> rankingActores = new ArrayList<FavoritoActor>();
		rankingActores.add(new FavoritoActor(RepoActores.getInstance().getActorById(1), 5));
		rankingActores.add(new FavoritoActor(RepoActores.getInstance().getActorById(0), 3));
		rankingActores.add(new FavoritoActor(RepoActores.getInstance().getActorById(2), 2));
		return rankingActores;
	}
	
}
