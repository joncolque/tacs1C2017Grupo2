package model;



public class Pelicula {
	private long id;
	private String nombre;
	private String nacionalidad;
	private String anioEstreno;
	private String descripcion;

	public Pelicula(String nombre, String nacionalidad, String anioEstreno) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.anioEstreno = anioEstreno;
	}
	public Pelicula(long id, String nombre, String nacionalidad, String anioEstreno, String desc) {
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.anioEstreno = anioEstreno;
		this.descripcion = desc;
	}
	
	public Pelicula(){
		
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public String getanioEstreno() {
		return anioEstreno;
	}
	public void setanioEstreno(String anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	
}
