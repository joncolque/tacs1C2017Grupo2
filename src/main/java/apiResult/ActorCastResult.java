package apiResult;

import java.util.List;

public class ActorCastResult {

	private List<MovieCastResult> cast;
	private String id;
	

	public List<MovieCastResult> getCast() {
		return cast;
	}
	public void setCast(List<MovieCastResult> cast) {
		this.cast = cast;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public ActorCastResult(){
		
	}
}
