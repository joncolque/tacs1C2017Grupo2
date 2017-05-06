package apiResult;

import java.util.List;

import model.SummaryActor;
import tacs.ConfigHolder;

public class SummaryActorResult {

	private int id;
	private boolean adult;
	private String profile_path;
	private String name;
	private int popularity;
	private List<MovieResult> known_for;
	
	public SummaryActorResult() {
		
	}
	
	public SummaryActor toSumActor() {
		String path;
		if (profile_path == null) {
			path = null;
		} else {
			path = ConfigHolder.getInstance().getConfig().getImages().getBase_url() + "w300/" + profile_path;
		}
		return new SummaryActor(id, path, name);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getProfile_path() {
		return profile_path;
	}
	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public List<MovieResult> getKnown_for() {
		return known_for;
	}
	public void setKnown_for(List<MovieResult> known_for) {
		this.known_for = known_for;
	}	
	
}
