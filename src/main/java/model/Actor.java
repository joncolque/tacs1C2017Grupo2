package model;

import java.util.Date;

public class Actor {
	private long id;
	private String nombre;
	private int edad;
	private String lugarNac;
	private String fechaNac;
	
	public Actor(String unNombre, int unaEdad, String unLugar, String unaFecha) {
		nombre = unNombre;
		edad = unaEdad;
		lugarNac = unLugar;
		fechaNac = unaFecha;
	}
	
	public Actor() {
		// TODO Auto-generated constructor stub
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
	
}
