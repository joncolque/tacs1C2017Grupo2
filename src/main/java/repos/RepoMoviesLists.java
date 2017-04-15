package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import hierarchyOfExceptions.UserNotFoundException;
import model.MovieList;

public class RepoMoviesLists {

	private static RepoMoviesLists instance;
	private static List<MovieList> moviesLists = new ArrayList<MovieList>();
	private static int counter = 1;
	
	public static RepoMoviesLists getInstance() {
		if (instance == null) {
			instance = new RepoMoviesLists();
		}
		return instance;
	}
	
	public void addMovieList(MovieList unMovieList) {
		unMovieList.setId((long) counter);
		moviesLists.add(unMovieList);		
		counter++;
	}
	
	public  MovieList getMovieList(Long idMovieList){
		Optional<MovieList> lista = moviesLists.stream().filter(ml -> ml.getId()==idMovieList).findFirst();
		return lista.isPresent() ? lista.get() : null;
	}
	
	public List<MovieList> getAllMovieLists() {
		return moviesLists;
	}	

}
