package tacs;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import apiResult.Configuration;
import creacionales.UsuarioBuilder;
import hierarchyOfExceptions.UserNotFoundException;
import model.Actor;
import model.MovieList;
import model.Pelicula;
import model.RankingActor;
import model.Rol;
import model.SummaryActor;
import model.Usuario;
import repos.RepoMoviesLists;
import repos.RepoUsuarios;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		ConfigHolder.getInstance();

		Rol adm = new Rol("Administrador");
		Rol usr = new Rol("Usuario");

		SummaryActor actorFavorito = new SummaryActor(1,"algo","Tom Hanks");
		Usuario guille = new UsuarioBuilder("Guille").pass("1234").rol(usr).build();
		RepoUsuarios.getInstance().addUsuario(guille);

		guille.addIdActorFavorito(actorFavorito);
		guille.removeIdActorFavorito(actorFavorito);
		guille.addIdActorFavorito(actorFavorito);

		MovieList rankingMovies = new MovieList("Lista A", Long.valueOf(guille.getId()));
		MovieController mc = new MovieController();
		rankingMovies.addPelicula(mc.getPeliculaById((long)120));
		rankingMovies.addPelicula(mc.getPeliculaById((long)121));
		rankingMovies.addPelicula(mc.getPeliculaById((long)122));
		MovieListController mcl = new MovieListController();

		RepoMoviesLists.getInstance().addMovieList(rankingMovies);
		RepoUsuarios.getInstance().addUsuario(guille);
		
		List<RankingActor> ranking = mcl.getRankingFromActorsByMovies(rankingMovies.getId());
		ranking.forEach(ac -> System.out.println("ID: "+ ac.getMovieActor() + " -- value: "+ ac.getCantRepeticiones()));			
		
		MovieList movielist1 = new MovieList("Lista A", guille.getId());
		movielist1.addPelicula(mc.getPeliculaById((long)120));
		MovieList movielist2 = new MovieList("Lista B", guille.getId());
		movielist2.addPelicula(mc.getPeliculaById((long)122));
		
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Alvaro").pass("1234").rol(adm).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("martin").pass("1234").rol(adm).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Julio").pass("1234").rol(usr).build());
		RepoUsuarios.getInstance().addUsuario(new UsuarioBuilder("Jon").pass("1234").rol(usr).build());
		
		RepoMoviesLists.getInstance().addMovieList(movielist1);
		RepoMoviesLists.getInstance().addMovieList(movielist2);
		RepoMoviesLists.getInstance().addMovieList(new MovieList("Lista C", 1l));
	}
}

