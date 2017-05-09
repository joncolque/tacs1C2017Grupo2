package tacs;

import model.MovieList;
import model.Rol;
import model.SummaryActor;
import model.Usuario;
import repos.RepoMoviesLists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jon on 16/04/17.
 */
public class FullDataUsuario {

    private List<MovieList> listaMovieList;
    private Long id;
    private String username;
    private String password;
    private Rol rol;
    private List<SummaryActor> actoresFavoritos;
    private int cantidad;

    public FullDataUsuario(Usuario user) {
        listaMovieList = RepoMoviesLists.getInstance().getAllMovieLists().stream().filter(movieList -> movieList.getOwnerId()==user.getId()).collect(Collectors.toList());
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        rol = user.getRol();
        actoresFavoritos = user.getIdsActoresFavoritos();
        cantidad = listaMovieList.size();
    }


    public List<MovieList> getListaMovieList() {
        return this.listaMovieList;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Rol getRol() {
        return rol;
    }

    public List<SummaryActor> getActoresFavoritos() {
        return actoresFavoritos;
    }

	public int getCantidad() {
		return cantidad;
	}
    
    
}
