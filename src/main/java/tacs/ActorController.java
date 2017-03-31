package tacs;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Actor;
import repos.RepoActores;

@RestController
public class ActorController {
	
	private RepoActores repoActores = RepoActores.getInstance();
	
	@RequestMapping("/actores")
	public List<Actor> getActores() {
		return repoActores.getAllActores();
	}
	
	@RequestMapping("/actor/{id}")
	public Actor getActorById(@PathVariable("id") Long id) {
		return repoActores.getActorById(id);
	}
	
}
