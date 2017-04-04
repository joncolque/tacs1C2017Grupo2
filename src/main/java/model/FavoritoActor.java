package model;

public class FavoritoActor {
	
	private Actor actor;
	private int cantidadFavoritos;
	
	public FavoritoActor(Actor unActor, int unNumero) {
		actor = unActor;
		cantidadFavoritos = unNumero;
	}
	
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public int getCantidadFavoritos() {
		return cantidadFavoritos;
	}
	public void setCantidadFavoritos(int cantidadFavoritos) {
		this.cantidadFavoritos = cantidadFavoritos;
	}

}
