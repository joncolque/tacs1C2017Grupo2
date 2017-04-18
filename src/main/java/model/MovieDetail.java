package model;

import java.util.List;

import apiResult.MovieActor;
import apiResult.Review;

public class MovieDetail extends Pelicula {
	//hereda id, nombre, nacionalidad, añoEstreno, descripcion y la imagen de Pelicula
	//agrega los actores y los reviews
	
	List<MovieActor> cast;
	List<Review> reviews;
	
	public MovieDetail(long id, String nombre, String nacionalidad, String anioEstreno, String desc, String unPath, List<MovieActor> unCast, List<Review> unasReviews) {
		super(id, nombre, nacionalidad, anioEstreno, desc, unPath);
		this.cast = unCast;
		this.reviews = unasReviews;
	}
	
	public MovieDetail() {}
	
	public List<MovieActor> getCast() {
		return cast;
	}
	public void setCast(List<MovieActor> cast) {
		this.cast = cast;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
