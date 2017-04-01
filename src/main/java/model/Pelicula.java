package model;



public class Pelicula {
	private long id;
	private String nombre;
	private String Nacionalidad;
	private int anioEstreno;

	public Pelicula(String nombre, String nacionalidad, int anioEstreno) {
		this.nombre = nombre;
		Nacionalidad = nacionalidad;
		this.anioEstreno = anioEstreno;
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
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public int getanioEstreno() {
		return anioEstreno;
	}
	public void setanioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	
}
