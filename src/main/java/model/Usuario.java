package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class Usuario {
	
	private Long id;
	private String username;
	private String password; //nota va a ser un salted hash a futuro?
	private Rol rol;
	private List<SummaryActor> actoresFavoritos;

	public Usuario(long unId, String unUser, String unaPass) {
		id = unId;
		username = unUser;
		password = unaPass;
		actoresFavoritos = new ArrayList<SummaryActor>();
	}
	
	public Usuario() {
		actoresFavoritos = new ArrayList<SummaryActor>();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
//	public List<MovieList> getListaMovieList() {
//		return listaMovieList;
//	}
	
//	public void setListaPeliculas(List<MovieList> listaPeliculas) {
//		this.listaMovieList = listaPeliculas;
//	}
//	public void addPeliculaToList(Long idLista, Pelicula unaPeli) {
//		getListaPeliculas(idLista).addPelicula(unaPeli);
//	}
//	public void addMovieList(MovieList unMovieList){
//		listaMovieList.add(unMovieList);
//	}
	public List<SummaryActor> getIdsActoresFavoritos() {
		return this.actoresFavoritos;
	}
	public void addIdActorFavorito(SummaryActor unId) {
		this.actoresFavoritos.add(unId);
	}
	public void removeIdActorFavorito(SummaryActor unActor) {
/*		for (SummaryActor actor : actoresFavoritos) {
			if (actor.equals(unId)) {
				actoresFavoritos.remove(actor);
			}
		}*/	
		
		List<SummaryActor> aclist = new ArrayList<>();
		aclist.addAll(this.actoresFavoritos);
		aclist.stream().forEach(ac -> {
			if (ac.getId() == unActor.getId())
				actoresFavoritos.remove(ac);						
		});

//		if (this.actoresFavoritos.stream().anyMatch(ac -> ac.getId()== unActor.getId())){
//			actoresFavoritos.remove(unActor);
		
	}

//	public List<SummaryActor> getActoresFavoritos() {
//		return actoresFavoritos;
//	}
}
