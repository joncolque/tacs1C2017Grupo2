package apiResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Actor;
import model.Pelicula;
import tacs.ConfigHolder;

public class ActorResult {

	private boolean adult;
	private String biography;
	private String birthday;
	private String deathday;
	private int gender;
	private String homepage;
	private int id;
	private String name;
	private String place_of_birth;
	private int popularity;
	private String profile_path;
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// GETTERS and SETTERS
	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeathday() {
		return deathday;
	}

	public void setDeathday(String deathday) {
		this.deathday = deathday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace_of_birth() {
		return place_of_birth;
	}

	public void setPlace_of_birth(String place_of_birth) {
		this.place_of_birth = place_of_birth;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String getProfile_path() {
		return profile_path;
	}

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

	//METODOS
	public ActorResult(){
		
	}
	
	public Actor toActor(){
		String path;
		if (profile_path == null) {
			path = null;
		} else {
			path = ConfigHolder.getInstance().getConfig().getImages().getBase_url() + "w300/" + profile_path;
		}
		Actor ac = new Actor(name, biography, place_of_birth, birthday, path);
		ac.setId(this.getId());
		return ac;
	}
}
