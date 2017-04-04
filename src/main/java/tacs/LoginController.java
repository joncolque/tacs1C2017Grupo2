package tacs;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Response;
import model.Usuario;
import repos.RepoUsuarios;


@RestController
@RequestMapping("/user")
public class LoginController {

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response ingresar(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "pass", required = true) String pass) {
		try{
			Usuario user = RepoUsuarios.getInstance().buscarUsuario(name, pass);
			return new Response(200, String.format("Usario: %s, con rol: %s logueado" , user.getUsername(),user.getRol().getName()));
		}catch (Exception e) {
			return new Response(404, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.PUT)
	public Response salir(@RequestParam(value = "id", required = true) Long id){
		return new Response(200, "Logout, Exitosamente!");
	}
	
}
