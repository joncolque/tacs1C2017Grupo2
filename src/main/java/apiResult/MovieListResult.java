package apiResult;

import java.util.ArrayList;
import java.util.List;

import model.Pelicula;

public class MovieListResult {
	
	private int page;
	private List<MovieResult> results;
	private int total_results;
	private int total_pages;
	
	public List<Pelicula> toMovieList() {
		List<Pelicula> lista = new ArrayList<Pelicula>();
		results.forEach((m)->lista.add(m.toMovie()));
		return lista;
	}
	
	public MovieListResult() {
		
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<MovieResult> getResults() {
		return results;
	}
	public void setResults(List<MovieResult> results) {
		this.results = results;
	}
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

}
