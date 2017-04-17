package apiResult;

import java.util.List;

public class MovieCredits {

	private int id;
	private List<MovieActor> cast;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<MovieActor> getCast() {
		return cast;
	}
	public void setCast(List<MovieActor> cast) {
		this.cast = cast;
	}
	

}
