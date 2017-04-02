package tacs;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Pelicula;
import model.Usuario;

@RestController
public class UserController {
	
	@RequestMapping("/usuarios/{id}")
	public Usuario getActorById(@PathVariable("id") Long id) {
		return new Usuario(id, "alumnos-utn", "123456");
	}
	
}
