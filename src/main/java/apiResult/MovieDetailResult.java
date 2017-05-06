package apiResult;

import model.MovieDetail;
import tacs.ConfigHolder;

public class MovieDetailResult extends MovieResult {
	
	private MovieCredits credits;
	private ReviewListResult reviews;
	
	public MovieDetail toFullMovie() {
		String path;
		if (poster_path == null) {
			path = null;
		} else {
			path = ConfigHolder.getInstance().getConfig().getImages().getBase_url() + "w300/" + poster_path;
		}
		return new MovieDetail(id, title, original_language, release_date, overview, path, credits.getCast(), reviews.getResults());
	}
	
	public MovieDetailResult() { }
	
	public MovieCredits getCredits() {
		return credits;
	}
	public void setCredits(MovieCredits credits) {
		this.credits = credits;
	}
	public ReviewListResult getReviews() {
		return reviews;
	}
	public void setReviews(ReviewListResult reviews) {
		this.reviews = reviews;
	}

}
