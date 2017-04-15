package model;

import java.util.ArrayList;
import java.util.List;

import repos.RepoUsuarios;

public class MovieList {
	
	private Long id;
	private String nombre;
	private Long ownerId; //Usuario
	private List<Pelicula> listaPeliculas;
	
	public MovieList() {
		listaPeliculas = new ArrayList<Pelicula>();
	}
	
	public MovieList(String unNombre, long unUserId) {
		id = 0l;
		nombre = unNombre;
		ownerId = unUserId;
//		try {
//			owner = RepoUsuarios.getInstance().buscarUsuario(unUsuario);
//		} catch(Exception e) {
//			owner = null;
//		}
		
		listaPeliculas = new ArrayList<Pelicula>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	public Long getOwnerId() {
		return ownerId;
	}

	public void setUserId(long userId) {
		this.ownerId = userId;
	}

	public void addPelicula(Pelicula p) {
		listaPeliculas.add(p);
	}

}
