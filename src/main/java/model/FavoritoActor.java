package model;

public class FavoritoActor {
	
	private SummaryActor actor;
	private int cantidadFavoritos;
	
	public FavoritoActor(SummaryActor unActor, int unNumero) {
		actor = unActor;
		cantidadFavoritos = unNumero;
	}
	
	public SummaryActor getActor() {
		return actor;
	}
	public void setActor(SummaryActor actor) {
		this.actor = actor;
	}
	public int getCantidadFavoritos() {
		return cantidadFavoritos;
	}
	public void setCantidadFavoritos(int cantidadFavoritos) {
		this.cantidadFavoritos = cantidadFavoritos;
	}
	public void masUnFav() {
		cantidadFavoritos++;
	}

}
