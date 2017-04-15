package model;

import java.util.Date;
import java.util.List;

import apiResult.ActorCastResult;
import apiResult.MovieCastResult;

public class Actor {
	private long id;
	private String nombre;
	private int edad;
	private String biography;
	private String lugarNac;
	private String fechaNac;
	private String imagePath;
	private List<MovieCastResult> listaPeliculas;
	
	
	public Actor(String unNombre,String unBiography, int unaEdad, String unLugar, String unaFecha, String unPath) {
		nombre = unNombre;
		edad = unaEdad;
		biography = unBiography;
		lugarNac = unLugar;
		fechaNac = unaFecha;
		imagePath = unPath;
	}
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<MovieCastResult> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(List<MovieCastResult> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	public long getId() {
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getLugarNac() {
		return lugarNac;
	}
	public void setLugarNac(String lugarNac) {
		this.lugarNac = lugarNac;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public void listMovie(ActorCastResult actorCastR) {
		this.listaPeliculas = actorCastR.getCast();
		
	}
	
}
