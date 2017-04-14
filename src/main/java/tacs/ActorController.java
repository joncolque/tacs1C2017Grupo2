package tacs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import apiResult.ActorCastResult;
import apiResult.ActorResult;
import apiResult.MovieResult;
import model.Actor;
import model.FavoritoActor;
import model.Response;
import repos.RepoActores;
import repos.RepoPeliculas;

@RestController
@RequestMapping("/actores")
public class ActorController extends AbstractController {
	
	private RepoActores repoActores = RepoActores.getInstance();

	// Lista de actores
	@RequestMapping(method = RequestMethod.GET)
	public List<Actor> getActores() {
		logger.info("getActores()");
		return repoActores.getAllActores();
	}

	@RequestMapping(value="/{actor}", method = RequestMethod.GET)
	public Actor getActorById(@PathVariable("actor") long idactor) throws ParseException {
		logger.info("getActor()");
		ActorResult actorR = api.getForObject(BASE_URL + "/person/"+ idactor + "?" + API_KEY, ActorResult.class);
		ActorCastResult actorCastR = api.getForObject(BASE_URL+ "/person/"+ idactor +"/movie_credits?"+ API_KEY, ActorCastResult.class);
		Actor actor = actorR.toActor();
		actor.listMovie(actorCastR);
		return actor;
	}
	
	// Ranking de actores favoriteados
	@RequestMapping(value = "/rankingFavoritos", method = RequestMethod.GET)
	public List<FavoritoActor> rankingActores(){
		logger.info("rankingActores()");
		List<FavoritoActor> rankingActores = new ArrayList<FavoritoActor>();
		rankingActores.add(new FavoritoActor(RepoActores.getInstance().getActorById(1), 5));
		rankingActores.add(new FavoritoActor(RepoActores.getInstance().getActorById(0), 3));
		rankingActores.add(new FavoritoActor(RepoActores.getInstance().getActorById(2), 2));
		return rankingActores;
	}
	
}
