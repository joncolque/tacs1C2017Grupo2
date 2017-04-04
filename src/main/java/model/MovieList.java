package model;

import java.util.ArrayList;
import java.util.List;

import repos.RepoUsuarios;

public class MovieList {
	
	private Long id;
	private String nombre;
	private String owner; //Usuario
	private List<Pelicula> listaPeliculas;
	
	public MovieList() {
		listaPeliculas = new ArrayList<Pelicula>();
	}
	
	public MovieList(String unNombre, String unUsuario) {
		id = 0l;
		nombre = unNombre;
		owner = unUsuario;
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
	public void setId(Long id) {
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
	public void addPelicula(Pelicula p) {
		listaPeliculas.add(p);
	}

}
