package model;

import java.util.List;

import apiResult.MovieResult;

public class SummaryActor {
	
	private int id;
	private String imagePath;
	private String nombre;
	
	public SummaryActor() {
		
	}
	
	public SummaryActor(int unId, String unPath, String unNombre) {
		id = unId;
		imagePath = unPath;
		nombre = unNombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
