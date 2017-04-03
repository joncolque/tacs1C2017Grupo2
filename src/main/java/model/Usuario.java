package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private long id;
	private String username;
	private String password; //nota va a ser un salted hash a futuro?
	private List<Pelicula> listaPeliculas;
	private Rol rol;

	public Usuario(long unId, String unUser, String unaPass) {
		id = unId;
		username = unUser;
		password = unaPass;
		listaPeliculas = new ArrayList<Pelicula>();
	}
	
	public Usuario() {
		listaPeliculas = new ArrayList<Pelicula>();
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
	public Rol getRole() {
		return rol;
	}

	public void setRole(Rol role) {
		this.rol = role;
	}
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	public void addPeliculaToList(Pelicula unaPeli) {
		this.listaPeliculas.add(unaPeli);
	}
}
