package tacs;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Response;
import model.Usuario;
import repos.RepoUsuarios;


@RestController
public class LoginController {

	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public Response validar(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "pass", required = true) String pass) {
		try{
			Usuario user = RepoUsuarios.getInstance().buscarUsuario(name, pass);
			return new Response(200, String.format("Usario: %s, con rol: %s logueado" , user.getUsername(),user.getRole().getName()));
		}catch (Exception e) {
			return new Response(404, e.getMessage());
		}
	}
}
