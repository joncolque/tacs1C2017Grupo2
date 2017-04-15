package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Usuario {
	
	private Long id;
	private String username;
	private String password; //nota va a ser un salted hash a futuro?
	private List<MovieList> listaMovieList;
	private Rol rol;
	private List<SummaryActor> actoresFavoritos;

	public Usuario(long unId, String unUser, String unaPass) {
		id = unId;
		username = unUser;
		password = unaPass;
		listaMovieList = new ArrayList<MovieList>();
		actoresFavoritos = new ArrayList<SummaryActor>();
	}
	
	public Usuario() {
		listaMovieList = new ArrayList<MovieList>();
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
	public List<MovieList> getListaMovieList() {
		return listaMovieList;
	}
	public MovieList getListaPeliculas(long idLista) {
		Optional<MovieList> lista = listaMovieList.stream().filter(ml -> ml.getId()==idLista).findFirst();
		return lista.isPresent() ? lista.get() : null;
	}
	
	public void setListaPeliculas(List<MovieList> listaPeliculas) {
		this.listaMovieList = listaPeliculas;
	}
	public void addPeliculaToList(Long idLista, Pelicula unaPeli) {
		getListaPeliculas(idLista).addPelicula(unaPeli);
	}
	public List<SummaryActor> getIdsActoresFavoritos() {
		return this.actoresFavoritos;
	}
	public void addIdActorFavorito(SummaryActor unId) {
		this.actoresFavoritos.add(unId);
	}
	public void removeIdActorFavorito(SummaryActor unId) {
		for (SummaryActor actor : actoresFavoritos) {
			if (actor.equals(unId)) {
				actoresFavoritos.remove(actor);
			}
		}
	}
	public void addMovieList(MovieList unMovieList){
		listaMovieList.add(unMovieList);
	}

}
