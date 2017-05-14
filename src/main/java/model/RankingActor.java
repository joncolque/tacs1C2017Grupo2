package model;

import apiResult.MovieActor;

public class RankingActor {
	
	private MovieActor MovieActor;
	private int cantRepeticiones;
	
	public RankingActor(MovieActor movieActor, int cantRepeticiones) {
		MovieActor = movieActor;
		this.cantRepeticiones = cantRepeticiones;
	}
	public MovieActor getMovieActor() {
		return MovieActor;
	}
	public void setMovieActor(MovieActor movieActor) {
		MovieActor = movieActor;
	}
	public int getCantRepeticiones() {
		return cantRepeticiones;
	}
	public void setCantRepeticiones(int cantRepeticiones) {
		this.cantRepeticiones = cantRepeticiones;
	}

}
