package model;



public class Pelicula {
	private long id;
	private String nombre;
	private String nacionalidad;
	private int anioEstreno;

	public Pelicula(String nombre, String nacionalidad, int anioEstreno) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.anioEstreno = anioEstreno;
	}
	
	public Pelicula(){
		
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
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getanioEstreno() {
		return anioEstreno;
	}
	public void setanioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	
}
