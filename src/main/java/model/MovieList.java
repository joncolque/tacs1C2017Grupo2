package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieList {
	
	private Long id;
	private String nombre;
	private Long ownerId; //Usuario
	private List<Pelicula> listaPeliculas;

	public MovieList() {
		listaPeliculas = new ArrayList<Pelicula>();
	}
	
	public MovieList(String unNombre, Long unUserId) {
		nombre = unNombre;
		ownerId = unUserId;
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
	public Long getOwnerId() {
		return ownerId;
	}

	public void setUserId(long userId) {
		this.ownerId = userId;
	}

	public void addPelicula(Pelicula p) {
		listaPeliculas.add(p);
	}
	
	//Devuelve una lista de peliculas que se encuentran en el objeto actual y el recibido por parametro
	public List<Pelicula> interseccion(MovieList movielist){
		List<Pelicula> interseccion = new ArrayList<Pelicula>();
		
		boolean esta = false;
		
		for (Pelicula peli : listaPeliculas) {
			Iterator<Pelicula> itPelis = movielist.getListaPeliculas().iterator(); 
			while (itPelis.hasNext() && !esta) {
				Pelicula peliAux = (Pelicula) itPelis.next();
				if (peli.getId() == peliAux.getId()){
					esta=true;
					interseccion.add(peli);
				}
			}
			esta=false;
		}
		return interseccion;
	}

}
