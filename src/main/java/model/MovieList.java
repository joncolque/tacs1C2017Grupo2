package model;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
	
	private Long id;
	private String nombre;
	private Long ownerId; //Usuario
	private List<Pelicula> listaPeliculas;
	private static int counter = 1;	
	
	public static int getCounter() {
		return counter;
	}


	public MovieList() {
		listaPeliculas = new ArrayList<Pelicula>();
	}
	
	public MovieList(String unNombre, long unUserId) {
		this.id = (long) counter;
		nombre = unNombre;
		ownerId = unUserId;
		listaPeliculas = new ArrayList<Pelicula>();
		counter++;
	}
	
	public Long getId() {
		return id;
	}
	public void setId() {
		this.id = (long) counter;
		counter++;
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
