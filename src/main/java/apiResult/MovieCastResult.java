package apiResult;

import model.Pelicula;
import tacs.ConfigHolder;

public class MovieCastResult {

	private String character;
	private int id;
	private String original_title;
	
	//GETTERS and SETTERS
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	
	//METODOS
	public MovieCastResult(){
		
	}
	
}
