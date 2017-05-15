package model;

import java.util.List;

import apiResult.MovieResult;

public class SummaryActor {
	
	private int id;
	private String imagePath;
	private String nombre;
	
	public SummaryActor() {
		
	}
	
	/**
	 * Constructor de SummaryActor
	 * @param unId
	 * @param unPath
	 * @param unNombre
	 */
	public SummaryActor(int unId, String unPath, String unNombre) {
		id = unId;
		imagePath = unPath;
		nombre = unNombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SummaryActor other = (SummaryActor) obj;
		if (id != other.id)
			return false;
		return true;
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
