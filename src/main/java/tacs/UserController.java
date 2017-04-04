package tacs;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import creacionales.UsuarioBuilder;
import model.Response;
import model.Rol;
import model.Usuario;
import repos.RepoActores;
import repos.RepoPeliculas;
import repos.RepoUsuarios;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	// Lista de Usuarios
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> getActores() {
		return RepoUsuarios.getInstance().getAllUsuarios();
	}	
	
	// Mostrar Detalle de un usuario
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Usuario getActorById(@PathVariable("id") Long id) {
		return new Usuario(id, "alumnos-utn", "123456");
	}
	
	// Crear nuevo usuario
	@RequestMapping(method = RequestMethod.POST)
	public Usuario add(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "pass", required = true) String pass) {
		Usuario nuevoUser = new UsuarioBuilder(name).pass(pass).rol(new Rol("Usuario")).build();
		RepoUsuarios.getInstance().addUsuario(nuevoUser);
		return nuevoUser;
	}
	
	// buscar una pelicula
	@RequestMapping(value = "/{usuario}/buscar/pelicula/{pelicula}", method = RequestMethod.GET)
	public Response findMovie(@PathVariable("usuario") Long usuario, @PathVariable("pelicula") Long pelicula) {
		try{
			RepoPeliculas.getInstance().getPeliculaById(pelicula);
			return new Response(200, "Pelicula encontrada");
		}catch (IndexOutOfBoundsException e){
			return new Response(400, "Pelicula no encontrada");
		}
	}
	
	// buscar un actor
	@RequestMapping(value = "/{usuario}/buscar/actor/{actor}", method = RequestMethod.GET)
	public Response findActor(@PathVariable("usuario") Long usuario, @PathVariable("actor") Long actor) {
		try{
			RepoActores.getInstance().getActorById(actor);
			return new Response(200, "Actor encontrado");
		}catch (IndexOutOfBoundsException e){
			return new Response(400, "Actor no encontrado");
		}
	}

	// buscar una pelicula y un actor
	@RequestMapping(value = "/{usuario}/buscar/{pelicula}/{actor}", method = RequestMethod.GET)
	public Response findMovieActor(@PathVariable("usuario") Long usuario,  @PathVariable("pelicula") Long pelicula, @PathVariable("actor") Long actor) {
		try{
			RepoActores.getInstance().getActorById(actor);
			RepoPeliculas.getInstance().getPeliculaById(pelicula);
			return new Response(200, "Busqueda: Actor y Pelicula encontrados");
		}catch (IndexOutOfBoundsException e){
			return new Response(400, "Busqueda: Actor y Pelicula no encontrados");
		}
	}
}
