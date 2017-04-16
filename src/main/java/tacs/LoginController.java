package tacs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import model.Response;
import model.Usuario;
import repos.RepoUsuarios;


@RestController
public class LoginController extends AbstractController {
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public Response ingresar(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "pass", required = true) String pass) {
//		logger.info("ingresar()");
//		try{
//			Usuario user = RepoUsuarios.getInstance().buscarUsuario(name, pass);
//			return new Response(200, String.format("Usario: %s, con rol: %s logueado" , user.getUsername(),user.getRol().getName()));
//		}catch (Exception e) {
//			logger.error("ingresar().catch");
//			return new Response(401, e.getMessage());
//		}
//	}
//	
//	@RequestMapping(value = "/logout", method = RequestMethod.PUT)
//	public Response salir(){
//		logger.info("salir()");
//		return new Response(200, "Logout, Exitosamente!");
//	}
	
}

