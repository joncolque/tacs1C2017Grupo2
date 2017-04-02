package repos;

import java.util.List;

import model.Actor;

import java.util.ArrayList;

public class RepoActores {
	
	private static RepoActores instance;
	private List<Actor> actores = new ArrayList<Actor>();
	private int counter = 0;
	
	public static RepoActores getInstance() {
		if (instance == null) {
			instance = new RepoActores();
		}
		return instance;
	}
	
	public List<Actor> getAllActores() {
		return actores;
	}
	
	public void addActor(Actor unActor) {
		unActor.setId(counter);
		actores.add(unActor);
		counter++;
	}
	
	public Actor getActorById(long unId) {
		return actores.get((int)unId);
	}
	
	public void deleteActor(long unID){
		actores.remove(unID);
	}
	
	public void actualizarActor(Actor actor){
		
	}
}
