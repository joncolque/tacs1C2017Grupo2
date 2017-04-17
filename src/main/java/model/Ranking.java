package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apiResult.MovieActor;
import apiResult.MovieCredits;

public class Ranking {
	
	private Map<Long, MovieActor> ranking=new HashMap<Long, MovieActor>();

	public Map<Long, MovieActor> getRankingFromActorsByMovies() {
		return ranking;
	}

	public void setRanking(Map<Long, MovieActor> ranking) {
		this.ranking = ranking;
	}

	public void processRankingFromActorByMovieList(MovieCredits mvCredits) {
		List<MovieActor> actors = mvCredits.getCast();
		actors.forEach(ac->{
			if(ranking.get(ac.getId())!=null){
				ranking.put((long) ac.getId(), ranking.get(ac.getId()).incrementCount());
			}else{
				this.addNewActor(ac);
			}						
		});
	}
	
	public void addNewActor(MovieActor ac){
		ranking.put(ac.getId(),ac.incrementCount());
	}
}
