package tacs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import apiResult.ActorCastResult;
import apiResult.ActorResult;
import apiResult.MovieCredits;
import model.Actor;

public class Connection {
	protected final static String BASE_URL = "https://api.themoviedb.org/3/";
	protected final static String API_KEY = "api_key=3eb489d424860bc6870dc6776d05f6b9";
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected static RestTemplate api = new RestTemplate();

	
	public static Actor getActorbyId(Long id){
		ActorResult actorR = api.getForObject(BASE_URL + "person/"+ id + "?" + API_KEY, ActorResult.class);
		ActorCastResult actorCastR = api.getForObject(BASE_URL+ "person/"+ id +"/movie_credits?"+ API_KEY, ActorCastResult.class);
		Actor actor = actorR.toActor();
		actor.listMovie(actorCastR);
		return actor;
	}
	
	public static MovieCredits getActorsMovie(String id){
		return api.getForObject(BASE_URL + "/movie/" + id +"/credits" + "?" + API_KEY, MovieCredits.class);
	}
}
